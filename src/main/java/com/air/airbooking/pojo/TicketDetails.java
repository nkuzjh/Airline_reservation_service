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
 * @Date: 2021/4/14 15:17
 * @description: 机票详情对象实体类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class TicketDetails {
    /**
     * 机票ID
     */
    private Integer ticketId;
    /**
     * 机票详情编号
     */
    private String ticketNumber;
    /**
     * 用户外键ID
     */
    private Integer operateId;
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
     * 机票状态
     */
    private Integer ticketStatus;
    /**
     * 默认创建时间
     */
    private Date ticketUpdate;

    private OperateUser operateUser;
    private CabinType cabinType;
    private AirlineCompany airlineCompany;
    private FlightRecords flightRecords;
}
