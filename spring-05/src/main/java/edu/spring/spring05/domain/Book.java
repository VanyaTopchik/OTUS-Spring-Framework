package edu.spring.spring05.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {

    private Long id;

    private final Author author;

    private final Genre genre;

    private final String title;

    private final String description;
}
