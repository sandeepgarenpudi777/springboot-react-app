package com.nec.controller;

import com.nec.entity.Book;
import com.nec.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "https://react-library-app.onrender.com") // adjust for your frontend port
public class BookController {

    private final BookService service;

    public BookController(BookService service) { this.service = service; }

    @GetMapping
    public List<Book> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Book getById(@PathVariable("id") Long id) { return service.getById(id); }

    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestBody Book book) {
        Book saved = service.create(book);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable("id") Long id, @Valid @RequestBody Book book) {
        return service.update(id, book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

