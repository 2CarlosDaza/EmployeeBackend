package com.luce.employee.application.port.in;

import com.luce.employee.controller.model.Employee;
import lombok.Builder;
import lombok.Value;

public interface SaveEmployeeCommand {
    Employee execute(Data data);
    @Value
    @Builder
    class Data{
        Employee employee;
    }
    static SaveEmployeeCommand.Data fromModel(Employee employee){
        return SaveEmployeeCommand.Data.builder()
                .employee(employee)
                .build();
    }
}
