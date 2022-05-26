package edu.spring.spring05.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Book {

    private String id;

    private Author author;

    private Genre genre;

    private String title;

    private String description;
}
