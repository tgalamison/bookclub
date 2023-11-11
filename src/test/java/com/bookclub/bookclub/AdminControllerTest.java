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

import com.bookclub.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.bookclub.web.AdminController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

// Marks this as a test class specifically for the AdminController with Web MVC context.
@WebMvcTest(AdminController.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc; // Injects MockMvc to simulate HTTP requests in tests.

    @MockBean
    private BookOfTheMonthDao bookOfTheMonthDao; // Creates a mock version of the BookOfTheMonthDao for use in testing.

    @Test
    @WithMockUser(roles = "ADMIN") // Specifies that a mock user with the "ADMIN" role is authenticated for this test.
    public void testShowBookOfTheMonth() throws Exception {
        mockMvc.perform(get("/monthly-books")) // Simulates a GET request to "/monthly-books".
                .andExpect(view().name("monthly-books/list")); // Asserts that the returned view's name is "monthly-books/list".
    }
}



