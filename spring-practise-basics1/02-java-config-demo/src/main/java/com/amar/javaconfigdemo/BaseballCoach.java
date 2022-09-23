package com.amar.javaconfigdemo;

public class BaseballCoach implements Coach{

    private FortuneService fortuneService;

    //constructor injection
    public BaseballCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "Baseball Coach - Spend 30 minute on batting practice";
    }

    @Override
    public String getDailyFortune() {
        //use fortune service
        return "From BaseballCoach's class: "+fortuneService.getFortune();
    }
}
