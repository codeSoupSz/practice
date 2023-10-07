package com.design.strategy.leave.strategy;

import com.design.strategy.leave.pojo.LeaveForm;

import java.util.ArrayList;
import java.util.List;

public class AuditStrategyFactory {
    private final static AuditStrategyFactory strategyFactory = new AuditStrategyFactory();
    private List<AuditStrategy> auditStrategyList = new ArrayList<>();
    private AuditStrategyFactory(){
        //注册规则
        auditStrategyList.add(new AuditStrategyImp1());
        auditStrategyList.add(new AuditStrategyImp2());
        auditStrategyList.add(new AuditStrategyImp3());
        auditStrategyList.add(new AuditStrategyImp4());
        auditStrategyList.add(new AuditStrategyImp5());
    }
    public static AuditStrategyFactory getInstance(){
        return strategyFactory;
    }
    public AuditStrategy getStrategy(LeaveForm leaveForm){
        AuditStrategy auditStrategy = null;
        for (AuditStrategy strategy : auditStrategyList) {
            if (strategy.isSupport(leaveForm)){
                if (auditStrategy == null){
                    auditStrategy = strategy;
                }else {
                    if (strategy.getPriority() == auditStrategy.getPriority()){
                        throw new RuntimeException("【"+auditStrategy.getName()+"】:【"+strategy.getName()+"】规则冲突，请尽快解决");
                    }else if (strategy.getPriority() > auditStrategy.getPriority()){
                        auditStrategy = strategy;
                    }
                }
            }
        }
        if (auditStrategy == null){
            throw new RuntimeException("没有匹配的请假审核规则");
        }
        return auditStrategy;
    }

}
