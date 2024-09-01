package com.lp;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MainLogin extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter pr = res.getWriter();
		
		String user = req.getParameter("UserName");
		String password = req.getParameter("Password");
		
		if(password.equals("admin")) {
			pr.println("Login Success " + user);
		}else {
			pr.println("Invalid credentials");
			req.getRequestDispatcher("login.html").include(req, res);
		}
	}
	
	
	
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException {
		
//		PrintWriter pr = res.getWriter();
	req.getRequestDispatcher("login.html").include(req, res);
//		pr.println("Invalid credentials");
		
	}
}
