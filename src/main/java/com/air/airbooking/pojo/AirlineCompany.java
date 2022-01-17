package com.air.airbooking.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.pojo
 * @Project: air_booking
 * @Date: 2021/4/14 14:52
 * @description: 航空公司对象实体类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AirlineCompany {
    /**
     * 航空公司ID
     */
    private Integer airlineId;
    /**
     * 航空公司名称
     */
    private String airlineName;
    /**
     * 航空公司LOGO
     */
    private String airlineLogo;
    /**
     * 航空公司飞机型号
     */
    private String airlineModel;
    /**
     * 航空公司状态
     */
    private Integer airlineStatus;
    /**
     * 默认创建时间
     */
    private Date airlineUpdate;

    private List<FlightRecords> flightRecordsList;
}
