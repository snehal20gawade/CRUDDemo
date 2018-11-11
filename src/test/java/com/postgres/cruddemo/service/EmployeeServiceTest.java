package com.postgres.cruddemo.service;

import com.postgres.cruddemo.create.Employee;
import com.postgres.cruddemo.create.Role;
import com.postgres.cruddemo.create.Salary;
import com.postgres.cruddemo.repository.EmployeeRepository;
import javafx.beans.binding.When;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private Salary salary;
    private EmployeeService employeeService;

    @Before
    public void setUp() throws Exception {
        employeeService = new EmployeeService(employeeRepository, salary);

    }

    @Test
    public void getAllEmployee() {
        when(employeeRepository.findAll()).thenReturn(mockEmployee());
        when(salary.calculateSalary(5, Role.MANAGER)).thenReturn(100);
        assertThat(employeeService.getAllEmployee(), hasItem(expectedEmployee()));
    }

    @Test
    public void getAllEmployee_size() {
        when(employeeRepository.findAll()).thenReturn(mockEmployee());
        assertThat(employeeService.getAllEmployee(), hasSize(3));
    }
    @Test
    public void getAllEmployee_contains() {
        when(employeeRepository.findAll()).thenReturn(mockEmployee());
        when(salary.calculateSalary(5, Role.MANAGER)).thenReturn(100);
        when(salary.calculateSalary(3, Role.MANAGER)).thenReturn(300);
        when(salary.calculateSalary(2, Role.DEVELOPER)).thenReturn(200);
        assertThat(employeeService.getAllEmployee(),containsInAnyOrder(mockEmployee()));
    }


    public List<Employee> mockEmployee() {

        List<Employee> employeeList = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Devidas");
        employee1.setNumberOfYearExp(5);
        employee1.setRole(Role.MANAGER);
        employee1.setSalary(100);
        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("Snehal");
        employee2.setNumberOfYearExp(3);
        employee2.setRole(Role.MANAGER);
        employee2.setSalary(200);
        Employee employee3 = new Employee();
        employee3.setId(3);
        employee3.setName("Anaya");
        employee3.setNumberOfYearExp(2);
        employee3.setRole(Role.DEVELOPER);
        employee3.setSalary(300);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        return employeeList;
    }

    public Employee expectedEmployee() {
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Devidas");
        employee1.setNumberOfYearExp(5);
        employee1.setRole(Role.MANAGER);
        employee1.setSalary(100);
        return employee1;
    }
}