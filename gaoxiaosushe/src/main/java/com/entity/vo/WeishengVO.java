package com.entity.vo;

import com.entity.WeishengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 卫生
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("weisheng")
public class WeishengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 宿舍管理员
     */

    @TableField(value = "susheguanliyuan_id")
    private Integer susheguanliyuanId;


    /**
     * 公寓
     */

    @TableField(value = "fangwu_id")
    private Integer fangwuId;


    /**
     * 卫生编号
     */

    @TableField(value = "weisheng_uuid_number")
    private String weishengUuidNumber;


    /**
     * 卫生照片
     */

    @TableField(value = "weisheng_photo")
    private String weishengPhoto;


    /**
     * 卫生状况
     */

    @TableField(value = "weisheng_types")
    private Integer weishengTypes;


    /**
     * 得分
     */

    @TableField(value = "weisheng_price")
    private Integer weishengPrice;


    /**
     * 卫生备注
     */

    @TableField(value = "weisheng_content")
    private String weishengContent;


    /**
     * 所属日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：卫生编号
	 */
    public String getWeishengUuidNumber() {
        return weishengUuidNumber;
    }


    /**
	 * 获取：卫生编号
	 */

    public void setWeishengUuidNumber(String weishengUuidNumber) {
        this.weishengUuidNumber = weishengUuidNumber;
    }
    /**
	 * 设置：卫生照片
	 */
    public String getWeishengPhoto() {
        return weishengPhoto;
    }


    /**
	 * 获取：卫生照片
	 */

    public void setWeishengPhoto(String weishengPhoto) {
        this.weishengPhoto = weishengPhoto;
    }
    /**
	 * 设置：卫生状况
	 */
    public Integer getWeishengTypes() {
        return weishengTypes;
    }


    /**
	 * 获取：卫生状况
	 */

    public void setWeishengTypes(Integer weishengTypes) {
        this.weishengTypes = weishengTypes;
    }
    /**
	 * 设置：得分
	 */
    public Integer getWeishengPrice() {
        return weishengPrice;
    }


    /**
	 * 获取：得分
	 */

    public void setWeishengPrice(Integer weishengPrice) {
        this.weishengPrice = weishengPrice;
    }
    /**
	 * 设置：卫生备注
	 */
    public String getWeishengContent() {
        return weishengContent;
    }


    /**
	 * 获取：卫生备注
	 */

    public void setWeishengContent(String weishengContent) {
        this.weishengContent = weishengContent;
    }
    /**
	 * 设置：所属日期
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：所属日期
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
