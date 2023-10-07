package com.design.strategy.targetUrl;

public class FinanceStrategy implements UrlStrategy{
    @Override
    public void exec() {
        System.out.println("168.34.77:9901/fin");
        System.out.println("调用金融保险相关接口");
    }

    @Override
    public String getSource() {
        return "F8";
    }
}
