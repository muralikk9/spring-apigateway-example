package com.murali;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final List<Book> bookList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        bookList.add(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Integer id) {
        Book book = bookList.stream().filter(b -> b.getId() == id).findAny().orElseThrow(() -> new RuntimeException("book not found"));
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
