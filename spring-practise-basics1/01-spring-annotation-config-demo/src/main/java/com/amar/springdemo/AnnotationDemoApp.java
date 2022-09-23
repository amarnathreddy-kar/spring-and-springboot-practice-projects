package com.amar.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {

        //read spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //get the bean from the spring container
        Coach theCoach = context.getBean("tableTennisCoach", Coach.class);
        //get the bean to get default bean id
        Coach anotherCoach = context.getBean("basketBallCoach", Coach.class);
        //
//        //autowiring any app
        Coach theTTcoach = context.getBean("tableTennisCoach", Coach.class);
//
//        //Field Injection
        Coach carrom = context.getBean("carromsCoach", Coach.class);

        //call method(s) on the bean
        System.out.println(theCoach.getDailyWorkout());
        //call dependency method of daily fortune service
        System.out.println(theCoach.getDailyFortune());

        System.out.println(anotherCoach.getDailyWorkout());
        System.out.println(anotherCoach.getDailyFortune());

        System.out.println(">>> "+theTTcoach.getDailyWorkout());
        System.out.println(">>> "+theTTcoach.getDailyFortune());

        System.out.println("--- "+carrom.getDailyWorkout());
        System.out.println("--- "+carrom.getDailyFortune());

        //close the context
        context.close();

    }
}
