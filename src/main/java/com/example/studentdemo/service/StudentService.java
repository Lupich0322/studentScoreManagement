package com.example.studentdemo.service;

import com.example.studentdemo.bean.req.CommonSearchReq;
import com.example.studentdemo.bean.req.StudentAddReq;
import com.example.studentdemo.bean.req.StudentUpdateReq;
import com.example.studentdemo.bean.res.Result;
import com.example.studentdemo.bean.vo.StudentVO;

import java.util.List;

public interface StudentService {
    /**
     * 新增学生
     */
    void add(StudentAddReq addReq);

    /**
     * 学生的分页查询
     */
    Result<List<StudentVO>> selectPage(CommonSearchReq searchReq);

    void deleteById(Long id);

    Result<StudentVO> selectById(Long id);

    void updateById(StudentUpdateReq updateReq);

    Result<List<StudentVO>> selectAll();
}
