package com.entity.model;

import com.entity.LiuyanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 留言
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LiuyanModel implements Serializable {
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
     * 留言编号
     */
    private String liuyanUuidNumber;


    /**
     * 留言标题
     */
    private String liuyanName;


    /**
     * 附件
     */
    private String liuyanFile;


    /**
     * 留言类型
     */
    private Integer liuyanTypes;


    /**
     * 留言内容
     */
    private String liuyanContent;


    /**
     * 留言时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 回复内容
     */
    private String liuyanHuifuContent;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date updateTime;


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
