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
import com.bookclub.bookclub.web.HomeController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(HomeController.class) // Indicates that this is a Web MVC test for the HomeController class.
public class HomeControllerViewTest {

    @Autowired
    private MockMvc mockMvc; // Injects MockMvc for simulating and testing web requests.

    @MockBean
    private BookOfTheMonthDao bookOfTheMonthDao; // Creates a mock BookOfTheMonthDao for use in testing.


    @Test
    @WithMockUser // Uses a mock user for this test, simulating an authenticated user session.
    public void testHomePageView() throws Exception {
        mockMvc.perform(get("/")) // Simulates a GET request to the home page URL ("/").
                .andExpect(view().name("index")); // Asserts that the view name returned is "index".
    }
}


