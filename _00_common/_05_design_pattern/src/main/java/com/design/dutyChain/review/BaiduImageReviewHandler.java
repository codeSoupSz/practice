package com.design.dutyChain.review;

import org.springframework.stereotype.Service;

@Service
public class BaiduImageReviewHandler implements IReview{
    @Override
    public void doReview(String content) {
//        解析图片
        String[] imageUrlList = getImages(content);
        for (String imageUrl : imageUrlList) {
            if (imageUrl.contains("百度图像违规内容")){
                System.out.println("百度图像审核失败，包含敏感内容！");
                return;
            }
        }
        System.out.println("3、图片审核通过");
        return;
    }

    private String[] getImages(String content) {
        System.out.println("从内容中解析出所有图片");
        return new String[]{"111","222"};
    }
}
