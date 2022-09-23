package com.amar.javaconfigdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {

        //load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanScopeApplicationContext.xml");

        //retrieve bean from spring container
        Coach theCoach1 = context.getBean("myCoach", Coach.class);
        Coach theCoach2 = context.getBean("myCoach", Coach.class);

        boolean compare = (theCoach1 == theCoach2);
        System.out.println("Comparing theCoach1 is equal to theCoach2: "+compare);
        //default bean scope is 'singleton'
        System.out.println("Memory location for theCoach1 = "+theCoach1);
        System.out.println("Memory location for theCoach2 = "+theCoach2);

        //Bean Lifecycle
        /*
         1. Container started
         2. Bean Instantiated
         3. Dependencies Injected
         4.
         */

        context.close();

    }
}
