package com.thientvse.springboottutorial;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // test schedule
public class SpringboottutorialApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringboottutorialApplication.class, args);
    }



    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Hello world from Application Runner");
    }
}
