package com.thientvse.sleuthapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class SleuthAppApplication {

    private static final Logger LOG =
            Logger.getLogger(SleuthAppApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(SleuthAppApplication.class, args);
    }

    @RequestMapping("/")
    public String index() {
        LOG.log(Level.INFO, "Index API is calling");
        return "Welcome Sleuth!";
    }
}
