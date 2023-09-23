/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
		    https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
		    Modified by Terrence Galamison (2023)
*/

package com.bookclub.bookclub.service.impl;

import com.bookclub.bookclub.model.WishListItem;
import com.bookclub.bookclub.service.dao.WishlistDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemWishlistDao implements WishlistDao {

    private final List<WishListItem> wishlist;

    // Constructor to instantiate the wishlist
    public MemWishlistDao() {
        this.wishlist = new ArrayList<>();
    }

    // Implementing the list() method
    @Override
    public List<WishListItem> list() {
        return wishlist;
    }

    // Implementing the find() method
    @Override
    public WishListItem find(Long key) {
        for (WishListItem item : wishlist) {
            if (item.getIsbn().equals(key.toString())) {
                return item;
            }
        }
        return null;
    }

    // Method to find a wishlist item by its ISBN
    public WishListItem findByIsbn(String isbn) {
        for (WishListItem item : wishlist) {
            if (item.getIsbn().equals(isbn)) {
                return item;
            }
        }
        return null;
    }

    // Method to update a wishlist item
    public void update(WishListItem wishlistItem) {
        for (int i = 0; i < wishlist.size(); i++) {
            if (wishlist.get(i).getIsbn().equals(wishlistItem.getIsbn())) {
                wishlist.set(i, wishlistItem);
                return;
            }
        }
    }

    // Method to delete a wishlist item by its ISBN
    public void deleteByIsbn(String isbn) {
        wishlist.removeIf(item -> item.getIsbn().equals(isbn));
    }

    // Method to add a new wishlist item
    public void add(WishListItem item) {
        wishlist.add(item);
    }
}

