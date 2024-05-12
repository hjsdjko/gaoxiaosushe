
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
 * 宿舍管理员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/susheguanliyuan")
public class SusheguanliyuanController {
    private static final Logger logger = LoggerFactory.getLogger(SusheguanliyuanController.class);

    private static final String TABLE_NAME = "susheguanliyuan";

    @Autowired
    private SusheguanliyuanService susheguanliyuanService;


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
        PageUtils page = susheguanliyuanService.queryPage(params);

        //字典表数据转换
        List<SusheguanliyuanView> list =(List<SusheguanliyuanView>)page.getList();
        for(SusheguanliyuanView c:list){
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
        SusheguanliyuanEntity susheguanliyuan = susheguanliyuanService.selectById(id);
        if(susheguanliyuan !=null){
            //entity转view
            SusheguanliyuanView view = new SusheguanliyuanView();
            BeanUtils.copyProperties( susheguanliyuan , view );//把实体数据重构到view中
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
    public R save(@RequestBody SusheguanliyuanEntity susheguanliyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,susheguanliyuan:{}",this.getClass().getName(),susheguanliyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<SusheguanliyuanEntity> queryWrapper = new EntityWrapper<SusheguanliyuanEntity>()
            .eq("username", susheguanliyuan.getUsername())
            .or()
            .eq("susheguanliyuan_phone", susheguanliyuan.getSusheguanliyuanPhone())
            .or()
            .eq("susheguanliyuan_id_number", susheguanliyuan.getSusheguanliyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SusheguanliyuanEntity susheguanliyuanEntity = susheguanliyuanService.selectOne(queryWrapper);
        if(susheguanliyuanEntity==null){
            susheguanliyuan.setCreateTime(new Date());
            susheguanliyuan.setPassword("123456");
            susheguanliyuanService.insert(susheguanliyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者宿舍管理员手机号或者宿舍管理员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SusheguanliyuanEntity susheguanliyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,susheguanliyuan:{}",this.getClass().getName(),susheguanliyuan.toString());
        SusheguanliyuanEntity oldSusheguanliyuanEntity = susheguanliyuanService.selectById(susheguanliyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(susheguanliyuan.getSusheguanliyuanPhoto()) || "null".equals(susheguanliyuan.getSusheguanliyuanPhoto())){
                susheguanliyuan.setSusheguanliyuanPhoto(null);
        }

            susheguanliyuanService.updateById(susheguanliyuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<SusheguanliyuanEntity> oldSusheguanliyuanList =susheguanliyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        susheguanliyuanService.deleteBatchIds(Arrays.asList(ids));

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
            List<SusheguanliyuanEntity> susheguanliyuanList = new ArrayList<>();//上传的东西
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
                            SusheguanliyuanEntity susheguanliyuanEntity = new SusheguanliyuanEntity();
//                            susheguanliyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            susheguanliyuanEntity.setPassword("123456");//密码
//                            susheguanliyuanEntity.setSusheguanliyuanUuidNumber(data.get(0));                    //工号 要改的
//                            susheguanliyuanEntity.setSusheguanliyuanName(data.get(0));                    //宿舍管理员姓名 要改的
//                            susheguanliyuanEntity.setSusheguanliyuanPhone(data.get(0));                    //宿舍管理员手机号 要改的
//                            susheguanliyuanEntity.setSusheguanliyuanIdNumber(data.get(0));                    //宿舍管理员身份证号 要改的
//                            susheguanliyuanEntity.setSusheguanliyuanPhoto("");//详情和图片
//                            susheguanliyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            susheguanliyuanEntity.setSusheguanliyuanEmail(data.get(0));                    //宿舍管理员邮箱 要改的
//                            susheguanliyuanEntity.setJinyongTypes(Integer.valueOf(data.get(0)));   //账户状态 要改的
//                            susheguanliyuanEntity.setCreateTime(date);//时间
                            susheguanliyuanList.add(susheguanliyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //工号
                                if(seachFields.containsKey("susheguanliyuanUuidNumber")){
                                    List<String> susheguanliyuanUuidNumber = seachFields.get("susheguanliyuanUuidNumber");
                                    susheguanliyuanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> susheguanliyuanUuidNumber = new ArrayList<>();
                                    susheguanliyuanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("susheguanliyuanUuidNumber",susheguanliyuanUuidNumber);
                                }
                                //宿舍管理员手机号
                                if(seachFields.containsKey("susheguanliyuanPhone")){
                                    List<String> susheguanliyuanPhone = seachFields.get("susheguanliyuanPhone");
                                    susheguanliyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> susheguanliyuanPhone = new ArrayList<>();
                                    susheguanliyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("susheguanliyuanPhone",susheguanliyuanPhone);
                                }
                                //宿舍管理员身份证号
                                if(seachFields.containsKey("susheguanliyuanIdNumber")){
                                    List<String> susheguanliyuanIdNumber = seachFields.get("susheguanliyuanIdNumber");
                                    susheguanliyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> susheguanliyuanIdNumber = new ArrayList<>();
                                    susheguanliyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("susheguanliyuanIdNumber",susheguanliyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<SusheguanliyuanEntity> susheguanliyuanEntities_username = susheguanliyuanService.selectList(new EntityWrapper<SusheguanliyuanEntity>().in("username", seachFields.get("username")));
                        if(susheguanliyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SusheguanliyuanEntity s:susheguanliyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //工号
                        List<SusheguanliyuanEntity> susheguanliyuanEntities_susheguanliyuanUuidNumber = susheguanliyuanService.selectList(new EntityWrapper<SusheguanliyuanEntity>().in("susheguanliyuan_uuid_number", seachFields.get("susheguanliyuanUuidNumber")));
                        if(susheguanliyuanEntities_susheguanliyuanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SusheguanliyuanEntity s:susheguanliyuanEntities_susheguanliyuanUuidNumber){
                                repeatFields.add(s.getSusheguanliyuanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [工号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //宿舍管理员手机号
                        List<SusheguanliyuanEntity> susheguanliyuanEntities_susheguanliyuanPhone = susheguanliyuanService.selectList(new EntityWrapper<SusheguanliyuanEntity>().in("susheguanliyuan_phone", seachFields.get("susheguanliyuanPhone")));
                        if(susheguanliyuanEntities_susheguanliyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SusheguanliyuanEntity s:susheguanliyuanEntities_susheguanliyuanPhone){
                                repeatFields.add(s.getSusheguanliyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [宿舍管理员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //宿舍管理员身份证号
                        List<SusheguanliyuanEntity> susheguanliyuanEntities_susheguanliyuanIdNumber = susheguanliyuanService.selectList(new EntityWrapper<SusheguanliyuanEntity>().in("susheguanliyuan_id_number", seachFields.get("susheguanliyuanIdNumber")));
                        if(susheguanliyuanEntities_susheguanliyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SusheguanliyuanEntity s:susheguanliyuanEntities_susheguanliyuanIdNumber){
                                repeatFields.add(s.getSusheguanliyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [宿舍管理员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        susheguanliyuanService.insertBatch(susheguanliyuanList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        SusheguanliyuanEntity susheguanliyuan = susheguanliyuanService.selectOne(new EntityWrapper<SusheguanliyuanEntity>().eq("username", username));
        if(susheguanliyuan==null || !susheguanliyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(susheguanliyuan.getJinyongTypes() != 1)
            return R.error("账户已被禁用");
        String token = tokenService.generateToken(susheguanliyuan.getId(),username, "susheguanliyuan", "宿舍管理员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","宿舍管理员");
        r.put("username",susheguanliyuan.getSusheguanliyuanName());
        r.put("tableName","susheguanliyuan");
        r.put("userId",susheguanliyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody SusheguanliyuanEntity susheguanliyuan, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<SusheguanliyuanEntity> queryWrapper = new EntityWrapper<SusheguanliyuanEntity>()
            .eq("username", susheguanliyuan.getUsername())
            .or()
            .eq("susheguanliyuan_phone", susheguanliyuan.getSusheguanliyuanPhone())
            .or()
            .eq("susheguanliyuan_id_number", susheguanliyuan.getSusheguanliyuanIdNumber())
            ;
        SusheguanliyuanEntity susheguanliyuanEntity = susheguanliyuanService.selectOne(queryWrapper);
        if(susheguanliyuanEntity != null)
            return R.error("账户或者宿舍管理员手机号或者宿舍管理员身份证号已经被使用");
        susheguanliyuan.setSusheguanliyuanUuidNumber(String.valueOf(new Date().getTime()));
        susheguanliyuan.setJinyongTypes(1);//启用
        susheguanliyuan.setCreateTime(new Date());
        susheguanliyuanService.insert(susheguanliyuan);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        SusheguanliyuanEntity susheguanliyuan = susheguanliyuanService.selectById(id);
        susheguanliyuan.setPassword("123456");
        susheguanliyuanService.updateById(susheguanliyuan);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        SusheguanliyuanEntity susheguanliyuan = susheguanliyuanService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(susheguanliyuan.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(susheguanliyuan.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        susheguanliyuan.setPassword(newPassword);
		susheguanliyuanService.updateById(susheguanliyuan);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        SusheguanliyuanEntity susheguanliyuan = susheguanliyuanService.selectOne(new EntityWrapper<SusheguanliyuanEntity>().eq("username", username));
        if(susheguanliyuan!=null){
            susheguanliyuan.setPassword("123456");
            susheguanliyuanService.updateById(susheguanliyuan);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrSusheguanliyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        SusheguanliyuanEntity susheguanliyuan = susheguanliyuanService.selectById(id);
        if(susheguanliyuan !=null){
            //entity转view
            SusheguanliyuanView view = new SusheguanliyuanView();
            BeanUtils.copyProperties( susheguanliyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = susheguanliyuanService.queryPage(params);

        //字典表数据转换
        List<SusheguanliyuanView> list =(List<SusheguanliyuanView>)page.getList();
        for(SusheguanliyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SusheguanliyuanEntity susheguanliyuan = susheguanliyuanService.selectById(id);
            if(susheguanliyuan !=null){


                //entity转view
                SusheguanliyuanView view = new SusheguanliyuanView();
                BeanUtils.copyProperties( susheguanliyuan , view );//把实体数据重构到view中

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
    public R add(@RequestBody SusheguanliyuanEntity susheguanliyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,susheguanliyuan:{}",this.getClass().getName(),susheguanliyuan.toString());
        Wrapper<SusheguanliyuanEntity> queryWrapper = new EntityWrapper<SusheguanliyuanEntity>()
            .eq("username", susheguanliyuan.getUsername())
            .or()
            .eq("susheguanliyuan_phone", susheguanliyuan.getSusheguanliyuanPhone())
            .or()
            .eq("susheguanliyuan_id_number", susheguanliyuan.getSusheguanliyuanIdNumber())
//            .notIn("susheguanliyuan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SusheguanliyuanEntity susheguanliyuanEntity = susheguanliyuanService.selectOne(queryWrapper);
        if(susheguanliyuanEntity==null){
            susheguanliyuan.setCreateTime(new Date());
            susheguanliyuan.setPassword("123456");
        susheguanliyuanService.insert(susheguanliyuan);

            return R.ok();
        }else {
            return R.error(511,"账户或者宿舍管理员手机号或者宿舍管理员身份证号已经被使用");
        }
    }

}

