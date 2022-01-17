package com.air.airbooking.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;
import java.util.List;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.pojo
 * @Project: air_booking
 * @Date: 2021/4/14 14:49
 * @description: 机舱类型对象实体类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CabinType {
    /**
     * 机舱ID
     */
    private Integer cabinId;
    /**
     * 机舱类型名称
     */
    private String cabinName;
    /**
     * 机舱类型状态
     */
    private Integer cabinStatus;
    /**
     * 机舱默认创建时间
     */
    private Date cabinUpdate;

    private List<FlightRecords> flightRecordsList;
}
