package com.luce.employee.application.usecase;

import com.luce.employee.application.port.in.SaveEmployeeCommand;
import com.luce.employee.controller.model.Employee;
import com.luce.employee.domain.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SaveEmployeeUseCase implements SaveEmployeeCommand {
    @Autowired
    EmployeeService service;
    @Override
    public Employee execute(Data data) {
        return service.create(data.getEmployee());
    }
}
