
package com.luce.employee.controller.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Employee {
	@Id
	private Integer id;
	private String firstName;
	private String secondName;
	private String lastName;
	private String lastName2;
	private String documentNumber;
}

