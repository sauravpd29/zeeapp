package com.zee.zee5app;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.UserService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Register register = new Register();
		//Register : Class name
		//register : reference to obj
		//new : keyword to create obj
		//Register() : Default constructor
		register.setFirstname("Saurav");
		register.setLastname("Prasad");
		register.setEmail("spd@gmail.com");
		register.setPassword("123");
		
		System.out.println(register);
		//printing reference calls toString() method
		
		System.out.println(register.toString());

		Login login = new Login();
		
		login.setUserName("spd");
		login.setPassword("123");
		System.out.println(login);
		
		UserService service = UserService.getInstance();
		
		for(int i=1;i<=11;i++)
		{
			Register register2 = new Register();
			register2.setId("ab00"+i);
			register2.setFirstname("abhi"+i);
			register2.setLastname("chivate"+i);
			register2.setPassword("abhi");
			String result=service.addUser(register2);
			
			System.out.println(result);
			
		}
		
		Register register2=service.getUserById("ab00");
		System.out.println(register2!=null);
		
		for(Register register3 : service.getUsers())
		{
			if(register3!=null)
			System.out.println(register3);
		}
		
		String id="ab000";
		Register register4=new Register();
		register4.setFirstname("Arpan");
		register4.setLastname("Ishan");
		register4.setEmail("arpit@gmail.com");
		register4.setPassword("Word");
		register4.setId("v");
		Register register5=service.updateUser(id, register4);
		System.out.println(register5);
		service.deleteUser("ab006");
	}

}
