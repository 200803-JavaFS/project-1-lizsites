package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.ReimbursementType;
import com.revature.util.HibernateUtil;

public class ReimbursementTypeDAOImp implements ReimbursementTypeDAO {

	@Override
	public List<ReimbursementType> getAllTypes() {
		Session sess = HibernateUtil.getSession();
		
		return sess.createQuery("FROM ReimbursementType" , ReimbursementType.class).list();
	}

	@Override
	public boolean addType(ReimbursementType type) {
		Session sess = HibernateUtil.getSession();
		try {
		sess.save(type);
		return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateType(ReimbursementType type) {
		Session sess = HibernateUtil.getSession();
		try {
		sess.merge(type);
		return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeType(int typeId) {
		Session sess = HibernateUtil.getSession();
		try {
		sess.createQuery("DELETE FROM ReimbursementType where typeId=" + typeId);
		return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
