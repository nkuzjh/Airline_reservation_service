package com.air.airbooking.utils;

import com.alibaba.fastjson.JSONException;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.utils
 * @Project: airbooking
 * @Date: 2021/4/23 18:19
 * @description: 短信验证码
 **/
public class ShortMessageUtil {

    /**
     * 发送短信验证码
     * @param iphoneNumber
     */
    public static void sendMessageUtil(String iphoneNumber){
        //短信API
        //SDK AppID是短信应用的唯一标识，调用短信API接口时,需要提供参数。(这个内容不要修改)
        int SMS_APP_ID = 1400479730;
        // App Key是用来校验短信发送合法性的密码，与SDK AppID对应，需要业务方高度保密，切勿把密码存储在客户端。(这个内容不要修改)
        String SMS_SDK_APP_ID = "9fc55f2316ceb04884b92ec9a5ffb127";
        // sms签名  签名内容 (签名如果想修改需要申请新的签名)
        String SMS_SIGN = "MJBLOG个人日志";
        String code = RandomStringUtils.randomNumeric(6);
        try {
            String [] params = {(String) code, "1"};  //第一个参数验证码,第二个代表的是多长时间失效
            SmsSingleSender ssender = new SmsSingleSender(SMS_APP_ID, SMS_SDK_APP_ID);
            SmsSingleSenderResult result = ssender.sendWithParam("86", iphoneNumber,857388, params, SMS_SIGN, "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
