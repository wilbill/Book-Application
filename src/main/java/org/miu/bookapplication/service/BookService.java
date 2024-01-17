package org.miu.bookapplication.service;

import org.miu.bookapplication.dto.request.CreateBookRequest;
import org.miu.bookapplication.dto.response.BookResponse;

import java.util.List;

public interface BookService {
    List<BookResponse> findAll();
    BookResponse findById(String bookId);
    BookResponse createBook(CreateBookRequest bookRequest);
    void deleteById(String bookId);

    BookResponse update(String bookId, CreateBookRequest bookRequest);
}
