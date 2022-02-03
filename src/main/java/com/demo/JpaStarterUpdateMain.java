package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterUpdateMain {

    public static void main(String[] args) {
        EntityManagerFactory eMFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = eMFactory.createEntityManager();

        Employee employee = entityManager.find(Employee.class, 2);
        employee.setEmployeeType(EmployeeType.PERMANENT);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        // JPA differentiates b/w update & create by looking at the id.
        // If the id exists in the DB then it is an update or create if otherwise.
        entityManager.persist(employee);

        transaction.commit();

        entityManager.close();
        eMFactory.close();
    }
}
