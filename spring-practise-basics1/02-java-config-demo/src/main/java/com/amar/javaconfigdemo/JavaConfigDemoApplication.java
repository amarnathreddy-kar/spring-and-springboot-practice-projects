package com.amar.javaconfigdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class JavaConfigDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaConfigDemoApplication.class, args);
		//load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);

		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());

		//let's call fortune service (helper/dependeny method)
		System.out.println(theCoach.getDailyFortune());

		//close the context
		context.close();
	}

}
