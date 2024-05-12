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
 * 留言
 *
 * @author 
 * @email
 */
@TableName("liuyan")
public class LiuyanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LiuyanEntity() {

	}

	public LiuyanEntity(T t) {
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
     * 留言编号
     */
    @ColumnInfo(comment="留言编号",type="varchar(200)")
    @TableField(value = "liuyan_uuid_number")

    private String liuyanUuidNumber;


    /**
     * 留言标题
     */
    @ColumnInfo(comment="留言标题",type="varchar(200)")
    @TableField(value = "liuyan_name")

    private String liuyanName;


    /**
     * 附件
     */
    @ColumnInfo(comment="附件",type="varchar(200)")
    @TableField(value = "liuyan_file")

    private String liuyanFile;


    /**
     * 留言类型
     */
    @ColumnInfo(comment="留言类型",type="int(11)")
    @TableField(value = "liuyan_types")

    private Integer liuyanTypes;


    /**
     * 留言内容
     */
    @ColumnInfo(comment="留言内容",type="longtext")
    @TableField(value = "liuyan_content")

    private String liuyanContent;


    /**
     * 留言时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="留言时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 回复内容
     */
    @ColumnInfo(comment="回复内容",type="longtext")
    @TableField(value = "liuyan_huifu_content")

    private String liuyanHuifuContent;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="回复时间",type="timestamp")
    @TableField(value = "update_time",fill = FieldFill.UPDATE)

    private Date updateTime;


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
	 * 获取：留言编号
	 */
    public String getLiuyanUuidNumber() {
        return liuyanUuidNumber;
    }
    /**
	 * 设置：留言编号
	 */

    public void setLiuyanUuidNumber(String liuyanUuidNumber) {
        this.liuyanUuidNumber = liuyanUuidNumber;
    }
    /**
	 * 获取：留言标题
	 */
    public String getLiuyanName() {
        return liuyanName;
    }
    /**
	 * 设置：留言标题
	 */

    public void setLiuyanName(String liuyanName) {
        this.liuyanName = liuyanName;
    }
    /**
	 * 获取：附件
	 */
    public String getLiuyanFile() {
        return liuyanFile;
    }
    /**
	 * 设置：附件
	 */

    public void setLiuyanFile(String liuyanFile) {
        this.liuyanFile = liuyanFile;
    }
    /**
	 * 获取：留言类型
	 */
    public Integer getLiuyanTypes() {
        return liuyanTypes;
    }
    /**
	 * 设置：留言类型
	 */

    public void setLiuyanTypes(Integer liuyanTypes) {
        this.liuyanTypes = liuyanTypes;
    }
    /**
	 * 获取：留言内容
	 */
    public String getLiuyanContent() {
        return liuyanContent;
    }
    /**
	 * 设置：留言内容
	 */

    public void setLiuyanContent(String liuyanContent) {
        this.liuyanContent = liuyanContent;
    }
    /**
	 * 获取：留言时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：留言时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：回复内容
	 */
    public String getLiuyanHuifuContent() {
        return liuyanHuifuContent;
    }
    /**
	 * 设置：回复内容
	 */

    public void setLiuyanHuifuContent(String liuyanHuifuContent) {
        this.liuyanHuifuContent = liuyanHuifuContent;
    }
    /**
	 * 获取：回复时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
	 * 设置：回复时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        return "Liuyan{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", liuyanUuidNumber=" + liuyanUuidNumber +
            ", liuyanName=" + liuyanName +
            ", liuyanFile=" + liuyanFile +
            ", liuyanTypes=" + liuyanTypes +
            ", liuyanContent=" + liuyanContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", liuyanHuifuContent=" + liuyanHuifuContent +
            ", updateTime=" + DateUtil.convertString(updateTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
