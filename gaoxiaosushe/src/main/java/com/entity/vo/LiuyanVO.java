package com.entity.vo;

import com.entity.LiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 留言
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("liuyan")
public class LiuyanVO implements Serializable {
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
     * 留言编号
     */

    @TableField(value = "liuyan_uuid_number")
    private String liuyanUuidNumber;


    /**
     * 留言标题
     */

    @TableField(value = "liuyan_name")
    private String liuyanName;


    /**
     * 附件
     */

    @TableField(value = "liuyan_file")
    private String liuyanFile;


    /**
     * 留言类型
     */

    @TableField(value = "liuyan_types")
    private Integer liuyanTypes;


    /**
     * 留言内容
     */

    @TableField(value = "liuyan_content")
    private String liuyanContent;


    /**
     * 留言时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 回复内容
     */

    @TableField(value = "liuyan_huifu_content")
    private String liuyanHuifuContent;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "update_time")
    private Date updateTime;


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
	 * 设置：留言编号
	 */
    public String getLiuyanUuidNumber() {
        return liuyanUuidNumber;
    }


    /**
	 * 获取：留言编号
	 */

    public void setLiuyanUuidNumber(String liuyanUuidNumber) {
        this.liuyanUuidNumber = liuyanUuidNumber;
    }
    /**
	 * 设置：留言标题
	 */
    public String getLiuyanName() {
        return liuyanName;
    }


    /**
	 * 获取：留言标题
	 */

    public void setLiuyanName(String liuyanName) {
        this.liuyanName = liuyanName;
    }
    /**
	 * 设置：附件
	 */
    public String getLiuyanFile() {
        return liuyanFile;
    }


    /**
	 * 获取：附件
	 */

    public void setLiuyanFile(String liuyanFile) {
        this.liuyanFile = liuyanFile;
    }
    /**
	 * 设置：留言类型
	 */
    public Integer getLiuyanTypes() {
        return liuyanTypes;
    }


    /**
	 * 获取：留言类型
	 */

    public void setLiuyanTypes(Integer liuyanTypes) {
        this.liuyanTypes = liuyanTypes;
    }
    /**
	 * 设置：留言内容
	 */
    public String getLiuyanContent() {
        return liuyanContent;
    }


    /**
	 * 获取：留言内容
	 */

    public void setLiuyanContent(String liuyanContent) {
        this.liuyanContent = liuyanContent;
    }
    /**
	 * 设置：留言时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：留言时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：回复内容
	 */
    public String getLiuyanHuifuContent() {
        return liuyanHuifuContent;
    }


    /**
	 * 获取：回复内容
	 */

    public void setLiuyanHuifuContent(String liuyanHuifuContent) {
        this.liuyanHuifuContent = liuyanHuifuContent;
    }
    /**
	 * 设置：回复时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 获取：回复时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
