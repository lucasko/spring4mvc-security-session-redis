package com.lucasko.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = { "/", "/admin" }, method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("admin");
		//System.out.println("---> "+session.getAttribute("name"));
		
		return model;
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login( HttpServletRequest request , @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) throws IOException {
		
		ModelAndView model = new ModelAndView("login");
		if (error != null)
			model.addObject("error", "Invalid username and password!");
	
		return model;
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
 
}
