
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
 * 调宿申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tiaosushenqing")
public class TiaosushenqingController {
    private static final Logger logger = LoggerFactory.getLogger(TiaosushenqingController.class);

    private static final String TABLE_NAME = "tiaosushenqing";

    @Autowired
    private TiaosushenqingService tiaosushenqingService;


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
        PageUtils page = tiaosushenqingService.queryPage(params);

        //字典表数据转换
        List<TiaosushenqingView> list =(List<TiaosushenqingView>)page.getList();
        for(TiaosushenqingView c:list){
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
        TiaosushenqingEntity tiaosushenqing = tiaosushenqingService.selectById(id);
        if(tiaosushenqing !=null){
            //entity转view
            TiaosushenqingView view = new TiaosushenqingView();
            BeanUtils.copyProperties( tiaosushenqing , view );//把实体数据重构到view中
            //级联表 学生
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(tiaosushenqing.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 公寓
            //级联表
            FangwuEntity fangwu = fangwuService.selectById(tiaosushenqing.getFangwuId());
            if(fangwu != null){
            BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
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
    public R save(@RequestBody TiaosushenqingEntity tiaosushenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tiaosushenqing:{}",this.getClass().getName(),tiaosushenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            tiaosushenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        FangwuRuzhuEntity fangwuRuzhuEntity = fangwuRuzhuService.selectOne(new EntityWrapper<FangwuRuzhuEntity>()
                .eq("yonghu_id", tiaosushenqing.getYonghuId())
        );
        if(fangwuRuzhuEntity ==null)
            return R.error("该学生之前没有宿舍,不能参与调宿");
        FangwuEntity fangwuEntity = fangwuService.selectById(fangwuRuzhuEntity.getFangwuId());
        if(fangwuEntity ==null)
            return R.error("查不到房屋");
        if(fangwuRuzhuEntity.getFangwuId()==tiaosushenqing.getFangwuId())
            return R.error("原住宿房屋不能和申请调宿的房屋为一个");
        tiaosushenqing.setTiaosushenqingYuanName(fangwuEntity.getFangwuName());
        tiaosushenqing.setTiaosushenqingYuanAddress(fangwuEntity.getFangwuAddress());
        tiaosushenqing.setInsertTime(new Date());
            tiaosushenqing.setTiaosushenqingYesnoTypes(1);
            tiaosushenqing.setCreateTime(new Date());
            tiaosushenqingService.insert(tiaosushenqing);
            return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TiaosushenqingEntity tiaosushenqing, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,tiaosushenqing:{}",this.getClass().getName(),tiaosushenqing.toString());
        TiaosushenqingEntity oldTiaosushenqingEntity = tiaosushenqingService.selectById(tiaosushenqing.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            tiaosushenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(tiaosushenqing.getTiaosushenqingFile()) || "null".equals(tiaosushenqing.getTiaosushenqingFile())){
                tiaosushenqing.setTiaosushenqingFile(null);
        }
        if("".equals(tiaosushenqing.getTiaosushenqingContent()) || "null".equals(tiaosushenqing.getTiaosushenqingContent())){
                tiaosushenqing.setTiaosushenqingContent(null);
        }
        if("".equals(tiaosushenqing.getTiaosushenqingYesnoText()) || "null".equals(tiaosushenqing.getTiaosushenqingYesnoText())){
                tiaosushenqing.setTiaosushenqingYesnoText(null);
        }

            tiaosushenqingService.updateById(tiaosushenqing);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody TiaosushenqingEntity tiaosushenqingEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,tiaosushenqingEntity:{}",this.getClass().getName(),tiaosushenqingEntity.toString());

        TiaosushenqingEntity oldTiaosushenqing = tiaosushenqingService.selectById(tiaosushenqingEntity.getId());//查询原先数据

        if(tiaosushenqingEntity.getTiaosushenqingYesnoTypes() == 2){//通过

            FangwuRuzhuEntity fangwuRuzhuEntity = fangwuRuzhuService.selectOne(new EntityWrapper<FangwuRuzhuEntity>()
                    .eq("yonghu_id", oldTiaosushenqing.getYonghuId())
            );
            if(fangwuRuzhuEntity ==null)
                return R.error("该学生之前没有宿舍,不能参与调宿");
            FangwuEntity oldFangwuEntity = fangwuService.selectById(fangwuRuzhuEntity.getFangwuId());
            if(oldFangwuEntity ==null)
                return R.error("查不到原住宿房屋");

            FangwuEntity newFangwuEntity = fangwuService.selectById(oldTiaosushenqing.getFangwuId());
            if(newFangwuEntity ==null)
                return R.error("查不到现住宿房屋");

            oldFangwuEntity.setFangwuYizhurenshu(oldFangwuEntity.getFangwuYizhurenshu()-1);
            fangwuService.updateById(oldFangwuEntity);


            List<FangwuRuzhuEntity> list = fangwuRuzhuService.selectList(new EntityWrapper<FangwuRuzhuEntity>()
                    .eq("fangwu_id", oldTiaosushenqing.getFangwuId())
            );
            if((list.size()+1)>newFangwuEntity.getFangwuRenshu())
                return R.error("要调宿的房屋已住满");

            newFangwuEntity.setFangwuYizhurenshu(list.size()+1);
            fangwuService.updateById(newFangwuEntity);


            //入住
            FangwuRuzhuEntity newFangwuRuzhuEntity=new FangwuRuzhuEntity();
            newFangwuRuzhuEntity.setFangwuId(oldTiaosushenqing.getFangwuId());
            newFangwuRuzhuEntity.setYonghuId(oldTiaosushenqing.getYonghuId());
            newFangwuRuzhuEntity.setCreateTime(new Date());
            newFangwuRuzhuEntity.setInsertTime(new Date());
            fangwuRuzhuService.insert(newFangwuRuzhuEntity);



            //删除之前入住
            fangwuRuzhuService.delete(new EntityWrapper<FangwuRuzhuEntity>()
                    .eq("fangwu_id",oldFangwuEntity.getId())
                    .eq("yonghu_id",oldTiaosushenqing.getYonghuId())
            );





        }else if(tiaosushenqingEntity.getTiaosushenqingYesnoTypes() == 3){//拒绝
        }
        tiaosushenqingEntity.setTiaosushenqingShenheTime(new Date());//审核时间
        tiaosushenqingService.updateById(tiaosushenqingEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<TiaosushenqingEntity> oldTiaosushenqingList =tiaosushenqingService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        tiaosushenqingService.deleteBatchIds(Arrays.asList(ids));

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
            List<TiaosushenqingEntity> tiaosushenqingList = new ArrayList<>();//上传的东西
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
                            TiaosushenqingEntity tiaosushenqingEntity = new TiaosushenqingEntity();
//                            tiaosushenqingEntity.setYonghuId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            tiaosushenqingEntity.setFangwuId(Integer.valueOf(data.get(0)));   //公寓 要改的
//                            tiaosushenqingEntity.setTiaosushenqingUuidNumber(data.get(0));                    //调宿申请编号 要改的
//                            tiaosushenqingEntity.setTiaosushenqingName(data.get(0));                    //申请标题 要改的
//                            tiaosushenqingEntity.setTiaosushenqingFile(data.get(0));                    //申请附件 要改的
//                            tiaosushenqingEntity.setTiaosushenqingTypes(Integer.valueOf(data.get(0)));   //调宿申请类型 要改的
//                            tiaosushenqingEntity.setTiaosushenqingYuanName(data.get(0));                    //原宿舍名称 要改的
//                            tiaosushenqingEntity.setTiaosushenqingYuanAddress(data.get(0));                    //原宿舍位置 要改的
//                            tiaosushenqingEntity.setTiaosushenqingContent("");//详情和图片
//                            tiaosushenqingEntity.setInsertTime(date);//时间
//                            tiaosushenqingEntity.setTiaosushenqingYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            tiaosushenqingEntity.setTiaosushenqingYesnoText(data.get(0));                    //审核意见 要改的
//                            tiaosushenqingEntity.setTiaosushenqingShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            tiaosushenqingEntity.setCreateTime(date);//时间
                            tiaosushenqingList.add(tiaosushenqingEntity);


                            //把要查询是否重复的字段放入map中
                                //调宿申请编号
                                if(seachFields.containsKey("tiaosushenqingUuidNumber")){
                                    List<String> tiaosushenqingUuidNumber = seachFields.get("tiaosushenqingUuidNumber");
                                    tiaosushenqingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> tiaosushenqingUuidNumber = new ArrayList<>();
                                    tiaosushenqingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("tiaosushenqingUuidNumber",tiaosushenqingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //调宿申请编号
                        List<TiaosushenqingEntity> tiaosushenqingEntities_tiaosushenqingUuidNumber = tiaosushenqingService.selectList(new EntityWrapper<TiaosushenqingEntity>().in("tiaosushenqing_uuid_number", seachFields.get("tiaosushenqingUuidNumber")));
                        if(tiaosushenqingEntities_tiaosushenqingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(TiaosushenqingEntity s:tiaosushenqingEntities_tiaosushenqingUuidNumber){
                                repeatFields.add(s.getTiaosushenqingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [调宿申请编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        tiaosushenqingService.insertBatch(tiaosushenqingList);
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
        PageUtils page = tiaosushenqingService.queryPage(params);

        //字典表数据转换
        List<TiaosushenqingView> list =(List<TiaosushenqingView>)page.getList();
        for(TiaosushenqingView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TiaosushenqingEntity tiaosushenqing = tiaosushenqingService.selectById(id);
            if(tiaosushenqing !=null){


                //entity转view
                TiaosushenqingView view = new TiaosushenqingView();
                BeanUtils.copyProperties( tiaosushenqing , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(tiaosushenqing.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    FangwuEntity fangwu = fangwuService.selectById(tiaosushenqing.getFangwuId());
                if(fangwu != null){
                    BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
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
    public R add(@RequestBody TiaosushenqingEntity tiaosushenqing, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,tiaosushenqing:{}",this.getClass().getName(),tiaosushenqing.toString());
        Wrapper<TiaosushenqingEntity> queryWrapper = new EntityWrapper<TiaosushenqingEntity>()
            .eq("yonghu_id", tiaosushenqing.getYonghuId())
            .eq("fangwu_id", tiaosushenqing.getFangwuId())
            .eq("tiaosushenqing_uuid_number", tiaosushenqing.getTiaosushenqingUuidNumber())
            .eq("tiaosushenqing_name", tiaosushenqing.getTiaosushenqingName())
            .eq("tiaosushenqing_types", tiaosushenqing.getTiaosushenqingTypes())
            .eq("tiaosushenqing_yuan_name", tiaosushenqing.getTiaosushenqingYuanName())
            .eq("tiaosushenqing_yuan_address", tiaosushenqing.getTiaosushenqingYuanAddress())
            .in("tiaosushenqing_yesno_types", new Integer[]{1,2})
            .eq("tiaosushenqing_yesno_text", tiaosushenqing.getTiaosushenqingYesnoText())
//            .notIn("tiaosushenqing_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TiaosushenqingEntity tiaosushenqingEntity = tiaosushenqingService.selectOne(queryWrapper);
        if(tiaosushenqingEntity==null){
            tiaosushenqing.setInsertTime(new Date());
            tiaosushenqing.setTiaosushenqingYesnoTypes(1);
            tiaosushenqing.setCreateTime(new Date());
        tiaosushenqingService.insert(tiaosushenqing);

            return R.ok();
        }else {
            if(tiaosushenqingEntity.getTiaosushenqingYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(tiaosushenqingEntity.getTiaosushenqingYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

