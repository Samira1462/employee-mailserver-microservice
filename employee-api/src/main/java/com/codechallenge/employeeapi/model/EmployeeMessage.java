package com.codechallenge.employeeapi.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonSerialize
@AllArgsConstructor
public class EmployeeMessage implements Serializable {

    private String action;
    private Employee employee;

/*    private EmployeeMessage() {
    }*/

    public EmployeeMessage(Employee employee, String action) {
        this.employee = employee;
        this.action = action;
    }
}
