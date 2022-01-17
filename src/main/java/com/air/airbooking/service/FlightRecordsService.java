package com.air.airbooking.service;

import com.air.airbooking.pojo.FlightRecords;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.mapper
 * @Project: air_booking
 * @Date: 2021/4/14 19:03
 * @description:
 **/

public interface FlightRecordsService {

    /**
     * 关联查询---航空公司表---机舱信息表
     * 查询机票详情信息
     * @return
     */
    List<FlightRecords> findFlightRecords();

    /**
     * 根据ID关联查询---航空公司表---机舱信息表
     * @param flightNumber
     * @return
     */
    List<FlightRecords> findFlightRecordsById(String flightNumber);

    /**
     * 根据ID查询始发地到达地
     * @param flightId
     * @return
     */
    FlightRecords findFlightRecordsByIdCity(Integer flightId);

    /**
     * 查询飞机票信息
     * @param map
     * @return
     */
    List<FlightRecords> findFlightRecordsByMap(Map<String, Object> map);

    /**
     * 查询飞机票务信息
     * @param flightId
     * @return
     */
    FlightRecords findFlightRecordsByIdFlightRecords(Integer flightId);

    /**
     * 查询飞机票信息
     * @param map
     * @return
     */
    FlightRecords findFlightRecordsSelectOne(Map<String, Object> map);
}
