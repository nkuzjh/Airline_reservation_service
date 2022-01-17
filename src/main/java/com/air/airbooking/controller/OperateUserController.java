package com.air.airbooking.controller;

import com.air.airbooking.pojo.OperateUser;
import com.air.airbooking.service.OperateUserService;
import com.air.airbooking.utils.CreateImageCode;
import com.air.airbooking.utils.ShortMessageUtil;
import com.air.airbooking.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.controller
 * @Project: airbooking
 * @Date: 2021/4/23 18:44
 * @description:
 **/
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/operateUser")
public class OperateUserController {

    @Autowired
    private OperateUserService operateUserService;

    @RequestMapping("/login")
    public Map<String, Object> login(String operateTel, String operatePassword) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("operateTel", operateTel);
        result.put("operatePassword", operatePassword);
        OperateUser operateUser = operateUserService.login(result);
        if (operateUser != null) {
            result.put("operateUsers", operateUser);
            result.put("msg","登录成功了哦！快去购票吧！");
        }
        return result;
    }

    @PostMapping(value = "/register", produces = "application/json;charset=UTF-8")
    public Result register(String code, String key, @RequestBody OperateUser operateUser, HttpServletRequest request) {
        Result result = new Result();
        log.info("接收到的验证码：" + code);
        log.info("接收到验证码的key：" + code);
        log.info("接收到airUser对象：" + operateUser);
        //验证验证码
        String keyCode = (String) request.getServletContext().getAttribute(key);
        log.info(keyCode);
        try {
            if (code.equalsIgnoreCase(keyCode)) {
                //注册用户
                operateUserService.register(operateUser);
                result.setMsg("注册成功啦,快去登录吧！！！！");
            } else {
                throw new RuntimeException("验证码错误！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(e.getMessage()).setStatus(false);
        }
        return result;
    }

    /**
     * 生成验证码
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/getImage")
    public Map<String, Object> getImage(HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<>();
        //获取验证码
        CreateImageCode createImageCode = new CreateImageCode();
        String code = createImageCode.getCode();
        //验证码存入session
        String key = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        request.getServletContext().setAttribute(key, code);
        //生成图片
        BufferedImage image = createImageCode.getBuffImg();
        //进行base64编码
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", bos);
        String string = Base64Utils.encodeToString(bos.toByteArray());
        result.put("key", key);
        result.put("image", string);
        return result;
    }

    @PostMapping("/getCode")
    public Map<String, Object> getVerificationCode(String operateTel) {
        ShortMessageUtil.sendMessageUtil(operateTel);
        Map<String, Object> result = new HashMap<>();

        return result;
    }

}
