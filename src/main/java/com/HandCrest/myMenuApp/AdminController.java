package com.HandCrest.myMenuApp;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@Autowired
	RestaurantRepository restaurantRepo;
	
	@Autowired
	MenuRepository menuRepo;
	
	@RequestMapping("/login")
	public String adminLoginPage() {
		return "login";
	}
	
	@RequestMapping("admin/login")
	public String adminLogin(HttpServletResponse response) {
		Cookie adminRoleCookie = new Cookie("role", "admin");
		adminRoleCookie.setHttpOnly(true);
		adminRoleCookie.setMaxAge(3000);
		response.addCookie(adminRoleCookie);
		return "redirect:/restaurant";
	}
}
