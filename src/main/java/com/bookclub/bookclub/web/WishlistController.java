/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
		    https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
		    Modified by Terrence Galamison (2023)
*/

package com.bookclub.bookclub.web;

import com.bookclub.bookclub.model.WishListItem;
import com.bookclub.bookclub.service.dao.WishlistDao;
import com.bookclub.bookclub.service.impl.MongoWishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

// Controller class to manage wishlist-related requests
@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    // Initialize an instance of the WishlistDao with the MongoDB implementation
    WishlistDao wishlistDao = new MongoWishlistDao();

    // Autowired setter method to inject a WishlistDao instance into the controller
    @Autowired
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    // Endpoint to display the wishlist page
    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist() {
        return "wishlist/list"; // Return the "wishlist/list" view
    }

    // Endpoint to display the form for adding a new item to the wishlist
    @RequestMapping(method = RequestMethod.GET, path = "/new")
    public String wishlistForm(Model model) {
        // Add an empty WishListItem object to the model to be filled in the form
        model.addAttribute("wishlistItem", new WishListItem());
        return "wishlist/new"; // Return the "wishlist/new" view
    }

    // Endpoint to process the form submission for adding a new wishlist item
    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(
            @Valid WishListItem wishlistItem, // Validate the submitted wishlist item
            BindingResult bindingResult) { // Result of the validation process

        // Print the submitted wishlist item for debugging purposes
        System.out.println(wishlistItem.toString());

        // If there are validation errors, return to the form view
        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }

        // If there are no errors, add the wishlist item to the database
        wishlistDao.add(wishlistItem);

        // Redirect the user to the main wishlist page after adding the item
        return "redirect:/wishlist";
    }
}
