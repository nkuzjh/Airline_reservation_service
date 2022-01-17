package com.air.airbooking.service.impl;

import com.air.airbooking.mapper.FlightRecordsMapper;
import com.air.airbooking.pojo.FlightRecords;
import com.air.airbooking.service.FlightRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.service.impl
 * @Project: airbooking
 * @Date: 2021/4/15 19:54
 * @description:
 **/
@Service
public class FlightRecordsServiceImpl implements FlightRecordsService {

    @Autowired
    private FlightRecordsMapper flightRecordsMapper;

    @Override
    public List<FlightRecords> findFlightRecords() {
        return flightRecordsMapper.findFlightRecords();
    }

    @Override
    public List<FlightRecords> findFlightRecordsById(String flightNumber) {
        return flightRecordsMapper.findFlightRecordsById(flightNumber);
    }

    @Override
    public FlightRecords findFlightRecordsByIdCity(Integer flightId) {
        return flightRecordsMapper.findFlightRecordsByIdCity(flightId);
    }

    @Override
    public List<FlightRecords> findFlightRecordsByMap(Map<String, Object> map) {
        return flightRecordsMapper.findFlightRecordsByMap(map);
    }

    @Override
    public FlightRecords findFlightRecordsByIdFlightRecords(Integer flightId) {
        return flightRecordsMapper.findFlightRecordsByIdFlightRecords(flightId);
    }

    @Override
    public FlightRecords findFlightRecordsSelectOne(Map<String, Object> map) {
        return flightRecordsMapper.findFlightRecordsSelectOne(map);
    }
}
