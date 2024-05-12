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
 * 公寓
 *
 * @author 
 * @email
 */
@TableName("fangwu")
public class FangwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangwuEntity() {

	}

	public FangwuEntity(T t) {
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
     * 房屋名称
     */
    @ColumnInfo(comment="房屋名称",type="varchar(200)")
    @TableField(value = "fangwu_name")

    private String fangwuName;


    /**
     * 公寓编号
     */
    @ColumnInfo(comment="公寓编号",type="varchar(200)")
    @TableField(value = "fangwu_uuid_number")

    private String fangwuUuidNumber;


    /**
     * 公寓照片
     */
    @ColumnInfo(comment="公寓照片",type="varchar(200)")
    @TableField(value = "fangwu_photo")

    private String fangwuPhoto;


    /**
     * 房屋位置
     */
    @ColumnInfo(comment="房屋位置",type="varchar(200)")
    @TableField(value = "fangwu_address")

    private String fangwuAddress;


    /**
     * 公寓类型
     */
    @ColumnInfo(comment="公寓类型",type="int(11)")
    @TableField(value = "fangwu_types")

    private Integer fangwuTypes;


    /**
     * 房租/月
     */
    @ColumnInfo(comment="房租/月",type="decimal(10,2)")
    @TableField(value = "fangwu_new_money")

    private Double fangwuNewMoney;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 限制人数
     */
    @ColumnInfo(comment="限制人数",type="int(11)")
    @TableField(value = "fangwu_renshu")

    private Integer fangwuRenshu;


    /**
     * 已住人数
     */
    @ColumnInfo(comment="已住人数",type="int(11)")
    @TableField(value = "fangwu_yizhurenshu")

    private Integer fangwuYizhurenshu;


    /**
     * 公寓介绍
     */
    @ColumnInfo(comment="公寓介绍",type="longtext")
    @TableField(value = "fangwu_content")

    private String fangwuContent;


    /**
     * 是否上架
     */
    @ColumnInfo(comment="是否上架",type="int(11)")
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "fangwu_delete")

    private Integer fangwuDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：房屋名称
	 */
    public String getFangwuName() {
        return fangwuName;
    }
    /**
	 * 设置：房屋名称
	 */

    public void setFangwuName(String fangwuName) {
        this.fangwuName = fangwuName;
    }
    /**
	 * 获取：公寓编号
	 */
    public String getFangwuUuidNumber() {
        return fangwuUuidNumber;
    }
    /**
	 * 设置：公寓编号
	 */

    public void setFangwuUuidNumber(String fangwuUuidNumber) {
        this.fangwuUuidNumber = fangwuUuidNumber;
    }
    /**
	 * 获取：公寓照片
	 */
    public String getFangwuPhoto() {
        return fangwuPhoto;
    }
    /**
	 * 设置：公寓照片
	 */

    public void setFangwuPhoto(String fangwuPhoto) {
        this.fangwuPhoto = fangwuPhoto;
    }
    /**
	 * 获取：房屋位置
	 */
    public String getFangwuAddress() {
        return fangwuAddress;
    }
    /**
	 * 设置：房屋位置
	 */

    public void setFangwuAddress(String fangwuAddress) {
        this.fangwuAddress = fangwuAddress;
    }
    /**
	 * 获取：公寓类型
	 */
    public Integer getFangwuTypes() {
        return fangwuTypes;
    }
    /**
	 * 设置：公寓类型
	 */

    public void setFangwuTypes(Integer fangwuTypes) {
        this.fangwuTypes = fangwuTypes;
    }
    /**
	 * 获取：房租/月
	 */
    public Double getFangwuNewMoney() {
        return fangwuNewMoney;
    }
    /**
	 * 设置：房租/月
	 */

    public void setFangwuNewMoney(Double fangwuNewMoney) {
        this.fangwuNewMoney = fangwuNewMoney;
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
	 * 获取：限制人数
	 */
    public Integer getFangwuRenshu() {
        return fangwuRenshu;
    }
    /**
	 * 设置：限制人数
	 */

    public void setFangwuRenshu(Integer fangwuRenshu) {
        this.fangwuRenshu = fangwuRenshu;
    }
    /**
	 * 获取：已住人数
	 */
    public Integer getFangwuYizhurenshu() {
        return fangwuYizhurenshu;
    }
    /**
	 * 设置：已住人数
	 */

    public void setFangwuYizhurenshu(Integer fangwuYizhurenshu) {
        this.fangwuYizhurenshu = fangwuYizhurenshu;
    }
    /**
	 * 获取：公寓介绍
	 */
    public String getFangwuContent() {
        return fangwuContent;
    }
    /**
	 * 设置：公寓介绍
	 */

    public void setFangwuContent(String fangwuContent) {
        this.fangwuContent = fangwuContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }
    /**
	 * 设置：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getFangwuDelete() {
        return fangwuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setFangwuDelete(Integer fangwuDelete) {
        this.fangwuDelete = fangwuDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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

    @Override
    public String toString() {
        return "Fangwu{" +
            ", id=" + id +
            ", susheguanliyuanId=" + susheguanliyuanId +
            ", fangwuName=" + fangwuName +
            ", fangwuUuidNumber=" + fangwuUuidNumber +
            ", fangwuPhoto=" + fangwuPhoto +
            ", fangwuAddress=" + fangwuAddress +
            ", fangwuTypes=" + fangwuTypes +
            ", fangwuNewMoney=" + fangwuNewMoney +
            ", sexTypes=" + sexTypes +
            ", fangwuRenshu=" + fangwuRenshu +
            ", fangwuYizhurenshu=" + fangwuYizhurenshu +
            ", fangwuContent=" + fangwuContent +
            ", shangxiaTypes=" + shangxiaTypes +
            ", fangwuDelete=" + fangwuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
