/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.shop.entity.Business;
import com.jeesite.modules.shop.dao.BusinessDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 商家管理Service
 * @author 史良浩
 * @version 2019-10-15
 */
@Service
@Transactional(readOnly=true)
public class BusinessService extends CrudService<BusinessDao, Business> {
	
	/**
	 * 获取单条数据
	 * @param business
	 * @return
	 */
	@Override
	public Business get(Business business) {
		return super.get(business);
	}
	
	/**
	 * 查询分页数据
	 * @param business 查询条件
	 * @param business.page 分页对象
	 * @return
	 */
	@Override
	public Page<Business> findPage(Business business) {
		return super.findPage(business);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param business
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(Business business) {
		super.save(business);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(business.getId(), "business_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(business.getId(), "business_file");
	}
	
	/**
	 * 更新状态
	 * @param business
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(Business business) {
		super.updateStatus(business);
	}
	
	/**
	 * 删除数据
	 * @param business
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(Business business) {
		super.delete(business);
	}
	
}