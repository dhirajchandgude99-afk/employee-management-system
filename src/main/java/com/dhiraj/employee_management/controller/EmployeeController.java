package com.dhiraj.employee_management.controller;

import com.dhiraj.employee_management.entity.Employee;
import com.dhiraj.employee_management.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {

    return employeeService.saveEmployee(employee);
}
@GetMapping
public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
}
@GetMapping("/{id}")
public Employee getEmployeeById(@PathVariable Long id) {
    return employeeService.getEmployeeById(id);
}
@PutMapping("/{id}")
public Employee updateEmployee(
        @PathVariable Long id,
        @Valid @RequestBody Employee employee) {

    return employeeService.updateEmployee(id, employee);
}

@DeleteMapping("/{id}")
public String deleteEmployee(@PathVariable Long id) {

    employeeService.deleteEmployee(id);

    return "Employee deleted successfully.";
}
@GetMapping("/pagination/{page}/{size}")
public Page<Employee> getEmployeesWithPagination(
        @PathVariable int page,
        @PathVariable int size) {

    return employeeService.getEmployeesWithPagination(page, size);
}

@GetMapping("/sorting/{field}")
public List<Employee> getEmployeesWithSorting(
        @PathVariable String field) {

    return employeeService.getEmployeesWithSorting(field);
}
@GetMapping("/department/{department}")
public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
    return employeeService.getEmployeesByDepartment(department);
}

@GetMapping("/salary/{salary}")
public List<Employee> getEmployeesBySalaryGreaterThan(@PathVariable Double salary) {
    return employeeService.getEmployeesBySalaryGreaterThan(salary);
}

@GetMapping("/native/department/{department}")
public List<Employee> getEmployeesByDepartmentNative(@PathVariable String department) {
    return employeeService.getEmployeesByDepartmentNative(department);
}

@GetMapping("/native/salary/{salary}")
public List<Employee> getEmployeesBySalaryNative(@PathVariable Double salary) {
    return employeeService.getEmployeesBySalaryNative(salary);
}
}
