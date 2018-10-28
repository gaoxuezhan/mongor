package com.gaoxz.controller;

import com.gaoxz.dao.ProductsDao;
import com.gaoxz.domain.ProductsEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	// inject via application.properties
	@Value("${welcome.message:Person}")
	private String message = "Hello World";

	@Autowired
	private ProductsDao productsDao;


	@RequestMapping("/hello")
	public Map hello(){
		String a = "1";
		String b = "2";
        ArrayList ab = new ArrayList();
        ab.add(a);
        ab.add(b);

        HashMap c = new HashMap();

        c.put("data" , ab);

		return c;
	}

    @RequestMapping("/hello2")
    public List hello2(){
        String a = "1";
        String b = "2";
        ArrayList ab = new ArrayList();
        ab.add(a);
        ab.add(b);

        HashMap c = new HashMap();

        c.put("data" , ab);

        return ab;
    }

	@RequestMapping("/rest")
	public Map welcome(Map<String, Object> model) {

		ProductsEx products= productsDao.findDetailByCode("ZH9112");

		List<String> keyList = new ArrayList<String>();
		keyList.addAll(products.getDetail().keySet());

        List<String> valueList = new ArrayList<String>();
        valueList.addAll(products.getDetail().values());

        Map<String, List> result = new HashMap<String, List>();

        result.put("keyList", keyList);
        result.put("valueList", valueList);

		return result;
	}

}