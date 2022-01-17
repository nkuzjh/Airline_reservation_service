package com.air.airbooking.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Author: 木林森里没有木
 * @Package: com.igy.travels.vo
 * @Project: travels
 * @Date: 2021/2/3 12:12
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Result {
    private Boolean status = true;
    private String msg;
    private String airId;
}
