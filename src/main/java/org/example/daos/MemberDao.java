package org.example.daos;

import org.example.entities.Members;
import org.example.entities.Reservations;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MemberDao extends GenericDao<Members, Long> {
    private final Session session;
    private final ReservationsDao reservationsDao;
    private Transaction transaction;


    public MemberDao(Session session, ReservationsDao reservationsDao) {
        super(session, Members.class);
        this.session = session;
        this.reservationsDao = reservationsDao;
    }

    public Members newMember(Members members) {
        return this.save(members);
    }

    public Members update(Members members) {
        return this.save(members);
    }

    public List<Members> findAll(Long memberId) {
        return super.findAll();
    }

}
