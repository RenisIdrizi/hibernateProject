package org.example.daos;

import org.example.entities.Author;
import org.example.entities.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookManagementDao extends GenericDao<Book, Long> {

    private final Session session;
    private final AuthorDao authorDao;
    private Transaction transaction;

    protected BookManagementDao(Session session, AuthorDao authorDao) {
        super(session, Book.class);
        this.session = session;
        this.authorDao = authorDao;
    }

    public Book newBooks(Book book, Long authorId) {
        Author author = authorDao.findById(authorId);
        book.setAuthor(author);
        return this.save(book);
    }


}
