package com.entity.vo;

import com.entity.FangwuTuisuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 公寓退宿申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangwu_tuisu")
public class FangwuTuisuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 退宿编号
     */

    @TableField(value = "fangwu_tuisu_uuid_number")
    private String fangwuTuisuUuidNumber;


    /**
     * 公寓
     */

    @TableField(value = "fangwu_id")
    private Integer fangwuId;


    /**
     * 学生
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 申请理由
     */

    @TableField(value = "fangwu_tuisu_text")
    private String fangwuTuisuText;


    /**
     * 申请退宿时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 申请状态
     */

    @TableField(value = "fangwu_tuisu_yesno_types")
    private Integer fangwuTuisuYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "fangwu_tuisu_yesno_text")
    private String fangwuTuisuYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fangwu_tuisu_shenhe_time")
    private Date fangwuTuisuShenheTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：退宿编号
	 */
    public String getFangwuTuisuUuidNumber() {
        return fangwuTuisuUuidNumber;
    }


    /**
	 * 获取：退宿编号
	 */

    public void setFangwuTuisuUuidNumber(String fangwuTuisuUuidNumber) {
        this.fangwuTuisuUuidNumber = fangwuTuisuUuidNumber;
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
	 * 设置：申请理由
	 */
    public String getFangwuTuisuText() {
        return fangwuTuisuText;
    }


    /**
	 * 获取：申请理由
	 */

    public void setFangwuTuisuText(String fangwuTuisuText) {
        this.fangwuTuisuText = fangwuTuisuText;
    }
    /**
	 * 设置：申请退宿时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请退宿时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getFangwuTuisuYesnoTypes() {
        return fangwuTuisuYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setFangwuTuisuYesnoTypes(Integer fangwuTuisuYesnoTypes) {
        this.fangwuTuisuYesnoTypes = fangwuTuisuYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getFangwuTuisuYesnoText() {
        return fangwuTuisuYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setFangwuTuisuYesnoText(String fangwuTuisuYesnoText) {
        this.fangwuTuisuYesnoText = fangwuTuisuYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getFangwuTuisuShenheTime() {
        return fangwuTuisuShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setFangwuTuisuShenheTime(Date fangwuTuisuShenheTime) {
        this.fangwuTuisuShenheTime = fangwuTuisuShenheTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
