package com.amar.booksapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BooksApiRestfulAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApiRestfulAppApplication.class, args);
	}

}
