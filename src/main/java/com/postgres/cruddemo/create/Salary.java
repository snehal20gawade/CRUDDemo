package com.postgres.cruddemo.create;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Salary {
    private static Map<Role, Integer> salarymap = new HashMap<Role, Integer>();
    private static int minSalary = 10000;

    public int calculateSalary(int numberOfYearExp, Role role) {
        salarymap.put(Role.MANAGER, 10);
        salarymap.put(Role.DEVELOPER, 5);
        salarymap.put(Role.ENGIENEER, 2);
        int factor = salarymap.get(role);
        int salary = numberOfYearExp * minSalary * factor;
        return salary;
    }
}
