package org.miu.bookapplication.dto.response;

import lombok.Data;
import org.miu.bookapplication.domain.Book;

@Data
public class BookResponse {
    private String id;
    private String isbn;

    public static BookResponse from(Book book){
        BookResponse bookResponse = new BookResponse();
        bookResponse.id = book.getId();
        bookResponse.isbn = book.getIsbn();
        return bookResponse;
    }
}
