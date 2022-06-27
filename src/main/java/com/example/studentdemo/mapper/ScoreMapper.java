package com.example.studentdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.studentdemo.bean.entity.ScoreDO;
import com.example.studentdemo.bean.req.CommonSearchReq;
import com.example.studentdemo.bean.vo.ScoreVO;

import java.util.List;

public interface ScoreMapper extends BaseMapper<ScoreDO> {
    List<ScoreVO> queryList(CommonSearchReq searchReq);
}
