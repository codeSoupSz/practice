package com.design.strategy.leave.strategy;

import com.design.strategy.leave.pojo.LeaveForm;

public class AuditStrategyImp4 implements AuditStrategy{
    @Override
    public boolean isSupport(LeaveForm leaveForm) {
        return leaveForm.getDays() == 1 && leaveForm.getType() == 0;
    }

    @Override
    public void audit(LeaveForm leaveForm) {
        System.out.println(leaveForm);
        System.out.println("一天病假无需审批，自动通过");
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public String getName() {
        return "一天病假规则";
    }
}
