package com.entity.model;

import com.entity.FangkeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 访客
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangkeModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 公寓
     */
    private Integer fangwuId;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 访客姓名
     */
    private String fangkeName;


    /**
     * 访客手机号
     */
    private String fangkePhone;


    /**
     * 访客身份证号
     */
    private String fangkeIdNumber;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 来访事由
     */
    private String fangkeContent;


    /**
     * 来访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 离开时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date likaiTime;


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
	 * 获取：公寓
	 */
    public Integer getFangwuId() {
        return fangwuId;
    }


    /**
	 * 设置：公寓
	 */
    public void setFangwuId(Integer fangwuId) {
        this.fangwuId = fangwuId;
    }
    /**
	 * 获取：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：学生
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：访客姓名
	 */
    public String getFangkeName() {
        return fangkeName;
    }


    /**
	 * 设置：访客姓名
	 */
    public void setFangkeName(String fangkeName) {
        this.fangkeName = fangkeName;
    }
    /**
	 * 获取：访客手机号
	 */
    public String getFangkePhone() {
        return fangkePhone;
    }


    /**
	 * 设置：访客手机号
	 */
    public void setFangkePhone(String fangkePhone) {
        this.fangkePhone = fangkePhone;
    }
    /**
	 * 获取：访客身份证号
	 */
    public String getFangkeIdNumber() {
        return fangkeIdNumber;
    }


    /**
	 * 设置：访客身份证号
	 */
    public void setFangkeIdNumber(String fangkeIdNumber) {
        this.fangkeIdNumber = fangkeIdNumber;
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
	 * 获取：来访事由
	 */
    public String getFangkeContent() {
        return fangkeContent;
    }


    /**
	 * 设置：来访事由
	 */
    public void setFangkeContent(String fangkeContent) {
        this.fangkeContent = fangkeContent;
    }
    /**
	 * 获取：来访时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：来访时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：离开时间
	 */
    public Date getLikaiTime() {
        return likaiTime;
    }


    /**
	 * 设置：离开时间
	 */
    public void setLikaiTime(Date likaiTime) {
        this.likaiTime = likaiTime;
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
