package com.luce.employee.application.port.in;

import com.luce.employee.controller.model.Employee;
import lombok.Builder;
import lombok.Value;

public interface DeleteEmployeeCommand {

    Employee execute(DeleteEmployeeCommand.Data data);
    @Value
    @Builder
    class Data{
        Integer id;
    }
    static DeleteEmployeeCommand.Data fromModel(Integer id){
        return Data.builder()
                .id(id)
                .build();
    }
}
