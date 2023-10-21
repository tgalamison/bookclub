/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
			https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
			Modified by Terrence Galamison (2023)
*/
package com.bookclub.bookclub.model;

import java.util.List;
// Represents a Book entity
public class Book
{
    // ISBN of the book
    private String isbn;
    // Title of the book
    private String title;
    // Description of the book
    private String description;
    // URL to additional information about the book
    private String infoUrl;
    // Number of pages in the book
    private int numOfPages;
    // Default constructor
    public Book() {}
    // Constructor to initialize all fields
    public Book(String isbn, String title, String description, String infoUrl, int numOfPages) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.infoUrl = infoUrl;
        this.numOfPages = numOfPages;
    }
    // Constructor to initialize isbn, title, and infoUrl only
    public Book(String isbn, String title, String infoUrl) {
        this.isbn = isbn;
        this.title = title;
        this.infoUrl = infoUrl;
    }
    // Set the ISBN for the book
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    // Retrieve the ISBN of the book
    public String getIsbn() {
        return isbn;
    }
    // Set the title of the book
    public void setTitle(String title) {
        this.title = title;
    }
    // Retrieve the title of the book
    public String getTitle() {
        return title;
    }
    // Set the description of the book
    public void setDescription(String description) {
        this.description = description;
    }
    // Retrieve the description of the book
    public String getDescription() {
        return description;
    }
    // Set the number of pages in the book
    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }
    // Retrieve the number of pages in the book
    public int getNumOfPages() {
        return numOfPages;
    }
    // Set the URL for more information about the book
    public void setInfoUrl(String infoUrl) {
        this.infoUrl = infoUrl;
    }
    // Retrieve the URL with more information about the book
    public String getInfoUrl() {
        return infoUrl;
    }
    // Overrides the default toString method to represent the book in a formatted string
    @Override
    public String toString() {
        return String.format("Book{isbn=%s, title=%s, description=%s, infoUrl=%s, numOfPages=%s}", isbn, title, description, infoUrl, numOfPages);
    }
}

