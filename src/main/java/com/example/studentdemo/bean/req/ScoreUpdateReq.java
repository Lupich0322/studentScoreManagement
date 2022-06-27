package com.example.studentdemo.bean.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ScoreUpdateReq {

    @NotNull(message = "id必须指定")
    private Long id;

    @NotNull
    private Long studentId;

    @NotBlank
    private String examName;

    @NotNull
    private Double cnScore;

    @NotNull
    private Double enScore;

    @NotNull
    private Double mathScore;
}

