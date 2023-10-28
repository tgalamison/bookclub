/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
		    https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
		    Modified by Terrence Galamison (2023)
*/

package com.bookclub.bookclub.web;

import com.bookclub.bookclub.model.WishListItem;
import com.bookclub.bookclub.service.impl.MongoWishlistDao;
import com.bookclub.bookclub.service.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.Authentication;

import javax.validation.Valid;

// Controller class to manage wishlist-related requests
@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    WishlistDao wishlistDao = new MongoWishlistDao();
    // Setter for wishlistDao, allows Spring to autowire and set the appropriate implementation of WishlistDao.
    @Autowired
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }
    // Endpoint to display the wishlist.
    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist() {
        return "wishlist/list";
    }
    // Displays the form for adding a new item to the wishlist.
    @RequestMapping(method = RequestMethod.GET, path = "/new")
    public String wishlistForm(Model model) {
        model.addAttribute("wishlistItem", new WishListItem());
        return "wishlist/new";
    }
    // Handles the submission of the new item form.
    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(@Valid WishListItem wishlistItem, BindingResult bindingResult, Authentication authentication) {
        wishlistItem.setUsername(authentication.getName());
        // Checks for any validation errors in the form.
        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }
        // If no errors are found then add the wishlist item to the data source.
        wishlistDao.add(wishlistItem); // add the record to MongoDB

        return "redirect:/wishlist";
    }
    // Removes an item from the wishlist based on its ID.
    @RequestMapping(method = RequestMethod.GET, path = "/remove/{id}")
    public String removeWishlistItem(@PathVariable String id) {

        wishlistDao.remove(id);

        return "redirect:/wishlist";
    }
    // Displays a specific item from the wishlist based on its ID.
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showWishlistItem(@PathVariable String id, Model model) {
        WishListItem wishlistItem = wishlistDao.find(id);

        model.addAttribute("wishlistItem", wishlistItem);

        return "wishlist/view";
    }
    // Handles updating an existing wishlist item.
    @RequestMapping(method = RequestMethod.POST, path = "/update")
    public String updateWishlistItem(@Valid WishListItem wishlistItem, BindingResult bindingResult, Authentication authentication) {
        wishlistItem.setUsername(authentication.getName());
        // Error check.
        if (bindingResult.hasErrors()) {
            return "wishlist/view";
        }
        // if no errors, update the wishlist item in the data source.
        wishlistDao.update(wishlistItem);
        // Redirect to wishlist page after successful update.
        return "redirect:/wishlist";
    }
}
