package com.thientvse.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RefreshScope // load config from config server
@RestController
public class ConfigClientApplication {

    @Value("${welcome.message}")
    String welcomeText;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }


    @RequestMapping(value="/")
    public String welcomeText() {
        return welcomeText;
    }
}
