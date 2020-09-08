package com.revature.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Query;
import javax.transaction.Transaction;

import org.apache.logging.log4j.LogManager;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.ERSUser;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.util.ConnectionUtil;
import com.revature.util.HibernateUtil;

public class ReimbursementsDAOImp implements ReimbursementsDAO{
	private static final org.apache.logging.log4j.Logger reimbLog = LogManager.getLogger(ReimbursementsDAOImp.class);
	public Reimbursement getReimbursement(int id) {
		Session sess = HibernateUtil.getSession();
		try {
			return sess.get(Reimbursement.class, id);
		}catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Reimbursement> getReimbursementsByAuthor(ERSUser u) {
		System.out.println("In getReimbursementsByAuthor()");
		Session sess = HibernateUtil.getSession();
		Query query = sess.createQuery("FROM Reimbursement where ersAuthor=:author",Reimbursement.class);
		query.setParameter("author", u);
		reimbLog.info("got reimbursemenst for User u: " + u);
		return query.getResultList();
		
	}

	@Override
	public List<Reimbursement> getReimbursementsByStatus(ReimbursementStatus status) {
		Session sess = HibernateUtil.getSession();
		Query query = sess.createQuery("FROM Reimbursement where reimbursementStatus=:status", Reimbursement.class);
		query.setParameter("status", status);
		reimbLog.info("got reimbursemenst for Reimbursement Status: " + status);
		return query.getResultList();
	}

	@Override
	public List<Reimbursement> getReimbursementsByType(ReimbursementType type) {
		Session sess = HibernateUtil.getSession();
		Query query = sess.createQuery("FROM Reimbursement where reimbursementType=:type", Reimbursement.class);
		query.setParameter("type", type);
		return query.getResultList();
	}

	@Override
	public boolean addReimbursement(Reimbursement reimbursement) {
		Session sess = HibernateUtil.getSession();
		try {
		sess.save(reimbursement);
		return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateReimbursement(Reimbursement reimbursement) {
		Session sess = HibernateUtil.getSession();
		try {
			org.hibernate.Transaction tx = sess.beginTransaction();
			sess.merge(reimbursement);
			tx.commit();
			reimbLog.info("Updated reimbursement: " + reimbursement);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean removeReimbursement(int id) {
		Session sess = HibernateUtil.getSession();
		try {
		sess.createQuery("DELETE FROM Reimbursement where reimbursementId=" + id);
		reimbLog.info("removed reimbursement with description : " + id);
		return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean cleanTest(Reimbursement r) {
		Session sess = HibernateUtil.getSession();
		try {
		sess.delete(r);
		reimbLog.info("removed reimbursement with id : " + r.getReimbursementId());
		return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Reimbursement> getReimbursements() {
		Session sess = HibernateUtil.getSession();
		List<Reimbursement> reimbs = sess.createQuery("FROM Reimbursement" , Reimbursement.class).list();
		reimbLog.info("got all reimbursements");
		return reimbs;
	}
}
