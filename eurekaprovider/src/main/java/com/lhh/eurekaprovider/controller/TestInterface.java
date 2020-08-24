package com.lhh.eurekaprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lai.huihui on 2020/7/21.
 */
@RestController
@RequestMapping("/test")
public class TestInterface {
    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }
}
