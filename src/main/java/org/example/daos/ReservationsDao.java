package org.example.daos;

import org.example.entities.Book;
import org.example.entities.Members;
import org.example.entities.Reservations;
import org.example.staticEnum.Status;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ReservationsDao extends GenericDao<Reservations, Long> {

    private final Session session;
    private final MemberDao memberDao;
    private final BookManagementDao bookManagementDao;
    private Transaction transaction;


    public ReservationsDao(Session session, MemberDao memberDao, BookManagementDao bookManagementDao) {
        super(session, Reservations.class);
        this.session = session;
        this.memberDao = memberDao;
        this.bookManagementDao = bookManagementDao;
    }

    public Reservations newReservations(Reservations reservations, Long bookId, Long memberId) {
        Book book = bookManagementDao.findById(bookId);
        Members member = memberDao.findById(memberId);
        reservations.setBooks(book);
        reservations.setMember(member);
        reservations.setStatus(Status.RESERVED);
        reservations.setReservationDate(LocalDate.now());
        reservations.setReturnDate(LocalDateTime.now().plusDays(30));
        return this.save(reservations);
    }

    public List<Reservations> findAllReservations(Long bookId) {
        String query = "from Reservations r where r.books.bookId = :bookId";
        Query<Reservations> findall = session.createQuery(query, Reservations.class);
        findall.setParameter("bookId", bookId);
        return findall.getResultList();
    }

}
