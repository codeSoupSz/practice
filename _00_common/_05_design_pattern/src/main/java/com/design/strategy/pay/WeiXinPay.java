package com.design.strategy.pay;

import org.springframework.stereotype.Service;

@Service
public class WeiXinPay implements PayService {
    @Override
    public void pay() {
        System.out.println("调用微信接口完成支付...");
    }

    @Override
    public String getName() {
        return "微信支付";
    }
}
