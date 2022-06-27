package com.example.studentdemo.service;

import com.example.studentdemo.bean.req.CommonSearchReq;
import com.example.studentdemo.bean.req.ScoreAddReq;
import com.example.studentdemo.bean.req.ScoreUpdateReq;
import com.example.studentdemo.bean.res.Result;
import com.example.studentdemo.bean.vo.ScoreVO;

import java.util.List;

public interface ScoreService {
    /**
     * 新增成绩
     */
    void add(ScoreAddReq addReq);

    Result<List<ScoreVO>> selectPage(CommonSearchReq searchReq);

    void deleteById(Long id);

    Result<ScoreVO> selectById(Long id);

    void updateById(ScoreUpdateReq updateReq);
}
