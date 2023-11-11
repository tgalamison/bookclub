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
import com.bookclub.bookclub.service.impl.MongoBookOfTheMonthDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class) // Use Mockito for mocking in this test class.
public class MongoBookOfTheMonthDaoTest {

    @Mock
    private MongoTemplate mongoTemplate; // Creates a mock of MongoTemplate to simulate MongoDB operations.

    @InjectMocks
    private MongoBookOfTheMonthDao dao; // Automatically inject the mock MongoTemplate into the DAO being tested.

    @Test
    public void testAdd() {
        // Test case for the 'add' method in MongoBookOfTheMonthDao.
        BookOfTheMonth book = new BookOfTheMonth();
        book.setId("12345");
        dao.add(book);
        verify(mongoTemplate).save(book);
    }
}


