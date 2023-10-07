package com.design.strategy.leave.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeaveForm {
//    请假员工
    private Employee employee;
//    请假原因
    private String reason;
//    请假天数
    private int days;
//    请假类型：0-病假、1-婚丧假、2-年假
    private int type;
}
