
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 卫生
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/weisheng")
public class WeishengController {
    private static final Logger logger = LoggerFactory.getLogger(WeishengController.class);

    private static final String TABLE_NAME = "weisheng";

    @Autowired
    private WeishengService weishengService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BaoxiuService baoxiuService;//报修
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ExampaperService exampaperService;//试卷
    @Autowired
    private ExampapertopicService exampapertopicService;//试卷选题
    @Autowired
    private ExamquestionService examquestionService;//试题表
    @Autowired
    private ExamrecordService examrecordService;//考试记录表
    @Autowired
    private ExamredetailsService examredetailsService;//答题详情表
    @Autowired
    private ExamrewrongquestionService examrewrongquestionService;//错题表
    @Autowired
    private FangkeService fangkeService;//访客
    @Autowired
    private FangwuService fangwuService;//公寓
    @Autowired
    private FangwuCollectionService fangwuCollectionService;//公寓收藏
    @Autowired
    private FangwuRuzhuService fangwuRuzhuService;//公寓学生
    @Autowired
    private FangwuTuisuService fangwuTuisuService;//公寓退宿申请
    @Autowired
    private FangwuYuyueService fangwuYuyueService;//公寓入住申请
    @Autowired
    private JiaofeiService jiaofeiService;//缴费
    @Autowired
    private LiuyanService liuyanService;//留言
    @Autowired
    private SusheguanliyuanService susheguanliyuanService;//宿舍管理员
    @Autowired
    private TiaosushenqingService tiaosushenqingService;//调宿申请
    @Autowired
    private YonghuService yonghuService;//学生
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("宿舍管理员".equals(role))
            params.put("susheguanliyuanId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = weishengService.queryPage(params);

        //字典表数据转换
        List<WeishengView> list =(List<WeishengView>)page.getList();
        for(WeishengView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WeishengEntity weisheng = weishengService.selectById(id);
        if(weisheng !=null){
            //entity转view
            WeishengView view = new WeishengView();
            BeanUtils.copyProperties( weisheng , view );//把实体数据重构到view中
            //级联表 宿舍管理员
            //级联表
            SusheguanliyuanEntity susheguanliyuan = susheguanliyuanService.selectById(weisheng.getSusheguanliyuanId());
            if(susheguanliyuan != null){
            BeanUtils.copyProperties( susheguanliyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "susheguanliyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setSusheguanliyuanId(susheguanliyuan.getId());
            }
            //级联表 公寓
            //级联表
            FangwuEntity fangwu = fangwuService.selectById(weisheng.getFangwuId());
            if(fangwu != null){
            BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "susheguanliyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setFangwuId(fangwu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WeishengEntity weisheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,weisheng:{}",this.getClass().getName(),weisheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("宿舍管理员".equals(role))
            weisheng.setSusheguanliyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WeishengEntity> queryWrapper = new EntityWrapper<WeishengEntity>()
            .eq("fangwu_id", weisheng.getFangwuId())
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeishengEntity weishengEntity = weishengService.selectOne(queryWrapper);
        if(weishengEntity==null){
            weisheng.setInsertTime(new Date());
            weisheng.setCreateTime(new Date());
            weishengService.insert(weisheng);
            return R.ok();
        }else {
            return R.error(511,"该宿舍该天已有卫生记录");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WeishengEntity weisheng, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,weisheng:{}",this.getClass().getName(),weisheng.toString());
        WeishengEntity oldWeishengEntity = weishengService.selectById(weisheng.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("宿舍管理员".equals(role))
//            weisheng.setSusheguanliyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(weisheng.getWeishengPhoto()) || "null".equals(weisheng.getWeishengPhoto())){
                weisheng.setWeishengPhoto(null);
        }
        if("".equals(weisheng.getWeishengContent()) || "null".equals(weisheng.getWeishengContent())){
                weisheng.setWeishengContent(null);
        }

            weishengService.updateById(weisheng);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WeishengEntity> oldWeishengList =weishengService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        weishengService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<WeishengEntity> weishengList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            WeishengEntity weishengEntity = new WeishengEntity();
//                            weishengEntity.setSusheguanliyuanId(Integer.valueOf(data.get(0)));   //宿舍管理员 要改的
//                            weishengEntity.setFangwuId(Integer.valueOf(data.get(0)));   //公寓 要改的
//                            weishengEntity.setWeishengUuidNumber(data.get(0));                    //卫生编号 要改的
//                            weishengEntity.setWeishengPhoto("");//详情和图片
//                            weishengEntity.setWeishengTypes(Integer.valueOf(data.get(0)));   //卫生状况 要改的
//                            weishengEntity.setWeishengPrice(Integer.valueOf(data.get(0)));   //得分 要改的
//                            weishengEntity.setWeishengContent("");//详情和图片
//                            weishengEntity.setInsertTime(date);//时间
//                            weishengEntity.setCreateTime(date);//时间
                            weishengList.add(weishengEntity);


                            //把要查询是否重复的字段放入map中
                                //卫生编号
                                if(seachFields.containsKey("weishengUuidNumber")){
                                    List<String> weishengUuidNumber = seachFields.get("weishengUuidNumber");
                                    weishengUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> weishengUuidNumber = new ArrayList<>();
                                    weishengUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("weishengUuidNumber",weishengUuidNumber);
                                }
                        }

                        //查询是否重复
                         //卫生编号
                        List<WeishengEntity> weishengEntities_weishengUuidNumber = weishengService.selectList(new EntityWrapper<WeishengEntity>().in("weisheng_uuid_number", seachFields.get("weishengUuidNumber")));
                        if(weishengEntities_weishengUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WeishengEntity s:weishengEntities_weishengUuidNumber){
                                repeatFields.add(s.getWeishengUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [卫生编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        weishengService.insertBatch(weishengList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
            FangwuRuzhuEntity fangwuRuzhuEntity = fangwuRuzhuService.selectOne(new EntityWrapper<FangwuRuzhuEntity>()
                    .eq("yonghu_id", request.getSession().getAttribute("userId"))
            );
            if(fangwuRuzhuEntity == null){
                params.put("fangwuId",-1);

            }else{
                params.put("fangwuId",fangwuRuzhuEntity.getFangwuId());
            }

        }
        else if("宿舍管理员".equals(role))
            params.put("susheguanliyuanId",request.getSession().getAttribute("userId"));


        CommonUtil.checkMap(params);
        PageUtils page = weishengService.queryPage(params);

        //字典表数据转换
        List<WeishengView> list =(List<WeishengView>)page.getList();
        for(WeishengView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WeishengEntity weisheng = weishengService.selectById(id);
            if(weisheng !=null){


                //entity转view
                WeishengView view = new WeishengView();
                BeanUtils.copyProperties( weisheng , view );//把实体数据重构到view中

                //级联表
                    SusheguanliyuanEntity susheguanliyuan = susheguanliyuanService.selectById(weisheng.getSusheguanliyuanId());
                if(susheguanliyuan != null){
                    BeanUtils.copyProperties( susheguanliyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "susheguanliyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSusheguanliyuanId(susheguanliyuan.getId());
                }
                //级联表
                    FangwuEntity fangwu = fangwuService.selectById(weisheng.getFangwuId());
                if(fangwu != null){
                    BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "susheguanliyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangwuId(fangwu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody WeishengEntity weisheng, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,weisheng:{}",this.getClass().getName(),weisheng.toString());
        Wrapper<WeishengEntity> queryWrapper = new EntityWrapper<WeishengEntity>()
            .eq("susheguanliyuan_id", weisheng.getSusheguanliyuanId())
            .eq("fangwu_id", weisheng.getFangwuId())
            .eq("weisheng_uuid_number", weisheng.getWeishengUuidNumber())
            .eq("weisheng_types", weisheng.getWeishengTypes())
            .eq("weisheng_price", weisheng.getWeishengPrice())
//            .notIn("weisheng_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeishengEntity weishengEntity = weishengService.selectOne(queryWrapper);
        if(weishengEntity==null){
            weisheng.setInsertTime(new Date());
            weisheng.setCreateTime(new Date());
        weishengService.insert(weisheng);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

