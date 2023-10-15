/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
			https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Tutorials Pedia. (2020, November 3). OpenAPI 3.0 Tutorial Swagger Tutorial For Beginners | Design REST API Using Swagger Editor. YouTube.
		    https://www.youtube.com/watch?v=mViFmjcDOoA

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
			Modified by Terrence Galamison (2023)
*/

package com.bookclub.bookclub.web;

import com.bookclub.bookclub.model.WishListItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bookclub.bookclub.model.WishListItem;
import com.bookclub.bookclub.service.dao.WishlistDao;
import com.bookclub.bookclub.service.impl.MongoWishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/api/wishlist", produces = "application/json")
@CrossOrigin(origins = "*")
public class WishlistRestController {

    // Instantiate a new MongoWishlistDao object. Note: It's typically recommended to do such initialization in a constructor or a @PostConstruct method.
    WishlistDao wishlistDao = new MongoWishlistDao();
    // Use Spring's dependency injection to assign a WishlistDao instance to the wishlistDao field.
    @Autowired
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }
    // Define an endpoint for HTTP GET requests to "/api/wishlist". It retrieves and returns all wishlist items.
    @RequestMapping(method = RequestMethod.GET)
    public List<WishListItem> showWishlist() {
        return wishlistDao.list();
    }
    // Define an endpoint for HTTP GET requests to "/api/wishlist/{id}". It retrieves and returns a wishlist item with a specific ID.
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public WishListItem findById(@PathVariable String id) {
        return wishlistDao.find(id);
    }

}


