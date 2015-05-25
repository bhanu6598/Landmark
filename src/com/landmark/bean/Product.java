package com.landmark.bean;

import java.io.Serializable;
import java.text.NumberFormat;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String productcode;
	private String productname;
	private String category;
	private String description;
	private double price;
	private String imageurl;
	
	public Product()
	{
		productcode="";
		productname="";
		category="";
		description="";
		price=0;
		imageurl="";
	}
	
	public Product(String productcode, String productname, String category, double price, String description, String imageurl)
	{
		this.productcode=productcode;
		this.productname=productname;
		this.category=category;
		this.price=price;
		this.description=description;
		this.imageurl = imageurl;
	}

	public String getProductcode() {
		return productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	
	public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
		
}
