package com.lp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig  
public class UploadServlet extends HttpServlet {

	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException {
		
		res.setContentType("text/html");
		PrintWriter pr = res.getWriter();
	//	MultipartRequest mr = new MultipartRequest(req,"C:/");
		

		for (Part part : req.getParts()) {
			String location = "C:/Desktop/eclipse";
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString(); // Get the file name
            
            File file = new File(location);
            if(file.exists()) {
            	System.out.println("file exists");
            }else {
            	 file.mkdirs();
            }
            String paths = location+"/"+fileName;
            part.write(paths);
            System.out.println(paths);
            
        }
		
	pr.println("Upload Success");
	req.getRequestDispatcher("upload.html").forward(req, res);
	}
	
	
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException {
		
//		PrintWriter pr = res.getWriter();
	req.getRequestDispatcher("upload.html").include(req, res);
//		pr.println("Invalid credentials");
		
	}
	
}
