package com.distribuida.db;

import jakarta.ws.rs.GET;
import lombok.Getter;
import lombok.Setter;

public class Book {
    @Getter @Setter private Integer id ;
    @Getter @Setter private String isbn;
    @Getter @Setter private String title;
    @Getter @Setter private String author;
    @Getter @Setter private Double price;
}

