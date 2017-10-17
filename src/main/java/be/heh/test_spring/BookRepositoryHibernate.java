package be.heh.test_spring;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

    @Component
    public class BookRepositoryHibernate implements IBookRepository{

        @Override
        public void save(Book b) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            session.save(b);

            session.getTransaction().commit();

            session.close();
            HibernateUtil.shutdown();
        }

        public List<Book> findByReader(String reader) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();

            //Query query = session.createQuery("select b from Book b where b.reader = :reader");
            Query query = session.createQuery("from Book b where b.reader = :reader");
            query.setParameter( "reader", reader);
            List books = query.list();

            session.getTransaction().commit();

            session.close();
            HibernateUtil.shutdown();
            return books;
        }

    }
