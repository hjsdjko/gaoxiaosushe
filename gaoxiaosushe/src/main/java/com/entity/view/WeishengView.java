package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WeishengEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 卫生
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("weisheng")
public class WeishengView extends WeishengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 卫生状况的值
	*/
	@ColumnInfo(comment="卫生状况的字典表值",type="varchar(200)")
	private String weishengValue;

	//级联表 公寓
					 
		/**
		* 公寓 的 宿舍管理员
		*/
		@ColumnInfo(comment="宿舍管理员",type="int(11)")
		private Integer fangwuSusheguanliyuanId;
		/**
		* 房屋名称
		*/

		@ColumnInfo(comment="房屋名称",type="varchar(200)")
		private String fangwuName;
		/**
		* 公寓编号
		*/

		@ColumnInfo(comment="公寓编号",type="varchar(200)")
		private String fangwuUuidNumber;
		/**
		* 公寓照片
		*/

		@ColumnInfo(comment="公寓照片",type="varchar(200)")
		private String fangwuPhoto;
		/**
		* 房屋位置
		*/

		@ColumnInfo(comment="房屋位置",type="varchar(200)")
		private String fangwuAddress;
		/**
		* 公寓类型
		*/
		@ColumnInfo(comment="公寓类型",type="int(11)")
		private Integer fangwuTypes;
			/**
			* 公寓类型的值
			*/
			@ColumnInfo(comment="公寓类型的字典表值",type="varchar(200)")
			private String fangwuValue;
		/**
		* 房租/月
		*/
		@ColumnInfo(comment="房租/月",type="decimal(10,2)")
		private Double fangwuNewMoney;
		/**
		* 限制人数
		*/

		@ColumnInfo(comment="限制人数",type="int(11)")
		private Integer fangwuRenshu;
		/**
		* 已住人数
		*/

		@ColumnInfo(comment="已住人数",type="int(11)")
		private Integer fangwuYizhurenshu;
		/**
		* 公寓介绍
		*/

		@ColumnInfo(comment="公寓介绍",type="longtext")
		private String fangwuContent;
		/**
		* 是否上架
		*/
		@ColumnInfo(comment="是否上架",type="int(11)")
		private Integer shangxiaTypes;
			/**
			* 是否上架的值
			*/
			@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
			private String shangxiaValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer fangwuDelete;
	//级联表 宿舍管理员
		/**
		* 工号
		*/

		@ColumnInfo(comment="工号",type="varchar(200)")
		private String susheguanliyuanUuidNumber;
		/**
		* 宿舍管理员姓名
		*/

		@ColumnInfo(comment="宿舍管理员姓名",type="varchar(200)")
		private String susheguanliyuanName;
		/**
		* 宿舍管理员手机号
		*/

		@ColumnInfo(comment="宿舍管理员手机号",type="varchar(200)")
		private String susheguanliyuanPhone;
		/**
		* 宿舍管理员身份证号
		*/

		@ColumnInfo(comment="宿舍管理员身份证号",type="varchar(200)")
		private String susheguanliyuanIdNumber;
		/**
		* 宿舍管理员头像
		*/

		@ColumnInfo(comment="宿舍管理员头像",type="varchar(200)")
		private String susheguanliyuanPhoto;
		/**
		* 宿舍管理员邮箱
		*/

		@ColumnInfo(comment="宿舍管理员邮箱",type="varchar(200)")
		private String susheguanliyuanEmail;
		/**
		* 账户状态
		*/
		@ColumnInfo(comment="账户状态",type="int(11)")
		private Integer jinyongTypes;
			/**
			* 账户状态的值
			*/
			@ColumnInfo(comment="账户状态的字典表值",type="varchar(200)")
			private String jinyongValue;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public WeishengView() {

	}

	public WeishengView(WeishengEntity weishengEntity) {
		try {
			BeanUtils.copyProperties(this, weishengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 卫生状况的值
	*/
	public String getWeishengValue() {
		return weishengValue;
	}
	/**
	* 设置： 卫生状况的值
	*/
	public void setWeishengValue(String weishengValue) {
		this.weishengValue = weishengValue;
	}


	//级联表的get和set 公寓
		/**
		* 获取：公寓 的 宿舍管理员
		*/
		public Integer getFangwuSusheguanliyuanId() {
			return fangwuSusheguanliyuanId;
		}
		/**
		* 设置：公寓 的 宿舍管理员
		*/
		public void setFangwuSusheguanliyuanId(Integer fangwuSusheguanliyuanId) {
			this.fangwuSusheguanliyuanId = fangwuSusheguanliyuanId;
		}

		/**
		* 获取： 房屋名称
		*/
		public String getFangwuName() {
			return fangwuName;
		}
		/**
		* 设置： 房屋名称
		*/
		public void setFangwuName(String fangwuName) {
			this.fangwuName = fangwuName;
		}

		/**
		* 获取： 公寓编号
		*/
		public String getFangwuUuidNumber() {
			return fangwuUuidNumber;
		}
		/**
		* 设置： 公寓编号
		*/
		public void setFangwuUuidNumber(String fangwuUuidNumber) {
			this.fangwuUuidNumber = fangwuUuidNumber;
		}

		/**
		* 获取： 公寓照片
		*/
		public String getFangwuPhoto() {
			return fangwuPhoto;
		}
		/**
		* 设置： 公寓照片
		*/
		public void setFangwuPhoto(String fangwuPhoto) {
			this.fangwuPhoto = fangwuPhoto;
		}

		/**
		* 获取： 房屋位置
		*/
		public String getFangwuAddress() {
			return fangwuAddress;
		}
		/**
		* 设置： 房屋位置
		*/
		public void setFangwuAddress(String fangwuAddress) {
			this.fangwuAddress = fangwuAddress;
		}
		/**
		* 获取： 公寓类型
		*/
		public Integer getFangwuTypes() {
			return fangwuTypes;
		}
		/**
		* 设置： 公寓类型
		*/
		public void setFangwuTypes(Integer fangwuTypes) {
			this.fangwuTypes = fangwuTypes;
		}


			/**
			* 获取： 公寓类型的值
			*/
			public String getFangwuValue() {
				return fangwuValue;
			}
			/**
			* 设置： 公寓类型的值
			*/
			public void setFangwuValue(String fangwuValue) {
				this.fangwuValue = fangwuValue;
			}

		/**
		* 获取： 房租/月
		*/
		public Double getFangwuNewMoney() {
			return fangwuNewMoney;
		}
		/**
		* 设置： 房租/月
		*/
		public void setFangwuNewMoney(Double fangwuNewMoney) {
			this.fangwuNewMoney = fangwuNewMoney;
		}

		/**
		* 获取： 限制人数
		*/
		public Integer getFangwuRenshu() {
			return fangwuRenshu;
		}
		/**
		* 设置： 限制人数
		*/
		public void setFangwuRenshu(Integer fangwuRenshu) {
			this.fangwuRenshu = fangwuRenshu;
		}

		/**
		* 获取： 已住人数
		*/
		public Integer getFangwuYizhurenshu() {
			return fangwuYizhurenshu;
		}
		/**
		* 设置： 已住人数
		*/
		public void setFangwuYizhurenshu(Integer fangwuYizhurenshu) {
			this.fangwuYizhurenshu = fangwuYizhurenshu;
		}

		/**
		* 获取： 公寓介绍
		*/
		public String getFangwuContent() {
			return fangwuContent;
		}
		/**
		* 设置： 公寓介绍
		*/
		public void setFangwuContent(String fangwuContent) {
			this.fangwuContent = fangwuContent;
		}
		/**
		* 获取： 是否上架
		*/
		public Integer getShangxiaTypes() {
			return shangxiaTypes;
		}
		/**
		* 设置： 是否上架
		*/
		public void setShangxiaTypes(Integer shangxiaTypes) {
			this.shangxiaTypes = shangxiaTypes;
		}


			/**
			* 获取： 是否上架的值
			*/
			public String getShangxiaValue() {
				return shangxiaValue;
			}
			/**
			* 设置： 是否上架的值
			*/
			public void setShangxiaValue(String shangxiaValue) {
				this.shangxiaValue = shangxiaValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getFangwuDelete() {
			return fangwuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setFangwuDelete(Integer fangwuDelete) {
			this.fangwuDelete = fangwuDelete;
		}
	//级联表的get和set 宿舍管理员

		/**
		* 获取： 工号
		*/
		public String getSusheguanliyuanUuidNumber() {
			return susheguanliyuanUuidNumber;
		}
		/**
		* 设置： 工号
		*/
		public void setSusheguanliyuanUuidNumber(String susheguanliyuanUuidNumber) {
			this.susheguanliyuanUuidNumber = susheguanliyuanUuidNumber;
		}

		/**
		* 获取： 宿舍管理员姓名
		*/
		public String getSusheguanliyuanName() {
			return susheguanliyuanName;
		}
		/**
		* 设置： 宿舍管理员姓名
		*/
		public void setSusheguanliyuanName(String susheguanliyuanName) {
			this.susheguanliyuanName = susheguanliyuanName;
		}

		/**
		* 获取： 宿舍管理员手机号
		*/
		public String getSusheguanliyuanPhone() {
			return susheguanliyuanPhone;
		}
		/**
		* 设置： 宿舍管理员手机号
		*/
		public void setSusheguanliyuanPhone(String susheguanliyuanPhone) {
			this.susheguanliyuanPhone = susheguanliyuanPhone;
		}

		/**
		* 获取： 宿舍管理员身份证号
		*/
		public String getSusheguanliyuanIdNumber() {
			return susheguanliyuanIdNumber;
		}
		/**
		* 设置： 宿舍管理员身份证号
		*/
		public void setSusheguanliyuanIdNumber(String susheguanliyuanIdNumber) {
			this.susheguanliyuanIdNumber = susheguanliyuanIdNumber;
		}

		/**
		* 获取： 宿舍管理员头像
		*/
		public String getSusheguanliyuanPhoto() {
			return susheguanliyuanPhoto;
		}
		/**
		* 设置： 宿舍管理员头像
		*/
		public void setSusheguanliyuanPhoto(String susheguanliyuanPhoto) {
			this.susheguanliyuanPhoto = susheguanliyuanPhoto;
		}

		/**
		* 获取： 宿舍管理员邮箱
		*/
		public String getSusheguanliyuanEmail() {
			return susheguanliyuanEmail;
		}
		/**
		* 设置： 宿舍管理员邮箱
		*/
		public void setSusheguanliyuanEmail(String susheguanliyuanEmail) {
			this.susheguanliyuanEmail = susheguanliyuanEmail;
		}
		/**
		* 获取： 账户状态
		*/
		public Integer getJinyongTypes() {
			return jinyongTypes;
		}
		/**
		* 设置： 账户状态
		*/
		public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
		}


			/**
			* 获取： 账户状态的值
			*/
			public String getJinyongValue() {
				return jinyongValue;
			}
			/**
			* 设置： 账户状态的值
			*/
			public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
			}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "WeishengView{" +
			", weishengValue=" + weishengValue +
			", susheguanliyuanUuidNumber=" + susheguanliyuanUuidNumber +
			", susheguanliyuanName=" + susheguanliyuanName +
			", susheguanliyuanPhone=" + susheguanliyuanPhone +
			", susheguanliyuanIdNumber=" + susheguanliyuanIdNumber +
			", susheguanliyuanPhoto=" + susheguanliyuanPhoto +
			", susheguanliyuanEmail=" + susheguanliyuanEmail +
			", fangwuName=" + fangwuName +
			", fangwuUuidNumber=" + fangwuUuidNumber +
			", fangwuPhoto=" + fangwuPhoto +
			", fangwuAddress=" + fangwuAddress +
			", fangwuNewMoney=" + fangwuNewMoney +
			", fangwuRenshu=" + fangwuRenshu +
			", fangwuYizhurenshu=" + fangwuYizhurenshu +
			", fangwuContent=" + fangwuContent +
			", fangwuDelete=" + fangwuDelete +
			"} " + super.toString();
	}
}
