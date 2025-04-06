package org.example.daos;

import org.example.entities.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthorDao extends GenericDao<Author, Long> {
    private final Session session;
    private Transaction transaction;

    protected AuthorDao(Session session) {
        super(session, Author.class);
        this.session = session;
    }

    public Author findById(Long id) {
        return super.findById(id);
    }


}
