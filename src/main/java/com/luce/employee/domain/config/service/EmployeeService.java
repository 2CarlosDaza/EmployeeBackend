package com.luce.employee.domain.config.service;

import com.luce.employee.adapter.out.jpa.EmployeeRepository;
import com.luce.employee.controller.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public List<Employee> findAllEmployees() {
        return repository.findAll();
    }

    public Employee findById(Integer employeeId) {
        return repository.findById(employeeId).orElse(null);
    }

    public Employee update(Employee dto) {
        if(dto.getId()!=null){
            return repository.save(dto);
        }
        throw new RuntimeException("The object to update doesn't have an ID");
    }

    public Employee create(Employee dto) {
        if(dto.getId()==null){
            return repository.save(dto);
        }
        throw new RuntimeException("The object to can't have an ID");
    }

    public String delete(Integer employeeId) {
        repository.deleteById(employeeId);
        return "Delete successful";
    }
}
