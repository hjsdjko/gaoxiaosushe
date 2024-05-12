package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.BaoxiuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 报修
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("baoxiu")
public class BaoxiuView extends BaoxiuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 报修类型的值
	*/
	@ColumnInfo(comment="报修类型的字典表值",type="varchar(200)")
	private String baoxiuValue;
	/**
	* 报修状态的值
	*/
	@ColumnInfo(comment="报修状态的字典表值",type="varchar(200)")
	private String baoxiuZhuangtaiValue;

	//级联表 学生
		/**
		* 学号
		*/

		@ColumnInfo(comment="学号",type="varchar(200)")
		private String yonghuUuidNumber;
		/**
		* 学生姓名
		*/

		@ColumnInfo(comment="学生姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 学生手机号
		*/

		@ColumnInfo(comment="学生手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 学生身份证号
		*/

		@ColumnInfo(comment="学生身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 学生头像
		*/

		@ColumnInfo(comment="学生头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 性格
		*/

		@ColumnInfo(comment="性格",type="varchar(200)")
		private String yonghuXingge;
		/**
		* 入睡时间
		*/

		@ColumnInfo(comment="入睡时间",type="varchar(200)")
		private String yonghuRushuishijian;
		/**
		* 起床时间
		*/

		@ColumnInfo(comment="起床时间",type="varchar(200)")
		private String yonghuQichuangshijian;
		/**
		* 学生邮箱
		*/

		@ColumnInfo(comment="学生邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 学院
		*/
		@ColumnInfo(comment="学院",type="int(11)")
		private Integer xueyuanTypes;
			/**
			* 学院的值
			*/
			@ColumnInfo(comment="学院的字典表值",type="varchar(200)")
			private String xueyuanValue;
		/**
		* 专业
		*/
		@ColumnInfo(comment="专业",type="int(11)")
		private Integer zhuanyeTypes;
			/**
			* 专业的值
			*/
			@ColumnInfo(comment="专业的字典表值",type="varchar(200)")
			private String zhuanyeValue;
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



	public BaoxiuView() {

	}

	public BaoxiuView(BaoxiuEntity baoxiuEntity) {
		try {
			BeanUtils.copyProperties(this, baoxiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 报修类型的值
	*/
	public String getBaoxiuValue() {
		return baoxiuValue;
	}
	/**
	* 设置： 报修类型的值
	*/
	public void setBaoxiuValue(String baoxiuValue) {
		this.baoxiuValue = baoxiuValue;
	}
	//当前表的
	/**
	* 获取： 报修状态的值
	*/
	public String getBaoxiuZhuangtaiValue() {
		return baoxiuZhuangtaiValue;
	}
	/**
	* 设置： 报修状态的值
	*/
	public void setBaoxiuZhuangtaiValue(String baoxiuZhuangtaiValue) {
		this.baoxiuZhuangtaiValue = baoxiuZhuangtaiValue;
	}


	//级联表的get和set 学生

		/**
		* 获取： 学号
		*/
		public String getYonghuUuidNumber() {
			return yonghuUuidNumber;
		}
		/**
		* 设置： 学号
		*/
		public void setYonghuUuidNumber(String yonghuUuidNumber) {
			this.yonghuUuidNumber = yonghuUuidNumber;
		}

		/**
		* 获取： 学生姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 学生姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 学生手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 学生手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 学生身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 学生身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 学生头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 学生头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 性格
		*/
		public String getYonghuXingge() {
			return yonghuXingge;
		}
		/**
		* 设置： 性格
		*/
		public void setYonghuXingge(String yonghuXingge) {
			this.yonghuXingge = yonghuXingge;
		}

		/**
		* 获取： 入睡时间
		*/
		public String getYonghuRushuishijian() {
			return yonghuRushuishijian;
		}
		/**
		* 设置： 入睡时间
		*/
		public void setYonghuRushuishijian(String yonghuRushuishijian) {
			this.yonghuRushuishijian = yonghuRushuishijian;
		}

		/**
		* 获取： 起床时间
		*/
		public String getYonghuQichuangshijian() {
			return yonghuQichuangshijian;
		}
		/**
		* 设置： 起床时间
		*/
		public void setYonghuQichuangshijian(String yonghuQichuangshijian) {
			this.yonghuQichuangshijian = yonghuQichuangshijian;
		}

		/**
		* 获取： 学生邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 学生邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}
		/**
		* 获取： 学院
		*/
		public Integer getXueyuanTypes() {
			return xueyuanTypes;
		}
		/**
		* 设置： 学院
		*/
		public void setXueyuanTypes(Integer xueyuanTypes) {
			this.xueyuanTypes = xueyuanTypes;
		}


			/**
			* 获取： 学院的值
			*/
			public String getXueyuanValue() {
				return xueyuanValue;
			}
			/**
			* 设置： 学院的值
			*/
			public void setXueyuanValue(String xueyuanValue) {
				this.xueyuanValue = xueyuanValue;
			}
		/**
		* 获取： 专业
		*/
		public Integer getZhuanyeTypes() {
			return zhuanyeTypes;
		}
		/**
		* 设置： 专业
		*/
		public void setZhuanyeTypes(Integer zhuanyeTypes) {
			this.zhuanyeTypes = zhuanyeTypes;
		}


			/**
			* 获取： 专业的值
			*/
			public String getZhuanyeValue() {
				return zhuanyeValue;
			}
			/**
			* 设置： 专业的值
			*/
			public void setZhuanyeValue(String zhuanyeValue) {
				this.zhuanyeValue = zhuanyeValue;
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


	@Override
	public String toString() {
		return "BaoxiuView{" +
			", baoxiuValue=" + baoxiuValue +
			", baoxiuZhuangtaiValue=" + baoxiuZhuangtaiValue +
			", yonghuUuidNumber=" + yonghuUuidNumber +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuXingge=" + yonghuXingge +
			", yonghuRushuishijian=" + yonghuRushuishijian +
			", yonghuQichuangshijian=" + yonghuQichuangshijian +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
