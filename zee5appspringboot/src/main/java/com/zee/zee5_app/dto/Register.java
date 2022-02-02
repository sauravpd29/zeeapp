package com.zee.zee5_app.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.zee.zee5_app.exception.InvalidEmailException;
import com.zee.zee5_app.exception.InvalidIdLengthException;
import com.zee.zee5_app.exception.InvalidNameException;
import com.zee.zee5_app.exception.InvalidPasswordException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
//ORM Mapping purpose
@Entity//entity class is used for ORM
//JPA takes care of table creation.Do we have an option to customize table name?
@Table(name="register")	
public class Register implements Comparable<Register> {
	
//	public Register(String id, String firstName, String lastName, String email, String password, BigDecimal contactNumber)
//			throws InvalidIdLengthException, InvalidNameException, InvalidEmailException, InvalidPasswordException {
//		super();
//		this.setId(id);
//		this.setFirstName(firstName);
//		this.setLastName(lastName);
//		this.setEmail(email);
//		this.setPassword(password);
//		this.contactNumber = contactNumber;
//	}
@Id//it will consider this as PK
@Column(name="regId")


private String id;

@Size(max=50)
@NotBlank
private String firstName;

@Size(max=50)
@NotBlank
private String lastName;

@Size(max=50)
@Email
private String email;

@Size(max=100)
@NotBlank
private String password;


@NotNull
private BigDecimal contactNumber;

public void setId(String id) throws InvalidIdLengthException {
	if(id.length()<6)
		throw new InvalidIdLengthException("id length is less than 6");
	this.id = id;
}

public void setFirstName(String firstName) throws InvalidNameException {
	if(firstName==null || firstName=="" || firstName.length()<2)
		throw new InvalidNameException("firstName is not valid");
	this.firstName = firstName;
}

public void setLastName(String lastName) throws InvalidNameException {
	if(lastName==null || lastName=="" || lastName.length()<2)
		throw new InvalidNameException("lastName is not valid");
	this.lastName = lastName;
}

public void setEmail(String email) throws InvalidEmailException {
	if(email==null || email=="" || email.length()<2 || !email.contains("@"))
		throw new InvalidEmailException("email is not valid");
	this.email = email;
}

public void setPassword(String password) throws InvalidPasswordException {
	if(password==null || password=="" || password.length()<2 || !password.matches("[A-Z a-z 0-9]+"))
		throw new InvalidPasswordException("password is not valid");
	this.password = password;
}

@Override
public int compareTo(Register o) {
	// TODO Auto-generated method stub
	return o.id.compareTo(this.getId());
}

}
