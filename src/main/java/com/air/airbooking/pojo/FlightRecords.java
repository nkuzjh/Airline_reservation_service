package com.air.airbooking.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.pojo
 * @Project: air_booking
 * @Date: 2021/4/14 14:57
 * @description: 航班记录对象实体类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class FlightRecords {
    /**
     * 航班ID
     */
    private Integer flightId;
    /**
     * 航班编号
     */
    private String flightNumber;
    /**
     * 出发地点
     */
    private String flightLeave;
    /**
     * 到达地点
     */
    private String flightArrive;
    /**
     * 出发机场
     */
    private String flightLeavePort;
    /**
     * 到达机场
     */
    private String flightArrivePort;
    /**
     * 出发时间
     */
    private String flightLeaveTime;
    /**
     * 抵达时间
     */
    private String flightArriveTime;
    /**
     * 耗费时长
     */
    private String flightDuration;
    /**
     * 机票价格
     */
    private Double flightPrice;
    /**
     * 外键机舱类型ID
     */
    private Integer cabinsId;
    /**
     * 航空公司外键ID
     */
    private Integer airlinesId;

    private AirlineCompany airlineCompany;
    private CabinType cabinType;
}
