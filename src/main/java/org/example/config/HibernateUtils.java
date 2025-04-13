package org.example.config;

import org.example.entities.Author;
import org.example.entities.Book;
import org.example.entities.Members;
import org.example.entities.Reservations;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Author.class);
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(Members.class);
            configuration.addAnnotatedClass(Reservations.class);
            sessionFactory = configuration.buildSessionFactory();
        }
        return this.sessionFactory;
    }
}
