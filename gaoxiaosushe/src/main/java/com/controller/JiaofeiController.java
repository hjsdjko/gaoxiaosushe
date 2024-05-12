
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
 * 缴费
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiaofei")
public class JiaofeiController {
    private static final Logger logger = LoggerFactory.getLogger(JiaofeiController.class);

    private static final String TABLE_NAME = "jiaofei";

    @Autowired
    private JiaofeiService jiaofeiService;


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
    private LiuyanService liuyanService;//留言
    @Autowired
    private SusheguanliyuanService susheguanliyuanService;//宿舍管理员
    @Autowired
    private TiaosushenqingService tiaosushenqingService;//调宿申请
    @Autowired
    private WeishengService weishengService;//卫生
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
        PageUtils page = jiaofeiService.queryPage(params);

        //字典表数据转换
        List<JiaofeiView> list =(List<JiaofeiView>)page.getList();
        for(JiaofeiView c:list){
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
        JiaofeiEntity jiaofei = jiaofeiService.selectById(id);
        if(jiaofei !=null){
            //entity转view
            JiaofeiView view = new JiaofeiView();
            BeanUtils.copyProperties( jiaofei , view );//把实体数据重构到view中
            //级联表 学生
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jiaofei.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "susheguanliyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 宿舍管理员
            //级联表
            SusheguanliyuanEntity susheguanliyuan = susheguanliyuanService.selectById(jiaofei.getSusheguanliyuanId());
            if(susheguanliyuan != null){
            BeanUtils.copyProperties( susheguanliyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "susheguanliyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setSusheguanliyuanId(susheguanliyuan.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端详情
    */
    @RequestMapping("/woyaojiaofei")
    public R woyaojiaofei(Long id, HttpServletRequest request){
        logger.debug("woyaojiaofei方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaofeiEntity jiaofei = jiaofeiService.selectById(id);
        if(jiaofei !=null){
            YonghuEntity yonghuEntity = yonghuService.selectById(jiaofei.getYonghuId());
            if(yonghuEntity==null)
                return R.error("查不到用户");
            double balance = yonghuEntity.getNewMoney() - jiaofei.getJiaofeiMoney();
            if(balance<0)
                return R.error("余额不够缴纳此次费用,请充值后再缴费");
            yonghuEntity.setNewMoney(balance);
            yonghuService.updateById(yonghuEntity);
            jiaofei.setJiaofeiTypes(2);
            jiaofeiService.updateById(jiaofei);

            return R.ok();
        }else {
            return R.error(511,"查不到缴费记录");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiaofeiEntity jiaofei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaofei:{}",this.getClass().getName(),jiaofei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            jiaofei.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("宿舍管理员".equals(role))
            jiaofei.setSusheguanliyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiaofeiEntity> queryWrapper = new EntityWrapper<JiaofeiEntity>()
            .eq("yonghu_id", jiaofei.getYonghuId())
            .eq("susheguanliyuan_id", jiaofei.getSusheguanliyuanId())
            .eq("jiaofei_name", jiaofei.getJiaofeiName())
            .eq("jiaofei_types", jiaofei.getJiaofeiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaofeiEntity jiaofeiEntity = jiaofeiService.selectOne(queryWrapper);
        if(jiaofeiEntity==null){
            jiaofei.setInsertTime(new Date());
            jiaofei.setCreateTime(new Date());
            jiaofeiService.insert(jiaofei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaofeiEntity jiaofei, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiaofei:{}",this.getClass().getName(),jiaofei.toString());
        JiaofeiEntity oldJiaofeiEntity = jiaofeiService.selectById(jiaofei.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            jiaofei.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("宿舍管理员".equals(role))
//            jiaofei.setSusheguanliyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jiaofei.getJiaofeiPhoto()) || "null".equals(jiaofei.getJiaofeiPhoto())){
                jiaofei.setJiaofeiPhoto(null);
        }
        if("".equals(jiaofei.getJiaofeiContent()) || "null".equals(jiaofei.getJiaofeiContent())){
                jiaofei.setJiaofeiContent(null);
        }

            jiaofeiService.updateById(jiaofei);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiaofeiEntity> oldJiaofeiList =jiaofeiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jiaofeiService.deleteBatchIds(Arrays.asList(ids));

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
            List<JiaofeiEntity> jiaofeiList = new ArrayList<>();//上传的东西
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
                            JiaofeiEntity jiaofeiEntity = new JiaofeiEntity();
//                            jiaofeiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            jiaofeiEntity.setSusheguanliyuanId(Integer.valueOf(data.get(0)));   //宿舍管理员 要改的
//                            jiaofeiEntity.setJiaofeiUuidNumber(data.get(0));                    //缴费编号 要改的
//                            jiaofeiEntity.setJiaofeiName(data.get(0));                    //缴费标题 要改的
//                            jiaofeiEntity.setJiaofeiPhoto("");//详情和图片
//                            jiaofeiEntity.setJiaofeiMoney(data.get(0));                    //缴费金额 要改的
//                            jiaofeiEntity.setJiaofeiContent("");//详情和图片
//                            jiaofeiEntity.setInsertTime(date);//时间
//                            jiaofeiEntity.setJiaofeiTypes(Integer.valueOf(data.get(0)));   //缴费状态 要改的
//                            jiaofeiEntity.setCreateTime(date);//时间
                            jiaofeiList.add(jiaofeiEntity);


                            //把要查询是否重复的字段放入map中
                                //缴费编号
                                if(seachFields.containsKey("jiaofeiUuidNumber")){
                                    List<String> jiaofeiUuidNumber = seachFields.get("jiaofeiUuidNumber");
                                    jiaofeiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiaofeiUuidNumber = new ArrayList<>();
                                    jiaofeiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiaofeiUuidNumber",jiaofeiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //缴费编号
                        List<JiaofeiEntity> jiaofeiEntities_jiaofeiUuidNumber = jiaofeiService.selectList(new EntityWrapper<JiaofeiEntity>().in("jiaofei_uuid_number", seachFields.get("jiaofeiUuidNumber")));
                        if(jiaofeiEntities_jiaofeiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiaofeiEntity s:jiaofeiEntities_jiaofeiUuidNumber){
                                repeatFields.add(s.getJiaofeiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [缴费编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiaofeiService.insertBatch(jiaofeiList);
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
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = jiaofeiService.queryPage(params);

        //字典表数据转换
        List<JiaofeiView> list =(List<JiaofeiView>)page.getList();
        for(JiaofeiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaofeiEntity jiaofei = jiaofeiService.selectById(id);
            if(jiaofei !=null){


                //entity转view
                JiaofeiView view = new JiaofeiView();
                BeanUtils.copyProperties( jiaofei , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jiaofei.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "susheguanliyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    SusheguanliyuanEntity susheguanliyuan = susheguanliyuanService.selectById(jiaofei.getSusheguanliyuanId());
                if(susheguanliyuan != null){
                    BeanUtils.copyProperties( susheguanliyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "susheguanliyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSusheguanliyuanId(susheguanliyuan.getId());
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
    public R add(@RequestBody JiaofeiEntity jiaofei, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiaofei:{}",this.getClass().getName(),jiaofei.toString());
        Wrapper<JiaofeiEntity> queryWrapper = new EntityWrapper<JiaofeiEntity>()
            .eq("yonghu_id", jiaofei.getYonghuId())
            .eq("susheguanliyuan_id", jiaofei.getSusheguanliyuanId())
            .eq("jiaofei_uuid_number", jiaofei.getJiaofeiUuidNumber())
            .eq("jiaofei_name", jiaofei.getJiaofeiName())
            .eq("jiaofei_types", jiaofei.getJiaofeiTypes())
//            .notIn("jiaofei_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaofeiEntity jiaofeiEntity = jiaofeiService.selectOne(queryWrapper);
        if(jiaofeiEntity==null){
            jiaofei.setInsertTime(new Date());
            jiaofei.setCreateTime(new Date());
        jiaofeiService.insert(jiaofei);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

