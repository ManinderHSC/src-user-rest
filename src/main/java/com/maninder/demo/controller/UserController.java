package com.maninder.demo.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maninder.demo.service.UserService;
import com.maninder.demo.transferobject.UserResponseTO;

@RestController
@RequestMapping("/v1/users")
@Validated
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping
	public UserResponseTO getUsers(
			@RequestParam (name = "lastName", required = false) String lastName,
			@RequestParam (name = "age", required = false) @Max(value = 150, message = "Age cannot exceed 150") @Min(1) Integer age,
            @RequestParam(name = "pageNo", defaultValue = "0", required = false) @Min(0) int pageNo,
            @RequestParam(name = "pageSize", defaultValue = "100", required = false) @Max(5000) @Min(25) int pageSize,
            @RequestParam(name = "sortBy", defaultValue = "name", required = false) String sortBy,
            @RequestParam (name = "sortDir", defaultValue = "asc", required = false) String sortDir
    ){
		
		long start = System.nanoTime();
		UserResponseTO response = userService.getUsers(lastName, age, pageNo,  pageSize,  sortBy,  sortDir);
	    long end = System.nanoTime();
	    long execution= end - start;
	    System.out.println("Execution time: " + execution/1000000 + " milliseconds");
		return response;
		
	}
	
	

}
