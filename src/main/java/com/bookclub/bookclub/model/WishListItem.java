/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
		    https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
		    Modified by Terrence Galamison (2023)
*/

package com.bookclub.bookclub.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "wishlist")
public class WishListItem
{
    // The unique identifier for a wishlist item.
    @Id
    private String id;
    // The ISBN of a book/item that cannot be null.
    @NotNull
    @NotEmpty(message = "ISBN is a required field.")
    private String isbn;
    // Title of the book that cannot be null.
    @NotNull
    @NotEmpty(message = "Title is a required field.")
    private String title;
    // The user to whom this wishlist belongs.
    private String username;
    // Default constructor.
    public WishListItem() {}
    // Parameterized constructor to initialize a wishlist item.
    public WishListItem(String isbn, String title, String username) {
        this.isbn = isbn;
        this.title = title;
        this.username = username;
    }
    // Setter for the ID.
    public void setId(String id) { this.id = id; }

    public String getId() {
        return id;
    }
    // Setter for the ISBN.
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    // Getter for the ISBN.
    public String getIsbn() {
        return isbn;
    }
    // Setter for the title.
    public void setTitle(String title) {
        this.title = title;
    }
    // Getter for the title.
    public String getTitle() {
        return title;
    }
    // Setter for the username.
    public void setUsername(String username) { this.username = username; }
    // Getter for the username.
    public String getUsername() { return username; }
    // Override the default toString method to return the wishlist item.
    @Override
    public String toString() {
        return String.format("WishlistItem{id=%s, isbn=%s, title=%s, username=%s}", id, isbn, title, username);
    }
}
