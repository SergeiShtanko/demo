package com.example.demo.controller;

import com.example.demo.dto.BookDTO;
import com.example.demo.exception.BookAlreadyExistsException;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.BookisUpToDateException;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BookEntity;

@RestController
@RequestMapping("/books")
public class BookControllerImpl implements BookController{

    @Autowired
    private BookService bookService;

    @PostMapping("/")
    public ResponseEntity createBook(@RequestBody BookEntity bookEntity){
        try {
            return ResponseEntity.ok(bookService.saveBook(bookEntity));
        } catch (BookAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Something went wrong during saving book");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getBookById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(bookService.getById(id));
        } catch (BookNotFoundException e){
            return ResponseEntity.badRequest().body("Book not found");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Something went wrong during retrieving book");
        }
    }



    @GetMapping("/")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(bookService.getAll());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Something went wrong during retrieving books");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBook(@PathVariable Long id, @RequestBody BookEntity bookEntity){
        try {

            return ResponseEntity.ok(bookService.updateBook(id, bookEntity));
        } catch (BookisUpToDateException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity patchBook(@PathVariable Long id, @RequestParam(required = false) String title,
                                    @RequestParam(required = false) String author, @RequestParam(required = false) Integer year,
                                    @RequestParam(required = false) Integer pageQuantity, @RequestParam(required = false) String description,
                                    @RequestParam(required = false) String publisher){
        try {
            return ResponseEntity.ok(bookService.patchBook(id, new BookDTO(id, title, author, year, pageQuantity, description, publisher)));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
