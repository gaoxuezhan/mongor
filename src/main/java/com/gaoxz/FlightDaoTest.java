package com.gaoxz;

import com.gaoxz.dao.FlightDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightDaoTest {

    @Autowired
    private FlightDao flightDao;

    @Test
    public void testSaveFlight() throws Exception {
        List<String> test;

        test = this.flightDao.getTargetDates_distinct("2018-12-29","北京","深圳","CA1337");
        System.out.println(test);

        test = this.flightDao.getDepartureCity_distinct("2018-12-29","北京","深圳","CA1337");
        System.out.println(test);

        test = this.flightDao.getArriveCity_distinct("2018-12-29","北京","深圳","CA1337");
        System.out.println(test);

        test = this.flightDao.getCode_distinct("2018-12-29","北京","深圳","CA1337");
        System.out.println(test);

        test = this.flightDao.getTheNewestData("2018-12-29","北京","深圳","");
        System.out.println(test.toString());

    }
//
//    @Test
//    public void findFlightByFlightName(){
//       FlightEntity flight= flightDao.findFlightByFlightName("小明");
//       System.out.println("flight is "+flight);
//    }
//
//    @Test
//    public void updateFlight(){
//        FlightEntity flight=new FlightEntity();
//        flight.setId(2l);
//        flight.setFlightName("天空");
//        flight.setPassWord("fffxxxx");
//        flightDao.updateFlight(flight);
//    }
//
//    @Test
//    public void deleteFlightById(){
//        flightDao.deleteFlightById(1l);
//    }

}