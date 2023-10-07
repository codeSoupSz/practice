package com.design.strategy.pay;

import java.util.ArrayList;
import java.util.List;

public class PayFactory {
    private final static  PayFactory payFactory = new PayFactory();

    private List<PayService> payServiceList = new ArrayList<>();
    private PayFactory(){
        payServiceList.add(new ZhiFuBao());
        payServiceList.add(new WeiXinPay());
        payServiceList.add(new ChinaBank());
    }
    public static PayFactory getInstance(){
        return payFactory;
    }
    public PayService getPayService(String payWay){
        PayService payService = null;
        for (PayService service : payServiceList) {
            if (service.getName().equals(payWay)){
                payService = service;
            }
        }
        if (payService == null){
            throw new RuntimeException("未找到匹配的支付方式");
        }
        return payService;
    }

}
