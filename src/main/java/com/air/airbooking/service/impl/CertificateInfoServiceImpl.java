package com.air.airbooking.service.impl;

import com.air.airbooking.mapper.CertificateInfoMapper;
import com.air.airbooking.pojo.CertificateInfo;
import com.air.airbooking.service.CertificateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.service.impl
 * @Project: airbooking
 * @Date: 2021/4/21 19:32
 * @description:
 **/
@Service
public class CertificateInfoServiceImpl implements CertificateInfoService {
    @Autowired
    private CertificateInfoMapper certificateInfoMapper;

    @Override
    public List<CertificateInfo> findCertificateInfo() {
        return certificateInfoMapper.findCertificateInfo();
    }
}
