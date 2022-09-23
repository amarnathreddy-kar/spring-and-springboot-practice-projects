package com.amar.booksapi.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello(){
        return "Hello from Spring boot, time on server: "+ LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run your daily 5Km!";
    }
    
    @GetMapping("/fortune")
    public String getDailyFourtune(){
        return "Today is your Lucky day!";
    }

    @GetMapping("/team-name")
    public String teamInfo(){
        return "<h1>Team Detail</h1> <h2>Coach Name from application.properties file: "+coachName+
                ", Team Name is "+teamName+"</h2>";
    }

}
