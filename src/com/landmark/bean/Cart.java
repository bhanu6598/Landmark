package com.landmark.bean;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<OrderItem> items;

    public Cart() {
        items = new ArrayList<OrderItem>();
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(OrderItem item) {
        String code = item.getProduct().getProductcode();
        int quantity = item.getQuantity();
        for (OrderItem cartItem : items) {
            if (cartItem.getProduct().getProductcode().equals(code)) {
                cartItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }
    
    public void removeItem(OrderItem item) {
        String code = item.getProduct().getProductcode();
        for (int i = 0; i < items.size(); i++) {
        	OrderItem lineItem = items.get(i);
            if (lineItem.getProduct().getProductcode().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }
}