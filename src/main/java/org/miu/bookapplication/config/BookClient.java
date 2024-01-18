package org.miu.bookapplication.config;

import org.miu.bookapplication.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
public class BookClient {
    @Autowired
    private RestOperations restOperations;
    private String serverUrl = "http://localhost:8080/book";

    public void callRestServer(){
        Book book = restOperations.getForObject(serverUrl+"/{message}", Book.class, " from Spring");
        System.out.println(book.getIsbn());
        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getPrice());
        System.out.println(book.getId());

    }
}
