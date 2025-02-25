package com.Capgemini.employee_payroll.controller;

import com.Capgemini.employee_payroll.dto.EmployeeDto;
import com.Capgemini.employee_payroll.entity.Employee;
import com.Capgemini.employee_payroll.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeThymeleafController {

    @Autowired
    private EmployeeServiceInterface employeeService;

    // Show Employee Page
    @GetMapping
    public String showEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        model.addAttribute("employeeDto", new EmployeeDto());
        return "employee";  // Renders employee.html
    }

    // Add Employee
    @PostMapping
    public String addEmployee(@ModelAttribute EmployeeDto employeeDto) {
        employeeService.saveEmp(employeeDto);
        return "redirect:/employee";
    }

    // Delete Employee
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }
}
