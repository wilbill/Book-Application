package org.miu.bookapplication.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "bookTable")
public class Book {
    @Id
    private String id;
    private String isbn;

}
