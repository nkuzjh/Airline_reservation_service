package com.air.airbooking.controller;

import com.air.airbooking.pojo.TicketDetails;
import com.air.airbooking.service.TicketDetailsService;
import com.air.airbooking.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.controller
 * @Project: airbooking
 * @Date: 2021/4/26 15:48
 * @description:
 **/
@RestController
@RequestMapping("/ticketDetails")
@CrossOrigin
public class TicketDetailsController {

    @Autowired
    private TicketDetailsService ticketDetailsService;

    @RequestMapping("/addTicketDetails")
    public Result addTicketDetails(Integer flightId,Integer cabinsId,Integer airlinesId,Integer operateId){
        Result result = new Result();
        try {
            //飞机票详情对象
            TicketDetails ticketDetails = new TicketDetails();
            String ticketNumber = "";
            ticketNumber = UUID.randomUUID()+ticketNumber;
            ticketDetails.setTicketNumber(ticketNumber);
            ticketDetails.setOperateId(operateId);
            ticketDetails.setCabinsId(cabinsId);
            ticketDetails.setAirlinesId(airlinesId);
            ticketDetails.setFlightsId(flightId);
            ticketDetailsService.addTicketDetails(ticketDetails);
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage()).setStatus(false);
        }
        return result;
    }

    @RequestMapping("/findTicketDetails")
    public Map<String, Object> findTicketDetails(Integer operateId){
        Map<String, Object> result = new HashMap<>();
        TicketDetails ticketDetails = ticketDetailsService.findTicketDetails(operateId);
        result.put("ticketDetails" ,ticketDetails);
        return result;
    }

}
