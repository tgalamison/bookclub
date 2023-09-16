/*
		Bro Code. (2020, November 10). Java Full Course for free [Video]. YouTube.
			https://www.youtube.com/watch?v=xk4_1vDrzzo&t=1234s

		Walls, C. (2019). Spring In Action (5th ed.). Shelter Island, NY: Manning Publications.
			Modified by Terrence Galamison (2023)
*/
package com.bookclub.bookclub.service;

import java.util.List;

public interface GenericDao <E, K> {

    List<E> list();

    E find(K key);
}
