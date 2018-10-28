package com.gaoxz.controller;

import com.gaoxz.dao.ProductsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WelcomeController2 {

	// inject via application.properties
	@Value("${welcome.message:Person}")
	private String message = "Hello World";

	@Autowired
	private ProductsDao productsDao;

	@RequestMapping("/welcome2")
	public String welcome(Map<String, Object> model) {

		model.put("message", this.message);
		return "welcome2";
	}

}