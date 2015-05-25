package com.landmark.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.landmark.db.ProductDB;
import com.landmark.bean.Product;

public class CatalogController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url="/catalog.jsp";
		String action=request.getParameter("action");
		String searchcategory=request.getParameter("Category");
		if(action == null)
			url="/catalog.jsp";
		else
		{
			if(action.equals("catalog"))
			{
				url="/catalog.jsp";
				ArrayList<Product> products = ProductDB.getAllProducts();            
	            request.setAttribute("products", products);
			}
			else if(!action.equals("catalog"))
			{
				Product product = ProductDB.getProduct(action);
				request.setAttribute("product", product);
				url="/item.jsp";
			}
		}
		if(searchcategory != null && !searchcategory.isEmpty())
		{
			url="/catalogcategory.jsp";
			ArrayList<Product> categoryproducts = ProductDB.getAllCategoryProducts(searchcategory);
            request.setAttribute("categoryproducts", categoryproducts);
            request.setAttribute("searchcategory", searchcategory);
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String action=request.getParameter("action");
		Product product = ProductDB.getProduct(action);
		request.setAttribute("product", product);
		String url="/item.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
}
