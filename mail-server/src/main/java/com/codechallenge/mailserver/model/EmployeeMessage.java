package com.codechallenge.mailserver.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class EmployeeMessage implements Serializable {

    private String action;
    private Employee employee;

    public EmployeeMessage() {
    }

    public EmployeeMessage(String action, Employee employee) {
        this.action = action;
        this.employee = employee;
    }
}
