/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
		    https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
		    Modified by Terrence Galamison (2023)
*/

// Specifies the package
package com.bookclub.web;
// Imports classes related to Spring Boot
import com.bookclub.bookclub.model.Book;
import com.bookclub.bookclub.service.impl.MemBookDao;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

// Annotation for Spring MVC controller
@Controller
// Map controller for URL path
@RequestMapping("/")
@ComponentScan(basePackages = {"com.bookclub.web"})
// Controller class
public class HomeController {
    // Handles GET request for home page
    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        MemBookDao booksDao = new MemBookDao();
        List<Book> books = booksDao.list();
        model.addAttribute("books", books);
        return "index";
    }

    // Handles GET request for the /about path
    @RequestMapping(method = RequestMethod.GET, path = "/about")
    public String showAboutUs(Model model) {

        return "about";
    }

    // Handles GET request for the /contact path
    @RequestMapping(method = RequestMethod.GET, path = "/contact")
    public String showContactUs(Model model) {

        return "contact";
    }
    @RequestMapping(method = RequestMethod.GET, path = "/book/{isbn}")
    public String getMonthlyBook(@PathVariable String isbn, Model model) {
        MemBookDao booksDao = new MemBookDao();

        Book book = booksDao.find(isbn);
        model.addAttribute("book", book);
        return "monthly-books/view";
    }
}
