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
 * 卫生
 *
 * @author 
 * @email
 */
@TableName("weisheng")
public class WeishengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WeishengEntity() {

	}

	public WeishengEntity(T t) {
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
     * 宿舍管理员
     */
    @ColumnInfo(comment="宿舍管理员",type="int(11)")
    @TableField(value = "susheguanliyuan_id")

    private Integer susheguanliyuanId;


    /**
     * 公寓
     */
    @ColumnInfo(comment="公寓",type="int(11)")
    @TableField(value = "fangwu_id")

    private Integer fangwuId;


    /**
     * 卫生编号
     */
    @ColumnInfo(comment="卫生编号",type="varchar(200)")
    @TableField(value = "weisheng_uuid_number")

    private String weishengUuidNumber;


    /**
     * 卫生照片
     */
    @ColumnInfo(comment="卫生照片",type="varchar(200)")
    @TableField(value = "weisheng_photo")

    private String weishengPhoto;


    /**
     * 卫生状况
     */
    @ColumnInfo(comment="卫生状况",type="int(11)")
    @TableField(value = "weisheng_types")

    private Integer weishengTypes;


    /**
     * 得分
     */
    @ColumnInfo(comment="得分",type="int(11)")
    @TableField(value = "weisheng_price")

    private Integer weishengPrice;


    /**
     * 卫生备注
     */
    @ColumnInfo(comment="卫生备注",type="longtext")
    @TableField(value = "weisheng_content")

    private String weishengContent;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @ColumnInfo(comment="所属日期",type="date")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：卫生编号
	 */
    public String getWeishengUuidNumber() {
        return weishengUuidNumber;
    }
    /**
	 * 设置：卫生编号
	 */

    public void setWeishengUuidNumber(String weishengUuidNumber) {
        this.weishengUuidNumber = weishengUuidNumber;
    }
    /**
	 * 获取：卫生照片
	 */
    public String getWeishengPhoto() {
        return weishengPhoto;
    }
    /**
	 * 设置：卫生照片
	 */

    public void setWeishengPhoto(String weishengPhoto) {
        this.weishengPhoto = weishengPhoto;
    }
    /**
	 * 获取：卫生状况
	 */
    public Integer getWeishengTypes() {
        return weishengTypes;
    }
    /**
	 * 设置：卫生状况
	 */

    public void setWeishengTypes(Integer weishengTypes) {
        this.weishengTypes = weishengTypes;
    }
    /**
	 * 获取：得分
	 */
    public Integer getWeishengPrice() {
        return weishengPrice;
    }
    /**
	 * 设置：得分
	 */

    public void setWeishengPrice(Integer weishengPrice) {
        this.weishengPrice = weishengPrice;
    }
    /**
	 * 获取：卫生备注
	 */
    public String getWeishengContent() {
        return weishengContent;
    }
    /**
	 * 设置：卫生备注
	 */

    public void setWeishengContent(String weishengContent) {
        this.weishengContent = weishengContent;
    }
    /**
	 * 获取：所属日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：所属日期
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Weisheng{" +
            ", id=" + id +
            ", susheguanliyuanId=" + susheguanliyuanId +
            ", fangwuId=" + fangwuId +
            ", weishengUuidNumber=" + weishengUuidNumber +
            ", weishengPhoto=" + weishengPhoto +
            ", weishengTypes=" + weishengTypes +
            ", weishengPrice=" + weishengPrice +
            ", weishengContent=" + weishengContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
