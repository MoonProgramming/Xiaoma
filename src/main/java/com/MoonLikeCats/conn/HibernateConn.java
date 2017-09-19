package com.MoonLikeCats.conn;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConn {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            System.out.println("Hibernate connection opened");
        } catch (Throwable ex) {
        	System.out.println("Hibernate connection failed");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
    	System.out.println("Hibernate session opened");
        return sessionFactory.openSession();
    }

    public static void shutdown() {
        sessionFactory.close();
        System.out.println("Hibernate session factory closed");
    }
}
