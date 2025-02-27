package com.Capgemini.employee_payroll.service;

import com.Capgemini.employee_payroll.dto.EmployeeDto;
import com.Capgemini.employee_payroll.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {
    Employee saveEmp(EmployeeDto employeeDTO);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmpById(Long id);
    Employee updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);

}
