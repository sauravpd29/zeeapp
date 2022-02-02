package com.zee.zee5_app.service;

import java.util.Optional;

import com.zee.zee5_app.dto.Login;
import com.zee.zee5_app.dto.ROLE;
import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidEmailException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.exception.InvalidPasswordException;

public interface LoginService {
	
	public String addCredentials(Login login);
	public String deleteCredentials(String username);
	public String changePassword(String username,String password);
	public String changeRole(String username, ROLE role);
	public Optional<Login> getUserById(String username) throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException;

}