package com.thientvse.hystrixapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class HystrixAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixAppApplication.class, args);
    }

}
