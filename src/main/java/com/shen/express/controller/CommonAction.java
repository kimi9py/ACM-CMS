package com.shen.express.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonAction {

	@RequestMapping(value = { "mlogin.action" })
	public String mlogin(HttpServletRequest request, @RequestParam String name, @RequestParam String password, @RequestParam String code) {
		Properties prop = new Properties();
		if (!(code.equalsIgnoreCase(request.getSession().getAttribute("code").toString()))) {
			return "adminSignin";
		}
		try {
			prop.load(CommonAction.class.getClassLoader().getResourceAsStream("user.properties"));
			if (!password.equals(prop.getProperty(name))) {
				return "adminSignin";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ExpressCustomer ec = customerService.loginByCharge(name, password);
		// ExpressSite es =
		// siteService.getSiteById(ec.getDepartment().getSid());
		// if (ec != null) {
		// request.getSession().setAttribute("adminLogined", "true");
		// request.getSession().setAttribute("who", ec); //不能放入用户，放入一个部门
		// request.getSession().setAttribute("currentUser", es); // 表示一个部门
		//
		// return "redirect:manager/gettingExpress.action";
		// } else {
		// return "adminSignin";
		// }
		// 一定登陆成功
		request.getSession().setAttribute("adminLogined", "true");
		request.getSession().setAttribute("who", name); // 不能放入用户，放入一个部门

		return "redirect:manager/welcome.action";
	}
}
