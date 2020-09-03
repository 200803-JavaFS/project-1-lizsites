package com.revature.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementsDAO;
import com.revature.dao.ReimbursementsDAOImp;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.models.ERSUser;
import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;

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
}
