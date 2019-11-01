/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.meal.web;

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
import com.jeesite.modules.meal.entity.MealRoll;
import com.jeesite.modules.meal.service.MealRollService;

/**
 * 餐卷管理Controller
 * @author 杨炜
 * @version 2019-10-15
 */
@Controller
@RequestMapping(value = "${adminPath}/meal/mealRoll")
public class MealRollController extends BaseController {

	@Autowired
	private MealRollService mealRollService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MealRoll get(String id, boolean isNewRecord) {
		return mealRollService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("meal:mealRoll:view")
	@RequestMapping(value = {"list", ""})
	public String list(MealRoll mealRoll, Model model) {
		model.addAttribute("mealRoll", mealRoll);
		return "modules/meal/mealRollList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("meal:mealRoll:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MealRoll> listData(MealRoll mealRoll, HttpServletRequest request, HttpServletResponse response) {
		mealRoll.setPage(new Page<>(request, response));
		Page<MealRoll> page = mealRollService.findPage(mealRoll);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("meal:mealRoll:view")
	@RequestMapping(value = "form")
	public String form(MealRoll mealRoll, Model model) {
		model.addAttribute("mealRoll", mealRoll);
		return "modules/meal/mealRollForm";
	}

	/**
	 * 保存餐卷
	 */
	@RequiresPermissions("meal:mealRoll:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MealRoll mealRoll) {
		mealRollService.save(mealRoll);
		return renderResult(Global.TRUE, text("保存餐卷成功！"));
	}
	
	/**
	 * 停用餐卷
	 */
	@RequiresPermissions("meal:mealRoll:edit")
	@RequestMapping(value = "disable")
	@ResponseBody
	public String disable(MealRoll mealRoll) {
		mealRoll.setStatus(MealRoll.STATUS_DISABLE);
		mealRollService.updateStatus(mealRoll);
		return renderResult(Global.TRUE, text("停用餐卷成功"));
	}
	
	/**
	 * 启用餐卷
	 */
	@RequiresPermissions("meal:mealRoll:edit")
	@RequestMapping(value = "enable")
	@ResponseBody
	public String enable(MealRoll mealRoll) {
		mealRoll.setStatus(MealRoll.STATUS_NORMAL);
		mealRollService.updateStatus(mealRoll);
		return renderResult(Global.TRUE, text("启用餐卷成功"));
	}
	
	/**
	 * 删除餐卷
	 */
	@RequiresPermissions("meal:mealRoll:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MealRoll mealRoll) {
		mealRollService.delete(mealRoll);
		return renderResult(Global.TRUE, text("删除餐卷成功！"));
	}
	
}