package com.gaoxz.controller;

import com.gaoxz.dao.ProductsDao;
import com.gaoxz.domain.ProductsEx;
import org.mockito.internal.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WelcomeController {

	// inject via application.properties
	@Value("${welcome.message:Person}")
	private String message = "Hello World";

	@Autowired
	private ProductsDao productsDao;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {

//		ProductsEx products= productsDao.findDetailByCode("ZH9112");
//
//		String updateTimes = "";
//        for (String temp: products.getDetail().keySet()
//             ) {
//            updateTimes = updateTimes + ',' + temp;
//        }
//
//        updateTimes = "[" + updateTimes.substring(1) + "]";
//
//        String prices = "";
//        for (String temp: products.getDetail().values()
//                ) {
//            prices = prices + ',' + temp;
//        }
//
//        prices = "[" + prices.substring(1) + "]";

//		String updateTimes = StringUtil.join("","\",\"",products.getDetail().keySet()).substring(2);
//		updateTimes = updateTimes + "\"";

//		String prices = StringUtil.join("",",",products.getDetail().values()).substring(1);

//		String temp = "{\n" +
//				"            xAxis: {\n" +
//				"                type: 'category',\n" +
//				"                data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']\n" +
//				"            },\n" +
//				"            yAxis: {\n" +
//				"                type: 'value'\n" +
//				"            },\n" +
//				"            series: [{\n" +
//				"                data: [820, 932, 901, 934, 1290, 1330, 1320],\n" +
//				"                type: 'line'\n" +
//				"            }]\n" +
//				"        };";

//		temp = temp.replace("['衬衫','羊毛衫','雪纺衫','裤子','高跟鞋','袜子']",updateTimes);
//		temp = temp.replace("[5, 20, 36, 10, 10, 20]", prices);

		model.put("message", this.message);
//		model.put("updateTimes", updateTimes);
//		model.put("prices", prices);
//		model.put("vo", temp );
		return "welcome";
	}

}