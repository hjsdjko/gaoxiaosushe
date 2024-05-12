package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.FangwuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 公寓
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("fangwu")
public class FangwuView extends FangwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 公寓类型的值
	*/
	@ColumnInfo(comment="公寓类型的字典表值",type="varchar(200)")
	private String fangwuValue;
	/**
	* 性别的值
	*/
	@ColumnInfo(comment="性别的字典表值",type="varchar(200)")
	private String sexValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;

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


	public FangwuView() {

	}

	public FangwuView(FangwuEntity fangwuEntity) {
		try {
			BeanUtils.copyProperties(this, fangwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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
	//当前表的
	/**
	* 获取： 性别的值
	*/
	public String getSexValue() {
		return sexValue;
	}
	/**
	* 设置： 性别的值
	*/
	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}
	//当前表的
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

	@Override
	public String toString() {
		return "FangwuView{" +
			", fangwuValue=" + fangwuValue +
			", sexValue=" + sexValue +
			", shangxiaValue=" + shangxiaValue +
			", susheguanliyuanUuidNumber=" + susheguanliyuanUuidNumber +
			", susheguanliyuanName=" + susheguanliyuanName +
			", susheguanliyuanPhone=" + susheguanliyuanPhone +
			", susheguanliyuanIdNumber=" + susheguanliyuanIdNumber +
			", susheguanliyuanPhoto=" + susheguanliyuanPhoto +
			", susheguanliyuanEmail=" + susheguanliyuanEmail +
			"} " + super.toString();
	}
}
