package com.amar.springdemo;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "DbFortuneService: From the DatabaseFortuneService";
    }
}
