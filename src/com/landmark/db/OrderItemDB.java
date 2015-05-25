package com.landmark.db;

import java.sql.*;
import java.util.*;

import com.landmark.bean.OrderItem;
import com.landmark.bean.Product;

public class OrderItemDB {

	    //This method adds one lineItem to the LineItems table.
	    public static long insert(long orderID, OrderItem orderItem) {
	    	Connection connection = DbAdmin.getConnection();
	        PreparedStatement ps;

	        String query = "INSERT INTO ORDERITEM(OrderNumber, ProductCode, Quantity) "
	                + "VALUES (?, ?, ?)";
	        try {
	            ps = connection.prepareStatement(query);
	            ps.setLong(1, orderID);
	            ps.setString(2, orderItem.getProduct().getProductcode());
	            ps.setInt(3, orderItem.getQuantity());
	            return ps.executeUpdate();
	        } catch (SQLException e) {
	            System.err.println(e);
	            return 0;
	        } 
	    }

	    //This method returns null if a record isn't found.
	    public static List<OrderItem> selectOrderItems(long orderID) {
	        Connection connection = DbAdmin.getConnection();
	        PreparedStatement ps = null;
	        ResultSet rs = null;

	        String query = "SELECT * FROM ORDERITEM "
	                + "WHERE OrderNumber = '" + orderID + "'";
	        try {
	            ps = connection.prepareStatement(query);
	            rs = ps.executeQuery();
	            List<OrderItem> orderItems = new ArrayList<>();
	            while (rs.next()) {
	                OrderItem orderItem = new OrderItem();
	                String productCode = rs.getString("productCode");
	                Product product = ProductDB.getProduct(productCode);
	                orderItem.setProduct(product);
	                orderItem.setQuantity(rs.getInt("Quantity"));
	                orderItems.add(orderItem);
	            }
	            return orderItems;
	        } catch (SQLException e) {
	            System.err.println(e);
	            return null;
	        } 
	    }
	}
