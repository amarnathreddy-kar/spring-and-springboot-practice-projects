package com.amar.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
    public static void main(String[] args) {

        //read spring from Java Class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //get the bean from the spring container
        Coach theCoach = context.getBean("swimCoach", Coach.class);

        //need this to access the new getters (values from application.properties) of SwimCoach
        SwimCoach swimmer = context.getBean("swimCoach", SwimCoach.class);

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        System.out.println("Accessing application.properties values: ");
        System.out.println("foo.email = "+swimmer.getEmail());
        System.out.println("foo.team = "+swimmer.getTeam());

        //close the context
        context.close();

    }
}
