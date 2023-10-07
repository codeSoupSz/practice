package com.design.strategy.leave.strategy;

import com.design.strategy.leave.pojo.LeaveForm;

public class AuditStrategyImp1 implements AuditStrategy{
    @Override
    public boolean isSupport(LeaveForm leaveForm) {
        return leaveForm.getDays() <= 3 && leaveForm.getType() == 1;
    }

    @Override
    public void audit(LeaveForm leaveForm) {
        System.out.println(leaveForm);
        System.out.println("三天以下婚丧假无序审批自动通过");
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public String getName() {
        return "三天以下婚丧假规则";
    }
}
