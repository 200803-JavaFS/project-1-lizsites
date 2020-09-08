package com.revature.dao;


import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.ERSUser;
import com.revature.util.HibernateUtil;

public class UserDAOImp implements UserDAO {

	private static final Logger userLogger = LogManager.getLogger(UserDAOImp.class);
	
	@Override
	public ERSUser getUserByUsername(String username) {
	
		Session sess = HibernateUtil.getSession();
		Query query  =sess.createQuery("FROM ERSUser where username =:name ", ERSUser.class);
		query.setParameter("name", username);
		List<ERSUser> u = query.getResultList();
		userLogger.info("getting User with name " + username);
		if (u.size()==1) {
			return u.get(0);
		} else {
			return null;
		}
	}

	@Override
	public ERSUser getUserById(int id) {
		
		return null;
	}

	@Override
	public List<ERSUser> getAllUsers() {
		Session sess = HibernateUtil.getSession();
		List<ERSUser> userList =sess.createQuery("FROM ERSUser", ERSUser.class).list();
		userLogger.info("getting all users");
		return userList;
		
	}

	@Override
	public ERSUser getUserByEmail(String email) {
		Session sess = HibernateUtil.getSession();
		Query query = sess.createQuery("FROM ERSUser where email=:email", ERSUser.class);
		query.setParameter(1, email);
		userLogger.info("getting user with email " + email);
		List<ERSUser> u = query.getResultList();
		if (u.size() == 1) {
			return u.get(0);
		} else if (u.size() >1){
			userLogger.warn("Error in getUserByEmail() multiple users have been pulled");
			return null;
		} else {
			userLogger.info("no user by " + email +" found by getUserByEmail");
			return null;
		}
	}

	@Override
	public boolean addUser(ERSUser u) {
		Session sess = HibernateUtil.getSession();
		try {
		sess.save(u);
		userLogger.info("getting user " + u.getUsername() + " has been added");
		return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(ERSUser u) {
		Session sess = HibernateUtil.getSession();
		try {
		sess.merge(u);
		userLogger.info("User " + u.getUsername() + " has been updated!");
		return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeUser(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
