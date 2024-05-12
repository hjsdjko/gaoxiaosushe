package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiaofeiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 缴费
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiaofei")
public class JiaofeiView extends JiaofeiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 缴费状态的值
	*/
	@ColumnInfo(comment="缴费状态的字典表值",type="varchar(200)")
	private String jiaofeiValue;

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

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer jinyongTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String jinyongValue;


	public JiaofeiView() {

	}

	public JiaofeiView(JiaofeiEntity jiaofeiEntity) {
		try {
			BeanUtils.copyProperties(this, jiaofeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 缴费状态的值
	*/
	public String getJiaofeiValue() {
		return jiaofeiValue;
	}
	/**
	* 设置： 缴费状态的值
	*/
	public void setJiaofeiValue(String jiaofeiValue) {
		this.jiaofeiValue = jiaofeiValue;
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
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getJinyongTypes() {
			return jinyongTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setJinyongTypes(Integer jinyongTypes) {
			this.jinyongTypes = jinyongTypes;
			}
				public String getJinyongValue() {
				return jinyongValue;
				}
				public void setJinyongValue(String jinyongValue) {
				this.jinyongValue = jinyongValue;
				}

	@Override
	public String toString() {
		return "JiaofeiView{" +
			", jiaofeiValue=" + jiaofeiValue +
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
			", susheguanliyuanUuidNumber=" + susheguanliyuanUuidNumber +
			", susheguanliyuanName=" + susheguanliyuanName +
			", susheguanliyuanPhone=" + susheguanliyuanPhone +
			", susheguanliyuanIdNumber=" + susheguanliyuanIdNumber +
			", susheguanliyuanPhoto=" + susheguanliyuanPhoto +
			", susheguanliyuanEmail=" + susheguanliyuanEmail +
			"} " + super.toString();
	}
}
