package com.design.strategy.targetUrl;

public class UrlDemo {
    void goToUrl(String source){
        UrlFactory urlFactory = UrlFactory.getInstance();
        UrlStrategy urlStrategy = urlFactory.getUrlStrategy(source);
        urlStrategy.exec();
    }

    public static void main(String[] args) {
        new UrlDemo().goToUrl("C3");
    }
}
