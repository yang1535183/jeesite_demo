/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 商家管理Entity
 * @author 史良浩
 * @version 2019-10-15
 */
@Table(name="upms_business", alias="a", columns={
		@Column(name="business_id", attrName="businessId", label="编号", isPK=true),
		@Column(name="name", attrName="name", label="商家名称", queryType=QueryType.LIKE),
		@Column(name="phone", attrName="phone", label="商家电话"),
		@Column(name="address", attrName="address", label="商家地址"),
		@Column(name="description", attrName="description", label="经验范围", queryType=QueryType.LIKE),
		@Column(name="photo", attrName="photo", label="商家照片"),
		@Column(name="license", attrName="license", label="营业执照"),
		@Column(name="hygiene", attrName="hygiene", label="卫生许可证"),
		@Column(name="create_time", attrName="createTime", label="创建时间"),
	}, orderBy="a.business_id DESC"
)
public class Business extends DataEntity<Business> {
	
	private static final long serialVersionUID = 1L;
	private String businessId;		// 编号
	private String name;		// 商家名称
	private String phone;		// 商家电话
	private String address;		// 商家地址
	private String description;		// 经验范围
	private String photo;		// 商家照片
	private String license;		// 营业执照
	private String hygiene;		// 卫生许可证
	private Date createTime;		// 创建时间
	
	public Business() {
		this(null);
	}

	public Business(String id){
		super(id);
	}
	
	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	
	@Length(min=0, max=20, message="商家名称长度不能超过 20 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=20, message="商家电话长度不能超过 20 个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=100, message="商家地址长度不能超过 100 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=1000, message="经验范围长度不能超过 1000 个字符")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Length(min=0, max=150, message="商家照片长度不能超过 150 个字符")
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Length(min=0, max=150, message="营业执照长度不能超过 150 个字符")
	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}
	
	@Length(min=0, max=150, message="卫生许可证长度不能超过 150 个字符")
	public String getHygiene() {
		return hygiene;
	}

	public void setHygiene(String hygiene) {
		this.hygiene = hygiene;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Date getCreateTime_gte() {
		return sqlMap.getWhere().getValue("create_time", QueryType.GTE);
	}

	public void setCreateTime_gte(Date createTime) {
		sqlMap.getWhere().and("create_time", QueryType.GTE, createTime);
	}
	
	public Date getCreateTime_lte() {
		return sqlMap.getWhere().getValue("create_time", QueryType.LTE);
	}

	public void setCreateTime_lte(Date createTime) {
		sqlMap.getWhere().and("create_time", QueryType.LTE, createTime);
	}
	
}