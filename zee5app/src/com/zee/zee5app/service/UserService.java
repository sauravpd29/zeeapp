package com.zee.zee5app.service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.UserRepository;

public class UserService {

	private UserRepository repository =  UserRepository.getInstance();
	
	private UserService() {
		// TODO Auto-generated constructor stub
	}
	//if we want to create that single object then we have to create it
	//inside the same class
	//and we have to share ref with others
	//to do the same we have to declare a method
	
	static UserService service = null;
	//this would be static
	//only one copy
	
	public static UserService getInstance() {
		//static makes it object independent for execution
		
		//static method can access only static ref
		if(service == null)
			service = new UserService();
		return service;
	}
	
	
	public String addUser(Register register)
	{
		return this.repository.addUser(register);
	}
	public Register getUserById(String id)
	{
		return this.repository.getUserById(id);
	}
	public Register[] getUsers() 
	{
		return this.repository.getUsers();
	}
	public Register updateUser(String id, Register register) {
		return repository.updateUser(id, register);
	}
	public void deleteUser(String id) {
		repository.deleteUser(id);
	}
}
