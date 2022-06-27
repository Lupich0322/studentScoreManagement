package com.example.studentdemo.bean.vo;


import com.example.studentdemo.bean.dto.JwtManagerDTO;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class JwtManagerVO extends JwtManagerDTO {

    private String token;

}
