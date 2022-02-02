package com.zee.zee5_app.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5_app.dto.Login;
import com.zee.zee5_app.dto.ROLE;
import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidEmailException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.exception.InvalidPasswordException;
import com.zee.zee5_app.repository.LoginRepository;
import com.zee.zee5_app.service.LoginService;
import com.zee.zee5_app.service.UserService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginRepository loginRepository;
	public LoginServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String addCredentials(Login login) {
		Login register2=loginRepository.save(login);
		if(register2!=null) {
			return "Success";
		}
		else {
			return "failure";
		}
		// TODO Auto-generated method stub
		//return null;
	}
	@Override
	public String deleteCredentials(String username) {
		// TODO Auto-generated method stub
		//return null;
	try {
		Optional<Login> optional =this.getUserById(username);
	} catch (IdNotFoundException | InvalidIdLengthException | InvalidNameException | InvalidEmailException
			| InvalidPasswordException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	loginRepository.deleteById(username);
	return null;
	}
	@Override
	public String changePassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String changeRole(String username, ROLE role) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<Login> getUserById(String username) throws IdNotFoundException, InvalidIdLengthException,
			InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		//return null;
		return loginRepository.findById(username);
	}
	
	
	}

	
