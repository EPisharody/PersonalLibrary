package com.episharody.personalLibrary.controller;

import com.episharody.personalLibrary.entity.Book;
import com.episharody.personalLibrary.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/personalLibrary")
public class BookMVCController {

    private BookService bookService;

    public BookMVCController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);

        return "book-list";
    }
}
