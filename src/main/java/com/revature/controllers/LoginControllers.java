package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.models.ERSUser;
import com.revature.models.LoginDTO;
import com.revature.models.UserRoles;
import com.revature.services.Proj1LoginService;

public class LoginControllers {
	private static ObjectMapper om = new ObjectMapper();
	private static Proj1LoginService ls = new Proj1LoginService();
	public void loginAttempt(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		BufferedReader reader = req.getReader();

		StringBuilder sb = new StringBuilder();

		String line = reader.readLine();

		while (line != null) {
			sb.append(line);
			line = reader.readLine();
		}

		String body = new String(sb);
		System.out.println("login controllers loginDTO :" + body);
		LoginDTO l = om.readValue(body, LoginDTO.class);

		if (ls.login(l)) {
			UserDAO userDAO = new UserDAOImp();
			ERSUser u = userDAO.getUserByUsername(l.username);
			HttpSession sesh = req.getSession();
			UserRoles role = u.getUserrole();
			sesh.setAttribute("user", u);
			sesh.setAttribute("loggedin" , true);
			ObjectMapper om = new ObjectMapper();
			String roleBody = om.writeValueAsString(role);
			res.getWriter().println(roleBody);
			res.setStatus(200);
			
			
		} else {
			/*
			 * Forbidden
			 * */
			res.setStatus(403);
			res.getWriter().println("Bad Login Credentials");
		}
	}
}
