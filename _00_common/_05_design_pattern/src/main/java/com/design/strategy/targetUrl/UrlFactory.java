package com.design.strategy.targetUrl;

import java.util.ArrayList;
import java.util.List;

public class UrlFactory {
    private static final UrlFactory urlFactory = new UrlFactory();
    private List<UrlStrategy> urlStrategyList = new ArrayList<>();
    private UrlFactory(){
        urlStrategyList.add(new FinanceStrategy());
        urlStrategyList.add(new CarStrategy());
        urlStrategyList.add(new HealthStrategy());
    }

    public UrlStrategy getUrlStrategy(String source){
        for (UrlStrategy urlStrategy : urlStrategyList) {
            if (urlStrategy.getSource().equals(source)){
                return urlStrategy;
            }
        }
        throw new RuntimeException("未找到目的URL");
    }

    public static UrlFactory getInstance(){
        return urlFactory;
    }




}
