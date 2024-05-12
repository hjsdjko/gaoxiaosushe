package com.entity.model;

import com.entity.JiaofeiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 缴费
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaofeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 宿舍管理员
     */
    private Integer susheguanliyuanId;


    /**
     * 缴费编号
     */
    private String jiaofeiUuidNumber;


    /**
     * 缴费标题
     */
    private String jiaofeiName;


    /**
     * 缴费附件
     */
    private String jiaofeiPhoto;


    /**
     * 缴费金额
     */
    private Double jiaofeiMoney;


    /**
     * 缴费缘由
     */
    private String jiaofeiContent;


    /**
     * 通知时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 缴费状态
     */
    private Integer jiaofeiTypes;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：宿舍管理员
	 */
    public Integer getSusheguanliyuanId() {
        return susheguanliyuanId;
    }


    /**
	 * 设置：宿舍管理员
	 */
    public void setSusheguanliyuanId(Integer susheguanliyuanId) {
        this.susheguanliyuanId = susheguanliyuanId;
    }
    /**
	 * 获取：缴费编号
	 */
    public String getJiaofeiUuidNumber() {
        return jiaofeiUuidNumber;
    }


    /**
	 * 设置：缴费编号
	 */
    public void setJiaofeiUuidNumber(String jiaofeiUuidNumber) {
        this.jiaofeiUuidNumber = jiaofeiUuidNumber;
    }
    /**
	 * 获取：缴费标题
	 */
    public String getJiaofeiName() {
        return jiaofeiName;
    }


    /**
	 * 设置：缴费标题
	 */
    public void setJiaofeiName(String jiaofeiName) {
        this.jiaofeiName = jiaofeiName;
    }
    /**
	 * 获取：缴费附件
	 */
    public String getJiaofeiPhoto() {
        return jiaofeiPhoto;
    }


    /**
	 * 设置：缴费附件
	 */
    public void setJiaofeiPhoto(String jiaofeiPhoto) {
        this.jiaofeiPhoto = jiaofeiPhoto;
    }
    /**
	 * 获取：缴费金额
	 */
    public Double getJiaofeiMoney() {
        return jiaofeiMoney;
    }


    /**
	 * 设置：缴费金额
	 */
    public void setJiaofeiMoney(Double jiaofeiMoney) {
        this.jiaofeiMoney = jiaofeiMoney;
    }
    /**
	 * 获取：缴费缘由
	 */
    public String getJiaofeiContent() {
        return jiaofeiContent;
    }


    /**
	 * 设置：缴费缘由
	 */
    public void setJiaofeiContent(String jiaofeiContent) {
        this.jiaofeiContent = jiaofeiContent;
    }
    /**
	 * 获取：通知时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：通知时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：缴费状态
	 */
    public Integer getJiaofeiTypes() {
        return jiaofeiTypes;
    }


    /**
	 * 设置：缴费状态
	 */
    public void setJiaofeiTypes(Integer jiaofeiTypes) {
        this.jiaofeiTypes = jiaofeiTypes;
    }
    /**
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
