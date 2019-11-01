/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.yang.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * yang_testEntity
 * @author 杨炜
 * @version 2019-10-10
 */
@Table(name="yang_test", alias="a", columns={
		@Column(name="id", attrName="id", label="uuid", isPK=true),
		@Column(name="create_by", attrName="createBy", label="创建者", isUpdate=false),
		@Column(name="create_date", attrName="createDate", label="创建时间", isUpdate=false),
		@Column(name="update_by", attrName="updateBy", label="更新者", isQuery=false),
		@Column(name="update_date", attrName="updateDate", label="更新时间", isQuery=false),
		@Column(name="remarks", attrName="remarks", label="备注信息", queryType=QueryType.LIKE),
		@Column(name="del_flag", attrName="delFlag", label="删除标记"),
		@Column(name="col1", attrName="col1", label="字段1"),
		@Column(name="col2", attrName="col2", label="字段2"),
		@Column(name="col3", attrName="col3", label="字段3"),
	}, orderBy="a.update_date DESC"
)
public class YangTest extends DataEntity<YangTest> {
	
	private static final long serialVersionUID = 1L;
	private String delFlag;		// 删除标记
	private String col1;		// 字段1
	private String col2;		// 字段2
	private String col3;		// 字段3
	
	public YangTest() {
		this(null);
	}

	public YangTest(String id){
		super(id);
	}
	
	@Length(min=0, max=1, message="删除标记长度不能超过 1 个字符")
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	@Length(min=0, max=255, message="字段1长度不能超过 255 个字符")
	public String getCol1() {
		return col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}
	
	@Length(min=0, max=255, message="字段2长度不能超过 255 个字符")
	public String getCol2() {
		return col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}
	
	@Length(min=0, max=255, message="字段3长度不能超过 255 个字符")
	public String getCol3() {
		return col3;
	}

	public void setCol3(String col3) {
		this.col3 = col3;
	}
	
}