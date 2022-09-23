package com.amar.javaconfigdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    public static void main(String[] args) {

        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //retrieve the bean(s) from spring container
        CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

        //call methods on the bean
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());
        System.out.println("Calling Literal Values (from ApplicationContext.xml)");
        System.out.println(theCoach.getEmailAddress());
        System.out.println(theCoach.getTeam());

        System.out.println("Calling literal values (From .properties file)");
        System.out.println(theCoach.getCoach());
        System.out.println(theCoach.getAge());

        //close the context
        context.close();

    }
}
