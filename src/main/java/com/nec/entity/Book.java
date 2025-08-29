package com.nec.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "reactbooks")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @Column(unique = true)
    private String isbn;

    private LocalDate publishedDate;

    @Min(0)
    private int copies;

    // Constructors, getters, setters

    public Book() {}

    public Book(String title, String author, String isbn, LocalDate publishedDate, int copies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishedDate = publishedDate;
        this.copies = copies;
    }

    // getters and setters ... (omitted for brevity in doc; include in actual file)

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public LocalDate getPublishedDate() { return publishedDate; }
    public void setPublishedDate(LocalDate publishedDate) { this.publishedDate = publishedDate; }
    public int getCopies() { return copies; }
    public void setCopies(int copies) { this.copies = copies; }
}
