package com.example.studentdemo.bean.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class StudentAddReq {

    @NotBlank
    private String no;

    @NotBlank
    private String realName;

    @NotNull
    private Date enrollTime;
}
