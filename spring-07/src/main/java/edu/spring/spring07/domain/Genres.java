package edu.spring.spring07.domain;

public enum Genres {
    ROMAN("Роман"),
    STORY("Повесть"),
    POEM("Поэма"),
    COMEDY("Комедия");

    private final String title;

    public String getTitle() {
        return title;
    }

    Genres(String title) {
        this.title = title;
    }
}
