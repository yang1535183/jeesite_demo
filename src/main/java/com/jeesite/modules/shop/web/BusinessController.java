/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.web;

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
import com.jeesite.modules.shop.entity.Business;
import com.jeesite.modules.shop.service.BusinessService;

/**
 * 商家管理Controller
 * @author 史良浩
 * @version 2019-10-15
 */
@Controller
@RequestMapping(value = "${adminPath}/shop/business")
public class BusinessController extends BaseController {

	@Autowired
	private BusinessService businessService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public Business get(String businessId, boolean isNewRecord) {
		return businessService.get(businessId, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("shop:business:view")
	@RequestMapping(value = {"list", ""})
	public String list(Business business, Model model) {
		model.addAttribute("business", business);
		return "modules/shop/businessList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("shop:business:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<Business> listData(Business business, HttpServletRequest request, HttpServletResponse response) {
		business.setPage(new Page<>(request, response));
		Page<Business> page = businessService.findPage(business);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("shop:business:view")
	@RequestMapping(value = "form")
	public String form(Business business, Model model) {
		model.addAttribute("business", business);
		return "modules/shop/businessForm";
	}

	/**
	 * 保存商家
	 */
	@RequiresPermissions("shop:business:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated Business business) {
		businessService.save(business);
		return renderResult(Global.TRUE, text("保存商家成功！"));
	}
	
	/**
	 * 停用商家
	 */
	@RequiresPermissions("shop:business:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(Business business) {
		business.setStatus(Business.STATUS_DISABLE);
		businessService.updateStatus(business);
		return renderResult(Global.TRUE, text("停用商家成功"));
	}
	
	/**
	 * 启用商家
	 */
	@RequiresPermissions("shop:business:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(Business business) {
		business.setStatus(Business.STATUS_NORMAL);
		businessService.updateStatus(business);
		return renderResult(Global.TRUE, text("启用商家成功"));
	}
	
	/**
	 * 删除商家
	 */
	@RequiresPermissions("shop:business:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(Business business) {
		businessService.delete(business);
		return renderResult(Global.TRUE, text("删除商家成功！"));
	}
	
}