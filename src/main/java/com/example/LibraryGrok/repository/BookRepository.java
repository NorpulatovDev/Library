package com.example.LibraryGrok.repository;

import com.example.LibraryGrok.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
