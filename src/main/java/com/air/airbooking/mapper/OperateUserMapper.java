package com.air.airbooking.mapper;


import com.air.airbooking.pojo.OperateUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.mapper
 * @Project: air_booking
 * @Date: 2021/4/14 15:35
 * @description: 操作用户Mapper层操作
 **/
@Mapper
public interface OperateUserMapper {
    /**
     * 新增用户信息
     * @param operateUser
     * @return
     */
    int register(OperateUser operateUser);

    /**
     * 登录
     * @param map
     * @return
     */
    OperateUser login(Map<String, Object> map);


}
