package com.air.airbooking.mapper;

import com.air.airbooking.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.mapper
 * @Project: airbooking
 * @Date: 2021/4/21 19:32
 * @description:
 **/
@Mapper
public interface UserInfoMapper {

    /**
     * 新增购票用户信息
     * @param userInfo
     * @return
     */
    int addUserInfo(UserInfo userInfo);

}
