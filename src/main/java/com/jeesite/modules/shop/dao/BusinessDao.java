/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.shop.entity.Business;

/**
 * 商家管理DAO接口
 * @author 史良浩
 * @version 2019-10-15
 */
@MyBatisDao
public interface BusinessDao extends CrudDao<Business> {
	
}