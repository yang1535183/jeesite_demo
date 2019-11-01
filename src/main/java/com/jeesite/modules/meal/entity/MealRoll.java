/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.meal.entity;

import org.hibernate.validator.constraints.Length;
import com.jeesite.modules.sys.entity.User;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotBlank;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 餐卷管理Entity
 * @author 杨炜
 * @version 2019-10-15
 */
@Table(name="meal_roll", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="create_by", attrName="createBy.userCode", label="创建人", isUpdate=false, isQuery=false),
		@Column(name="create_date", attrName="createDate", label="创建时间", isUpdate=false, isQuery=false),
		@Column(name="del_flag", attrName="delFlag", label="删除标识"),
		@Column(name="user_by", attrName="userBy.userCode", label="领用人"),
		@Column(name="user_date", attrName="userDate", label="领用时间"),
		@Column(name="face_value", attrName="faceValue", label="面值"),
		@Column(name="coop_business", attrName="coopBusiness", label="合作商家"),
		@Column(name="is_use", attrName="isUse", label="是否领用"),
	}, joinTable={

		@JoinTable(type=Type.LEFT_JOIN, entity=User.class, attrName="createBy", alias="u2",
			on="u2.user_code = a.create_by", columns={
				@Column(name="user_code", label="用户编码", isPK=true),
				@Column(name="user_name", label="用户名称", isQuery=false),
		}),

		@JoinTable(type=Type.LEFT_JOIN, entity=User.class, attrName="userBy", alias="u5",
			on="u5.user_code = a.user_by", columns={
				@Column(name="user_code", label="用户编码", isPK=true),
				@Column(name="user_name", label="用户名称", isQuery=false),
		}),
	}, orderBy="a.id DESC"
)
public class MealRoll extends DataEntity<MealRoll> {
	
	private static final long serialVersionUID = 1L;
	private String delFlag;		// 删除标识
	private User userBy;		// 领用人
	private Date userDate;		// 领用时间
	private String faceValue;		// 面值
	private String coopBusiness;		// 合作商家
	private String isUse;		// 是否领用
	
	public MealRoll() {
		this(null);
	}

	public MealRoll(String id){
		super(id);
	}
	
	@Length(min=0, max=255, message="删除标识长度不能超过 255 个字符")
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	public User getUserBy() {
		return userBy;
	}

	public void setUserBy(User userBy) {
		this.userBy = userBy;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUserDate() {
		return userDate;
	}

	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}
	
	@NotBlank(message="面值不能为空")
	@Length(min=0, max=255, message="面值长度不能超过 255 个字符")
	public String getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(String faceValue) {
		this.faceValue = faceValue;
	}
	
	@Length(min=0, max=255, message="合作商家长度不能超过 255 个字符")
	public String getCoopBusiness() {
		return coopBusiness;
	}

	public void setCoopBusiness(String coopBusiness) {
		this.coopBusiness = coopBusiness;
	}
	
	@Length(min=0, max=255, message="是否领用长度不能超过 255 个字符")
	public String getIsUse() {
		return isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}
	
	public Date getUserDate_gte() {
		return sqlMap.getWhere().getValue("user_date", QueryType.GTE);
	}

	public void setUserDate_gte(Date userDate) {
		sqlMap.getWhere().and("user_date", QueryType.GTE, userDate);
	}
	
	public Date getUserDate_lte() {
		return sqlMap.getWhere().getValue("user_date", QueryType.LTE);
	}

	public void setUserDate_lte(Date userDate) {
		sqlMap.getWhere().and("user_date", QueryType.LTE, userDate);
	}
	
}