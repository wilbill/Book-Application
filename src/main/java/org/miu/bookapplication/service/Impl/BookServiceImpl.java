package org.miu.bookapplication.service.Impl;

import org.miu.bookapplication.Exceptions.BookNotFoundException;
import org.miu.bookapplication.domain.Book;
import org.miu.bookapplication.dto.request.CreateBookRequest;
import org.miu.bookapplication.dto.response.BookResponse;
import org.miu.bookapplication.repository.BookRepository;
import org.miu.bookapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<BookResponse> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(BookResponse::from)
                .toList();
    }
    @Override
    public BookResponse findById(String bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(
                ()-> new BookNotFoundException(String.format("Book has not been found")));
        return BookResponse.from(book);
    }

    @Override
    public BookResponse createBook(CreateBookRequest bookRequest) {
        Book book = new Book();
        book.setIsbn(bookRequest.getIsbn());
        return BookResponse.from(book);
    }

    @Override
    public BookResponse update(String bookId, CreateBookRequest bookRequest) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if(bookOptional.isPresent()){
            Book book = bookOptional.get();
            book.setIsbn(bookRequest.getIsbn());
            bookRepository.save(book);
            return BookResponse.from(book);
        }
        else {
            throw new BookNotFoundException(String.format("Book with id %s not found", bookId));
        }
    }
    @Override
    public void deleteById(String bookId) {
        bookRepository.deleteById(bookId);
    }
}
