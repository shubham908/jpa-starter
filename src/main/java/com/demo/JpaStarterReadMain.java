package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaStarterReadMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee emp1 = entityManager.find(Employee.class, 1);

        if (emp1 != null) {
            System.out.println("Employee: " + emp1);
            System.out.println("AccessCard: " + emp1.getAccessCard());
        } else {
            System.out.println("Employee doesn't exist for the given primary key");
        }

        Employee emp2 = entityManager.find(Employee.class, 2);
        System.out.println("**** Lazily fetching employee-2 ****");
        System.out.println("Employee name: " + emp2.getName());
    }
}
