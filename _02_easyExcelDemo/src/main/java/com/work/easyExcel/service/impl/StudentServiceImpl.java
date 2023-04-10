package com.work.easyExcel.service.impl;

import com.alibaba.excel.EasyExcel;
import com.work.easyExcel.entity.Student;
import com.work.easyExcel.mapper.StudentMapper;
import com.work.easyExcel.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    @Override
    public void exportAll(HttpServletResponse response) {
        List<Student> students = studentMapper.queryAll();
        //设置response
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = null;
        try {
             fileName = URLEncoder.encode("学生信息汇总.xlsx","UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        response.setHeader("Access-Control-Expose-Headers","Content-Disposition");
        response.setHeader("Content-Disposition","attachment;fileName="+ fileName);

        //easyExcel写出
        try {
            EasyExcel.write(response.getOutputStream(),Student.class)
                    .sheet("学生信息")
                    .doWrite(students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void save(List<Student> cachedDataList) {
        studentMapper.batchSave(cachedDataList);
    }
}
