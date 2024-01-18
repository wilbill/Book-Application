package org.miu.bookapplication.dto.request;

import lombok.Data;

@Data
public class CreateBookRequest {
    private Long id;
    private String isbn;
    private String author;
    private double price;
    private String title;
}
