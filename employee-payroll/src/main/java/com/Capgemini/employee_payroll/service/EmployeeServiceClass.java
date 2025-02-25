package com.Capgemini.employee_payroll.service;

import com.Capgemini.employee_payroll.dto.EmployeeDto;
import com.Capgemini.employee_payroll.entity.Employee;
import com.Capgemini.employee_payroll.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class EmployeeServiceClass implements EmployeeServiceInterface {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmp(EmployeeDto employeeDto) {
        log.info("Saving employee: " + employeeDto);
        Employee employee = new Employee(employeeDto.getName(), employeeDto.getSalary());
        log.info("Employee saved successfully");
        return employeeRepository.save(employee);

    }

    @Override

    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        List<Employee> emp = employeeRepository.findAll();
        log.info("All employees fetched successfully");
        return emp;

    }

    @Override
    public Optional<Employee> getEmpById(Long id) {
        log.info("Finding employee by id");
        Optional<Employee> emp = employeeRepository.findById(id);
        if(emp.isPresent()){
            log.info("Employee is present",emp.get());
        }
        else {
            log.warn("Employee is not present by id: ", id);
        }
        return emp;
        //return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDto employeeDto) {
        log.info("Updating employee by id",id);
        return employeeRepository.findById(id).map(emp -> {
            emp.setName(employeeDto.getName());
            emp.setSalary(employeeDto.getSalary());
            Employee updatedEmp = employeeRepository.save(emp);
            log.info("Employee updated successfully");
            return updatedEmp;
        }).orElseThrow(() -> {
            log.error("Employee not found with ID: {}", id);
            return new RuntimeException("Employee not found by ID: " + id);
        });
    }

    @Override
    public void deleteEmployee(Long id) {
        log.info("Delete employee by id: ",id);

    employeeRepository.deleteById(id);
    log.info(" employee deleted  successfully");
    }
}
