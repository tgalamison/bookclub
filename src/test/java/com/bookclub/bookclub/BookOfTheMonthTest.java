/*
		Amigoscode. (2021, March 28). Software Testing Tutorial - Learn Unit Testing and Integration Testing. YouTube. https://www.youtube.com/watch?v=Geq60OVyBPg

		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
			https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		in28minutes - Get Cloud Certified. (2017, February 9). Spring Boob Unit Testing - For Rest Web Services. YouTube. https://www.youtube.com/watch?v=RbZvXCAtMus

		Teddy Smith. (2022, November 15). Spring Boot Unit Testing With Mockito-Controllers. YouTube. https://www.youtube.com/watch?v=BZBFw6fBeIU&t=452s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
			Modified by Terrence Galamison (2023)
*/

package com.bookclub.bookclub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.bookclub.bookclub.model.BookOfTheMonth;

public class BookOfTheMonthTest {

    @Test // Marks this method as a test method.
    public void testGettersAndSetters() {
        // Creates a new instance of BookOfTheMonth.
        BookOfTheMonth book = new BookOfTheMonth();
        book.setId("12345"); // Sets the ID of the book to "12345".
        book.setMonth(5); // Sets the month of the book to 5.
        book.setIsbn("978-3-16-148410-0"); // Sets the ISBN of the book to "978-3-16-148410-0".
        // Asserts that the ID getter returns the value set earlier.
        assertEquals("12345", book.getId());
        // Asserts that the month getter returns the value set earlier.
        assertEquals(Integer.valueOf(5), book.getMonth());
        // Asserts that the ISBN getter returns the value set earlier.
        assertEquals("978-3-16-148410-0", book.getIsbn());
    }
}

