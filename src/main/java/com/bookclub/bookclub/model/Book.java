/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
			https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
			Modified by Terrence Galamison (2023)
*/
package com.bookclub.bookclub.model;

import java.util.List;

public class Book {

    private String isbn;
    private String title;
    private String description;
    private int numOfPages;
    private List<String> authors;

    // Default constructor
    public Book() {}

    // Constructor with parameters
    public Book(String isbn, String title, String description, int numOfPages, List<String> authors) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.numOfPages = numOfPages;
        this.authors = authors;
    }
    // Getter and Setter methods
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public List<String> getAuthors() {
        return authors;
    }

    // Override the toString method
    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", numOfPages=" + numOfPages +
                ", authors=" + authors +
                '}';
    }
}
