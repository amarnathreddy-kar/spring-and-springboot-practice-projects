package com.amar.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RestFulFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "RestFortuneService: From the RestFulFortuneService";
    }
}
