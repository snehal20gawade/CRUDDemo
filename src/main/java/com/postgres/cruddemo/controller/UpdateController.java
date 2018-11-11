package com.postgres.cruddemo.controller;

import com.postgres.cruddemo.create.Employee;
import com.postgres.cruddemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/update")
public class UpdateController {
    @Autowired
    private EmployeeRepository repository;

    @PutMapping("/employee")
   public  void updateEmployee(@RequestBody Employee employee){
        Employee employee1 = repository.findById(employee.getId());
        employee1.setNumberOfYearExp(employee.getNumberOfYearExp());
        repository.save(employee1);
    }

}
