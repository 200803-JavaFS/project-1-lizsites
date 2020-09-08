package com.revature.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.controllers.LoginControllers;
import com.revature.controllers.ReimbursementsController;

public class MasterServlet extends HttpServlet{
	private static ReimbursementsController rc = new ReimbursementsController();
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setStatus(404);
		
		
		final String uri = req.getRequestURI().replace("/project1/", "");
		String[] layeredUri = uri.split("/");
		System.out.println(Arrays.toString(layeredUri));
		
		
		if (layeredUri.length==0) {
			res.setContentType("text/html");
			req.getRequestDispatcher("index.html").forward(req,res);
		}
		
		try {
		switch (layeredUri[0]) {
		case "reimbursements":
			System.out.println("I am in reimbursements case");
			if (req.getSession(false) != null && (boolean) req.getSession().getAttribute("loggedin")) {
				if (req.getMethod().equals("POST")) {
					if (layeredUri.length==2) {
						rc.updateReimbursement(req, res);
					} else {
					rc.addReimbursement(req,res);
					}
				} else if (req.getMethod().equals("GET")) {
					if (layeredUri.length == 2) {
						rc.seePendingReimbursements(req,res);
					} else {
					rc.seeReimbursements(req, res);
					}
				} else if (req.getMethod().equals("PUT")) {
					rc.updateReimbursement(req, res);
				} 
			}
			break;
			
		case "login" :
			LoginControllers lc = new LoginControllers();
			lc.loginAttempt(req,res);
			break;
			
		case "logout" :
			LoginControllers lc2 = new LoginControllers();
			lc2.logoutAttemp(req, res);
			break;
		}
		
		
		
		} catch (NumberFormatException e) {
			e.printStackTrace();
			res.getWriter().print("Reimbursement Id provided is not an integer");
			res.setStatus(400);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
