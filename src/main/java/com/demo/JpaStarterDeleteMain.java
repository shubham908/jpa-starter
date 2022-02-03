package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterDeleteMain {

    public static void main(String[] args) {
        EntityManagerFactory eMFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = eMFactory.createEntityManager();

        Employee employee = entityManager.find(Employee.class, 2);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(employee);

        transaction.commit();
        entityManager.close();
        eMFactory.close();
    }
}
