package com.amar.javaconfigdemo;

public class HappyFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "HappyFortuneService - Today's your lucky day!";
    }
}
