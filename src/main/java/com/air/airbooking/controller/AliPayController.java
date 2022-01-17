package com.air.airbooking.controller;

import com.air.airbooking.service.AliPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 星期八领证
 * @Date: 2021/4/16 : 8:23
 * @Content: AliPayController  阿里支付控制器
 */
@CrossOrigin
@Controller
public class AliPayController {

    @Autowired
    private AliPayService aliPayService;

    /**
     * 支付
     *
     * @return
     */
    @RequestMapping(value = "/pay", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String payInfo(Integer  flightId) {
        return aliPayService.payInfo(flightId);
    }

    /**
     * 退款
     *
     * @param orderId
     * @param tradeNo
     * @param refundAmount
     * @param refundReason
     * @return
     */
    @RequestMapping(value = "/refundPay", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String refundPay(String orderId, String tradeNo, String refundAmount, String refundReason) {

        return aliPayService.refundPay(orderId, tradeNo, refundAmount, refundReason);
    }

    /**
     * 查看付款信息
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/findByOrderIdPayInfo")
    public String findByOrderIdPayInfo(String orderId, Model model) {
        model.addAttribute("payInfo", aliPayService.findByOrderIdPayInfo(orderId));
        return "PayInfo";
    }

    /**
     * 查看退款信息
     * @param tradeNo
     * @return
     */
    @RequestMapping(value = "/findRefundPayInfo")
    public String findRefundPayInfo(String orderId,String tradeNo, Model model) {
        model.addAttribute("payInfo", aliPayService.findRefundPayInfo(orderId,tradeNo));
        return "RefundPayInfo";
    }


    /**
     * 用户端支付成功后返回的网址
     *
     * @param out_trade_no 订单号
     * @param trade_no     交易编号
     * @param total_amount 交易金额
     * @param timestamp    交易时间
     * @return
     */
    @RequestMapping("/returnUrl")
    public String returnUrl(HttpServletRequest request, String out_trade_no, String trade_no, String total_amount, String timestamp, Model model) {
        System.out.println("订单号:" + out_trade_no);
        System.out.println("交易时间:" + timestamp);
        System.out.println("交易编号:" + trade_no);
        System.out.println("交易金额:" + total_amount);

        //放入作用域
        model.addAttribute("out_trade_no", out_trade_no);
        model.addAttribute("trade_no", trade_no);
        model.addAttribute("total_amount", total_amount);
        //跳转到成功页面
        return "success";
    }


}
