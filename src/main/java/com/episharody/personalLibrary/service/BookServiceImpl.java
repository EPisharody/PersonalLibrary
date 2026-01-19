package com.episharody.personalLibrary.service;

import com.episharody.personalLibrary.dao.BookRepository;
import com.episharody.personalLibrary.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return  bookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        Optional<Book> result = bookRepository.findById(id);
        Book bookEntry = null;

        if (result.isPresent()) {
            bookEntry = result.get();
        } else {
            throw new RuntimeException("Book with id - " + id + " not found");
        }
        return bookEntry;
    }

    @Override
    public void deleteByID(int id) {
        bookRepository.deleteById(id);
    }
}
