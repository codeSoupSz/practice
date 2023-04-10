package com.work.easyExcel.mapper;

import com.work.easyExcel.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    List<Student> queryAll();

    void batchSave(@Param("studentList") List<Student> cachedDataList);
}
