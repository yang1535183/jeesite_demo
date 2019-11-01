/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.map.web;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.meal.entity.MealRoll;
import com.jeesite.modules.meal.service.MealRollService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 餐卷管理Controller
 * @author 杨炜
 * @version 2019-10-15
 */
@Controller
@RequestMapping(value = "${adminPath}/map")
public class MapController extends BaseController {
	@RequestMapping(value = {"baseMap", ""})
	public String list() {
		return "modules/map/baseMap";
	}
}