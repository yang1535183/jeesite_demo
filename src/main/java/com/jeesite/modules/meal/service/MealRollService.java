/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.meal.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.meal.entity.MealRoll;
import com.jeesite.modules.meal.dao.MealRollDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 餐卷管理Service
 * @author 杨炜
 * @version 2019-10-15
 */
@Service
@Transactional(readOnly=true)
public class MealRollService extends CrudService<MealRollDao, MealRoll> {
	
	/**
	 * 获取单条数据
	 * @param mealRoll
	 * @return
	 */
	@Override
	public MealRoll get(MealRoll mealRoll) {
		return super.get(mealRoll);
	}
	
	/**
	 * 查询分页数据
	 * @param mealRoll 查询条件
	 * @return
	 */
	@Override
	public Page<MealRoll> findPage(MealRoll mealRoll) {
		return super.findPage(mealRoll);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param mealRoll
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MealRoll mealRoll) {
		super.save(mealRoll);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(mealRoll.getId(), "mealRoll_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(mealRoll.getId(), "mealRoll_file");
	}
	
	/**
	 * 更新状态
	 * @param mealRoll
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MealRoll mealRoll) {
		super.updateStatus(mealRoll);
	}
	
	/**
	 * 删除数据
	 * @param mealRoll
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MealRoll mealRoll) {
		super.delete(mealRoll);
	}
	
}