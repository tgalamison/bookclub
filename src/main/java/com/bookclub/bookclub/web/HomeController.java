/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
		    https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
		    Modified by Terrence Galamison (2023)
*/

// Specifies the package
package com.bookclub.bookclub.web;

// Imports classes related to Spring Boot
import com.bookclub.bookclub.model.BookOfTheMonth;
import com.bookclub.bookclub.model.Book;
import com.bookclub.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.bookclub.service.impl.MongoBookOfTheMonthDao;
import com.bookclub.bookclub.service.impl.RestBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

// Controller class to handle web requests related to home page functionalities
@Controller
// Base URL path for this controller
@RequestMapping("/")
public class HomeController {

    BookOfTheMonthDao bookOfTheMonthDao = new MongoBookOfTheMonthDao();

    @Autowired
    public void setBookOfTheMonthDao(BookOfTheMonthDao bookOfTheMonthDao) {
        this.bookOfTheMonthDao =bookOfTheMonthDao;
}
    // Handle GET request for the root URL and displays the home page
    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int calMonth = cal.get(Calendar.MONTH) + 1;

        // DAO (Data Access Object) to fetch book data
        RestBookDao bookDao = new RestBookDao();

        // Fetch the list of books
        List<BookOfTheMonth> monthlyBooks = bookOfTheMonthDao.list(Integer.toString(calMonth));

        StringBuilder isbnBuilder = new StringBuilder();
        isbnBuilder.append("ISBN:");

        for (BookOfTheMonth monthlyBook : monthlyBooks) {
            isbnBuilder.append(monthlyBook.getIsbn()).append(",");
        }

        String isbnString = isbnBuilder.toString().substring(0, isbnBuilder.toString().length() - 1);

        List<Book> books = bookDao.list(isbnString);
        // Add the list of books to the model to be used in the view
        model.addAttribute("books", books);

        // Return the view name to be rendered
        return "index";
    }

    // Handle GET request for a specific book by its ID
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getMonthlyBook(@PathVariable("id") String id, Model model) {
        // DAO (Data Access Object) to fetch book data
        RestBookDao bookDao = new RestBookDao();

        // Fetch a specific book by its ID
        Book book = bookDao.find(id);

        // Add the fetched book to the model to be used in the view
        model.addAttribute("book", book);

        // Return the view name to be rendered
        return "monthly-books/view";
    }

    // Handle GET request for the about page
    @RequestMapping(method = RequestMethod.GET, path = "/about")
    public String showAboutUs()
    {
        // Return the view name for the about page
        return "about";
    }

    // Handle GET request for the contact page
    @RequestMapping(method = RequestMethod.GET, path = "/contact")
    public String showContactUs()
    {
        // Return the view name for the contact page
        return "contact";
    }
}
