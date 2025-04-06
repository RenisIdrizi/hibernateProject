package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.example.staticEnum.Genre;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;
    private String title;
    private LocalDate published_date;
    private Long quantity;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
