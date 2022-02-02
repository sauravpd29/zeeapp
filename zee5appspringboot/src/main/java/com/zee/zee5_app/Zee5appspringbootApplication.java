package com.zee.zee5_app;

import javax.sql.DataSource;
import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5_app.dto.Register;
import com.zee.zee5_app.repository.UserRepository;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		//SpringApplication.run(Zee5appspringbootApplication.class, args);
		ConfigurableApplicationContext applicationContext=SpringApplication.run(Zee5appspringbootApplication.class,args);
//		DataSource dataSource =applicationContext.getBean(DataSource.class);
//		System.out.println(dataSource!=null);
		
		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
		Register register=null;
				try {
					register = new Register("reg000777", "Uzumaki", "Naruto", "rasengan@gmail.com", "hina123", null);
//					
					register.setContactNumber(new BigDecimal("9438267499"));
					Register result = userRepository.save(register);
					System.out.println(result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		applicationContext.close();
		//applicationContext.close();
	}

}




