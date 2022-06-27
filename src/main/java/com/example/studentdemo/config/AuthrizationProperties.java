package com.example.studentdemo.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "auth")
public class AuthrizationProperties {
    //不需要权限校验的url列表
    private List<String> ignoreUrls;
}
