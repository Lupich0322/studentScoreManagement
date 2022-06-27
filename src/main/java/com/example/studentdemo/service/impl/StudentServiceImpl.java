package com.example.studentdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.studentdemo.bean.entity.StudentDO;
import com.example.studentdemo.bean.req.CommonSearchReq;
import com.example.studentdemo.bean.req.StudentAddReq;
import com.example.studentdemo.bean.req.StudentUpdateReq;
import com.example.studentdemo.bean.res.Result;
import com.example.studentdemo.bean.vo.StudentVO;
import com.example.studentdemo.ex.BizEx;
import com.example.studentdemo.mapper.StudentMapper;
import com.example.studentdemo.service.StudentService;
import com.example.studentdemo.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(StudentAddReq addReq) {
        LambdaQueryWrapper<StudentDO> qw = new LambdaQueryWrapper<>();
        qw.eq(StudentDO::getNo,addReq.getNo());
        Long count = studentMapper.selectCount(qw);
        if (count > 0) {
            throw new BizEx("学号已存在");
        }
        StudentDO studentDO = new StudentDO();
        BeanUtils.copyProperties(addReq,studentDO);
        studentMapper.insert(studentDO);
    }

    @Override
    public Result<List<StudentVO>> selectPage(CommonSearchReq searchReq) {
        PageUtil.startPage(searchReq.getPageNow(),searchReq.getPageSize());
        List<StudentVO> list = studentMapper.queryList(searchReq);
        return PageUtil.wrapPageData(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Long id) {
        studentMapper.deleteById(id);
    }

    @Override
    public Result<StudentVO> selectById(Long id) {
        StudentDO studentDO = studentMapper.selectById(id);
        if(studentDO == null) {
            return Result.buildEmptySuccess();
        }
        StudentVO vo = new StudentVO();
        BeanUtils.copyProperties(studentDO,vo);
        return Result.buildSuccess(vo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateById(StudentUpdateReq updateReq) {
        StudentDO studentDO = new StudentDO();
        BeanUtils.copyProperties(updateReq,studentDO);
        studentMapper.updateById(studentDO);
    }

    @Override
    public Result<List<StudentVO>> selectAll() {
        List<StudentVO> list = studentMapper.queryList(new CommonSearchReq());
        return Result.buildSuccess(list);
    }
}
