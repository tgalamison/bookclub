/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
		    https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
		    Modified by Terrence Galamison (2023)
*/

package com.bookclub.bookclub.web;

import com.bookclub.bookclub.model.WishListItem;
import com.bookclub.bookclub.service.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    private WishlistDao wishlistDao; // Use the interface type

    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist(Model model) {
        model.addAttribute("wishlist", wishlistDao.list());
        return "wishlist/list";
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String wishlistForm(Model model) {
        model.addAttribute("wishlistItem", new WishListItem());
        return "wishlist/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(@Valid WishListItem wishlistItem, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }
        wishlistDao.add(wishlistItem);
        return "redirect:/wishlist";
    }

    @RequestMapping(path = "/edit/{isbn}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable String isbn, Model model) {
        WishListItem item = wishlistDao.findByIsbn(isbn);
        if (item != null) {
            model.addAttribute("wishlistItem", item);
            return "wishlist/edit";
        }
        return "redirect:/wishlist";
    }

    @RequestMapping(path = "/edit/{isbn}", method = RequestMethod.POST)
    public String updateWishlistItem(@PathVariable String isbn, @Valid WishListItem wishlistItem, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "wishlist/edit";
        }
        wishlistDao.update(wishlistItem);
        return "redirect:/wishlist";
    }

    @RequestMapping(path = "/delete/{isbn}", method = RequestMethod.GET)
    public String deleteWishlistItem(@PathVariable String isbn) {
        wishlistDao.deleteByIsbn(isbn);
        return "redirect:/wishlist";
    }
}
