package com.luce.employee.adapter.in.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@GetMapping("/say/{message}")
	public String talkBack(@PathVariable String message) {	
		return message;
	}
	
	@GetMapping("/hello")
	public String sayHelloWorld() {	
		return "Hello World";
	}
	

}
