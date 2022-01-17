package com.air.airbooking.service;

import com.air.airbooking.pojo.AirSeat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.mapper
 * @Project: air_booking
 * @Date: 2021/4/14 19:10
 * @description:
 **/

public interface AirSeatService {
    /**
     * 查询飞机座位
     * @return
     */
    AirSeat[] findAirSeat(Integer operateId,Integer flightsId);

    /**
     * 查询类型
     * @param operateId
     * @param flightsId
     * @return
     */
    int findCabinsId(Integer operateId,Integer flightsId);

    /**
     * 修改座位状态
     * @param seatId
     * @param seatStatus
     * @return
     */
    int updateAirOrderStatus(Integer seatId);

    /**
     * 查询剩余座位
     * @param flightsId
     * @return
     */
    int selectSeatOne(Integer flightsId);
}
