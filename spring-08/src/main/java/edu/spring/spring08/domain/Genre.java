package edu.spring.spring08.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "genres")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Genre(Genres genre) {
        this.genre = genre;
    }

    @Column(name = "genre")
    private Genres genre;
}
