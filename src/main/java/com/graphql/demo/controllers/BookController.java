package com.graphql.demo.controllers;

import com.graphql.demo.entities.Book;
import com.graphql.demo.services.BookService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/books")
@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    //create

    //@PostMapping
    @MutationMapping("createBook")
    public Book create(@Argument BookInput book){
        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setDesc(book.getDesc());
        b.setAuthor(book.getAuthor());
        b.setPrice(book.getPrice());
        b.setPages(book.getPages());
        return this.bookService.create(b);
    }

    //get all
    //@GetMapping
    @QueryMapping("allBooks")
    public List<Book> getAll(){
        return this.bookService.getAll();
    }

    //get sinlge
    //@GetMapping("/{bookId}")
    @QueryMapping("getBook")
    public Book get(@Argument int bookId){
        return this.bookService.get(bookId);
    }
}

@Getter
@Setter
class BookInput{
    private String title;
    private String desc;
    private String author;
    private double price;
    private int pages;
}