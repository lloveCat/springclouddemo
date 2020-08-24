package com.lhh.eurekaconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by lai.huihui on 2020/7/21.
 */
@RestController
@RequestMapping("/consumer")
public class TestConsumer {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate httpClient;
    @HystrixCommand(defaultFallback = "errorFallback", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    @GetMapping("/hello")
    public String consumerHello() {
//        List<ServiceInstance> sis = discoveryClient.getInstances("FIRSTPROVIDER");
//        ServiceInstance instance = sis.get(0);
//        String host = instance.getHost();
//        int port = instance.getPort();
//        StringBuilder sb = new StringBuilder();
//        sb.append("http://").append(host).append(":").append(port).append("/test/hello");
//        String response = httpClient.getForObject(sb.toString(), String.class);
        String response = httpClient.getForObject("http://FIRSTPROVIDER/test/hello", String.class);
        return response;
    }
    public String errorFallback() {
        return "服务调用失败";
    }
}
