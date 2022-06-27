package com.example.studentdemo.controller;

import com.example.studentdemo.bean.req.LoginReq;
import com.example.studentdemo.bean.res.Result;
import com.example.studentdemo.bean.vo.JwtManagerVO;
import com.example.studentdemo.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Slf4j
@RequestMapping("/manager")
public class ManagerController {

    @Resource
    private ManagerService managerService;

    @PostMapping("/login")
    public Result<JwtManagerVO> login(@RequestBody @Validated LoginReq loginReq) {
        log.info("login params:{}",loginReq);
        return managerService.login(loginReq);
    }

    @PostMapping("/login2")
    public Result<JwtManagerVO> login2(@Validated LoginReq loginReq) {
        log.info("login2 params:{}",loginReq);
        return managerService.login(loginReq);
    }

}
