package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementStatusDAO;
import com.revature.dao.ReimbursementStatusDAOImp;
import com.revature.dao.ReimbursementTypeDAO;
import com.revature.dao.ReimbursementTypeDAOImp;
import com.revature.dao.ReimbursementsDAO;
import com.revature.dao.ReimbursementsDAOImp;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.models.ERSUser;
import com.revature.models.LoginDTO;
import com.revature.models.ReimbDTO;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;

public class ReimbursementsController {
	public void seeReimbursements(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("in seeReimbursements");
		UserDAO userDAO = new UserDAOImp();
		ReimbursementsDAO reimbDAO = new ReimbursementsDAOImp();
		HttpSession sess = req.getSession(false);
		System.out.println((LoginDTO)sess.getAttribute("user"));
		ERSUser u = userDAO.getUserByUsername(((LoginDTO)sess.getAttribute("user")).username);
		List<Reimbursement> reimbs = reimbDAO.getReimbursementsByAuthor(u);
			res.setContentType("application/json");
			ObjectMapper om = new ObjectMapper();
			String reimbursements = om.writeValueAsString(reimbs);
	
			res.getWriter().print(reimbursements);
			System.out.println(res.getStatus());
		
	}
	
	public void getReimbursement(HttpServletResponse res, int id) {
		
	}

	public void addReimbursement(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ReimbursementTypeDAO typeDAO = new ReimbursementTypeDAOImp();
		ReimbursementStatusDAO statusDAO = new ReimbursementStatusDAOImp();
		HttpSession sess = req.getSession(false);
		UserDAO userDAO = new UserDAOImp();
		ERSUser u = userDAO.getUserByUsername(((LoginDTO)sess.getAttribute("user")).username);
		BufferedReader reader = req.getReader();
		StringBuilder sb = new StringBuilder();
		String line = reader.readLine();
		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);
		ObjectMapper om = new ObjectMapper();
		ReimbDTO reimb = om.readValue(body, ReimbDTO.class);
		Reimbursement r = new Reimbursement();
		r.setAmount(reimb.amount);
		r.setDescription(reimb.description);
		r.setTimeSubmitted();
		r.setTimeResolved(null);
		r.setErsAuthor(u);
		r.setErsResolver(null);
		r.setReimbursementType(typeDAO.getTypeByTypeName(reimb.type));
		r.setReimbursementStatus(statusDAO.getStatusByStatusName("PENDING"));
		ReimbursementService rs = new ReimbursementService();
		rs.addReimbursement(r);
		res.setStatus(201);
		res.getWriter().print("Reimbursement added!!");
	}
	
	public void updateReimbursement(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		UserDAO userDAO = new UserDAOImp();
		ReimbursementsDAO reimbDAO = new ReimbursementsDAOImp();
		HttpSession sess = req.getSession(false);
		
		ReimbursementService rs = new ReimbursementService();
	
	}
}
