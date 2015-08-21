package com.sanjiv.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory buildSessionFactory(){
		
		return new Configuration().configure("hibernate.cfg.xml")
				   .buildSessionFactory();
	}

}
