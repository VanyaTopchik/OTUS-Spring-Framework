package edu.spring.spring05.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Author {

    private String id;

    private String name;
}
