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
 * @Date: 2021/4/14 15:26
 * @description: 订单记录对象实体类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AirOrder {
    /**
     * 订单记录ID
     */
    private Integer orderId;
    /**
     * 订单记录编号
     */
    private String orderNumber;
    /**
     * 默认创建时间
     */
    private Date orderUpdate;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 外键操作用户ID
     */
    private Integer operatesId;
    /**
     * 外键机舱类型ID
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
     * 机票详情外键ID
     */
    private Integer ticketsId;
    /**
     * 座位外键ID
     */
    private Integer seatsId;

    private FlightRecords flightRecords;

    private CabinType cabinType;

    private AirlineCompany airlineCompany;

}

