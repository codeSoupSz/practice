package com.design.strategy.leave;

import com.design.strategy.leave.pojo.Employee;
import com.design.strategy.leave.pojo.LeaveForm;
import com.design.strategy.leave.strategy.AuditStrategy;
import com.design.strategy.leave.strategy.AuditStrategyFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class LeaveDemo {
    public String leaveOld(@RequestBody LeaveForm leaveForm) {
        int days = leaveForm.getDays();
        int type = leaveForm.getType();
        int level = leaveForm.getEmployee().getLevel();
        //3天以下婚丧假，自动通过
        if (days <= 3 && type == 1){
            System.out.println("三天以下婚丧假无序审批自动通过");
        }
        if (days >= 3 && type == 1){
            System.out.println("三天以上婚丧假，进入上级审批流程");
        }
        if ( level == 9){
            System.out.println("总经理请假，无需审批，自动通过");
        }
        if (days == 1 && type == 0){
            System.out.println("一天病假无需审批，自动通过");
        }
        if (days > 1 && type == 0){
            System.out.println("一天以上病假，进入上级审批流程");
        }

        return "leave done";
    }

    public String leaveNew(@RequestBody LeaveForm leaveForm) {
        AuditStrategyFactory strategyFactory = AuditStrategyFactory.getInstance();
        AuditStrategy auditStrategy = strategyFactory.getStrategy(leaveForm);
        auditStrategy.audit(leaveForm);
        return "leave done";
    }

    public static void main(String[] args) {
        Employee employee = new Employee("王总经理", 9);
        LeaveForm leaveForm = new LeaveForm(employee, "准备去云南参加好友婚礼", 2, 1);
        LeaveDemo demo = new LeaveDemo();
        demo.leaveOld(leaveForm);
        demo.leaveNew(leaveForm);

    }
}
