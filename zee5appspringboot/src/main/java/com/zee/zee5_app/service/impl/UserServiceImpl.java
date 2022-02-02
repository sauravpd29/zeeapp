package com.zee.zee5_app.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.exception.IdNotFoundException;
import com.zee.zee5_app.exception.InvalidEmailException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.exception.InvalidPasswordException;
import com.zee.zee5_app.repository.UserRepository;
import com.zee.zee5_app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	public UserServiceImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		Register register2=userRepository.save(register);
		if(register2!=null) {
			return "Success";
		}
		else {
			return "failure";
		}
	}

	@Override
	public String updateUser(String id, Register register) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException, InvalidIdLengthException,
			InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public Register[] getAllUsers()
			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		List<Register> list = userRepository.findAll();
		Register[] array = new Register[list.size()];
		return list.toArray(array);
	}

	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Register> optional =this.getUserById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("Record not found");
			}
			else {
				userRepository.deleteById(id);
				return "Success";
			}
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidNameException | InvalidEmailException
				| InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userRepository.deleteById(id);
		return null;
	}

	@Override
	public Optional<List<Register>> getAllUserDetails()
			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(userRepository.findAll());
	}

	
}
