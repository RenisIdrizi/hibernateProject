package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String first_name;
    private String last_name;
    @Column(name = "biography")
    private String bio;
    @OneToMany(mappedBy = "author")
    private List<Book> books;

}
