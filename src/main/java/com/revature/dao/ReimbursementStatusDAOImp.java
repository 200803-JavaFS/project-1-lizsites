package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.ReimbursementStatus;
import com.revature.util.HibernateUtil;

public class ReimbursementStatusDAOImp implements ReimbursementStatusDAO {

	@Override
	public List<ReimbursementStatus> getAllStatuses() {
		Session sess = HibernateUtil.getSession();
		return sess.createQuery("FROM ReimbursementStatus", ReimbursementStatus.class).list();
	}

	@Override
	public boolean addStatus(ReimbursementStatus status) {
		Session sess = HibernateUtil.getSession();
		try {
		sess.save(status);
		return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateStatus(ReimbursementStatus status) {
		Session sess = HibernateUtil.getSession();
		try {
		sess.merge(status);
		return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeStatus(int statusId) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
