package com.landmark.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.landmark.bean.Cart;
import com.landmark.bean.Order;
import com.landmark.bean.OrderItem;
import com.landmark.bean.Product;
import com.landmark.bean.User;
import com.landmark.db.ProductDB;
import com.landmark.db.UserDB;
import com.landmark.db.OrderDB;

public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url="/cart.jsp";
		String action= request.getParameter("action");
		String[] products=request.getParameterValues("productList");
		ArrayList<Product> pl1 = ProductDB.getAllProducts();
		HttpSession session = request.getSession();
        Cart theShoppingCart = (Cart) session.getAttribute("theShoppingCart");
        if (theShoppingCart == null) {
        	theShoppingCart = new Cart();
        }
		if (action==null && products==null) {
			url = "/cart.jsp";  // default action
        }
		if(action!=null && !action.isEmpty())
		{
			if (action.equals("updateCart")) {
				int quantity;
	        	for(int i=0;i<products.length;i++)
	            {
	        		String quantityString = request.getParameter(products[i]);
	        		try {
	                    quantity = Integer.parseInt(quantityString);
	                    if (quantity < 0) {
	                        quantity = 1;
	                    }
	                } catch (NumberFormatException nfe) {
	                    quantity = 1;
	                }
	        			String[] code = new String[8];
	        			String productcode = null;
	        			String productname = null;
	        			String category = null;
	        			String description = null;
	        			double price = 0;
	        			String imageurl = null;
	        			int size=code.length;
	        			int alindex=0;
	        			for (int i1=0; i1<size; i1++)
	        		    {
	        				code[i1]=pl1.get(i1).getProductcode();
	        		      if(code[i1].equals(products[i]))
	        		      {  
	        		    	alindex=i1;
	        		    	productcode=pl1.get(alindex).getProductcode();
	        				productname=pl1.get(alindex).getProductname();
	        				category=pl1.get(alindex).getCategory();
	        				description=pl1.get(alindex).getDescription();
	        				price=pl1.get(alindex).getPrice();
	        				imageurl=pl1.get(alindex).getImageurl();
	        		      }
	        		    }
	        		Product product=new Product();
	        		product.setProductcode(productcode);
					product.setProductname(productname);
					product.setCategory(category);
					product.setDescription(description);
					product.setPrice(price);
					product.setImageurl(imageurl);
					
	        		OrderItem orderitem = new OrderItem();
	        		orderitem.setProduct(product);
	                orderitem.setQuantity(quantity);
	                if (quantity > 0) {
	                	theShoppingCart.addItem(orderitem);
	                } else if (quantity == 0) {
	                	theShoppingCart.removeItem(orderitem);
	                }
	            }
	            
	            session.setAttribute("theShoppingCart", theShoppingCart);
	            url = "/cart.jsp";
	        }
			else if (action.equals("checkout")) {
	            url = "/order.jsp";
	            User existinguser = (User) session.getAttribute("theUser");
	            if(existinguser==null)
	            {
	            	ArrayList<User> users = UserDB.getAllUsers();
		            String userid=users.get(0).getUserid();
		            String firstname=users.get(0).getFirstname();
		        	String lastname=users.get(0).getLastname();
		        	String email=users.get(0).getEmail();
		        	String address1=users.get(0).getAddress1();
		        	String address2=users.get(0).getAddress2();
		        	String city=users.get(0).getCity();
		        	String state=users.get(0).getState();
		        	String zip=users.get(0).getZip();
		        	String country=users.get(0).getCountry();
		        	User user=new User();
		        	user.setUserid(userid);
		        	user.setFirstname(firstname);
		        	user.setLastname(lastname);
		        	user.setEmail(email);
		        	user.setAddress1(address1);
		        	user.setAddress2(address2);
		        	user.setCity(city);
		        	user.setState(state);
		        	user.setZip(zip);
		        	user.setCountry(country);
		        	
		        	session.setAttribute("theUser", user);
		        	session.setAttribute("firstname", firstname);
		        	
		        	Order order=new Order();
		            Date date = new Date();
		        	order.setUser(user);
		        	order.setDate(date);
		        	order.setOrderItems(theShoppingCart.getItems());
		        	order.setPaid(false);
		        	order.setTax(9.5);
		        	
		            session.setAttribute("currentOrder", order);
	            }
	            
	            else
	            {
	            	String firstname=existinguser.getFirstname();
	            	session.setAttribute("firstname", firstname);
		        	Order order=new Order();
		            Date date = new Date();
		        	order.setUser(existinguser);
		        	order.setDate(date);
		        	order.setOrderItems(theShoppingCart.getItems());
		        	order.setPaid(false);
		        	order.setTax(9.5);
		        	
		            session.setAttribute("currentOrder", order);
	            }
	            
	        }
			
			else if (action.equals("confirmOrder")) 
			{
				url="/invoice.jsp";
				Order order = (Order) session.getAttribute("currentOrder");
		        User user = order.getUser();
		        order.setUser(user);
		        long orderID = OrderDB.insert(order);
		        session.setAttribute("theShoppingCart", null);
		        session.setAttribute("orderID", orderID);
		      }
			
			else if (action.equals("viewOrders")) 
			{
		        User user = (User) session.getAttribute("theUser");
		        if(user==null)
		        {
		        	url="/catalog.jsp";
		        	ArrayList<Product> catalogproducts = ProductDB.getAllProducts();            
		            request.setAttribute("products", catalogproducts);
		        }
		        else
		        {
		        	url="/orderlist.jsp";
		        	int userid=Integer.parseInt(user.getUserid());
		        	ArrayList<Order> theOrders = OrderDB.getAllOrders(userid);
		        	
		        	session.setAttribute("theOrders", theOrders);
		        }
		      }
			}
        
        	getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
