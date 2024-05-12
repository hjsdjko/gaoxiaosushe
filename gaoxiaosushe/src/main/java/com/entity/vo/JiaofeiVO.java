package com.entity.vo;

import com.entity.JiaofeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 缴费
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaofei")
public class JiaofeiVO implements Serializable {
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
     * 宿舍管理员
     */

    @TableField(value = "susheguanliyuan_id")
    private Integer susheguanliyuanId;


    /**
     * 缴费编号
     */

    @TableField(value = "jiaofei_uuid_number")
    private String jiaofeiUuidNumber;


    /**
     * 缴费标题
     */

    @TableField(value = "jiaofei_name")
    private String jiaofeiName;


    /**
     * 缴费附件
     */

    @TableField(value = "jiaofei_photo")
    private String jiaofeiPhoto;


    /**
     * 缴费金额
     */

    @TableField(value = "jiaofei_money")
    private Double jiaofeiMoney;


    /**
     * 缴费缘由
     */

    @TableField(value = "jiaofei_content")
    private String jiaofeiContent;


    /**
     * 通知时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 缴费状态
     */

    @TableField(value = "jiaofei_types")
    private Integer jiaofeiTypes;


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
	 * 设置：宿舍管理员
	 */
    public Integer getSusheguanliyuanId() {
        return susheguanliyuanId;
    }


    /**
	 * 获取：宿舍管理员
	 */

    public void setSusheguanliyuanId(Integer susheguanliyuanId) {
        this.susheguanliyuanId = susheguanliyuanId;
    }
    /**
	 * 设置：缴费编号
	 */
    public String getJiaofeiUuidNumber() {
        return jiaofeiUuidNumber;
    }


    /**
	 * 获取：缴费编号
	 */

    public void setJiaofeiUuidNumber(String jiaofeiUuidNumber) {
        this.jiaofeiUuidNumber = jiaofeiUuidNumber;
    }
    /**
	 * 设置：缴费标题
	 */
    public String getJiaofeiName() {
        return jiaofeiName;
    }


    /**
	 * 获取：缴费标题
	 */

    public void setJiaofeiName(String jiaofeiName) {
        this.jiaofeiName = jiaofeiName;
    }
    /**
	 * 设置：缴费附件
	 */
    public String getJiaofeiPhoto() {
        return jiaofeiPhoto;
    }


    /**
	 * 获取：缴费附件
	 */

    public void setJiaofeiPhoto(String jiaofeiPhoto) {
        this.jiaofeiPhoto = jiaofeiPhoto;
    }
    /**
	 * 设置：缴费金额
	 */
    public Double getJiaofeiMoney() {
        return jiaofeiMoney;
    }


    /**
	 * 获取：缴费金额
	 */

    public void setJiaofeiMoney(Double jiaofeiMoney) {
        this.jiaofeiMoney = jiaofeiMoney;
    }
    /**
	 * 设置：缴费缘由
	 */
    public String getJiaofeiContent() {
        return jiaofeiContent;
    }


    /**
	 * 获取：缴费缘由
	 */

    public void setJiaofeiContent(String jiaofeiContent) {
        this.jiaofeiContent = jiaofeiContent;
    }
    /**
	 * 设置：通知时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：通知时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：缴费状态
	 */
    public Integer getJiaofeiTypes() {
        return jiaofeiTypes;
    }


    /**
	 * 获取：缴费状态
	 */

    public void setJiaofeiTypes(Integer jiaofeiTypes) {
        this.jiaofeiTypes = jiaofeiTypes;
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
