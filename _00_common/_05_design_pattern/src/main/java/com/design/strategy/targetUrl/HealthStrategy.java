package com.design.strategy.targetUrl;

public class HealthStrategy implements UrlStrategy{
    @Override
    public void exec() {
        System.out.println("76.987.82882:9901/h5");
        System.out.println("调用健康险相关接口");
    }

    @Override
    public String getSource() {
        return "H5";
    }
}
