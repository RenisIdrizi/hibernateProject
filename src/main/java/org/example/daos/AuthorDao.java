package org.example.daos;

import org.example.entities.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AuthorDao extends GenericDao<Author, Long> {
    private final Session session;
    private Transaction transaction;

    public AuthorDao(Session session) {
        super(session, Author.class);
        this.session = session;
    }

    public Author findById(Long id) {
        return super.findById(id);
    }

    public List<Author> findAll() {
        return super.findAll();
    }

    public Author save(Author author) {
        return super.save(author);
    }

    public List<Author> findByFirstName(String firstName) {
        String query = "from Author a where a.firstName like :firstName";
        Query<Author> findByFirstNameQuery = session.createQuery(query, Author.class);
        findByFirstNameQuery.setParameter("firstName", "%".concat(firstName).concat("%"));
        return findByFirstNameQuery.getResultList();
    }

    public List<Author> findByLastName(String lastName) {
        String query = "from Author a where a.lastName like :lastName";
        Query<Author> findByLastNameQuery = session.createQuery(query, Author.class);
        findByLastNameQuery.setParameter("lastName", "%".concat(lastName).concat("%"));
        return findByLastNameQuery.getResultList();
    }


}
