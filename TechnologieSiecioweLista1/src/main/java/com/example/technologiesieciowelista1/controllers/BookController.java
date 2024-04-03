package com.example.technologiesieciowelista1.controllers;

import com.example.technologiesieciowelista1.entity.Book;
import com.example.technologiesieciowelista1.entity.Loan;
import com.example.technologiesieciowelista1.repositories.BookRepository;
import com.example.technologiesieciowelista1.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody Book addBook(@RequestBody Book book) {
        if (bookRepository.existsByIsbn(book.getIsbn())) {
            throw new IllegalArgumentException("Book with ISBN " + book.getIsbn() + " already exists.");
        }
        return bookRepository.save(book);
    }
    @GetMapping("/getAll")
    public @ResponseBody Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
