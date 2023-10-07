package com.design.strategy.pay;

import org.springframework.stereotype.Service;

@Service
public class ChinaBank implements PayService {
    @Override
    public void pay() {
        System.out.println("调用中国接口完成支付...");
    }

    @Override
    public String getName() {
        return "中国银行";
    }
}
