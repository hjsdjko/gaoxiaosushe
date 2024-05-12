package com.entity.model;

import com.entity.TiaosushenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 调宿申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TiaosushenqingModel implements Serializable {
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
     * 公寓
     */
    private Integer fangwuId;


    /**
     * 调宿申请编号
     */
    private String tiaosushenqingUuidNumber;


    /**
     * 申请标题
     */
    private String tiaosushenqingName;


    /**
     * 申请附件
     */
    private String tiaosushenqingFile;


    /**
     * 调宿申请类型
     */
    private Integer tiaosushenqingTypes;


    /**
     * 原宿舍名称
     */
    private String tiaosushenqingYuanName;


    /**
     * 原宿舍位置
     */
    private String tiaosushenqingYuanAddress;


    /**
     * 申请缘由
     */
    private String tiaosushenqingContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 申请状态
     */
    private Integer tiaosushenqingYesnoTypes;


    /**
     * 审核意见
     */
    private String tiaosushenqingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date tiaosushenqingShenheTime;


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
	 * 获取：调宿申请编号
	 */
    public String getTiaosushenqingUuidNumber() {
        return tiaosushenqingUuidNumber;
    }


    /**
	 * 设置：调宿申请编号
	 */
    public void setTiaosushenqingUuidNumber(String tiaosushenqingUuidNumber) {
        this.tiaosushenqingUuidNumber = tiaosushenqingUuidNumber;
    }
    /**
	 * 获取：申请标题
	 */
    public String getTiaosushenqingName() {
        return tiaosushenqingName;
    }


    /**
	 * 设置：申请标题
	 */
    public void setTiaosushenqingName(String tiaosushenqingName) {
        this.tiaosushenqingName = tiaosushenqingName;
    }
    /**
	 * 获取：申请附件
	 */
    public String getTiaosushenqingFile() {
        return tiaosushenqingFile;
    }


    /**
	 * 设置：申请附件
	 */
    public void setTiaosushenqingFile(String tiaosushenqingFile) {
        this.tiaosushenqingFile = tiaosushenqingFile;
    }
    /**
	 * 获取：调宿申请类型
	 */
    public Integer getTiaosushenqingTypes() {
        return tiaosushenqingTypes;
    }


    /**
	 * 设置：调宿申请类型
	 */
    public void setTiaosushenqingTypes(Integer tiaosushenqingTypes) {
        this.tiaosushenqingTypes = tiaosushenqingTypes;
    }
    /**
	 * 获取：原宿舍名称
	 */
    public String getTiaosushenqingYuanName() {
        return tiaosushenqingYuanName;
    }


    /**
	 * 设置：原宿舍名称
	 */
    public void setTiaosushenqingYuanName(String tiaosushenqingYuanName) {
        this.tiaosushenqingYuanName = tiaosushenqingYuanName;
    }
    /**
	 * 获取：原宿舍位置
	 */
    public String getTiaosushenqingYuanAddress() {
        return tiaosushenqingYuanAddress;
    }


    /**
	 * 设置：原宿舍位置
	 */
    public void setTiaosushenqingYuanAddress(String tiaosushenqingYuanAddress) {
        this.tiaosushenqingYuanAddress = tiaosushenqingYuanAddress;
    }
    /**
	 * 获取：申请缘由
	 */
    public String getTiaosushenqingContent() {
        return tiaosushenqingContent;
    }


    /**
	 * 设置：申请缘由
	 */
    public void setTiaosushenqingContent(String tiaosushenqingContent) {
        this.tiaosushenqingContent = tiaosushenqingContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getTiaosushenqingYesnoTypes() {
        return tiaosushenqingYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setTiaosushenqingYesnoTypes(Integer tiaosushenqingYesnoTypes) {
        this.tiaosushenqingYesnoTypes = tiaosushenqingYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getTiaosushenqingYesnoText() {
        return tiaosushenqingYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setTiaosushenqingYesnoText(String tiaosushenqingYesnoText) {
        this.tiaosushenqingYesnoText = tiaosushenqingYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getTiaosushenqingShenheTime() {
        return tiaosushenqingShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setTiaosushenqingShenheTime(Date tiaosushenqingShenheTime) {
        this.tiaosushenqingShenheTime = tiaosushenqingShenheTime;
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
