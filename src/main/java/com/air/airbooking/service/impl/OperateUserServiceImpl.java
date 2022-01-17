package com.air.airbooking.service.impl;

import com.air.airbooking.mapper.OperateUserMapper;
import com.air.airbooking.pojo.OperateUser;
import com.air.airbooking.service.OperateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.service.impl
 * @Project: airbooking
 * @Date: 2021/4/23 18:42
 * @description:
 **/
@Service
public class OperateUserServiceImpl implements OperateUserService {

    @Autowired
    private OperateUserMapper operateUserMapper;

    @Override
    public int register(OperateUser operateUser) {
        return operateUserMapper.register(operateUser);
    }

    @Override
    public OperateUser login(Map<String, Object> map) {
        return operateUserMapper.login(map);
    }
}
