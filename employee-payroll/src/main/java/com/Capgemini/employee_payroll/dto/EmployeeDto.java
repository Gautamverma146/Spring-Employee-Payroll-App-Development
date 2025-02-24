package com.Capgemini.employee_payroll.dto;

public class EmployeeDto {
    private String name;
    private double salary;
    public EmployeeDto(){}
    public EmployeeDto(String name, double salary){
        this.name=name;
        this.salary=salary;
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
