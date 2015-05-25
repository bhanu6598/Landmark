package com.landmark.bean;

import java.io.Serializable;
import java.util.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
    private List<OrderItem> orderitems;
    private Date date;
    private Long orderNumber;
    private boolean paid;
    private double tax;

    public Order() {
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setOrderItems(List<OrderItem> orderitems) {
        this.orderitems = orderitems;
    }

    public List<OrderItem> getOrderItems() {
        return orderitems;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getOrderDateDefaultFormat() {
        DateFormat dateFormat = DateFormat.getDateInstance();
        String orderDateFormatted = dateFormat.format(date);
        return orderDateFormatted;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }
    
    public boolean isPaid() {
		return paid;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public double getOrderTotal() {
        double totalCost = 0.0;
        for (OrderItem item : orderitems) {
        	totalCost += item.getTotal();
        }
        return totalCost;
    }
	
	public double getTaxDoubleAmount() {
        double totalTax = 0.0;
        double totalCost = 0.0;
        for (OrderItem item : orderitems) {
        	totalCost += item.getTotal();
        }
        totalTax=(totalCost*tax)/100;
        return totalTax;
    }
	
	public String getTaxAmount() {
        double totalTax = 0.0;
        double totalCost = 0.0;
        for (OrderItem item : orderitems) {
        	totalCost += item.getTotal();
        }
        totalTax=(totalCost*tax)/100;
        DecimalFormat f = new DecimalFormat("##.00");
        return f.format(totalTax);
    }

    public String getOrderTotalCurrencyFormat() {
        double total = this.getOrderTotal();
        double totalTax = this.getTaxDoubleAmount();
        double grandtotal = total+totalTax;
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String formattedTotal = currency.format(grandtotal);
        return formattedTotal;
    }
    
    public Double getDoubleOrderTotal() {
        double total = this.getOrderTotal();
        double totalTax = this.getTaxDoubleAmount();
        double grandtotal = total+totalTax;
        return grandtotal;
    }
}
