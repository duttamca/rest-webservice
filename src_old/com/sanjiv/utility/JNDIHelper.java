package com.sanjiv.utility;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDIHelper {
	
	public static Context getInitialContext(){
		Context ctx = null;
		Properties prop = new Properties();
		prop.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		prop.put(Context.PROVIDER_URL,"t3://localhost:7002,localhost:7003");
		try {
			ctx = new InitialContext(prop);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ctx;
	}

}
