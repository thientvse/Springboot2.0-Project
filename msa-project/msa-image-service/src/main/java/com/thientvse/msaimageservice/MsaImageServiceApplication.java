package com.thientvse.msaimageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsaImageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaImageServiceApplication.class, args);
    }

}
