package com.revature.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.LoginControllers;
import com.revature.controllers.ReimbursementsController;

public class MasterServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setStatus(404);
		
		final String uri = req.getRequestURI().replace("/project1/", "");
		String[] layeredUri = uri.split("/");
		System.out.println(Arrays.toString(layeredUri));
		
		
		if (layeredUri.length==0) {
			req.getRequestDispatcher("index.html").forward(req,res);
		}
		try {
		switch (layeredUri[0]) {
		case "reimbursement":
			if (req.getSession(false) != null && (boolean) req.getAttribute("loggedIn")) {
				if (layeredUri.length == 2) {
					ReimbursementsController rc = new ReimbursementsController();
					int id = Integer.parseInt(layeredUri[1]);
					rc.getReimbursement(res, id);
				} 
			}
			break;
			
//		case "login" :
//			LoginControllers lc = new LoginControllers();
//			lc.loginAttempt(req,res);
//			break;
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
