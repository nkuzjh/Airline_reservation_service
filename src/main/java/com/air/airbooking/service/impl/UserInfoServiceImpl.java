package com.air.airbooking.service.impl;

import com.air.airbooking.mapper.UserInfoMapper;
import com.air.airbooking.pojo.UserInfo;
import com.air.airbooking.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.service.impl
 * @Project: airbooking
 * @Date: 2021/4/22 17:53
 * @description:
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int addUserInfo(UserInfo userInfo) {
        return userInfoMapper.addUserInfo(userInfo);
    }
}
