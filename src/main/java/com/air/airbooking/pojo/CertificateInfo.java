package com.air.airbooking.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.pojo
 * @Project: airbooking
 * @Date: 2021/4/21 19:26
 * @description: 用户证件实体类对象
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificateInfo {
    private Integer cerId;
    private String cerName;
    private List<UserInfo> userInfoList;
}
