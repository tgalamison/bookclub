/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
			https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
			Modified by Terrence Galamison (2023)
*/
package com.bookclub.bookclub.service.impl;


import com.bookclub.bookclub.model.Book;
import com.bookclub.bookclub.service.dao.BookDao;

import java.util.ArrayList;
import java.util.List;

public class MemBookDao implements BookDao {

    private final List<Book> books;

    public MemBookDao() {
        books = new ArrayList<>();
        books.add(new Book("9780618260300", "The Fellowship of the Ring", "The first book in the Lord of the Rings trilogy follows hobbit Frodo Baggins as he inherits the Ring of Power and journeys to destroy it.", 422, List.of("J.R.R. Tolkien")));
        books.add(new Book("9780060935467", "To Kill a Mockingbird", "A Pulitzer Prize winning novel set in 1930s Alabama that deals with racial injustice and growing up.", 336, List.of("Harper Lee")));
        books.add(new Book("9780451524935", "1984", "Published in 1949, this dystopian novel follows Winston Smith in a totalitarian state ruled by Big Brother.", 328, List.of("George Orwell")));
        books.add(new Book("9781594631931", "The Kite Runner", "A story of friendship, betrayal, guilt, redemption and the power of reading, set in Afghanistan.", 371, List.of("Khaled Hosseini")));
        books.add(new Book("9780743273565", "The Great Gatsby", "Published in 1925, this Jazz Age novel depicts the lives of wealthy Long Islanders in the 1920s and involves themes of idealism, social upheaval, excess, and unrequited love.", 180, List.of("F. Scott Fitzgerald")));
    }

    @Override
    public List<Book> list() {
        return books;
    }

    @Override
    public Book find(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}
