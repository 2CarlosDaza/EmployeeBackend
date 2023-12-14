package com.luce.employee.adapter.in.rest;

import java.util.List;

import com.luce.employee.application.port.in.FindAllEmployeeQuery;
import com.luce.employee.application.port.in.FindEmployeeByIdQuery;
import com.luce.employee.application.port.in.SaveEmployeeCommand;
import com.luce.employee.application.port.in.UpdateEmployeeCommand;
import com.luce.employee.controller.model.ApiResponse;
import com.luce.employee.controller.model.Employee;
import com.luce.employee.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("luce/api/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	@Autowired
	FindAllEmployeeQuery findAllEmployeeQuery;
	@Autowired
	FindEmployeeByIdQuery findEmployeeByIdQuery;
	@Autowired
	SaveEmployeeCommand saveEmployeeCommand;
	@Autowired
	UpdateEmployeeCommand updateEmployeeCommand;
	
	@GetMapping()
	public List<Employee> findAll() {
		return findAllEmployeeQuery.execute(FindAllEmployeeQuery.fromModel());
	}
	
	@GetMapping("/{employeeId}")
	public Employee findById(@PathVariable Integer employeeId) {
		return findEmployeeByIdQuery.execute(FindEmployeeByIdQuery.fromModel(employeeId));
	}
	
	@PutMapping()
	public ApiResponse update(@RequestBody Employee dto) {
		Employee responseDto =updateEmployeeCommand.execute(UpdateEmployeeCommand.fromModel(dto));
		ApiResponse apiResponse;
		if(responseDto!=null) {
			apiResponse=ApiResponse.builder()
					.Message("Actualización exitosa")
					.State("OK")
					.build();
		}else {
			apiResponse=ApiResponse.builder()
					.Message("Error al actualizar")
					.State("ERROR")
					.build();
		}
		return apiResponse;
		
	}
	@PostMapping()
	public ApiResponse create(@RequestBody Employee dto) {
		Employee responseDto =saveEmployeeCommand.execute(SaveEmployeeCommand.fromModel(dto));
		ApiResponse apiResponse;
		if(responseDto!=null) {
			apiResponse=ApiResponse.builder()
					.Message("Guardado exitoso")
					.State("OK")
					.build();
		}else {
			apiResponse=ApiResponse.builder()
					.Message("Error al Guardar")
					.State("ERROR")
					.build();
		}
		return apiResponse;
	}
	@DeleteMapping("/{employeeId}")
	public ApiResponse deActivateEmployee(@PathVariable Integer employeeId) {
		String message=service.delete(employeeId);
		ApiResponse apiResponse=ApiResponse.builder()
				.Message(message)
				.State("OK")
				.build();	
		return apiResponse;
	}
	
}
