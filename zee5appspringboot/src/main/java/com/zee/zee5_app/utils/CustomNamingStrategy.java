package com.zee.zee5_app.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomNamingStrategy extends PhysicalNamingStrategyStandardImpl {
private final static String POSTFIX= "_table";
//by default all tables should be 
@Override
	public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment context) {
		// TODO Auto-generated method stub
		if(identifier==null) {
			return null;
		}
		final String newName=identifier.getText()+POSTFIX;
		return identifier.toIdentifier(newName);
				//table name1.if @table annotation is available then it will use that name
				//if @rable aint available then it will take entity name, if entity not available take classname as entity name
	}
}
