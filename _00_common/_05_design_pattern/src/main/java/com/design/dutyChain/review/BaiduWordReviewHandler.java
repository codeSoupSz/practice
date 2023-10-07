package com.design.dutyChain.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaiduWordReviewHandler implements IReview{
    @Autowired
    private BaiduImageReviewHandler imageReviewHandler;
    @Override
    public void doReview(String content) {
        if (content.contains("百度敏感词")){
            System.out.println("包含百度文本审核敏感词！");
            return;
        }
        System.out.println("2、文本审核通过");
        imageReviewHandler.doReview(content);
    }
}
