package com.design.dutyChain.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * 基础审核
 */
@Service
@Primary
public class BaseReviewHandler implements IReview{
    @Autowired
    private BaiduWordReviewHandler wordReviewHandler;
    @Override
    public void doReview(String content) {
        //1、检查字数，假设业务需求为：字数不超过 2000 字
        int length = content.replaceAll(" ", "").length();
        if (length > 10){
            System.out.println("文本字数不能超过 10！");
            return;
        }
        //2、是否包含自定义的敏感词
        if (content.contains("冰毒")){
            System.out.println("文本包含自定义敏感词！");
            return;
        }
        //3、通过基础审核，进行下一步百度文本审核
        System.out.println("1、base审核通过");
        wordReviewHandler.doReview(content);
    }
}
