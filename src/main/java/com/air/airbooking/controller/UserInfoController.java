package com.air.airbooking.controller;

import com.air.airbooking.pojo.UserInfo;
import com.air.airbooking.service.UserInfoService;
import com.air.airbooking.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.controller
 * @Project: airbooking
 * @Date: 2021/4/22 17:54
 * @description:
 **/
@RestController
@RequestMapping("/userInfo")
@Slf4j
@CrossOrigin
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/addUserInfo")
    public Result addUserInfo(@RequestBody UserInfo userInfo){
        log.info("userInfo===>"+userInfo);
        Result result = new Result();
        try {
            userInfoService.addUserInfo(userInfo);
            result.setMsg("已经购票成功了哦！快去支付订单吧！");
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg(e.getMessage()).setStatus(false);
        }
        return result;
    }

}
