package com.postgres.cruddemo.create;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class SalaryTest {
    private Salary salary;

    @Before
    public void setUp() throws Exception {
        salary = new Salary();
    }

    @Test
    public void calculateSalary_forDeveloper_noOfExperience3() {
        assertEquals(150000, salary.calculateSalary(3 , Role.DEVELOPER));
    }

    @Test
    public void calculateSalary_forManager_noOfExperience3() {
        assertEquals(300000, salary.calculateSalary(3 , Role.MANAGER));
    }
    @Test
    public void calulateSalary_forEngineer_noOfExperience2(){
        assertEquals(40000,salary.calculateSalary(2,Role.ENGIENEER));
    }
    @Test
    public void calulateSalary_forDeveloper_noOfExperience2() {
        assertEquals(100000, salary.calculateSalary(2, Role.DEVELOPER));
    }
    @Test
    public void calulateSalary_forManager_noOfExperience5() {
        assertEquals(500000, salary.calculateSalary(5, Role.MANAGER));
    }
    @Test
    public void calulateSalary_forEngineer_noOfExperience4(){
        assertEquals(80000,salary.calculateSalary(4,Role.ENGIENEER));
    }

    }