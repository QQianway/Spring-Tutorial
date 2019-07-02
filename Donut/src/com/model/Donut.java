package com.model;
public class Donut {
    private String ID;  //unique id for each type of donut
    private String name;    //unique name for each type of donut
    private double price;   //price of each donut
    private int store;   //default store for each donut is 20
    private int order;
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
	}
	@Override
	public String toString() {
		return "Donut [ID=" + ID + ", Name=" + name + ", price=" + price + ", store=" + store + ", order=" + order
				+ "]";
	}  
}
