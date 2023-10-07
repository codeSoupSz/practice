package com.design.strategy.leave.strategy;

import com.design.strategy.leave.pojo.LeaveForm;

public class AuditStrategyImp3 implements AuditStrategy{
    @Override
    public boolean isSupport(LeaveForm leaveForm) {
        return leaveForm.getEmployee().getLevel() == 9;
    }

    @Override
    public void audit(LeaveForm leaveForm) {
        System.out.println(leaveForm);
        System.out.println("总经理请假，无需审批，自动通过");
    }

    @Override
    public int getPriority() {
        return 999;
    }

    @Override
    public String getName() {
        return "总经理请假规则";
    }
}
