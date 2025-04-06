package org.example.config;

import org.example.entities.Author;
import org.example.entities.Book;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Author.class);
            configuration.addAnnotatedClass(Book.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return this.sessionFactory;
    }
}
