package com.lhh.eurekaprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaproviderApplication.class, args);
    }

}
