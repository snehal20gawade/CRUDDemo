package com.postgres.cruddemo.service;

import com.postgres.cruddemo.create.Employee;
import com.postgres.cruddemo.create.Salary;
import com.postgres.cruddemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private Salary salary ;

    public EmployeeService(EmployeeRepository employeeRepository,Salary salary) {
        this.employeeRepository = employeeRepository;
        this.salary = salary;
    }

    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        for (Employee employee : employeeList) {
            int sal = salary.calculateSalary(employee.getNumberOfYearExp(),employee.getRole());
            employee.setSalary(sal);
        }

        return employeeList;
    }
}

