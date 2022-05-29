package edu.spring.spring05.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Genre {

    private Long id;

    private Genres genre;
}
