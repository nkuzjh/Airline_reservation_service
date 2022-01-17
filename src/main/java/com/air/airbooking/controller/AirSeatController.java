package com.air.airbooking.controller;

import com.air.airbooking.pojo.AirSeat;
import com.air.airbooking.service.AirSeatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.util.*;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.controller
 * @Project: airbooking
 * @Date: 2021/4/25 19:19
 * @description:
 **/
@RestController
@RequestMapping("/airSeat")
@CrossOrigin
@Slf4j
public class AirSeatController {

    @Autowired
    private AirSeatService airSeatService;

    @RequestMapping("/findAirSeat")
    public List<Object[]> findAirSeat(Integer operateId, Integer flightsId) {
        List<Object[]> arrayList = new ArrayList<>();
        AirSeat[] all = airSeatService.findAirSeat(operateId, flightsId);
        int count = all.length / 8;
        int ii = 0;
        for (int i = 0; i < 10; i++) {
            Object[] o = new Object[count];
            for (int j = 0; j < count; j++) {
                if (i == 4 || i == 5) {
                    o[j] = 0;
                } else {
                    o[j] = all[ii];
                    ii++;
                }
            }
            arrayList.add(o);
        }
        // 反转lists
        Collections.reverse(arrayList);
        return arrayList;
    }

    @RequestMapping("/findCabinsId")
    public int findCabinsId(Integer operateId, Integer flightsId){
        int cabinsId = airSeatService.findCabinsId(operateId,flightsId);
        return cabinsId;
    }

    /**
     * 查询剩余座位
      * @param flightId
     * @return
     */
    @RequestMapping("/selectSeatOne")
    public int selectSeatOne(Integer flightId){
        int count = airSeatService.selectSeatOne(flightId);
        System.out.println(count);
        return count;
    }

}
