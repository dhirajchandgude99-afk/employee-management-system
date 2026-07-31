package com.dhiraj.employee_management.repository;

import com.dhiraj.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.department = :department")
List<Employee> findByDepartment(@Param("department") String department);

@Query("SELECT e FROM Employee e WHERE e.salary > :salary")
List<Employee> findBySalaryGreaterThan(@Param("salary") Double salary);

@Query(value = "SELECT * FROM employees WHERE department = ?", nativeQuery = true)
List<Employee> findByDepartmentNative(String department);

@Query(value = "SELECT * FROM employees WHERE salary > ?", nativeQuery = true)
List<Employee> findBySalaryNative(Double salary);
}

