package com.example.studentdemo.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("manager")
public class ManagerDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String userName;
    private String pwd;

}
