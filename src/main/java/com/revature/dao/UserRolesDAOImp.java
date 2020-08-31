package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.ERSUser;
import com.revature.models.UserRoles;
import com.revature.util.HibernateUtil;

public class UserRolesDAOImp implements UserRolesDAO {

	@Override
	public List<UserRoles> getAllUserRoles() {
		Session sess = HibernateUtil.getSession();
		return sess.createQuery("FROM UserRoles" , UserRoles.class).list();
	}

	@Override
	public List<ERSUser> getUsersByRole(UserRoles role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addRole(UserRoles roles) {
		Session sess = HibernateUtil.getSession();
		try {
		sess.save(roles);
		return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateRole(UserRoles roles) {
		Session sess = HibernateUtil.getSession();
		try {
		sess.merge(roles);
		return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeRole(int roleId) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
