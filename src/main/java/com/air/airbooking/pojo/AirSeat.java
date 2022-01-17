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
 * @Date: 2021/4/14 15:22
 * @description: 座位对象实体类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AirSeat {
    /**
     * 座位ID
     */
    private Integer seatId;
    /**
     * 座位编号
     */
    private String seatNumber;
    /**
     * 座位状态
     */
    private Integer seatStatus;
    /**
     * 操作用户外键ID
     */
    private Integer operatesId;
    /**
     * 机舱类型外键ID
     */
    private Integer cabinsId;
    /**
     * 航空公司外键ID
     */
    private Integer airlinesId;
    /**
     * 航班记录外键ID
     */
    private Integer flightsId;
    /**
     * 默认创建时间
     */
    private Date seatUpdate;

    private OperateUser operateUser;

    private CabinType cabinType;

    private AirlineCompany airlineCompany;

    private FlightRecords flightRecords;
}
