/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
		    https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
		    Modified by Terrence Galamison (2023)
*/

package com.bookclub.bookclub.model;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotEmpty;
// Public class representing the BookOfTheMonth model.
public class BookOfTheMonth {
    // Annotation indicating this field is the ID in the database.
    @Id
    private String id;
    // Field for storing the month associated with the book.
    private Integer month;
    // Field for storing the ISBN of the book.
    @NotEmpty(message = "ISBN is a required field")
    private String isbn;
    // Default constructor.
    public BookOfTheMonth() {}
    // Constructor that initializes the month and ISBN of the book.
    public BookOfTheMonth(int month, String isbn) {
        this.month = month;
        this.isbn = isbn;
    }
    // Setter for the ID field.
    public void setId(String id) { this.id = id; }
    // Getter for the ID field.
    public String getId() { return id; }

    // Setter for the month field.
    public void setMonth(Integer month) { this.month = month; }
    // Getter for the month field.
    public Integer getMonth() { return month; }
    // Setter for the ISBN field.
    public void setIsbn(String isbn) { this.isbn = isbn; }
    // Getter for the ISBN field.
    public String getIsbn() { return isbn; }
    // Overridden toString() method for representing this object as a string.
    @Override
    public  String toString() { return String.format("BookOfTheMonth{id=%s, month=%s, isbn=%s}", id, month, isbn); }
}


