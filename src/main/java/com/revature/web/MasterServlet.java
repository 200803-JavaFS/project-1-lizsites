package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.LoginControllers;

public class MasterServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/json");
		res.setStatus(404);
		
		final String uri = req.getRequestURI().replace("/project1/", "");
		String[] layeredUri = uri.split("/");
		switch (layeredUri[0]) {
		case "login":
			if (req.getMethod().equals("POST")) {
				LoginControllers lc = new LoginControllers();
				lc.loginAttempt(req,res);
			}
			break;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
