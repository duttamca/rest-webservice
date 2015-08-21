package com.sanjiv.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sanjiv.model.Users;

public class UsersDao implements UsersDaoInterface {
	
	SessionFactory sessionFactory;
	
	public UsersDao(){};
	
	public UsersDao(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
		
	}

	
	public List<Users> getUsers() {
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Users> usersList = session.createQuery("from Users").list();
		tx.commit();
		return usersList;
	}

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public Users getUserById(int userid) {
		Users user = null;
		
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		user = (Users) session.get(Users.class, userid);
		
		tx.commit();
		
		return user;
	}

	public void addUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();

	}

	@Override
	public void deleteUsers() {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("Delete from Users");
		int result = query.executeUpdate();
		tx.commit();

	}

	@Override
	public void deleteUserById(int userid) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("Delete from Users where userID= :ID");
		query.setParameter("ID", userid);
		int result = query.executeUpdate();
		tx.commit();

	}

	@Override
	public void updateUser(Users user) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		session.saveOrUpdate(user);
		tx.commit();
		
	}

}
