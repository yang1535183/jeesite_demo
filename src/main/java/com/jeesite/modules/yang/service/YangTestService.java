/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.yang.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.yang.entity.YangTest;
import com.jeesite.modules.yang.dao.YangTestDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * yang_testService
 * @author 杨炜
 * @version 2019-10-10
 */
@Service
@Transactional(readOnly=true)
public class YangTestService extends CrudService<YangTestDao, YangTest> {
	
	/**
	 * 获取单条数据
	 * @param yangTest
	 * @return
	 */
	@Override
	public YangTest get(YangTest yangTest) {
		return super.get(yangTest);
	}
	
	/**
	 * 查询分页数据
	 * @param yangTest 查询条件
	 * @param yangTest.page 分页对象
	 * @return
	 */
	@Override
	public Page<YangTest> findPage(YangTest yangTest) {
		return super.findPage(yangTest);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param yangTest
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(YangTest yangTest) {
		super.save(yangTest);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(yangTest.getId(), "yangTest_image");
		// 保存上传附件
		FileUploadUtils.saveFileUpload(yangTest.getId(), "yangTest_file");
	}
	
	/**
	 * 更新状态
	 * @param yangTest
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(YangTest yangTest) {
		super.updateStatus(yangTest);
	}
	
	/**
	 * 删除数据
	 * @param yangTest
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(YangTest yangTest) {
		super.delete(yangTest);
	}
	
}