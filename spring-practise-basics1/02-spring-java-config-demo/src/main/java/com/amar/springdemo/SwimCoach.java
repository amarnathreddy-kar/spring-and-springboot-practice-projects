package com.amar.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{

    private FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    SwimCoach(){
        System.out.println("SwimCoach: >>Inside default Constructor");
    }

    public SwimCoach(FortuneService fortuneService){
        System.out.println("SwimCoach: >>Inside Constructor Injection");
        this.fortuneService = fortuneService;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1K meter as a warm-up!";
    }

    @Override
    public String getDailyFortune() {
        return "From SwimCoachgetDailyFortune: "+fortuneService.getFortune();
    }
}
