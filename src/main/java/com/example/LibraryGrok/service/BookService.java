package com.example.LibraryGrok.service;


import com.example.LibraryGrok.model.Book;
import com.example.LibraryGrok.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    public Book addBook(Book book){
        return repo.save(book);
    }

    public List<Book> getAllBooks(){
        return repo.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return repo.findById(id);
    }

    public Book updateBook(Long id, Book bookDetails){
        Book book = repo.findById(id).orElseThrow(()-> new RuntimeException("Book not found!"));
        book.setAuthor(bookDetails.getAuthor());
        book.setBorrowed(book.isBorrowed());
        book.setTitle(bookDetails.getTitle());
        return repo.save(book);
    }


    public void deleteBook(Long id){
        repo.deleteById(id);
    }


    public Book borrowBook(Long bookId){
        Book book = repo.findById(bookId)
                .orElseThrow(
                ()-> new RuntimeException("Book not found!"));

        if(!book.isBorrowed()){
            book.setBorrowed(true);
            return repo.save(book);
        }else {
            throw new RuntimeException("Book is already borrowed");
        }
    }


    public Book returnBook(Long bookId){
        Book book = repo.findById(bookId)
                .orElseThrow(()-> new RuntimeException("Book not found!"));

        if(book.isBorrowed()){
            book.setBorrowed(false);
            return repo.save(book);
        }else{
            throw new RuntimeException("Book is not borrowed!");
        }
    }

}
