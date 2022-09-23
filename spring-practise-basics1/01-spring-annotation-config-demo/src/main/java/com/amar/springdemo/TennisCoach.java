package com.amar.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach{

    //constructor injection demo
    ////databaseFortuneService,happyFortuneService,randomFortuneService,restFulFortuneService
    private FortuneService fortuneService;

    //defining init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println(">>> TennisCoach: Inside doMyStartupStuff()");
    }

    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println(">>> TennisCoach: Inside doMyCleanupStuff()");
    }

    @Autowired
    public TennisCoach( @Qualifier("randomFortuneService") FortuneService fortuneService){
        System.out.println(">> TennisCoach: Inside Constructor");
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Tennis Coach: Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return "Tennis Coach's Fortune Service: "+fortuneService.getFortune();
    }
}
