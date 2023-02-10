package com.thientvse.springboottutorial.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {

//    @Scheduled(cron = "0*9**?")
    // fixedRate
//@Scheduled(fixedRate = 2000)
// fixed delay
//@Scheduled(fixedDelay = 10000)
public void cronJobSch(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: "+strDate);
    }
}
