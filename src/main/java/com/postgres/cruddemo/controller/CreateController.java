package com.postgres.cruddemo.controller;

import com.postgres.cruddemo.configuration.HelloWorld;
import com.postgres.cruddemo.create.Employee;
import com.postgres.cruddemo.create.Role;
import com.postgres.cruddemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class CreateController {

    @Autowired
    private EmployeeRepository employees;

    HelloWorld helloWorld;

    public CreateController(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    @PostMapping("/create")
    public void create(@RequestBody List<Employee> employeeList) {
        //List<Employee> employeeList = getEmployees();

        for (Employee employee : employeeList)
            employees.save(employee);
    }


    @GetMapping("/message/{message}")
    public String getMessage(@PathVariable String message) {
        helloWorld.setMsg(message);
        return helloWorld.getMsg();
    }

    private List<Employee> getEmployees() {
        List<Employee> empList = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.setId(2);
        employee1.setNumberOfYearExp(3);
        employee1.setName("Snehal");
        employee1.setRole(Role.MANAGER);
        Employee employee2 = new Employee();
        employee2.setId(3);
        employee2.setName("Anaya");
        employee2.setNumberOfYearExp(4);
        employee2.setRole(Role.DEVELOPER);
        Employee employee3 = new Employee();
        employee3.setId(4);
        employee3.setName("Isha");
        employee3.setNumberOfYearExp(2);
        employee3.setRole(Role.ENGIENEER);
        empList.add(employee1);
        empList.add(employee2);
        empList.add(employee3);
        return empList;
    }


}