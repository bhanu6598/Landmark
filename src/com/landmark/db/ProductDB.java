package com.landmark.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.landmark.bean.Product;

public class ProductDB {

    public void createProductTable() {

        Statement statement = DbAdmin.getNewStatement();

        try {

            statement.execute("CREATE TABLE product("
                    + "productCode VARCHAR(10),productName VARCHAR(50),"
                    + "catalogCategory VARCHAR(50),"
                    + "price FLOAT(2),description VARCHAR(800),imageUrl VARCHAR(50),"
                    + "PRIMARY KEY (productCode))");
            System.out.println("Created a new table: " + "PRODUCT");
        } catch (SQLException se) {
            if (se.getErrorCode() == 30000 && "X0Y32".equals(se.getSQLState())) {
                // we got the expected exception when the table is already there
            } else {
                // if the error code or SQLState is different, we have an unexpected exception
                System.out.println("ERROR: Could not create PRODUCT table: " + se);
            }
        }
    }

    public Product addProduct(String productCode, String productName, String catalogCategory,
            float price, String description, String imageUrl) {

        Connection connection = DbAdmin.getConnection();
        PreparedStatement ps;
        // insert the new row into the table
        try {
            ps = connection.prepareStatement("INSERT INTO product VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, productCode);
            ps.setString(2, productName);
            ps.setString(3, catalogCategory);
            ps.setFloat(4, price);
            ps.setString(5, description);
            ps.setString(6, imageUrl);

            ps.executeUpdate();

        } catch (SQLException se) {
            if (((se.getErrorCode() == 30000) && ("23505".equals(se.getSQLState())))) {
                System.out.println("ERROR: Could not insert record into PRODUCT; dup primary key: " + productCode);
            } else {
                System.out.println("ERROR: Could not add row to PRODUCT table: " + productCode + " " + se.getCause());
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERROR: Could not add row to PRODUCT table: " + productCode);
            return null;
        }
        System.out.println("Added product to PRODUCT table: " + productCode);

        return new Product(productCode, productName, catalogCategory,
                price, description, imageUrl);
    }

    public Product addProduct(Product product) {

        Connection connection = DbAdmin.getConnection();
        PreparedStatement ps;
        // insert the new row into the table
        try {
            ps = connection.prepareStatement("INSERT INTO product VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, product.getProductcode());
            ps.setString(2, product.getProductname());
            ps.setString(3, product.getCategory());
            ps.setDouble(4, product.getPrice());
            ps.setString(5, product.getDescription());
            ps.setString(6, product.getImageurl());

            ps.executeUpdate();

        } catch (SQLException se) {
            if (((se.getErrorCode() == 30000) && ("23505".equals(se.getSQLState())))) {
                System.out.println("ERROR: Could not insert record into PRODUCT; dup primary key: " + product.getProductcode());
            } else {
                System.out.println("ERROR: Could not add row to PRODUCT table: " + product.getProductcode() + " " + se.getCause());
            }
            return null;
        } catch (Exception e) {
            System.out.println("ERROR: Could not add row to PRODUCT table: " + product.getProductcode());
            return null;
        }
        System.out.println("Added product to PRODUCT table: " + product.getProductcode());

        // return the  product object
        return product;
    }

    public static Product getProduct(String pcode) {

        Product product = new Product();
        product.setProductcode(pcode);

        String query = "SELECT productName, catalogCategory, price, description, url"
                + " from LANDMARK.PRODUCT where PRODUCT.productCode ='" + pcode + "'";
        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;

        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                product.setProductname(resultSet.getString("productName"));
                product.setCategory(resultSet.getString("catalogCategory"));
                product.setPrice(resultSet.getDouble("price"));
                product.setDescription(resultSet.getString("description"));
                product.setImageurl(resultSet.getString("url"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;

    }
    
    public static ArrayList<Product> getAllCategoryProducts(String pcategory) {
    	System.out.println(pcategory);
        ArrayList<Product> categoryproducts = new ArrayList<Product>();

        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;

        String productCode = "";
        String productName = "";
        String catalogCategory = "";
        float price = 0.0f;
        String description = "";
        String imageUrl = "";

        try {

            resultSet = statement.executeQuery(
                    "SELECT productCode, productName, catalogCategory, price, description, url from LANDMARK.PRODUCT where PRODUCT.catalogCategory ='" + pcategory + "'");
            while (resultSet.next()) {
                productCode = resultSet.getString("productCode");
                productName = resultSet.getString("productName");
                catalogCategory = resultSet.getString("catalogCategory");
                price = resultSet.getFloat("price");
                description = resultSet.getString("description");
                imageUrl = resultSet.getString("url");

                Product product = new Product(productCode, productName, catalogCategory, price, description, imageUrl);
                categoryproducts.add(product);
                System.out.println("Found product in PRODUCT table: " + productCode);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not exicute SQL statement in: " + "ProductDB.getAllCategoryProducts()");
            System.out.println("ERROR: Could not exicute SQL statement: " + se);
            return null;
        }

        return categoryproducts;
    }
    
    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<Product>();

        Statement statement = DbAdmin.getNewStatement();
        ResultSet resultSet = null;

        String productCode = "";
        String productName = "";
        String catalogCategory = "";
        float price = 0.0f;
        String description = "";
        String imageUrl = "";

        try {

            resultSet = statement.executeQuery(
                    "SELECT productCode, productName, catalogCategory, price, description, url FROM LANDMARK.product ORDER BY productCode");
            while (resultSet.next()) {
                productCode = resultSet.getString("productCode");
                productName = resultSet.getString("productName");
                catalogCategory = resultSet.getString("catalogCategory");
                price = resultSet.getFloat("price");
                description = resultSet.getString("description");
                imageUrl = resultSet.getString("url");

                Product product = new Product(productCode, productName, catalogCategory, price, description, imageUrl);
                products.add(product);
                System.out.println("Found product in PRODUCT table: " + productCode);
            }
        } catch (SQLException se) {
            System.out.println("ERROR: Could not exicute SQL statement in: " + "ProductDB.getAllProducts()");
            System.out.println("ERROR: Could not exicute SQL statement: " + se);
            return null;
        }

        return products;
    }
    
}
