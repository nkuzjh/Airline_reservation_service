package com.air.airbooking.controller;

import com.air.airbooking.pojo.CertificateInfo;
import com.air.airbooking.service.CertificateInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.controller
 * @Project: airbooking
 * @Date: 2021/4/21 19:33
 * @description:
 **/
@RestController
@RequestMapping("/cer")
@Slf4j
@CrossOrigin
public class CertificateInfoController {

    @Autowired
    private CertificateInfoService certificateInfoService;

    @RequestMapping("/findCertificateInfo")
    public Map<String, Object> findCertificateInfo(){
        Map result = new HashMap();
        List<CertificateInfo> certificateInfoList = certificateInfoService.findCertificateInfo();
        result.put("certificateInfoList",certificateInfoList);
        return result;
    }

}
