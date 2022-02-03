package com.demo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE_DATA")
public class Employee {

    // If we do not want to provide the values of id ourselves
    // then in that case we can use @GeneratedValue
    @Id
    @Column(name = "EMPLOYEE_ID")
    @GeneratedValue
    private int id;

    @Column(length = 512, nullable = false)
    private String name;

    @Column(name = "AADHAR_ID", unique = true, updatable = false)
    private String aadhar;

    @Column(name = "CREATED_TS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    // Default behavior is store enum as integer.
    // This can result in data inconsistency in situation where we change the order of enums.
    // Due to this, we should use EnumType.STRING.
    @Column(name = "EMPLOYEE_TYPE")
    @Enumerated(EnumType.STRING)
    private EmployeeType employeeType;

    // Tells JPA not to create a column for this field.
    // Better than using transient keyword.
    @Transient
    private String transientColumn;

    // By default, JPA will do an eager fetch by doing a JOIN operation.
    // LAZY fetch will make it delay the fetching of JOIN & only ask for it when required.
    @OneToOne(fetch = FetchType.LAZY)
    private AccessCard accessCard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public String getTransientColumn() {
        return transientColumn;
    }

    public void setTransientColumn(String transientColumn) {
        this.transientColumn = transientColumn;
    }

    public AccessCard getAccessCard() {
        return accessCard;
    }

    public void setAccessCard(AccessCard accessCard) {
        this.accessCard = accessCard;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", aadhar='" + aadhar + '\'' +
                ", createdAt=" + createdAt +
                ", employeeType=" + employeeType +
                ", accessCard=" + accessCard +
                '}';
    }
}
