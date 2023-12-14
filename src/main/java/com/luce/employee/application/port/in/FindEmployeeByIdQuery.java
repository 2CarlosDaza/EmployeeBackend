package com.luce.employee.application.port.in;

import com.luce.employee.controller.model.Employee;
import lombok.Builder;
import lombok.Value;

public interface FindEmployeeByIdQuery {
    Employee execute(Data data);
    @Value
    @Builder
    class Data{
        Integer id;
    }
    static FindEmployeeByIdQuery.Data fromModel(Integer id){
        return FindEmployeeByIdQuery.Data.builder()
                .id(id)
                .build();
    }
}
