package com.air.airbooking.service.impl;

import com.air.airbooking.mapper.AirSeatMapper;
import com.air.airbooking.pojo.AirSeat;
import com.air.airbooking.service.AirSeatService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.service.impl
 * @Project: airbooking
 * @Date: 2021/4/25 19:18
 * @description:
 **/
@Service
public class AirSeatServiceImpl implements AirSeatService {

    @Autowired
    private AirSeatMapper airSeatMapper;


    @Override
    public AirSeat[] findAirSeat(Integer operateId, Integer flightsId) {
        return airSeatMapper.findAirSeat( operateId, flightsId);
    }

    @Override
    public int findCabinsId(Integer operateId, Integer flightsId) {
        return airSeatMapper.findCabinsId(operateId,flightsId);
    }

    @Override
    public int updateAirOrderStatus(Integer seatId) {
        return airSeatMapper.updateAirOrderStatus(seatId);
    }

    @Override
    public int selectSeatOne(Integer flightsId) {
        return airSeatMapper.selectSeatOne(flightsId);
    }
}
