/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.meal.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.meal.entity.MealRoll;

/**
 * 餐卷管理DAO接口
 * @author 杨炜
 * @version 2019-10-15
 */
@MyBatisDao
public interface MealRollDao extends CrudDao<MealRoll> {
	
}