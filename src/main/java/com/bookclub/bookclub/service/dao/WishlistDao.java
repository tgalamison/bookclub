package com.bookclub.bookclub.service.dao;

import com.bookclub.bookclub.model.WishListItem;

public interface WishlistDao extends GenericCrudDao<WishListItem, String> {

    WishListItem findByIsbn(String isbn);

    void deleteByIsbn(String isbn);
}
