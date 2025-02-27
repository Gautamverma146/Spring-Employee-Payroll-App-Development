package com.Capgemini.employee_payroll.dto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Size;
import lombok.Data;
//import lombok
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class EmployeeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @NotNull
   @Size(min = 2, message = "Name must have at least 2 characters")
    private String name;
    private double salary;

    public EmployeeDto(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
