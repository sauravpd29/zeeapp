//package com.zee.zee5_app;
//
//import javax.sql.DataSource;
//import java.math.BigDecimal;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//
//import com.zee.zee5_app.dto.Register;
//import com.zee.zee5_app.repository.UserRepository;
//
//@SpringBootApplication
//public class Zee5appspringbootApplicationTests {
//
//	public static void main(String[] args) {
//		//SpringApplication.run(Zee5appspringbootApplication.class, args);
//		ConfigurableApplicationContext applicationContext=SpringApplication.run(Zee5appspringbootApplication.class,args);
//		//DataSource dataSource =applicationContext.getBean(DataSource.class);
//		//System.out.println(dataSource!=null);
//		
//		UserRepository userRepository = applicationContext.getBean(UserRepository.class);
//		Register register=null;
//				try {
//					register = new Register("reg000555", "spider", "super", "spidersup@gmail.com", "spid123", null);
//					register.setContactNumber(new BigDecimal("9321654870"));
//					String result = userRepository.addUser(register);
//					System.out.println(result);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		applicationContext.close();
//		//applicationContext.close();
//	}
//
//}
