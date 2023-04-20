package com.graphql.demo.services;

import com.graphql.demo.entities.Book;

import java.util.List;

public interface BookService {
    //create book
    Book create(Book book);

    // get all books
    List<Book> getAll();

    // get single book
    Book get(int bookId);

}
