package com.air.airbooking;

import com.air.airbooking.pojo.FlightRecords;
import com.air.airbooking.service.FlightRecordsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class AirbookingApplicationTests {

    @Autowired
    private FlightRecordsService flightRecordsService;

    @Test
    void contextLoads() {
        Map map = new HashMap();
        map.put("flightLeave","北京");
        map.put("flightArrive","上海");
        map.put("flightLeaveTime","2021-04-24 12:00:00");
        map.put("flightArriveTime","2021-04-24 14:00:00");
        List<FlightRecords> flightRecordsList = flightRecordsService.findFlightRecordsByMap(map);
        flightRecordsList.forEach(System.out::println);
    }

}
