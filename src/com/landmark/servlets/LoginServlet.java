package com.landmark.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.landmark.db.UserDB;
import com.landmark.bean.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String n=request.getParameter("userId");    
        String p=request.getParameter("userpass");
        HttpSession session = request.getSession();
        String url="/index.jsp";
        User user=UserDB.validateUser(n,p);
        if(user==null)
        {
        	url="/invaliduser.jsp";
        }
        else
        {
        	session.setAttribute("theUser", user);
        	session.setAttribute("currentOrder", null);
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
