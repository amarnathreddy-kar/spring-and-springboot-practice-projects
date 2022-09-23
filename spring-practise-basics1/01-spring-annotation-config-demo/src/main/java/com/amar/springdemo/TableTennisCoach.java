package com.amar.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TableTennisCoach implements Coach{

    //to demonstrate Autowiring with any method (not only constructor and/or setter methods)
    TableTennisCoach(){
        System.out.println(">>> Inside TableTennisCoach's default Constructor");
    }

    //since it's only one dependency field, Spring will take care of '@Autowired'
    private FortuneService fortuneService;

    @Autowired
    @Qualifier("restFulFortuneService") ////databaseFortuneService,happyFortuneService,randomFortuneService,restFulFortuneService
    public void doSomeCrazyStuff(FortuneService theFortuneService){
        System.out.println(">>> Inside TableTennisCoach's doSomeCrazyStuff()");
        fortuneService = theFortuneService;
    }


    @Override
    public String getDailyWorkout() {
        return "TableTennisCoach: Practice backhand ball spin counter.";
    }

    @Override
    public String getDailyFortune() {

        return "TableTennisCoach: "+fortuneService.getFortune();
    }
}
