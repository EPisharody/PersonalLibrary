package com.episharody.personalLibrary;

import com.episharody.personalLibrary.entity.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class PersonalLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalLibraryApplication.class, args);
	}

//    @Bean
//    public CommandLineRunner commandLineRunner(BookDAO bookDAO) {
//        return runner -> {
//            createBook(bookDAO);
//
//            createMultipleBooks(bookDAO);
//
//            // readBookEntry(bookDAO);
//
//            // findBooksQuery(bookDAO);
//
//            // findBooksByAuthor(bookDAO);
//
//            // updateBookEntry(bookDAO);
//
//            // deleteBookByID(bookDAO);
//
//            // deleteAllBooks(bookDAO);
//        };
//    }
}
