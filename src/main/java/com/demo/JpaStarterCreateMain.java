package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaStarterCreateMain {

    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.setName("Dwayne Johnson");
        e1.setAadhar("123");
        e1.setCreatedAt(new Date());
        e1.setEmployeeType(EmployeeType.PERMANENT);

        Employee e2 = new Employee();
        e2.setName("Kevin Hart");
        e2.setAadhar("456");
        e2.setCreatedAt(new Date());
        e2.setEmployeeType(EmployeeType.CONTRACTOR);
        AccessCard c1 = new AccessCard();
        c1.setIssuedDate(new Date());
        c1.setActive(true);
        c1.setFirmwareVersion("1.0.0");
        e1.setAccessCard(c1);

        AccessCard c2 = new AccessCard();
        c2.setIssuedDate(new Date());
        c2.setActive(false);
        c2.setFirmwareVersion("1.0.1");
        e2.setAccessCard(c2);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(e1);
        entityManager.persist(e2);
        entityManager.persist(c1);
        entityManager.persist(c2);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
