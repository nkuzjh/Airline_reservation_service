package com.air.airbooking.service.impl;

import com.air.airbooking.config.AliPayConfig;
import com.air.airbooking.pojo.FlightRecords;
import com.air.airbooking.service.AliPayService;
import com.air.airbooking.service.FlightRecordsService;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeRefundResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author: 星期八领证
 * @Date: 2021/4/16 : 8:25
 * @Content: AliPayServiceImpl
 */
@Service
public class AliPayServiceImpl implements AliPayService {

    @Autowired
    private FlightRecordsService flightRecordsService;

    //获得初始化的AlipayClient
    AlipayClient alipayClient = new DefaultAlipayClient(AliPayConfig.gatewayUrl, AliPayConfig.app_id, AliPayConfig.merchant_private_key, "json", AliPayConfig.charset, AliPayConfig.alipay_public_key, AliPayConfig.sign_type);


    /**
     * 付款
     *
     * @return
     */
    @Override
    public String payInfo(Integer flightId) {


        FlightRecords flightRecordsByIdFlightRecords = flightRecordsService.findFlightRecordsByIdFlightRecords(flightId);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AliPayConfig.return_url);
        alipayRequest.setNotifyUrl(AliPayConfig.notify_url);

        //生成订单号
        String orderId = UUID.randomUUID().toString();
        //设置金额
        Double totalAmount = flightRecordsByIdFlightRecords.getFlightPrice()+50;
        //订单名称
        String subject = flightRecordsByIdFlightRecords.getFlightNumber()+"航班支付";
        //商品描述（可以不写）
        String body =  flightRecordsByIdFlightRecords.getFlightNumber()+"航班支付";

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + orderId + "\","
                + "\"total_amount\":\"" + totalAmount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"timeout_express\":\"10m\"," //最晚支付时间，单位分钟
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = null;
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 退款
     *
     * @param orderId      - 订单号
     * @param tradeNo      - 支付宝账号
     * @param refundAmount - 退款金额
     * @param refundReason - 退款原因
     * @return
     */
    @Override
    public String refundPay(String orderId, String tradeNo, String refundAmount, String refundReason) {
        //设置请求参数
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + orderId + "\","
                + "\"trade_no\":\"" + tradeNo + "\","
                + "\"refund_amount\":\"" + refundAmount + "\","
                + "\"refund_reason\":\"" + refundAmount + "\"}");
        AlipayTradeRefundResponse response = null;
        //请求
        try {
            response = alipayClient.execute(alipayRequest);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        //是否退款成功
        if (response.getMsg().equals("Success")) {
            //退款成功
            System.out.println("订单ID:" + response.getOutTradeNo());
            System.out.println("支付宝账号:" + response.getTradeNo());
            System.out.println("退款金额:" + response.getRefundFee());
            System.out.println("退款时间:" + response.getGmtRefundPay());
        } else {
            System.out.println("退款失败");
        }
        return response.getMsg();
    }

    /**
     * 查询付款信息
     * @param orderId
     * @return
     */
    @Override
        public String findByOrderIdPayInfo(String orderId) {
        //设置请求参数
        AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();
        alipayRequest.setBizContent("{\"out_trade_no\":\"" + orderId + "\"}");
        AlipayTradeQueryResponse response = null;
        try {
            response = alipayClient.execute(alipayRequest);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println("付款金额:" + response.getTotalAmount());
        System.out.println("用户ID:" + response.getBuyerUserId());
        System.out.println("订单编号:" + response.getOutTradeNo());
        System.out.println("付款时间:" + response.getSendPayDate());
        System.out.println("交易编号:" + response.getTradeNo());
        System.out.println("支付状态:" + response.getTradeStatus());
        return response.getBody();
    }

    /**
     * 查询退款信息
     * @param orderId
     * @param tradeNo
     * @return
     */
    @Override
    public String findRefundPayInfo(String orderId,String tradeNo) {
        AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ orderId +"\","
                +"\"trade_no\":\""+ tradeNo +"\","
                +"\"out_request_no\":\""+ orderId +"\"}");
        AlipayTradeFastpayRefundQueryResponse response = null;
        try {
            response  = alipayClient.execute(alipayRequest);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println("付款金额:" + response.getTotalAmount());
        System.out.println("退款金额:" + response.getRefundAmount());
        System.out.println("订单编号:" + response.getOutTradeNo());
        System.out.println("交易编号:" + response.getTradeNo());
        return response.getBody();
    }
}
