package com.gaoxz.controller;

import com.gaoxz.dao.FlightDao;
import com.gaoxz.domain.FlightEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestController3 {

	// inject via application.properties
	@Value("${welcome.message:Person}")
	private String message = "Hello World";

	@Autowired
	private FlightDao flightsDao;


	@RequestMapping("/rest3")
	public List welcome(Map<String, Object> model) {

		FlightEx flights= flightsDao.getTheHistoryDataOfTheFlightInTargetDate("2018-12-29", "MU5391");

		List<String> keyList = new ArrayList<String>();
		keyList.addAll(flights.getDetail().keySet());

		List result = new ArrayList();
        for (String key:keyList
             ) {

            Map one = new HashMap();
            one.put("name", "x");

            List b = new ArrayList();
            b.add(key);
            b.add(flights.getDetail().get(key));

            one.put("value", b);

            result.add(one);

        }

		return result;
	}

}