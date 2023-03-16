package com.example.hiber;

import com.example.hiber.model.Children;
import com.example.hiber.model.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Section.class)
                .addAnnotatedClass(Children.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();

            Section section = new Section("Golf");
            Children tom = new Children("TOM",22);

            session.beginTransaction();

            section.addChildren(tom);

            session.save(section);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}

