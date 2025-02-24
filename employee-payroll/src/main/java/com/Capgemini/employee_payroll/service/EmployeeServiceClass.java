package com.Capgemini.employee_payroll.service;

import com.Capgemini.employee_payroll.dto.EmployeeDto;
import com.Capgemini.employee_payroll.entity.Employee;
import com.Capgemini.employee_payroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceClass implements EmployeeServiceInterface {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmp(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getName(), employeeDto.getSalary());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmpById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDto employeeDto) {
        return employeeRepository.findById(id).map(emp -> {
            emp.setName(employeeDto.getName());
            emp.setSalary(employeeDto.getSalary());
            return employeeRepository.save(emp);
        }).orElseThrow(() -> new RuntimeException("Employee not found by ID: " + id));
    }

    @Override
    public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
    }
}
