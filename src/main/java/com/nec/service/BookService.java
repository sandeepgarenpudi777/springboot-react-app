package com.nec.service;

import com.nec.entity.Book;
import com.nec.exception.ResourceNotFoundException;
import com.nec.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAll() { return repo.findAll(); }

    public Book getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
    }

    public Book create(Book book) { return repo.save(book); }

    public Book update(Long id, Book book) {
        Book existing = getById(id);
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setIsbn(book.getIsbn());
        existing.setPublishedDate(book.getPublishedDate());
        existing.setCopies(book.getCopies());
        return repo.save(existing);
    }

    public void delete(Long id) { repo.delete(getById(id)); }
}

