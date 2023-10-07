package com.design.dutyChain.review;

/**
 * 审核接口
 */
public interface IReview {
    /**
     * 审核的具体实现
     */
    void doReview(String content);
}
