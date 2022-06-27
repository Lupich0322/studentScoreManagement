package com.example.studentdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.studentdemo.bean.dto.JwtManagerDTO;
import com.example.studentdemo.bean.entity.ManagerDO;
import com.example.studentdemo.bean.req.LoginReq;
import com.example.studentdemo.bean.res.Result;
import com.example.studentdemo.bean.vo.JwtManagerVO;
import com.example.studentdemo.mapper.ManagerMapper;
import com.example.studentdemo.service.ManagerService;
import com.example.studentdemo.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@Slf4j
public class ManagerServiceImpl implements ManagerService {

    @Resource
    private ManagerMapper managerMapper;


    @Override
    public Result<JwtManagerVO> login(LoginReq loginReq) {
        // 查询用户是否存在
        LambdaQueryWrapper<ManagerDO> qw = new LambdaQueryWrapper<>();
        qw.eq(ManagerDO::getUserName,loginReq.getUserName())
                .eq(ManagerDO::getPwd,loginReq.getPwd());
        ManagerDO managerDO = managerMapper.selectOne(qw);
        if (managerDO == null) {
            return Result.buildFailure("用户名或密码不正确");
        }
        JwtManagerVO vo = generateToken(managerDO);
        return Result.buildSuccess(vo);
    }


    private JwtManagerVO generateToken(ManagerDO managerDO) {

        JwtManagerDTO jwtManagerDTO = new JwtManagerDTO();
        BeanUtils.copyProperties(managerDO,jwtManagerDTO);
        String token = JwtUtil.getToken(jwtManagerDTO);
//        返回给前端token和用户信息
        JwtManagerVO vo = new JwtManagerVO();
        BeanUtils.copyProperties(jwtManagerDTO,vo);
        vo.setToken(token);

        return vo;

    }
}
