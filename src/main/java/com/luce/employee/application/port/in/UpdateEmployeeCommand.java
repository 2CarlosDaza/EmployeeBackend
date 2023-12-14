package com.luce.employee.application.port.in;

import com.luce.employee.controller.model.Employee;
import lombok.Builder;
import lombok.Value;

public interface UpdateEmployeeCommand {
    Employee execute(Data data);
    @Value
    @Builder
    class Data{
        Employee employee;
    }
    static UpdateEmployeeCommand.Data fromModel(Employee employee) {
        return UpdateEmployeeCommand.Data.builder()
                .employee(employee)
                .build();
        }
    }
