package com.sanjiv.utility;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionHelper {
	
	private static final String ORACLE_DATASOURCE_NAME="jdbc/OracleXADataSource";
	private static final String MYSQL_DATASOURCE_NAME="jdbc/OracleXADataSource";
	static Connection con = null;
	
	public static Connection getConnection(){
		DataSource dataSource=null;
		Context ctx = JNDIHelper.getInitialContext();
		try {
			dataSource = (DataSource) ctx.lookup(ORACLE_DATASOURCE_NAME);
			con = dataSource.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}

}
