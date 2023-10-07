package com.design.dutyChain.review;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest(classes = ReviewApp.class)
@RunWith(SpringRunner.class)
public class ReviewAppTest {
    @Autowired
    private IReview reviewService;
    @Test
    public void reviewTest(){
        reviewService.doReview("百度图像违规内容re");
    }
}