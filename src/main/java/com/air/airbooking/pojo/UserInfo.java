package com.air.airbooking.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.airbooking.pojo
 * @Project: airbooking
 * @Date: 2021/4/21 19:27
 * @description: 用户信息对象实体类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Integer userId;
    private String userName;
    private String userPhone;
    private String userSex;
    private Integer cersId;
    private String userCard;
    private List<CertificateInfo> certificateInfos;


}
