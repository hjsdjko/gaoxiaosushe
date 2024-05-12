package com.entity.model;

import com.entity.SusheguanliyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 宿舍管理员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SusheguanliyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 工号
     */
    private String susheguanliyuanUuidNumber;


    /**
     * 宿舍管理员姓名
     */
    private String susheguanliyuanName;


    /**
     * 宿舍管理员手机号
     */
    private String susheguanliyuanPhone;


    /**
     * 宿舍管理员身份证号
     */
    private String susheguanliyuanIdNumber;


    /**
     * 宿舍管理员头像
     */
    private String susheguanliyuanPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 宿舍管理员邮箱
     */
    private String susheguanliyuanEmail;


    /**
     * 账户状态
     */
    private Integer jinyongTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：工号
	 */
    public String getSusheguanliyuanUuidNumber() {
        return susheguanliyuanUuidNumber;
    }


    /**
	 * 设置：工号
	 */
    public void setSusheguanliyuanUuidNumber(String susheguanliyuanUuidNumber) {
        this.susheguanliyuanUuidNumber = susheguanliyuanUuidNumber;
    }
    /**
	 * 获取：宿舍管理员姓名
	 */
    public String getSusheguanliyuanName() {
        return susheguanliyuanName;
    }


    /**
	 * 设置：宿舍管理员姓名
	 */
    public void setSusheguanliyuanName(String susheguanliyuanName) {
        this.susheguanliyuanName = susheguanliyuanName;
    }
    /**
	 * 获取：宿舍管理员手机号
	 */
    public String getSusheguanliyuanPhone() {
        return susheguanliyuanPhone;
    }


    /**
	 * 设置：宿舍管理员手机号
	 */
    public void setSusheguanliyuanPhone(String susheguanliyuanPhone) {
        this.susheguanliyuanPhone = susheguanliyuanPhone;
    }
    /**
	 * 获取：宿舍管理员身份证号
	 */
    public String getSusheguanliyuanIdNumber() {
        return susheguanliyuanIdNumber;
    }


    /**
	 * 设置：宿舍管理员身份证号
	 */
    public void setSusheguanliyuanIdNumber(String susheguanliyuanIdNumber) {
        this.susheguanliyuanIdNumber = susheguanliyuanIdNumber;
    }
    /**
	 * 获取：宿舍管理员头像
	 */
    public String getSusheguanliyuanPhoto() {
        return susheguanliyuanPhoto;
    }


    /**
	 * 设置：宿舍管理员头像
	 */
    public void setSusheguanliyuanPhoto(String susheguanliyuanPhoto) {
        this.susheguanliyuanPhoto = susheguanliyuanPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：宿舍管理员邮箱
	 */
    public String getSusheguanliyuanEmail() {
        return susheguanliyuanEmail;
    }


    /**
	 * 设置：宿舍管理员邮箱
	 */
    public void setSusheguanliyuanEmail(String susheguanliyuanEmail) {
        this.susheguanliyuanEmail = susheguanliyuanEmail;
    }
    /**
	 * 获取：账户状态
	 */
    public Integer getJinyongTypes() {
        return jinyongTypes;
    }


    /**
	 * 设置：账户状态
	 */
    public void setJinyongTypes(Integer jinyongTypes) {
        this.jinyongTypes = jinyongTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
