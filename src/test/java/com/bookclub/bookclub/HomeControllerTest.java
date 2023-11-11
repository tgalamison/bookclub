/*
		Amigoscode. (2021, March 28). Software Testing Tutorial - Learn Unit Testing and Integration Testing. YouTube. https://www.youtube.com/watch?v=Geq60OVyBPg

		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
			https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		in28minutes - Get Cloud Certified. (2017, February 9). Spring Boob Unit Testing - For Rest Web Services. YouTube. https://www.youtube.com/watch?v=RbZvXCAtMus

		Teddy Smith. (2022, November 15). Spring Boot Unit Testing With Mockito-Controllers. YouTube. https://www.youtube.com/watch?v=BZBFw6fBeIU&t=452s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
			Modified by Terrence Galamison (2023)
*/

package com.bookclub.bookclub;

import com.bookclub.bookclub.model.BookOfTheMonth;
import com.bookclub.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.bookclub.web.HomeController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Initializes Mockito mocks before each test method.
class HomeControllerTest {

    @Mock
    private BookOfTheMonthDao bookOfTheMonthDao; // Mock DAO for Book of the Month data access.

    @Mock
    private Model model; // Mock Spring's Model interface for web context.

    @InjectMocks
    private HomeController homeController; // Injects the mocks into the HomeController being tested.

    @Test
    void showAboutUsReturnsAboutView() {


        // Test method to verify that the "about" view is returned for the About Us page.
        String viewName = homeController.showAboutUs();

        // Asserts that the expected view name is returned.
        assertEquals("about", viewName);
    }

    @Test
    void showContactUsReturnsContactView() {


        // Test method to verify that the "contact" view is returned for the Contact Us page.
        String viewName = homeController.showContactUs();

        // Asserts that the expected view name is returned.
        assertEquals("contact", viewName);
    }

    // Utility method for creating a list of BookOfTheMonth instances
    private List<BookOfTheMonth> someListOfMonthlyBooks() {
        // Implementation would create and return a list of mock BookOfTheMonth instances.
        return null;
    }
}



