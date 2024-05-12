package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 调宿申请
 *
 * @author 
 * @email
 */
@TableName("tiaosushenqing")
public class TiaosushenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TiaosushenqingEntity() {

	}

	public TiaosushenqingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 学生
     */
    @ColumnInfo(comment="学生",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 公寓
     */
    @ColumnInfo(comment="公寓",type="int(11)")
    @TableField(value = "fangwu_id")

    private Integer fangwuId;


    /**
     * 调宿申请编号
     */
    @ColumnInfo(comment="调宿申请编号",type="varchar(200)")
    @TableField(value = "tiaosushenqing_uuid_number")

    private String tiaosushenqingUuidNumber;


    /**
     * 申请标题
     */
    @ColumnInfo(comment="申请标题",type="varchar(200)")
    @TableField(value = "tiaosushenqing_name")

    private String tiaosushenqingName;


    /**
     * 申请附件
     */
    @ColumnInfo(comment="申请附件",type="varchar(200)")
    @TableField(value = "tiaosushenqing_file")

    private String tiaosushenqingFile;


    /**
     * 调宿申请类型
     */
    @ColumnInfo(comment="调宿申请类型",type="int(11)")
    @TableField(value = "tiaosushenqing_types")

    private Integer tiaosushenqingTypes;


    /**
     * 原宿舍名称
     */
    @ColumnInfo(comment="原宿舍名称",type="varchar(200)")
    @TableField(value = "tiaosushenqing_yuan_name")

    private String tiaosushenqingYuanName;


    /**
     * 原宿舍位置
     */
    @ColumnInfo(comment="原宿舍位置",type="varchar(200)")
    @TableField(value = "tiaosushenqing_yuan_address")

    private String tiaosushenqingYuanAddress;


    /**
     * 申请缘由
     */
    @ColumnInfo(comment="申请缘由",type="longtext")
    @TableField(value = "tiaosushenqing_content")

    private String tiaosushenqingContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "tiaosushenqing_yesno_types")

    private Integer tiaosushenqingYesnoTypes;


    /**
     * 审核意见
     */
    @ColumnInfo(comment="审核意见",type="longtext")
    @TableField(value = "tiaosushenqing_yesno_text")

    private String tiaosushenqingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "tiaosushenqing_shenhe_time")

    private Date tiaosushenqingShenheTime;


    /**
     * 创建时间   listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Tiaosushenqing{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", fangwuId=" + fangwuId +
            ", tiaosushenqingUuidNumber=" + tiaosushenqingUuidNumber +
            ", tiaosushenqingName=" + tiaosushenqingName +
            ", tiaosushenqingFile=" + tiaosushenqingFile +
            ", tiaosushenqingTypes=" + tiaosushenqingTypes +
            ", tiaosushenqingYuanName=" + tiaosushenqingYuanName +
            ", tiaosushenqingYuanAddress=" + tiaosushenqingYuanAddress +
            ", tiaosushenqingContent=" + tiaosushenqingContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", tiaosushenqingYesnoTypes=" + tiaosushenqingYesnoTypes +
            ", tiaosushenqingYesnoText=" + tiaosushenqingYesnoText +
            ", tiaosushenqingShenheTime=" + DateUtil.convertString(tiaosushenqingShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
