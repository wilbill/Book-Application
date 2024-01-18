package org.miu.bookapplication.dto.response;

import lombok.Data;
import org.miu.bookapplication.domain.Book;

@Data
public class BookResponse {
    private String id;
    private String isbn;
    private String author;
    private double price;
    private String title;

    public static BookResponse from(Book book){
        BookResponse bookResponse = new BookResponse();
        bookResponse.id = book.getId();
        bookResponse.isbn = book.getIsbn();
        bookResponse.author = book.getAuthor();
        bookResponse.price = book.getPrice();
        bookResponse.title = book.getTitle();
        return bookResponse;
    }
}
