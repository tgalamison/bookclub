/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
			https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
			Modified by Terrence Galamison (2023)
*/
package com.bookclub.bookclub.service.impl;


import com.bookclub.bookclub.model.Book;
import com.bookclub.bookclub.service.dao.BookDao;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

// Implementation of BookDao that fetches book information from a REST API
public class RestBookDao implements BookDao {

    // Default constructor for RestBookDao
    public RestBookDao() {  }

    // Fetches a list of books based on a predefined set of ISBN numbers
    @Override
    public List<Book> list(String key) {
        Object doc = getBooksDoc(key);

        // Predefined set of ISBN numbers
        String isbnString = "ISBN:9780593099322,9780261102361,9780261102378,9780590302715,9780316769532";

        // Create an empty list to hold Book objects
        List<Book> books = new ArrayList<Book>();

        // Extract relevant information using JSON path
        List<String> titles = JsonPath.read(doc, "$..title");
        List<String> isbns = JsonPath.read(doc, "$..bib_key");
        List<String> infoUrls = JsonPath.read(doc, "$..info_url");

        // Populate the books list using extracted data
        for (int index = 0; index < titles.size(); index++) {
            books.add(new Book(isbns.get(index), titles.get(index), infoUrls.get(index)));
        }

        return books;
    }

    // Fetches details of a single book based on its ISBN
    @Override
    public Book find(String key) {
        // Get book details from the API based on the provided ISBN key
        Object doc = getBooksDoc(key);

        // Extract relevant information using JSON path
        List<String> isbns = JsonPath.read(doc, "$..bib_key");
        List<String> titles = JsonPath.read(doc, "$..title");
        List<String> subtitle = JsonPath.read(doc, "$..details.subtitle");
        List<String> infoUrls = JsonPath.read(doc, "$..info_url");
        List<Integer> pages = JsonPath.read(doc, "$..details.number_of_pages");

        // Safely get the first element of each list or provide a default value
        String isbn = isbns.size() > 0 ? isbns.get(0) : "N/A";
        String title = titles.size() > 0 ? titles.get(0) : "N/A";
        String desc = subtitle.size() > 0 ? subtitle.get(0) : "N/A";
        String infoUrl = infoUrls.size() > 0 ? infoUrls.get(0) : "N/A";
        int numOfPages = pages.size() > 0 ? pages.get(0) : 0;

        // Construct a Book object using the extracted details
        Book book = new Book(isbn, title, desc, infoUrl, numOfPages);

        return book;
    }

    // Helper method to fetch book details from the OpenLibrary API based on a given ISBN string
    private Object getBooksDoc(String isbnString) {
        // Base URL for the OpenLibrary API
        String openLibraryUrl = "https://openlibrary.org/api/books";

        // Initialize the RestTemplate object to invoke a third-party API call
        RestTemplate rest = new RestTemplate();

        // Set up headers for the API request
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        // Construct the API URL with necessary query parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(openLibraryUrl)
                .queryParam("bibkeys", isbnString)
                .queryParam("format", "json")
                .queryParam("jscmd", "details");

        // Create an HTTP entity object with the set headers
        HttpEntity<?> entity = new HttpEntity<>(headers);

        // Execute the API request and fetch the response
        HttpEntity<String> response = rest.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        // Parse the JSON response to a suitable format
        String jsonBooklist = response.getBody();

        return Configuration.defaultConfiguration().jsonProvider().parse(jsonBooklist);
    }
}

