package com.entity.model;

import com.entity.WeishengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 卫生
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WeishengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 宿舍管理员
     */
    private Integer susheguanliyuanId;


    /**
     * 公寓
     */
    private Integer fangwuId;


    /**
     * 卫生编号
     */
    private String weishengUuidNumber;


    /**
     * 卫生照片
     */
    private String weishengPhoto;


    /**
     * 卫生状况
     */
    private Integer weishengTypes;


    /**
     * 得分
     */
    private Integer weishengPrice;


    /**
     * 卫生备注
     */
    private String weishengContent;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
