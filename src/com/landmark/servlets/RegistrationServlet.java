package com.landmark.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.landmark.db.UserDB;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        String fname=request.getParameter("fname");  
        String lname=request.getParameter("lname");    
        String email=request.getParameter("email");
        String addr1=request.getParameter("addr1");  
        String addr2=request.getParameter("addr2");    
        String city=request.getParameter("city");
        String state=request.getParameter("state");
        String zip=request.getParameter("zip");
        String country=request.getParameter("country");
        String pwd=request.getParameter("password");

        HttpSession session = request.getSession();
        String url="/registrationsuccess.jsp";
    	
    	String firstname=UserDB.addUser(fname,lname,email,addr1,addr2,city,state,zip,country,pwd).getFirstname();
    	String uid=UserDB.addUser(fname,lname,email,addr1,addr2,city,state,zip,country,pwd).getUserid();
    	session.setAttribute("uid", uid);
    	session.setAttribute("firstname", firstname);
    
    	getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
