package com.gaoxz.controller;

import com.gaoxz.dao.ProductsDao;
import com.gaoxz.domain.ProductsEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController2 {

	// inject via application.properties
	@Value("${welcome.message:Person}")
	private String message = "Hello World";

	@Autowired
	private ProductsDao productsDao;


	@RequestMapping("/rest2")
	public List welcome(Map<String, Object> model) {

		ProductsEx products= productsDao.findDetailByCode("HU7703");

		List<String> keyList = new ArrayList<String>();
		keyList.addAll(products.getDetail().keySet());

		List result = new ArrayList();
        for (String key:keyList
             ) {

            if(Integer.valueOf(products.getDetail().get(key)) > 1500){
                continue;
            }

            Map one = new HashMap();
            one.put("name", "x");

            List b = new ArrayList();
            b.add(key);
            b.add(products.getDetail().get(key));

            one.put("value", b);

            result.add(one);

        }

		return result;
	}

}