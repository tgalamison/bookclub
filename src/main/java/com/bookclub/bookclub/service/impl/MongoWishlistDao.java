/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
			https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Bro Code. (2023, April 14). Learn MongoDB in 1 Hour [Video]. YouTube.
			https://www.youtube.com/watch?v=c2M-rlkkT5o
*/

package com.bookclub.bookclub.service.impl;

import com.bookclub.bookclub.model.WishListItem;
import com.bookclub.bookclub.service.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
// Data access object in Spring.
@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {
    // Autowires the MongoTemplate utility for MongoDB operations.
    @Autowired
    private MongoTemplate mongoTemplate;
    // Adds a new wishlist item.
    @Override
    public void add(WishListItem entity) {
        mongoTemplate.save(entity);
    }
    // Updates an existing wishlist item.
    @Override
    public void update(WishListItem entity) {
        // This will also be implemented using mongoTemplate.save() since it can upsert.
        mongoTemplate.save(entity);
    }
    // Removes an existing wishlist item.
    @Override
    public boolean remove(WishListItem entity) {
        mongoTemplate.remove(entity);
        return true;  // For simplicity, we're always returning true here.
    }
    // Lists all wishlist items.
    @Override
    public List<WishListItem> list() {

        return mongoTemplate.findAll(WishListItem.class);
    }
    // Placeholder for finding an item by key.
    @Override
    public WishListItem find(String key) {
        // This method will be implemented later as it requires querying by the ISBN.
        return null;
    }
    // Placeholder for finding an item by ISBN.
    @Override
    public WishListItem findByIsbn(String isbn) {
        return null;
    }
    // Method to delete a wishlist item.
    @Override
    public void deleteByIsbn(String isbn) {

    }
}

