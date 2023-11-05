package com.bookclub.bookclub.service.impl;

import com.bookclub.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.bookclub.model.BookOfTheMonth;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

// Annotation saying that this class is a repository component within Spring.
@Repository("bookOfTheMonthDao")
public class MongoBookOfTheMonthDao implements BookOfTheMonthDao {
    // Field for MongoTemplate.
    @Autowired
    private MongoTemplate mongoTemplate;
    // Implementation of the add method from BookOfTheMonthDao interface.
    @Override
    public void add(BookOfTheMonth book) {
        mongoTemplate.save(book);
    }
    // Implementation of the remove method from BookOfTheMonthDao interface.
    @Override
    public boolean remove(String key) {
        // Creates a new Query object.
        Query query = new Query();
        // Adds a criteria to the query to search by ID.
        query.addCriteria(Criteria.where("id").is(key));
        // Removes the matching document.
        mongoTemplate.remove(query, BookOfTheMonth.class);
        // Returns true to indicate successful removal.
        return true;
    }
    // Unimplemented update method from the interface.
    @Override
    public void update(BookOfTheMonth entity) {
        throw new NotImplementedException(); }

    // Implementation of the list method.
    @Override
    public List<BookOfTheMonth> list(String key) {
        // Parses the key to an integer representing a month.
        int month = Integer.parseInt(key);
        // Debug statement.
        System.out.println("Month: " + month);
        // Checks if the month value is 999.
        if (month == 999) {
            // Returns all BookOfTheMonth objects from MongoDB.
            return mongoTemplate.findAll(BookOfTheMonth.class);
        }
        // Creates a new query object for a specific month.
        Query query = new Query();
        query.addCriteria(Criteria.where("month").is(month));
        // Returns a list of BookOfTheMonth objects for the given month.
        return mongoTemplate.find(query, BookOfTheMonth.class);
    }
    // Find method from the BookOfTheMonthDao interface.
    @Override
    public BookOfTheMonth find(String key) { throw new NotImplementedException(); }
    }

