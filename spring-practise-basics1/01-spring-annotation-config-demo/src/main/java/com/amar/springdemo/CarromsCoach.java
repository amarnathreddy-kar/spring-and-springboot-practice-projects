package com.amar.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CarromsCoach implements Coach{

    //to demonstrate field injection. Here Spring will automatically inject all the private fields which have '@Autowired'
    //via java reflection (including private fields)

    CarromsCoach(){
        System.out.println(">>> Inside CarromsCoach's default Constructor");
    }

    @Autowired
    @Qualifier("databaseFortuneService") //databaseFortuneService,happyFortuneService,randomFortuneService,restFulFortuneService
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return "CarromsCoach: Practice queen follower coin for 30 minute";
    }

    @Override
    public String getDailyFortune() {

        return "CarromsCoach: "+fortuneService.getFortune();
    }
}
