package edu.spring.spring08.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(targetEntity = Book.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "comment", nullable = false)
    private String comment;

    public Comment(Book book, String comment) {
        this.book = book;
        this.comment = comment;
    }
}