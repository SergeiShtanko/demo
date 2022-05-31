package com.example.demo.dto;


import com.example.demo.entity.BookEntity;

public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private Integer year;
    private Integer pageQuantity;
    private String description;
    private String publisher;

    public BookDTO() {
    }

    public BookDTO(Long id, String title, String author, Integer year, Integer pageQuantity, String description, String publisher) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.pageQuantity = pageQuantity;
        this.description = description;
        this.publisher = publisher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPageQuantity() {
        return pageQuantity;
    }

    public void setPageQuantity(Integer pageQuantity) {
        this.pageQuantity = pageQuantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public BookEntity convertToEntity(){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(id);
        bookEntity.setAuthor(author);
        bookEntity.setTitle(title);
        bookEntity.setDescription(description);
        bookEntity.setPublisher(publisher);
        bookEntity.setYear(year);
        bookEntity.setPageQuantity(pageQuantity);
        return bookEntity;
    }
}
