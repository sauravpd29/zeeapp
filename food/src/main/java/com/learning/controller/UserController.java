package com.learning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.Register;
import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.service.UserService;

@RestController //combination of @ResponseBody and @Controller
//REST API: Response wherever we have to share the response that method must be marked with @ResponseBody
//1000 methods ---> @ResponseBody 1000 times so o avoid this we use @RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//add user info into register table
	//info will be shared by the client in terms of JSON object
	//now we need to read that JSON object
	//this JSON object is available in requestbody
	//we need to read that requestbody content
	//transform JSON obj to java object ---> this will be done by @RequestBody
	
	//we need to inform when this method should be used so we should specify the endpoint
	@PostMapping("/addUser")
	//used ? so we can return any type
	public ResponseEntity<?> addUser(@Valid @RequestBody Register register) throws AlreadyExistsException {
		
		//1. It should store the received info in database
		Register result = userService.addUser(register);
		return ResponseEntity.status(201).body(result);
		
		}
	//retrieve single record
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") String id) throws IdNotFoundException{
		Register result = userService.getUserById(id);
		return ResponseEntity.ok(result);	
		
	}
	
	//retrieve all records
	@GetMapping("/all")
	public ResponseEntity<?> getAllUserDetails(){
		Optional<List<Register>> optional = userService.getAllUserDetails();
		if(optional.isEmpty()) {
			Map<String, String> map = new HashMap<>();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		}
		return ResponseEntity.ok(optional.get());	
		
	}
	
	@DeleteMapping("id/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable("id") String id) throws IdNotFoundException{
		String result = userService.deleteUserById(id);
		return ResponseEntity.ok(result);	
		
	}
	
	
	@PutMapping("/{email}")
	public ResponseEntity<?> updateUser(@PathVariable("email") String email, @Valid @RequestBody Register register) throws IdNotFoundException{
		String result = userService.updateUser(email,register);
		return ResponseEntity.ok(result);	
		
	}
	


}
