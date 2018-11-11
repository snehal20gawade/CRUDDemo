package com.postgres.cruddemo.create;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "employee")
public class Employee
{
    @Id
    private int id;
    private String name;
    private double salary;
    private int numberOfYearExp;
    private Role role;

}
