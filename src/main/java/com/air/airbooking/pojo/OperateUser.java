package com.air.airbooking.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

/**
 * @Author: 木林森里没有木
 * @Package: com.air.pojo
 * @Project: air_booking
 * @Date: 2021/4/14 14:44
 * @description: 操作用户对象实体类
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OperateUser {

    /**
     * 用户编号
     */
    private Integer operateId;
    /**
     * 用户电话
     */
    private String operateTel;
    /**
     * 用户的姓
     */
    private String operateSurname;
    /**
     * 用户的名
     */
    private String operateUsername;
    /**
     * 用户密码
     */
    private String operatePassword;
    /**
     * 用户权限
     */
    private Integer operateRole;
    /**
     * 用户是否是会员
     */
    private Integer operateMember;
    /**
     * 用户状态
     */
    private Integer operateStatus;
    /**
     * 用户默认创建时间
     */
    private Date operateUpdate;
}
