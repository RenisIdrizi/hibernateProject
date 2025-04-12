package org.example.daos;

import org.example.entities.Author;
import org.example.entities.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.SimpleTimeZone;

public class BookManagementDao extends GenericDao<Book, Long> {

    private final Session session;
    private final AuthorDao authorDao;
    private Transaction transaction;

    public BookManagementDao(Session session, AuthorDao authorDao) {
        super(session, Book.class);
        this.session = session;
        this.authorDao = authorDao;
    }

    public Book newBooks(Book book, Long authorId) {
        Author author = authorDao.findById(authorId);
        book.setAuthor(author);
        return this.save(book);
    }

    public List<Book> findByAuthor(Long authorId) {
        String query = "from Book b where b.author.id = :authorId";
        Query<Book> findByAuthorQuery = session.createQuery(query, Book.class);
        findByAuthorQuery.setParameter("authorId", authorId);
        return findByAuthorQuery.getResultList();
    }

}
