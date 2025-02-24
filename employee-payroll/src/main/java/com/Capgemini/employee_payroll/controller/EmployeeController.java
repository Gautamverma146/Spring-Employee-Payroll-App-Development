package com.Capgemini.employee_payroll.controller;

import com.Capgemini.employee_payroll.dto.EmployeeDto;
import com.Capgemini.employee_payroll.entity.Employee;
import com.Capgemini.employee_payroll.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceInterface employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody EmployeeDto employeeDto){
       return employeeService.saveEmp(employeeDto);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmpById(@PathVariable Long id){
        return employeeService.getEmpById(id);
    }

    @PutMapping("/put/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(id, employeeDto);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
         employeeService.deleteEmployee(id);
         return "Employee deleted successfully";
    }
}
