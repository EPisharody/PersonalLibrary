package com.episharody.personalLibrary.controller;

import com.episharody.personalLibrary.entity.Book;
import com.episharody.personalLibrary.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int id, Model model) {
        // get book from service
        Book book = bookService.findById(id);
        // set book in model to prepopulate the form
        model.addAttribute("book", book);
        // send to our form

        return "book-form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book newBook) {
        bookService.save(newBook);
        return "redirect:/personalLibrary/books";
    }

    @GetMapping("/delete")
    public String deleteBook(@RequestParam("bookId") int id) {
        bookService.deleteByID(id);
        return "redirect:/personalLibrary/books";
    }
}
