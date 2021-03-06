package com.landmark.db;


import java.sql.*;
import java.util.*;

import com.landmark.bean.User;

public class UserDB {

// This class handles the USER table.
    public void createUserTable() {

        Statement statement = DbAdmin.getNewStatement();

        try {
            statement.execute("CREATE TABLE users("
                    + "userID VARCHAR(50),firstName VARCHAR(50),"
                    + "lastName VARCHAR(50), emailAddr VARCHAR(50),"
                    + "address1 VARCHAR(50), address2 VARCHAR(50),"
                    + "city VARCHAR(50),state VARCHAR(50),zipcode VARCHAR(50),"
                    + "country VARCHAR(50), password VARCHAR(50),"
                    + "PRIMARY KEY (userID))");

            System.out.println("Created a new table: " + "USER");
        } catch (SQLException se) {
            if (se.getErrorCode() == 30000 && "X0Y32".equals(se.getSQLState())) {
                // we got the expected exception when the table is already there
            } else {
                // if the error code or SQLState is different, we have an unexpected exception
                System.out.println("ERROR: Could not create USER table: " + se);
            }
        }
    }

    public static User addUser(String firstName, String lastName, String email,
            String address1, String address2, String city, String state,
            String zipcode, String country, String password) {

        Connection connection = DbAdmin.getConnection();
        PreparedStatement insertRow;
        String userID = null;
        // insert the new row into the table
        try {
            insertRow = connection.prepareStatement("INSERT INTO USER (firstName, lastName, emailAddr, address1Field, address2Field, city, state, zipPostalCode, country, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            insertRow.setString(1, firstName);
            insertRow.setString(2, lastName);
            insertRow.setString(3, email);
            insertRow.setString(4, address1);
            insertRow.setString(5, address2);
            insertRow.setString(6, city);
            insertRow.setString(7, state);
            insertRow.setString(8, zipcode);
            insertRow.setString(9, country);
            insertRow.setString(10, password);
            insertRow.executeUpdate();
            
            String identityQuery = "SELECT @@IDENTITY AS IDENTITY";
            Statement identityStatement = connection.createStatement();
            ResultSet identityResultSet = identityStatement.executeQuery(identityQuery);
            identityResultSet.next();
            Long uid = identityResultSet.getLong("IDENTITY");
            System.out.println("djsfhbghdsbghj");
            System.out.println(uid);
            userID=uid.toString();
            identityResultSet.close();
            identityStatement.close();
            System.out.println("kjdsgkdjbgk");
            System.out.println(uid);

        } catch (SQLException se) {
            if (((se.getErrorCode() == 30000) && ("23505".equals(se.getSQLState())))) {
                System.out.println("ERROR: Could not insert record into USER; dup primary key: " + userID);
            } else {
                System.out.println("ERROR: Could not add row to USER table: " + userID + " " + se.getCause());
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERROR: Could not add row to USER table: " + userID);
            return null;
        }
        System.out.println("Added user to USER table: " + userID);

        // return the new User object
        return new User(userID, firstName, lastName, email, address1, address2, city, state, zipcode, country);
    }

    public static User getUser(String userID) {

        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;

        String firstName = "";
        String lastName = "";
        String email = "";
        String address1 = "";
        String address2 = "";
        String city = "";
        String state = "";
        String zipcode = "";
        String country = "";

        String query = "";
        try {
            // Find the speciic row in the table
            query = "SELECT userID, firstName, lastName, emailAddr, address1Field, address2Field, city, state, zipPostalCode, country FROM user WHERE userID ='" + userID + "'";

            resultSet = statement.executeQuery(query);
            if (!resultSet.next()) {
                System.out.println("WARNING: Could not find user in USER table: " + userID);
                return null;
            } else {
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
                email = resultSet.getString("emailAddr");
                address1 = resultSet.getString("address1Field");
                address2 = resultSet.getString("address2Field");
                city = resultSet.getString("city");
                state = resultSet.getString("state");
                zipcode = resultSet.getString("zipPostalCode");
                country = resultSet.getString("country");

                System.out.println("Found user in user table: " + userID);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not exicute SQL statement: " + query);
            System.out.println("SQL error: " + se);
            return null;
        }

        return new User(userID, firstName, lastName, email, address1, address2, city, state, zipcode, country);
    }

    public static User validateUser(String userID, String password) {

        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;

        String firstName = "";
        String lastName = "";
        String email = "";
        String address1 = "";
        String address2 = "";
        String city = "";
        String state = "";
        String zipcode = "";
        String country = "";

        String query = "";
        try {
            // Find the speciic row in the table
            query = "SELECT userID, firstName, lastName, emailAddr, address1Field, address2Field, city, state, zipPostalCode, country FROM user WHERE userID ='" + userID + "' and password='" + password + "'";

            resultSet = statement.executeQuery(query);
            if (!resultSet.next()) {
                System.out.println("WARNING: Could not find user in USER table: " + userID);
                return null;
            } else {
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
                email = resultSet.getString("emailAddr");
                address1 = resultSet.getString("address1Field");
                address2 = resultSet.getString("address2Field");
                city = resultSet.getString("city");
                state = resultSet.getString("state");
                zipcode = resultSet.getString("zipPostalCode");
                country = resultSet.getString("country");

                System.out.println("Found user in user table: " + userID);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not exicute SQL statement: " + query);
            System.out.println("SQL error: " + se);
            return null;
        }

        return new User(userID, firstName, lastName, email, address1, address2, city, state, zipcode, country);
    }
    
    public static ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<User>();

        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;

        String userID = "";
        String firstName = "";
        String lastName = "";
        String email = "";
        String address1 = "";
        String address2 = "";
        String city = "";
        String state = "";
        String zipcode = "";
        String country = "";
        try {
            // Find the speciic row in the table
            resultSet = statement.executeQuery(
                    "SELECT userID, firstName, lastName, emailAddr, address1Field, address2Field, city, state, zipPostalCode, country FROM LANDMARK.user ORDER BY userID");
            while (resultSet.next()) {
                userID = resultSet.getString("userID");
                firstName = resultSet.getString("firstName");
                lastName = resultSet.getString("lastName");
                email = resultSet.getString("emailAddr");
                address1 = resultSet.getString("address1Field");
                address2 = resultSet.getString("address2Field");
                city = resultSet.getString("city");
                state = resultSet.getString("state");
                zipcode = resultSet.getString("zipPostalCode");
                country = resultSet.getString("country");
                User user = new User(userID, firstName, lastName, email, address1, address2, city, state, zipcode, country);
                users.add(user);
                System.out.println("Found user in USER table: " + userID);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not exicute SQL statement in: " + "UserDB.getAllUsers()");
            System.out.println("ERROR: Could not exicute SQL statement: " + se);
            return null;
        }

        return users;
    }

}
