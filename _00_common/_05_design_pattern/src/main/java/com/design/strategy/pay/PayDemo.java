package com.design.strategy.pay;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class PayDemo {
    public void payOld(String payWay){
        if ("支付宝".equals(payWay)){
            System.out.println("调用支付宝接口进行支付");
        }else if("微信支付".equals(payWay)){
            System.out.println("调用微信接口进行支付");
        }else if("中国银行".equals(payWay)){
            System.out.println("调用中国银行接口进行支付");
        }else {
            System.out.println("没有找到合适的支付方式");
        }
    }

    public void payNew(String payWay){
        PayFactory payFactory = PayFactory.getInstance();
        PayService payService = payFactory.getPayService(payWay);
        payService.pay();
    }

    public static void main(String[] args) {
        PayDemo demo = new PayDemo();
        demo.payNew("支付宝");

    }
}
