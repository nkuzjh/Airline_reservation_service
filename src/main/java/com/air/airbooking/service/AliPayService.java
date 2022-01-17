package com.air.airbooking.service;

/**
 * @Author: 星期八领证
 * @Date: 2021/4/16 : 8:24
 * @Content: AliPayService
 */
public interface AliPayService {

    /**
     * 付款
     * @return
     */
    String payInfo(Integer flightId);

    /**
     * 退款
     * @param orderId - 订单号
     * @param tradeNo - 支付宝账号
     * @param refundAmount - 退款金额
     * @param refundReason - 退款原因
     * @return
     */
    String refundPay(String orderId, String tradeNo, String refundAmount, String refundReason);

    /**
     * 按订单ID付款信息查找
     */
    String findByOrderIdPayInfo(String orderId);


    /**
     * 查找退款付款信息
     */
    String findRefundPayInfo(String orderId,String tradeNo);

}
