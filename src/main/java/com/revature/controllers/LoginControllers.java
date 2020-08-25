package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ERSUser;
import com.revature.models.LoginDTO;
import com.revature.services.LoginService;

public class LoginControllers {
	private static ObjectMapper om = new ObjectMapper();
	private static LoginService ls = new LoginService();
	public void loginAttempt(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		LoginDTO l = new LoginDTO();
		l.username = username;
		l.password = password;
		if (ls.login(l)) {
			HttpSession sesh = req.getSession();
			sesh.setAttribute("user", l);
			sesh.setAttribute("loggedin" , true);
			res.setStatus(200);
			res.getWriter().println("Login successful!!!");
		} else {
			/*
			 * Forbidden
			 * */
			res.setStatus(403);
			res.getWriter().println("Bad Login Credentials");
		}
	}
}
