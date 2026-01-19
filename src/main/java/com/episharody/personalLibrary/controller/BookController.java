package com.episharody.personalLibrary.controller;

import com.episharody.personalLibrary.entity.Book;
import com.episharody.personalLibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personalLibrary")
public class BookController {

    private BookService bookService;

    private JsonMapper jsonMapper;

    @Autowired
    public BookController(BookService bookService, JsonMapper jsonMapper) {
        this.bookService = bookService;
        this.jsonMapper = jsonMapper;
    }

    // Endpoint to get list of all books
    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    // Endpoint to retrieve a specific book by ID
    @GetMapping("/books/{bookId}")
    public Book findById(@PathVariable("bookId") int bookId) {
        // save to a new variable book and check if null and throw exception before returning
        Book book = bookService.findById(bookId);

        if (book == null) {
            throw new RuntimeException("Book not found for id - " + bookId);
        }
        return book;
    }

    // Endpoint to add a new book entry
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        book.setId(0); // just in case an id was passed in
        return bookService.save(book);
    }

    // Endpoint to update a book entry
    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    // Endpoint to update specific fields of a book entry (using PATCH mapping)
    @PatchMapping("/books/{bookId}")
    public Book patchBook(@PathVariable int bookId, @RequestBody Map<String, Object> patchPayload){
        Book tempBook =  bookService.findById(bookId);

        // Throw exception if id does not exist
        if (tempBook == null) {
            throw new RuntimeException("Book not found for id - " + bookId);
        }

        // Throw exception if payload includes id
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("ID not allowed in payload");
        }

        Book patchedBook = jsonMapper.updateValue(tempBook, patchPayload); // update values

        return bookService.save(patchedBook);
    }

    // Endpoint to delete a book entry
    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable int bookId) {
        Book tempBook = bookService.findById(bookId);
        if (tempBook == null) {
            throw new RuntimeException("Book not found for id - " + bookId);
        }

        bookService.deleteByID(bookId);

        return "Deleted book with id - " + bookId;
    }
}
