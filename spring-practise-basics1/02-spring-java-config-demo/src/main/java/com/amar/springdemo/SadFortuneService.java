package com.amar.springdemo;

public class SadFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "SadFortuneService: Today is not a lucky day, that's pretty sad!";
    }
}
