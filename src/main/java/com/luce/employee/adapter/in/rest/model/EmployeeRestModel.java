package com.luce.employee.adapter.in.rest.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class EmployeeRestModel {
    private Integer id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String lastName2;
    private String documentNumber;
    private String email;
    private String phone;
}
