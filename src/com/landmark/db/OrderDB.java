package com.landmark.db;

import java.sql.*;
import java.util.*;

import com.landmark.bean.Order;
import com.landmark.bean.OrderItem;
import com.landmark.bean.User;
import com.landmark.db.OrderItemDB;


public class OrderDB {

    public static long insert(Order order) {
    	Connection connection = DbAdmin.getConnection();
        PreparedStatement ps;
        long orderID = 0;
        String query = "INSERT INTO ORDERED (UserID, Date, Tax, TotalCost, Paid) "
                + "VALUES (?, ?, ?, ?, 'y')";
        // insert the new row into the table
        try {
        	    ps = connection.prepareStatement(query);
        	    int uid=Integer.parseInt(order.getUser().getUserid());
                ps.setInt(1, uid);
                java.util.Date utilDate = order.getDate();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                ps.setDate(2, sqlDate);
                ps.setDouble(3, order.getTaxDoubleAmount());
                ps.setDouble(4, order.getDoubleOrderTotal());
                ps.executeUpdate();

                String identityQuery = "SELECT @@IDENTITY AS IDENTITY";
                Statement identityStatement = connection.createStatement();
                ResultSet identityResultSet = identityStatement.executeQuery(identityQuery);
                identityResultSet.next();
                orderID = identityResultSet.getLong("IDENTITY");
                identityResultSet.close();
                identityStatement.close();

                //Write line items to the LineItem table.
                List<OrderItem> orderItems = order.getOrderItems();
                for (OrderItem item : orderItems) {
                    OrderItemDB.insert(orderID, item);
                }
            } catch (SQLException e) {
                System.err.println(e);
            } 
        return orderID;
        }
    
    public static ArrayList<Order> getAllOrders(int userID) {
        Connection connection = DbAdmin.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * "
                + "FROM USER "
                + "INNER JOIN ORDERED "
                + "ON USER.UserID = ORDERED.UserID "
                + "WHERE USER.UserID = '" + userID + "'"
                + "ORDER BY ORDERED.Date";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Order> orders = new ArrayList<>();
            while (rs.next()) {
            	String uid=Integer.toString(userID);
                User user = UserDB.getUser(uid);

                //Get line items
                long orderID = rs.getInt("ORDERED.OrderNumber");
                List<OrderItem> orderItems = OrderItemDB.selectOrderItems(orderID);

            	Order order = new Order();
                order.setUser(user);
                order.setDate(rs.getDate("Date"));
                order.setOrderNumber(orderID);
                order.setOrderItems(orderItems);
                order.setTax(9.5);

                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } 
    }
    
    public static ArrayList<Order> selectAllOrders() {
        Connection connection = DbAdmin.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * "
                + "FROM USER "
                + "INNER JOIN ORDERED "
                + "ON USER.UserID = ORDERED.UserID "
                + "ORDER BY ORDERED.OrderNumber";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Order> orders = new ArrayList<>();
            while (rs.next()) {
            	
            	//Get line items
                long orderID = rs.getInt("ORDERED.OrderNumber");
                String uid=Integer.toString(rs.getInt("UserID"));
                User user = UserDB.getUser(uid);
                List<OrderItem> orderItems = OrderItemDB.selectOrderItems(orderID);

            	Order order = new Order();
                order.setUser(user);
                order.setDate(rs.getDate("Date"));
                order.setOrderNumber(orderID);
                order.setOrderItems(orderItems);
                order.setTax(9.5);

                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } 
    }
}