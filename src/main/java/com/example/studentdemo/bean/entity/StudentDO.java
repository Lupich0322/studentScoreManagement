package com.example.studentdemo.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


@Data
@TableName("student")
public class StudentDO {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String no;
    private String realName;
    private Date enrollTime;

}