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
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repository class to manage operations related to Wishlist in MongoDB
@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {

    // Autowired MongoDB template to facilitate database operations
    @Autowired
    private MongoTemplate mongoTemplate;

    // Adds a wishlist item to the MongoDB database
    @Override
    public void add(WishListItem entity) {
        mongoTemplate.save(entity);
    }

    // Updates a wishlist item in the MongoDB database
    @Override
    public void update(WishListItem entity) {

    }

    // Removes a specific wishlist item from the MongoDB database based on its ID
    @Override
    public boolean remove(WishListItem entity) {
        // Create a query to match wishlist items by ID
        Query query = new Query();

        query.addCriteria(Criteria.where("id").is(entity.getId()));

        // Remove the matched wishlist item from the database
        mongoTemplate.remove(query, WishListItem.class);

        return true;
    }

    // Fetches and returns all wishlist items from the MongoDB database
    @Override
    public List<WishListItem> list() {
        return mongoTemplate.findAll(WishListItem.class);
    }

    // Fetches and returns a specific wishlist item from the MongoDB database based on its key (ID)
    @Override
    public WishListItem find(String key) {
        return mongoTemplate.findById(key, WishListItem.class);
    }
}

