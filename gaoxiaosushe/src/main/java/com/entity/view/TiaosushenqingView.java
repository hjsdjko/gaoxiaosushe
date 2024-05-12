package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.TiaosushenqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 调宿申请
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("tiaosushenqing")
public class TiaosushenqingView extends TiaosushenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 调宿申请类型的值
	*/
	@ColumnInfo(comment="调宿申请类型的字典表值",type="varchar(200)")
	private String tiaosushenqingValue;
	/**
	* 申请状态的值
	*/
	@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
	private String tiaosushenqingYesnoValue;

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

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public TiaosushenqingView() {

	}

	public TiaosushenqingView(TiaosushenqingEntity tiaosushenqingEntity) {
		try {
			BeanUtils.copyProperties(this, tiaosushenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 调宿申请类型的值
	*/
	public String getTiaosushenqingValue() {
		return tiaosushenqingValue;
	}
	/**
	* 设置： 调宿申请类型的值
	*/
	public void setTiaosushenqingValue(String tiaosushenqingValue) {
		this.tiaosushenqingValue = tiaosushenqingValue;
	}
	//当前表的
	/**
	* 获取： 申请状态的值
	*/
	public String getTiaosushenqingYesnoValue() {
		return tiaosushenqingYesnoValue;
	}
	/**
	* 设置： 申请状态的值
	*/
	public void setTiaosushenqingYesnoValue(String tiaosushenqingYesnoValue) {
		this.tiaosushenqingYesnoValue = tiaosushenqingYesnoValue;
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
		return "TiaosushenqingView{" +
			", tiaosushenqingValue=" + tiaosushenqingValue +
			", tiaosushenqingYesnoValue=" + tiaosushenqingYesnoValue +
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
