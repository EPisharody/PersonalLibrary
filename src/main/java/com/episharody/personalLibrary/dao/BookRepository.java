package com.episharody.personalLibrary.dao;

import com.episharody.personalLibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    // method to sort by alphabetical order of title
    public List<Book> findAllByOrderByTitleAsc();
}
