package com.work.easyExcel.controller;

import com.alibaba.excel.EasyExcel;
import com.work.easyExcel.entity.Student;
import com.work.easyExcel.listener.StudentListener;
import com.work.easyExcel.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/student")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping("/exportAll")
    public String exportAll(HttpServletResponse response) {
        studentService.exportAll(response);
        return "学生信息汇总导出成功";
    }

    // todo 导入
    // 场景还原： 用户上传一个Excel文件，导入程序会解析Excel生成一个List，然后持久化到数据库保存，完成文件上传。
    @PostMapping("/upload")
    public String upload(@RequestPart MultipartFile file){
        try {
            EasyExcel.read(file.getInputStream(), Student.class, new StudentListener(studentService)).sheet().doRead();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "上传成功";
    }
}
