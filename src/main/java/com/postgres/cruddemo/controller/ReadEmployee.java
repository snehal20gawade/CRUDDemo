package com.postgres.cruddemo.controller;


import com.postgres.cruddemo.create.Employee;
import com.postgres.cruddemo.create.NameComparator;
import com.postgres.cruddemo.repository.EmployeeRepository;
import com.postgres.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class ReadEmployee {

    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    public ReadEmployee(EmployeeService employees, EmployeeRepository employeeRepository) {
        this.employeeService = employees;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/id/{empId}")
    public Employee read(@PathVariable int empId) {
        return employeeRepository.findById(empId);

    }

    @GetMapping("/name/{name}")
    public List<Employee> getEmployee(@PathVariable String name) {
        List<Employee> employeeList = employeeService.getAllEmployee();
        return findByName(name, employeeList);
    }

    private List<Employee> findByName(String name, List<Employee> employees) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employeeList.add(employee);
            }
        }
        return employeeList;
    }


    @GetMapping
    public List<Employee> getAllEmployee() {
        List unsortedList = employeeService.getAllEmployee();
        return sortByName(unsortedList);

    }

    public List<Employee> sortByName(List<Employee> employee) {
        employee.sort(new NameComparator());
        return employee;
    }

    @DeleteMapping("/id/{empId}")
    public void deleteEmployee(@PathVariable int empId) {
        employeeRepository.deleteById(empId);
    }
}