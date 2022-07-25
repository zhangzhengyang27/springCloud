package com.lagou.page.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigClientController {

    @Value("${mysql.user}")
    private String user;

    @Value("${person.name}")
    private String name;


    @RequestMapping("/query")
    public String getRemoteConfig() {
        return user + " - " + name;
    }
    
}
