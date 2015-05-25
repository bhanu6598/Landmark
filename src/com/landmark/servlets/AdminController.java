package com.landmark.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;

import com.landmark.bean.Order;
import com.landmark.db.OrderDB;


public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="/admin.jsp";
		String action= request.getParameter("action");
		HttpSession session = request.getSession();
		ArrayList<Order> allOrders;
		if (action.equals("viewOrders")) 
		{
			url="/orderlist.jsp";
			allOrders = OrderDB.selectAllOrders();
			session.setAttribute("theOrders", allOrders);
		}		
	getServletContext().getRequestDispatcher(url).forward(request, response);
	
	     	}
	}
