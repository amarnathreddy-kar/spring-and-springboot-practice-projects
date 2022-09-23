package com.amar.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BasketBallCoach implements Coach{

    //default constructor
    public BasketBallCoach(){
        System.out.println(">>BaseketBallCoach: Inside default Constructor");
    }

    // setter injection demo


    FortuneService fortuneService;

    //setter method
    @Autowired
    @Qualifier("happyFortuneService")
    public void setFortuneService(FortuneService fortuneService){
        System.out.println(">>BasketBallCoach: Inside setter method - setFortuneService");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "BasketBallCoach: Practice rope skipping for 30 minutes";
    }

    @Override
    public String getDailyFortune() {
        return "BasketBallCoach's Fortune Service: "+fortuneService.getFortune();
    }
}
