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
 * 访客
 *
 * @author 
 * @email
 */
@TableName("fangke")
public class FangkeEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FangkeEntity() {

	}

	public FangkeEntity(T t) {
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
     * 公寓
     */
    @ColumnInfo(comment="公寓",type="int(11)")
    @TableField(value = "fangwu_id")

    private Integer fangwuId;


    /**
     * 学生
     */
    @ColumnInfo(comment="学生",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 访客姓名
     */
    @ColumnInfo(comment="访客姓名",type="varchar(200)")
    @TableField(value = "fangke_name")

    private String fangkeName;


    /**
     * 访客手机号
     */
    @ColumnInfo(comment="访客手机号",type="varchar(200)")
    @TableField(value = "fangke_phone")

    private String fangkePhone;


    /**
     * 访客身份证号
     */
    @ColumnInfo(comment="访客身份证号",type="varchar(200)")
    @TableField(value = "fangke_id_number")

    private String fangkeIdNumber;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 来访事由
     */
    @ColumnInfo(comment="来访事由",type="longtext")
    @TableField(value = "fangke_content")

    private String fangkeContent;


    /**
     * 来访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="来访时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 离开时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="离开时间",type="timestamp")
    @TableField(value = "likai_time")

    private Date likaiTime;


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

    @Override
    public String toString() {
        return "Fangke{" +
            ", id=" + id +
            ", fangwuId=" + fangwuId +
            ", yonghuId=" + yonghuId +
            ", fangkeName=" + fangkeName +
            ", fangkePhone=" + fangkePhone +
            ", fangkeIdNumber=" + fangkeIdNumber +
            ", sexTypes=" + sexTypes +
            ", fangkeContent=" + fangkeContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", likaiTime=" + DateUtil.convertString(likaiTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
