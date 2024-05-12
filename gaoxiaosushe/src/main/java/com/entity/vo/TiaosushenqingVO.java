package com.entity.vo;

import com.entity.TiaosushenqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 调宿申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tiaosushenqing")
public class TiaosushenqingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 学生
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 公寓
     */

    @TableField(value = "fangwu_id")
    private Integer fangwuId;


    /**
     * 调宿申请编号
     */

    @TableField(value = "tiaosushenqing_uuid_number")
    private String tiaosushenqingUuidNumber;


    /**
     * 申请标题
     */

    @TableField(value = "tiaosushenqing_name")
    private String tiaosushenqingName;


    /**
     * 申请附件
     */

    @TableField(value = "tiaosushenqing_file")
    private String tiaosushenqingFile;


    /**
     * 调宿申请类型
     */

    @TableField(value = "tiaosushenqing_types")
    private Integer tiaosushenqingTypes;


    /**
     * 原宿舍名称
     */

    @TableField(value = "tiaosushenqing_yuan_name")
    private String tiaosushenqingYuanName;


    /**
     * 原宿舍位置
     */

    @TableField(value = "tiaosushenqing_yuan_address")
    private String tiaosushenqingYuanAddress;


    /**
     * 申请缘由
     */

    @TableField(value = "tiaosushenqing_content")
    private String tiaosushenqingContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 申请状态
     */

    @TableField(value = "tiaosushenqing_yesno_types")
    private Integer tiaosushenqingYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "tiaosushenqing_yesno_text")
    private String tiaosushenqingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "tiaosushenqing_shenhe_time")
    private Date tiaosushenqingShenheTime;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：公寓
	 */
    public Integer getFangwuId() {
        return fangwuId;
    }


    /**
	 * 获取：公寓
	 */

    public void setFangwuId(Integer fangwuId) {
        this.fangwuId = fangwuId;
    }
    /**
	 * 设置：调宿申请编号
	 */
    public String getTiaosushenqingUuidNumber() {
        return tiaosushenqingUuidNumber;
    }


    /**
	 * 获取：调宿申请编号
	 */

    public void setTiaosushenqingUuidNumber(String tiaosushenqingUuidNumber) {
        this.tiaosushenqingUuidNumber = tiaosushenqingUuidNumber;
    }
    /**
	 * 设置：申请标题
	 */
    public String getTiaosushenqingName() {
        return tiaosushenqingName;
    }


    /**
	 * 获取：申请标题
	 */

    public void setTiaosushenqingName(String tiaosushenqingName) {
        this.tiaosushenqingName = tiaosushenqingName;
    }
    /**
	 * 设置：申请附件
	 */
    public String getTiaosushenqingFile() {
        return tiaosushenqingFile;
    }


    /**
	 * 获取：申请附件
	 */

    public void setTiaosushenqingFile(String tiaosushenqingFile) {
        this.tiaosushenqingFile = tiaosushenqingFile;
    }
    /**
	 * 设置：调宿申请类型
	 */
    public Integer getTiaosushenqingTypes() {
        return tiaosushenqingTypes;
    }


    /**
	 * 获取：调宿申请类型
	 */

    public void setTiaosushenqingTypes(Integer tiaosushenqingTypes) {
        this.tiaosushenqingTypes = tiaosushenqingTypes;
    }
    /**
	 * 设置：原宿舍名称
	 */
    public String getTiaosushenqingYuanName() {
        return tiaosushenqingYuanName;
    }


    /**
	 * 获取：原宿舍名称
	 */

    public void setTiaosushenqingYuanName(String tiaosushenqingYuanName) {
        this.tiaosushenqingYuanName = tiaosushenqingYuanName;
    }
    /**
	 * 设置：原宿舍位置
	 */
    public String getTiaosushenqingYuanAddress() {
        return tiaosushenqingYuanAddress;
    }


    /**
	 * 获取：原宿舍位置
	 */

    public void setTiaosushenqingYuanAddress(String tiaosushenqingYuanAddress) {
        this.tiaosushenqingYuanAddress = tiaosushenqingYuanAddress;
    }
    /**
	 * 设置：申请缘由
	 */
    public String getTiaosushenqingContent() {
        return tiaosushenqingContent;
    }


    /**
	 * 获取：申请缘由
	 */

    public void setTiaosushenqingContent(String tiaosushenqingContent) {
        this.tiaosushenqingContent = tiaosushenqingContent;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getTiaosushenqingYesnoTypes() {
        return tiaosushenqingYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setTiaosushenqingYesnoTypes(Integer tiaosushenqingYesnoTypes) {
        this.tiaosushenqingYesnoTypes = tiaosushenqingYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getTiaosushenqingYesnoText() {
        return tiaosushenqingYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setTiaosushenqingYesnoText(String tiaosushenqingYesnoText) {
        this.tiaosushenqingYesnoText = tiaosushenqingYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getTiaosushenqingShenheTime() {
        return tiaosushenqingShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setTiaosushenqingShenheTime(Date tiaosushenqingShenheTime) {
        this.tiaosushenqingShenheTime = tiaosushenqingShenheTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
