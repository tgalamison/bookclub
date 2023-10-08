/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
			https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
			Modified by Terrence Galamison (2023)
*/

package com.bookclub.bookclub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @ComponentScan(basePackages = {"com.bookclub.bookclub.web", "com.bookclub.bookclub.service", "com.bookclub.bookclub.service.impl"})

public class BookclubApplication {
	public static void main(String[] args) {
		SpringApplication.run(BookclubApplication.class, args);
	}
}
