/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
		    https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
		    Modified by Terrence Galamison (2023)
*/

package com.bookclub.bookclub.web;


import com.bookclub.bookclub.model.BookOfTheMonth;
import com.bookclub.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.bookclub.service.impl.MongoBookOfTheMonthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.*;
// Marks this class as a Spring MVC Controller.
@Controller
// Maps requests with the base path "/monthly-books" to this controller.
@RequestMapping("/monthly-books")
public class AdminController {
    // Field for BookOfTheMonth DAO with initialization.
    BookOfTheMonthDao bookOfTheMonthDao = new MongoBookOfTheMonthDao();
    // BookOfTheMonthDao method
    @Autowired
    public void setBookOfTheMonthDao(BookOfTheMonthDao bookOfTheMonthDao) {
        this.bookOfTheMonthDao = bookOfTheMonthDao;
}
// Handles GET requests to "/monthly-books". It shows the book of the month.
@RequestMapping(method = RequestMethod.GET)
public String showBookOfTheMonth(Model model) {
        // Adds a list of books to the model.
        model.addAttribute("books", bookOfTheMonthDao.list("999"));
        // Returns the view name for listing books.
        return "monthly-books/list";
}

@RequestMapping(path = "/new", method = RequestMethod.GET)
public String bookOfTheMonthForm(Model model) {
        // Adds a list of months and a new BookOfTheMonth object to the model.
        model.addAttribute("months", getMonths());
    model.addAttribute("bookOfTheMonth", new BookOfTheMonth());
    // Returns the view name for the new book.
    return "monthly-books/new";
}
// Handles POST requests to "/monthly-books".
@RequestMapping(method = RequestMethod.POST)
public String addBookOfTheMonth(@Valid BookOfTheMonth bookOfTheMonth, BindingResult bindingResult, Model model) {
        // Prints the book details to the console.
        System.out.println(bookOfTheMonth.toString());
    // Checks for validation errors.
    if (bindingResult.hasErrors()) {
        // If there are errors, it re-displays the form with existing data.
        model.addAttribute("months", getMonths());
        return "monthly-books/new";
    }
    // Adds the new book to the DAO.
    bookOfTheMonthDao.add(bookOfTheMonth);
    // Redirects to the listing page after successful addition.
    return "redirect:/monthly-books";
}
// Handles GET requests to "/monthly-books/(id)".
@RequestMapping(method = RequestMethod.GET, path = "/{id}")
public String removeBookOfTheMonth(@PathVariable String id) {
    bookOfTheMonthDao.remove(id);
    // Redirects to the listing page after removal.
    return "redirect:/monthly-books";
}
// A private helper method to get a mapping of month numbers to their names.
private Map<Integer, String> getMonths() {
    Map<Integer, String> months = new HashMap<>();
    months.put(1, "January");
    months.put(2, "February");
    months.put(3, "March");
    months.put(4, "April");
    months.put(5, "May");
    months.put(6, "June");
    months.put(7, "July");
    months.put(8, "August");
    months.put(9, "September");
    months.put(10, "October");
    months.put(11, "November");
    months.put(12, "December");

    return months;

    }

}
















