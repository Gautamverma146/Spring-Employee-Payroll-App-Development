package com.Capgemini.employee_payroll.repository;

import com.Capgemini.employee_payroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
