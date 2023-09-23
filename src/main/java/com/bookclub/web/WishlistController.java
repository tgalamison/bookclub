/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
		    https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
		    Modified by Terrence Galamison (2023)
*/

package com.bookclub.web;

import com.bookclub.bookclub.model.WishListItem;
import com.bookclub.bookclub.service.impl.MemWishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jakarta.validation.Valid;

/*
 * Controller for handling wishlist-related web requests.
 */
@Controller
@RequestMapping("/wishlist")
public class WishlistController {
    // Autowiring the wishlist DAO for data operations
    @Autowired
    private MemWishlistDao wishlistDao;

    /*
     * Displays the wishlist page.
     *
     * @param modelModel to pass attributes to the view.
     * @return Path to the wishlist view.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist(Model model) {
        model.addAttribute("wishlist", wishlistDao.list());
        return "wishlist/list";
    }
    /*
     * Displays the form for adding a new item to the wishlist.
     *
     * @param modelModel to pass attributes to the view.
     * @return Path to the new wishlist item view.
     */
    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String wishlistForm(Model model) {
        model.addAttribute("wishlistItem", new WishListItem());
        return "wishlist/new";
    }
    /*
     * Handles the submission of a new wishlist item.
     *
     * @param wishlistItem Item to be added.
     * @param bindingResult Validation results for the submitted item.
     * @return Redirection path after processing the submission.
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(@Valid WishListItem wishlistItem, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }
        wishlistDao.add(wishlistItem);
        return "redirect:/wishlist";
    }
    /*
     * Displays the form for editing an existing wishlist item.
     *
     * @param isbnISBN of the item to be edited.
     * @param modelModel to pass attributes to the view.
     * @return Path to the edit wishlist item view.
     */
    @RequestMapping(path = "/edit/{isbn}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable String isbn, Model model) {
        WishListItem item = wishlistDao.findByIsbn(isbn);
        if (item != null) {
            model.addAttribute("wishlistItem", item);
            return "wishlist/edit";
        }
        return "redirect:/wishlist";
    }
    /*
     * Handles the update request for a wishlist item.
     *
     * @param isbnISBN of the item to be updated.
     * @param wishlistItem  Updated item details.
     * @param bindingResult Validation results for the updated item.
     * @return Redirection path after processing the update.
     */
    @RequestMapping(path = "/edit/{isbn}", method = RequestMethod.POST)
    public String updateWishlistItem(@PathVariable String isbn, @Valid WishListItem wishlistItem, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "wishlist/edit";
        }
        wishlistDao.update(wishlistItem);
        return "redirect:/wishlist";
    }
    /*
     * Deletes a wishlist item based on its ISBN.
     *
     * @param isbnISBN of the item to be deleted.
     * @return Redirection path after the deletion.
     */
    @RequestMapping(path = "/delete/{isbn}", method = RequestMethod.GET)
    public String deleteWishlistItem(@PathVariable String isbn) {
        wishlistDao.deleteByIsbn(isbn);
        return "redirect:/wishlist";
    }

}


