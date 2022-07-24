package com.lagou.page.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/metadata")
public class MetadataController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("show")
    public String showMetadata() {
        String result = "";
        List<ServiceInstance> instances = discoveryClient.getInstances("lagou-service-page");
        for (ServiceInstance instance : instances) {
            Map<String, String> metadata = instance.getMetadata();
            Set<Map.Entry<String, String>> entries = metadata.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                String key = entry.getKey();
                String value = entry.getValue();
                result += "key:" + key + ",value:" + value;
            }
        }
        System.out.println("result"+result);
        return result;
    }
}