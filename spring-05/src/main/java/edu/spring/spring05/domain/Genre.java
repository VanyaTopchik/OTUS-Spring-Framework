package edu.spring.spring05.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Genre {

    private Long id;

    private final Genres genre;
}
