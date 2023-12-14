package com.luce.employee.application.port.in;

import com.luce.employee.controller.model.Employee;
import lombok.Builder;
import lombok.Value;

import java.util.List;

public interface FindAllEmployeeQuery {
    List<Employee> execute(Data data);
    @Value
    @Builder
    class Data{

    }
    static FindAllEmployeeQuery.Data fromModel() {
        return FindAllEmployeeQuery.Data.builder()
                .build();
    }

}
