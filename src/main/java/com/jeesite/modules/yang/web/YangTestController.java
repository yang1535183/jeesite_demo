/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.yang.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.yang.entity.YangTest;
import com.jeesite.modules.yang.service.YangTestService;

/**
 * yang_testController
 * @author 杨炜
 * @version 2019-10-10
 */
@Controller
@RequestMapping(value = "${adminPath}/yang/yangTest")
public class YangTestController extends BaseController {

	@Autowired
	private YangTestService yangTestService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public YangTest get(String id, boolean isNewRecord) {
		return yangTestService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("yang:yangTest:view")
	@RequestMapping(value = {"list", ""})
	public String list(YangTest yangTest, Model model) {
		model.addAttribute("yangTest", yangTest);
		return "modules/yang/yangTestList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("yang:yangTest:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<YangTest> listData(YangTest yangTest, HttpServletRequest request, HttpServletResponse response) {
		yangTest.setPage(new Page<>(request, response));
		Page<YangTest> page = yangTestService.findPage(yangTest);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("yang:yangTest:view")
	@RequestMapping(value = "form")
	public String form(YangTest yangTest, Model model) {
		model.addAttribute("yangTest", yangTest);
		return "modules/yang/yangTestForm";
	}

	/**
	 * 保存yang_test
	 */
	@RequiresPermissions("yang:yangTest:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated YangTest yangTest) {
		yangTestService.save(yangTest);
		return renderResult(Global.TRUE, text("保存yang_test成功！"));
	}
	
	/**
	 * 停用yang_test
	 */
	@RequiresPermissions("yang:yangTest:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(YangTest yangTest) {
		yangTest.setStatus(YangTest.STATUS_DISABLE);
		yangTestService.updateStatus(yangTest);
		return renderResult(Global.TRUE, text("停用yang_test成功"));
	}
	
	/**
	 * 启用yang_test
	 */
	@RequiresPermissions("yang:yangTest:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(YangTest yangTest) {
		yangTest.setStatus(YangTest.STATUS_NORMAL);
		yangTestService.updateStatus(yangTest);
		return renderResult(Global.TRUE, text("启用yang_test成功"));
	}
	
	/**
	 * 删除yang_test
	 */
	@RequiresPermissions("yang:yangTest:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(YangTest yangTest) {
		yangTestService.delete(yangTest);
		return renderResult(Global.TRUE, text("删除yang_test成功！"));
	}
	
}