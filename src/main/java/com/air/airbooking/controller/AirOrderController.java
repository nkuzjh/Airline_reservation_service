package com.air.airbooking.controller;

import com.air.airbooking.pojo.AirOrder;
import com.air.airbooking.service.AirOrderService;
import com.air.airbooking.service.AirSeatService;
import com.air.airbooking.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.controller
 * @Project: airbooking
 * @Date: 2021/4/28 16:24
 * @description:
 **/
@RestController
@RequestMapping("/airOrder")
@Slf4j
@CrossOrigin
public class AirOrderController {

    @Autowired
    private AirOrderService airOrderService;
    @Autowired
    private AirSeatService airSeatService;

    @PostMapping("/addAirOrder")
    public Result addAirOrder(Integer operateId,Integer cabinsId,Integer airlinesId,Integer flightsId,Integer seatId){
        Result result = new Result();

        try {
            AirOrder airOrder = new AirOrder();
            String seatNumber = "";
            seatNumber ="XHX"+UUID.randomUUID()+seatNumber;
            airOrder.setOrderNumber(seatNumber);
            airOrder.setOperatesId(operateId);
            airOrder.setCabinsId(cabinsId);
            airOrder.setAirlinesId(airlinesId);
            airOrder.setFlightsId(flightsId);
            airOrder.setSeatsId(seatId);
            System.out.println(airOrder);

            airOrderService.addAirOrder(airOrder);
            airSeatService.updateAirOrderStatus(seatId);
            result.setMsg("已经选坐成功了哦！！！");
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage()).setStatus(false);
        }
        return result;
    }


    @RequestMapping("/findByOperateId")
    public Map<String, Object> findByOperateId(Integer operatesId){
        Map<String, Object> result = new HashMap<String, Object>();
        List<AirOrder> airOrderList = airOrderService.findByOperateId(operatesId);
        airOrderList.forEach(System.out::println);
        result.put("airOrderList",airOrderList);
        return result;
    }

}
