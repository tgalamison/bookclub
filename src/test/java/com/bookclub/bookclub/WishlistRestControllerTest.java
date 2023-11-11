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

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bookclub.bookclub.service.dao.WishlistDao;
import com.bookclub.bookclub.web.WishlistRestController;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Marks this class as a Spring Boot test, which loads the entire application context.
@SpringBootTest
@AutoConfigureMockMvc
public class WishlistRestControllerTest {

    @Autowired
    private MockMvc mockMvc; // Injects MockMvc to simulate HTTP requests and responses.


    @MockBean
    private WishlistDao wishlistDao; // Creates a mock implementation of WishlistDao for testing purposes.

    @InjectMocks
    private WishlistRestController wishlistRestController; // Injects the above mocks into WishlistRestController.

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this); // Initializes mocks annotated with Mockito annotations.
        // Sets up mock behavior for wishlistDao to return an empty list when its 'list' method is called with any string.
        when(wishlistDao.list(anyString())).thenReturn(Collections.emptyList());
    }

    @Test
    @WithMockUser(username="user", roles={"USER"}) // Simulates a request from a mock user with "USER" role.
    public void testGetWishlistItems() throws Exception {
        // Test to ensure that the "/api/wishlist" endpoint returns an OK status and an empty JSON array.
        mockMvc.perform(MockMvcRequestBuilders.get("/api/wishlist")) // Performs a GET request to "/api/wishlist".
                .andExpect(MockMvcResultMatchers.status().isOk()) // Asserts that the response status is OK (200).
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(0))); // Asserts that the JSON response is an empty array.
    }
}

