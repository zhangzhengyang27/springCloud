package com.lagou.page.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigClientController {

    @Value("${lagou.message}")
    private String message;

    @Value("${pagea}")
    private String pagea;

    @Value("${pageb}")
    private String pageb;

    @RequestMapping("/query")
    public String getRemoteConfig(){
        return message+" - "+pagea+" - "+pageb;
    }



}
