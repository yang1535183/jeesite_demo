/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.yang.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.yang.entity.YangTest;

/**
 * yang_testDAO接口
 * @author 杨炜
 * @version 2019-10-10
 */
@MyBatisDao
public interface YangTestDao extends CrudDao<YangTest> {
	
}