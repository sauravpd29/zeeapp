package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Register {
	
	private String id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	
	public Register() {
		//Explicit Default Constructor
		//any kind of customization during the initialization of object
		//then its better to use EDC or PC or both
	}
	
	
	//setter : is used to set the value for a particular field.
	//getter : to get/return the value of a specific field.
	

}
