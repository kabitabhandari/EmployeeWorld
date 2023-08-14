package com.example.employeeworld.model;

import lombok.Data;

@Data
public class ResponseEmployee {
    private String employeeid;
    private String name;
    private Integer age;
    private String jobtitle;
    private double salary;
    private Phone phone;
}
