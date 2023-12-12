package com.luce.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


//@EnableEurekaClient
//@EnableJpaRepositories
@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class })
@EntityScan({ "com.luce.employee.controller.model" })
public class EmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

}
