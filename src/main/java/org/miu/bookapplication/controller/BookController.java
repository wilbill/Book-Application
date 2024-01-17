package org.miu.bookapplication.controller;

import org.miu.bookapplication.dto.request.CreateBookRequest;
import org.miu.bookapplication.dto.response.BookResponse;
import org.miu.bookapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<?> getBooks(){
        List<BookResponse> bookResponseList = bookService.findAll();
        return new ResponseEntity<>(bookResponseList, HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBook(@PathVariable String bookId){
        BookResponse bookResponse = bookService.findById(bookId);
        return new ResponseEntity<>(bookResponse, HttpStatus.OK);
    }

    @PostMapping("/{bookId}")
    public ResponseEntity<?>createBook(@RequestBody CreateBookRequest bookRequest){
        BookResponse bookResponse = bookService.createBook(bookRequest);
        return new ResponseEntity<>(bookResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable String bookId){
        bookService.deleteById(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<?>updateBook(@PathVariable String bookId, @RequestBody CreateBookRequest bookRequest){
        BookResponse bookResponse = bookService.update(bookId, bookRequest);
        return new ResponseEntity<>(bookResponse, HttpStatus.OK);
    }

}
