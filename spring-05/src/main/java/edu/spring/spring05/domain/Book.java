package edu.spring.spring05.domain;

import lombok.Data;

@Data
public class Book {

    private String id;

    private Author author;

    private Genre genre;

    private String title;

    private String description;
}
