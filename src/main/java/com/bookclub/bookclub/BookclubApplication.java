/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
			https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
			Modified by Terrence Galamison (2023)
*/

// Specifies the package
package com.bookclub.bookclub;
// Imports classes related to Spring Boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// Annotation that marks the class as a Spring Boot Application
@SpringBootApplication
// Annotation that scans all components in the package; I could not get the links on the homepage to resolve without this annotation
@ComponentScan(basePackages = {"com.bookclub.web"})
// Main class
public class BookclubApplication {
	// Main method that launches the Spring Boot Application
	public static void main(String[] args) {
		SpringApplication.run(BookclubApplication.class, args);
	}

}
