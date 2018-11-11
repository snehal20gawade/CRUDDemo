package com.postgres.cruddemo.create;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Comparator;

@Data
@Entity
public class Address {
    @Id
    private int id;
    private String city;
    private String country;
    private String postcode;

    }
