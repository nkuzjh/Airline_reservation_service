package com.air.airbooking.service.impl;

import com.air.airbooking.mapper.TicketDetailsMapper;
import com.air.airbooking.pojo.TicketDetails;
import com.air.airbooking.service.TicketDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.service.impl
 * @Project: airbooking
 * @Date: 2021/4/26 15:47
 * @description:
 **/
@Service
public class TicketDetailsServiceImpl implements TicketDetailsService {

    @Autowired
    private TicketDetailsMapper ticketDetailsMapper;


    @Override
    public int addTicketDetails(TicketDetails ticketDetails) {
        return ticketDetailsMapper.addTicketDetails(ticketDetails);
    }

    @Override
    public TicketDetails findTicketDetails(Integer operateId) {
        return ticketDetailsMapper.findTicketDetails(operateId);
    }
}
