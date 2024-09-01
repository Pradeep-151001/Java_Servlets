package com.lp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException {
		
		res.setContentType("text/html");
		PrintWriter pr = res.getWriter();
		req.getRequestDispatcher("index.html").include(req,res);
		Cookie cookie = new Cookie("test","value");
		cookie.setMaxAge(0);
		res.addCookie(cookie);
		pr.println("Logout success");
	}
	
}
