package com.Capgemini.employee_payroll.controller;

import com.Capgemini.employee_payroll.dto.EmployeeDto;
import com.Capgemini.employee_payroll.entity.Employee;
import com.Capgemini.employee_payroll.service.EmployeeServiceInterface;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

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
    public String addEmployee(@Valid @ModelAttribute  EmployeeDto employeeDto ) {//BindingResult e
        employeeService.saveEmp(employeeDto);
    //    if(e.hasErrors()){
     //       for(ObjectError error: e.getAllErrors()){
     //           log.error(error.getDefaultMessage());
     //       }
      //  }

        return "redirect:/employee";

        //return "added";
    }
    @PutMapping("/put/{id}")
    public Employee updateEmployee(@PathVariable Long id,@Valid @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    // Delete Employee
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }
}
