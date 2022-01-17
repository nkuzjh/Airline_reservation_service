package com.air.airbooking.service;

import com.air.airbooking.pojo.TicketDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.mapper
 * @Project: air_booking
 * @Date: 2021/4/14 19:07
 * @description:
 **/
public interface TicketDetailsService {

    /**
     * 新增机票详情信息
     * @param ticketDetails
     * @return
     */
    int addTicketDetails(TicketDetails ticketDetails);

    /**
     *
     * @param operateId
     * @return
     */
    TicketDetails findTicketDetails(Integer operateId);
}
