package com.design.strategy.pay;

import org.springframework.stereotype.Service;

@Service
public class ZhiFuBao implements PayService {
    @Override
    public void pay() {
        System.out.println("调用支付宝接口完成支付...");
    }

    @Override
    public String getName() {
        return "支付宝";
    }
}
