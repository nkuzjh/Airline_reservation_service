package com.air.airbooking.controller;

import com.air.airbooking.pojo.FlightRecords;
import com.air.airbooking.service.FlightRecordsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.controller
 * @Project: airbooking
 * @Date: 2021/4/15 19:55
 * @description:
 **/
@RestController
@RequestMapping("/records")
@Slf4j
@CrossOrigin //跨域
public class FlightRecordsController {

    @Autowired
    private FlightRecordsService flightRecordsService;

    /**
     * 关联查询->>>航空公司表->>>机舱信息表
     * 查询机票详情信息
     *
     * @return
     */
    @RequestMapping("/findFlightRecords")
    public List<FlightRecords> findFlightRecords() {
        return flightRecordsService.findFlightRecords();
    }

    /**
     * 根据航班号查询机票信息
     *
     * @param flightNumber
     * @return
     */
    @RequestMapping("/findFlightRecordsByFlightNumber")
    public Map<String, Object> findFlightRecordsById(String flightNumber) {
        Map<String, Object> result = new HashMap<String, Object>();
        List<FlightRecords> flightRecordsList = flightRecordsService.findFlightRecordsById(flightNumber);
        result.put("flightRecordsList", flightRecordsList);
        return result;
    }

    /**
     * 根据ID查询城市名称
     *
     * @param flightId
     * @return
     */
    @RequestMapping("/findFlightRecordsByIdCity")
    public Map<String, Object> findFlightRecordsByIdCity(Integer flightId) {
        Map<String, Object> result = new HashMap<String, Object>();
        FlightRecords flightRecords = flightRecordsService.findFlightRecordsByIdCity(flightId);
        System.out.println(flightRecords);
        result.put("fr", flightRecords);
        return result;
    }

    /**
     * 根据多个条件查询机票信息
     *
     * @param flightLeave
     * @param flightArrive
     * @param flightLeaveTime
     * @param flightArriveTime
     * @return
     */
    @RequestMapping("/findFlightRecordsByMap")
    public Map<String, Object> findFlightRecordsByMap(String flightLeave, String flightArrive, String flightLeaveTime, String flightArriveTime, String flightNumber) {
        Map<String, Object> result = new HashMap<>();
        result.put("flightLeave", flightLeave);
        System.out.println("起始地：" + flightLeave);
        System.out.println("到达地：" + flightArrive);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate dateTime = LocalDate.parse(flightLeaveTime, formatter);

        LocalDateTime flightLeaveTimeNew;
        if (LocalDate.now().isAfter(dateTime) || LocalDate.now().equals(dateTime)) {
            flightLeaveTimeNew = LocalDateTime.now();
            result.put("flightLeaveTime", df.format(flightLeaveTimeNew));
        } else {
            result.put("flightLeaveTime", flightLeaveTime);
        }


        System.out.println("起始时间：" + flightLeaveTime);
        System.out.println("到达时间：" + flightArriveTime);
        System.out.println("航班号：" + flightNumber);
        result.put("flightArrive", flightArrive);
        result.put("flightArriveTime", flightArriveTime);
        result.put("flightNumber", flightNumber);
        List<FlightRecords> flightRecordsList = flightRecordsService.findFlightRecordsByMap(result);
        flightRecordsList.forEach(System.out::println);
        result.put("flightRecordsList", flightRecordsList);
        return result;
    }

    /**
     * 根据ID查询票务信息
     * @param flightId
     * @return
     */
    @RequestMapping("/findFlightRecordsByIdFlightRecords")
    public Map<String, Object> findFlightRecordsByIdFlightRecords(Integer flightId){
        Map<String, Object> result = new HashMap<>();
        FlightRecords flightRecords = flightRecordsService.findFlightRecordsByIdCity(flightId);
        System.out.println(flightRecords.getAirlineCompany().getAirlineModel());
        result.put("frs", flightRecords);
        return result;
    }

    /**
     * 根据多个条件查询机票信息
     *
     * @param flightLeave
     * @param flightArrive
     * @param flightLeaveTime
     * @param flightArriveTime
     * @return
     */
    @RequestMapping("/findFlightRecordsSelectOne")
    public Map<String, Object> findFlightRecordsSelectOne(String flightLeave, String flightArrive, String flightLeaveTime, String flightArriveTime, String flightNumber) {
        Map<String, Object> result = new HashMap<>();
        result.put("flightLeave", flightLeave);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate dateTime = LocalDate.parse(flightLeaveTime, formatter);

        LocalDateTime flightLeaveTimeNew;
        if (LocalDate.now().isAfter(dateTime) || LocalDate.now().equals(dateTime)) {
            flightLeaveTimeNew = LocalDateTime.now();
            result.put("flightLeaveTime", df.format(flightLeaveTimeNew));
        } else {
            result.put("flightLeaveTime", flightLeaveTime);
        }
        System.out.println("起始时间：" + flightLeaveTime);
        System.out.println("到达时间：" + flightArriveTime);
        System.out.println("航班号：" + flightNumber);
        result.put("flightArrive", flightArrive);
        result.put("flightArriveTime", flightArriveTime);
        result.put("flightNumber", flightNumber);
        FlightRecords flightRecords = flightRecordsService.findFlightRecordsSelectOne(result);
        result.put("frds", flightRecords);
        return result;
    }

}
