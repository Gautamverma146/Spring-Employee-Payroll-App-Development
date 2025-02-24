package com.Capgemini.employee_payroll.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.PutMapping;
@Entity
public class Employee {
    @Id
    private Long id;
    private String name;
    private double salary;
     public Employee(){}
    public Employee(Long id, String name, double salary){
         this.id=id;
         this.name=name;
         this.salary=salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
