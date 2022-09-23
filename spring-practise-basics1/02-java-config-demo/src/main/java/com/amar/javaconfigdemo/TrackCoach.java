package com.amar.javaconfigdemo;

public class TrackCoach implements Coach{

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Track Coach - Run a hard 500 meter";
    }

    @Override
    public String getDailyFortune() {
        return "TrackCoach Class: "+fortuneService.getFortune();
    }
}
