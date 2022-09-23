package com.amar.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.amar.springdemo")
@PropertySource("classpath:application.properties")
public class SportConfig {

    @Bean //define bean for sad fortune service (dependency of SwimCoach)
    public FortuneService sadFortuneService(){
        return new SadFortuneService();
    }

    @Bean //define bean for Swim coach and inject dependency
    public Coach swimCoach(){
        return new SwimCoach(sadFortuneService()); //calling above method - injecting sadFortuneService() into swimCoach();
    }
}
