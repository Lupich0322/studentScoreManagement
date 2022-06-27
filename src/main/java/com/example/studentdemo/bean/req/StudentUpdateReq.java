package com.example.studentdemo.bean.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class StudentUpdateReq {

    @NotNull(message = "更新学生时,学生id必须指定")
    private Long id;

    @NotBlank
    private String no;

    @NotBlank
    private String realName;

    @NotNull
    private Date enrollTime;
}
