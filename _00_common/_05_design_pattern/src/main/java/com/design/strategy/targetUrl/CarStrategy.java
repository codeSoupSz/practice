package com.design.strategy.targetUrl;

public class CarStrategy implements UrlStrategy{
    @Override
    public void exec() {
        System.out.println("139.108.99:9901/car");
        System.out.println("调用汽车保险相关接口");
    }

    @Override
    public String getSource() {
        return "C3";
    }
}
