package com.example.hiber;

import com.example.hiber.model.Department;
import com.example.hiber.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();


            Department department = new Department("IT", 300L, 400L);

            Employee tom = new Employee("Tom", "Tomson", 300L);
            Employee bil = new Employee("Bil", "Bili", 245L);

            department.addEmployeeToDepartment(tom);
            department.addEmployeeToDepartment(bil);


            session.beginTransaction();

            session.persist(department);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}

