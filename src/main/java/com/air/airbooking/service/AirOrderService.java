package com.air.airbooking.service;

import com.air.airbooking.pojo.AirOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.mapper
 * @Project: air_booking
 * @Date: 2021/4/14 19:12
 * @description:
 **/
public interface AirOrderService {

    /**
     *
     * @param airOrder
     * @return
     */
    int addAirOrder(AirOrder airOrder);

    /**
     * 按照id
     * @param operatesId
     * @return
     */
    List<AirOrder> findByOperateId(Integer operatesId);

}
