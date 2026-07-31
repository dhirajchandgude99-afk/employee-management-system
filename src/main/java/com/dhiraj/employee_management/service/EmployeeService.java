package com.dhiraj.employee_management.service;

import com.dhiraj.employee_management.entity.Employee;
import com.dhiraj.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    public Employee updateEmployee(Long id, Employee employee) {

    Employee existingEmployee = employeeRepository.findById(id).orElse(null);

    if (existingEmployee != null) {

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());

        return employeeRepository.save(existingEmployee);
    }

    return null;
}

public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
}
public Page<Employee> getEmployeesWithPagination(int page, int size) {

    Pageable pageable = PageRequest.of(page, size);

    return employeeRepository.findAll(pageable);
}

public List<Employee> getEmployeesWithSorting(String field) {

    return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, field));
}
}

