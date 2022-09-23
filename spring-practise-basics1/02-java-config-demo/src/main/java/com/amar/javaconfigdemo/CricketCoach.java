package com.amar.javaconfigdemo;

public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("CricketCoach: Inside no-arg constructor");
    }

    private FortuneService fortuneService;

    private String emailAddress;

    private String team;

    private String coach;

    private Integer age;

    public void setFortuneService(FortuneService fortuneService){
        System.out.println("CricketCoach: Inside setter method - setFortuneService");
        this.fortuneService = fortuneService;
    }

    public void setEmailAddress(String emailAddress){
        System.out.println("CricketCoach: Inside setter method - setEmailAddress");
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team){
        System.out.println("CricketCoach: Inside setter method - setTeam");
        this.team = team;
    }

    public String getEmailAddress(){
        System.out.println("CricketCoach: Inside setter method - getEmailAddress");
        return emailAddress;
    }

    public String getTeam(){
        System.out.println("CricketCoach: Inside setter method - getTeam");
        return team;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket Coach - Practice hitting hook shot and ducking";
    }

    @Override
    public String getDailyFortune() {
        return "CricketCoach Class: "+fortuneService.getFortune();
    }
}
