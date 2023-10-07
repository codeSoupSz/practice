package com.design.strategy.leave.strategy;

import com.design.strategy.leave.pojo.LeaveForm;

public interface AuditStrategy {
    boolean isSupport(LeaveForm leaveForm);//看条件是否匹配
    void audit(LeaveForm leaveForm);//审核业务逻辑
    int getPriority();//获取优先级
    String getName();//规则名称
}
