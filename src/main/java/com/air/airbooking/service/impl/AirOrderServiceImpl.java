package com.air.airbooking.service.impl;

import com.air.airbooking.mapper.AirOrderMapper;
import com.air.airbooking.pojo.AirOrder;
import com.air.airbooking.service.AirOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.service.impl
 * @Project: airbooking
 * @Date: 2021/4/28 16:22
 * @description:
 **/
@Service
public class AirOrderServiceImpl implements AirOrderService {

    @Autowired
    private AirOrderMapper airOrderMapper;

    @Override
    public int addAirOrder(AirOrder airOrder) {
        return airOrderMapper.addAirOrder(airOrder);
    }

    @Override
    public List<AirOrder> findByOperateId(Integer operatesId) {
        return airOrderMapper.findByOperateId(operatesId);
    }
}
