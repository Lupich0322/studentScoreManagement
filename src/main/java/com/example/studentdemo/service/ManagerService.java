package com.example.studentdemo.service;

import com.example.studentdemo.bean.req.LoginReq;
import com.example.studentdemo.bean.res.Result;
import com.example.studentdemo.bean.vo.JwtManagerVO;

public interface ManagerService {
    Result<JwtManagerVO> login(LoginReq loginReq);
}
