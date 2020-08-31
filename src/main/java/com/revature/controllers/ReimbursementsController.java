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
		res.setContentType("text/html");
		req.getRequestDispatcher("reimbursements.html").forward(req, res);
		UserDAO userDAO = new UserDAOImp();
		ReimbursementsDAO reimbDAO = new ReimbursementsDAOImp();
		ERSUser u = userDAO.getUserByUsername(((LoginDTO)req.getAttribute("l")).username);
		List<Reimbursement> reimbs = reimbDAO.getReimbursementsByAuthor(u);
		
		if (reimbs!= null) {
		res.setStatus(200);
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(reimbs);
		res.getWriter().println(json);
		}
	}
	
	public void getReimbursement(HttpServletResponse res, int id) {
		
	}
}
