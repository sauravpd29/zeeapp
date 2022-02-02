package com.zee.zee5_app.config;
//
//import javax.sql.DataSource;
//
////import org.apache.commons.dbcp2.BasicDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.Scope;
//import org.springframework.core.env.Environment;
//
//import com.zee.zee5_app.utils.PasswordUtils;
//
//@Configuration
////@ComponentScan("com.zee.zee5_app")
////@PropertySource("classpath:application.properties")
//public class Config {
//	
//	@Autowired//will bring already create object based on name / tyep
//	Environment environment;
////	
////	@Bean(name="ds")//for providing singleton object
//	//@Scope("prototype")//==>if you will call getBean method N no of times then you will get n OBJECTS
//	//if we wont specify name then it will  take method name as bean name
//	//to get multiple object we should use prototype scope 
//	@Scope("singleton")//gives single ton instance
////	public DataSource dataSource() {
////	//	BasicDataSource basicDataSource = new BasicDataSource();
////		
////		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
////		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
////		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
////		basicDataSource.setInitialSize(5);
////		try {
////			basicDataSource.getConnection().setAutoCommit(false);
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		//basicDataSource.setDefaultAutoCommit(false);
////		
////		return basicDataSource;
////	}
//@Bean//are we going to create object?yes
////this object can we initialize as per req?
////can we customise as and when req?in case of bean
//public PasswordUtils passwordUtils() {
//	return new PasswordUtils();
//}
//
//}
//



import javax.sql.DataSource;

//import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.zee.zee5_app.utils.PasswordUtils;

@Configuration
//@ComponentScan("com.zee.zee5_app")
//@PropertySource("classpath:application.properties")
public class Config {
	
	@Autowired//will bring already create object based on name / tyep
	Environment environment;
//	
//	@Bean(name="ds")//for providing singleton object
	//@Scope("prototype")//==>if you will call getBean method N no of times then you will get n OBJECTS
	//if we wont specify name then it will  take method name as bean name
	//to get multiple object we should use prototype scope 
	@Scope("singleton")//gives single ton instance
//	public DataSource dataSource() {
//	//	BasicDataSource basicDataSource = new BasicDataSource();
//		
//		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
//		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
//		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
//		basicDataSource.setInitialSize(5);
//		try {
//			basicDataSource.getConnection().setAutoCommit(false);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//basicDataSource.setDefaultAutoCommit(false);
//		
//		return basicDataSource;
//	}
@Bean//are we going to create object?yes
//this object can we initialize as per req?
//can we customise as and when req?in case of bean
public PasswordUtils passwordUtils() {
	return new PasswordUtils();
}

}
