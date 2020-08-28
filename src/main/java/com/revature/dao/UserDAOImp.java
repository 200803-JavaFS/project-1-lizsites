package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.revature.models.ERSUser;
import com.revature.util.ConnectionUtil;
import com.revature.util.HibernateUtil;

public class UserDAOImp implements UserDAO {

	private static final Logger userLogger = LogManager.getLogger(UserDAOImp.class);
	
	@Override
	public ERSUser getUserByUsername(String username) {
		ERSUser e = new ERSUser();
		
	
		return e;
	}

	@Override
	public ERSUser getUserById(int id) {
		
		return null;
	}

	@Override
	public List<ERSUser> getAllUsers() {
		Session sess = HibernateUtil.getSession();
		List<ERSUser> userList =sess.createQuery("FROM ERSUser", ERSUser.class).list();
		
		return userList;
		
	}

	@Override
	public ERSUser getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUser(ERSUser u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(ERSUser u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeUser(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
