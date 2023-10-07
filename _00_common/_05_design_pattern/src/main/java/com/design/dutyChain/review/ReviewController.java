package com.design.dutyChain.review;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 责任链模式Demo
 */
@Controller
public class ReviewController {
    @Autowired
    private IReview reviewService;

}
