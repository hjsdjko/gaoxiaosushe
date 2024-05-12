package com.entity.vo;

import com.entity.SusheguanliyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 宿舍管理员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("susheguanliyuan")
public class SusheguanliyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 工号
     */

    @TableField(value = "susheguanliyuan_uuid_number")
    private String susheguanliyuanUuidNumber;


    /**
     * 宿舍管理员姓名
     */

    @TableField(value = "susheguanliyuan_name")
    private String susheguanliyuanName;


    /**
     * 宿舍管理员手机号
     */

    @TableField(value = "susheguanliyuan_phone")
    private String susheguanliyuanPhone;


    /**
     * 宿舍管理员身份证号
     */

    @TableField(value = "susheguanliyuan_id_number")
    private String susheguanliyuanIdNumber;


    /**
     * 宿舍管理员头像
     */

    @TableField(value = "susheguanliyuan_photo")
    private String susheguanliyuanPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 宿舍管理员邮箱
     */

    @TableField(value = "susheguanliyuan_email")
    private String susheguanliyuanEmail;


    /**
     * 账户状态
     */

    @TableField(value = "jinyong_types")
    private Integer jinyongTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：工号
	 */
    public String getSusheguanliyuanUuidNumber() {
        return susheguanliyuanUuidNumber;
    }


    /**
	 * 获取：工号
	 */

    public void setSusheguanliyuanUuidNumber(String susheguanliyuanUuidNumber) {
        this.susheguanliyuanUuidNumber = susheguanliyuanUuidNumber;
    }
    /**
	 * 设置：宿舍管理员姓名
	 */
    public String getSusheguanliyuanName() {
        return susheguanliyuanName;
    }


    /**
	 * 获取：宿舍管理员姓名
	 */

    public void setSusheguanliyuanName(String susheguanliyuanName) {
        this.susheguanliyuanName = susheguanliyuanName;
    }
    /**
	 * 设置：宿舍管理员手机号
	 */
    public String getSusheguanliyuanPhone() {
        return susheguanliyuanPhone;
    }


    /**
	 * 获取：宿舍管理员手机号
	 */

    public void setSusheguanliyuanPhone(String susheguanliyuanPhone) {
        this.susheguanliyuanPhone = susheguanliyuanPhone;
    }
    /**
	 * 设置：宿舍管理员身份证号
	 */
    public String getSusheguanliyuanIdNumber() {
        return susheguanliyuanIdNumber;
    }


    /**
	 * 获取：宿舍管理员身份证号
	 */

    public void setSusheguanliyuanIdNumber(String susheguanliyuanIdNumber) {
        this.susheguanliyuanIdNumber = susheguanliyuanIdNumber;
    }
    /**
	 * 设置：宿舍管理员头像
	 */
    public String getSusheguanliyuanPhoto() {
        return susheguanliyuanPhoto;
    }


    /**
	 * 获取：宿舍管理员头像
	 */

    public void setSusheguanliyuanPhoto(String susheguanliyuanPhoto) {
        this.susheguanliyuanPhoto = susheguanliyuanPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：宿舍管理员邮箱
	 */
    public String getSusheguanliyuanEmail() {
        return susheguanliyuanEmail;
    }


    /**
	 * 获取：宿舍管理员邮箱
	 */

    public void setSusheguanliyuanEmail(String susheguanliyuanEmail) {
        this.susheguanliyuanEmail = susheguanliyuanEmail;
    }
    /**
	 * 设置：账户状态
	 */
    public Integer getJinyongTypes() {
        return jinyongTypes;
    }


    /**
	 * 获取：账户状态
	 */

    public void setJinyongTypes(Integer jinyongTypes) {
        this.jinyongTypes = jinyongTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
