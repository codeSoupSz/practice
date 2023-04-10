package com.work.easyExcel.service;

import com.work.easyExcel.entity.Student;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface StudentService {
    void exportAll(HttpServletResponse response);

    void save(List<Student> cachedDataList);
}
