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
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bookclub.bookclub.service.dao.WishlistDao;
import com.bookclub.bookclub.service.impl.MongoWishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// REST Controller to manage API requests related to wishlist
@RestController
@RequestMapping(path = "/api/wishlist", produces = "application/json") // Base path and JSON response type for this controller
@CrossOrigin(origins = "*") // Allows requests from any origin
public class WishlistRestController {

    // Initialize an instance of the WishlistDao with the MongoDB implementation
    WishlistDao wishlistDao = new MongoWishlistDao();

    // Autowired setter method to inject a WishlistDao instance into the REST controller
    @Autowired
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    // API endpoint to retrieve the list of all wishlist items
    @RequestMapping(method = RequestMethod.GET)
    public List<WishListItem> showWishlist(Authentication authentication) {
        String username = authentication.getName();

        return wishlistDao.list(username); // Return the list of wishlist items from the database
    }

    // API endpoint to retrieve a specific wishlist item by its ID
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public WishListItem findById(@PathVariable String id) {
        // Return the wishlist item corresponding to the provided ID
        return wishlistDao.find(id);
    }
}


