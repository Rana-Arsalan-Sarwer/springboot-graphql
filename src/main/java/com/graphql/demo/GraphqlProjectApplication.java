package com.graphql.demo;

import com.graphql.demo.entities.Book;
import com.graphql.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlProjectApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book b1 = new Book();
		b1.setTitle("book1");
		b1.setDesc("desc 1");
		b1.setAuthor("auther 1");
		b1.setPages(500);
		b1.setPrice(2000);

		Book b2 = new Book();
		b2.setTitle("book2");
		b2.setDesc("desc 2");
		b2.setAuthor("auther 2");
		b2.setPages(600);
		b2.setPrice(3000);

		Book b3 = new Book();
		b3.setTitle("book3");
		b3.setDesc("desc 3");
		b3.setAuthor("auther 3");
		b3.setPages(700);
		b3.setPrice(4000);

		this.bookService.create(b1);
		this.bookService.create(b2);
		this.bookService.create(b3);

	}
}
