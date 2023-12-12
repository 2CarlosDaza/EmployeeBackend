package com.luce.employee.controller.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {
	private String State;
	private String Message;
}
