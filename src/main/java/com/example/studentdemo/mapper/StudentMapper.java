package com.example.studentdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.studentdemo.bean.entity.StudentDO;
import com.example.studentdemo.bean.req.CommonSearchReq;
import com.example.studentdemo.bean.vo.StudentVO;

import java.util.List;

public interface StudentMapper extends BaseMapper<StudentDO> {
    List<StudentVO> queryList(CommonSearchReq searchReq);
}
