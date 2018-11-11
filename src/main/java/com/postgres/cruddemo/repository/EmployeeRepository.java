package com.postgres.cruddemo.repository;

import com.postgres.cruddemo.create.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAll();
    Employee findById(int id);
    void deleteById(int id);
}
