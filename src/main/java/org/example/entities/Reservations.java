package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.example.staticEnum.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Data
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;
    @Column(name = "reservation_date")
    private LocalDate reservationDate;
    @Column(name = "return_date")
    private LocalDateTime returnDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book books;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Members member;


}
