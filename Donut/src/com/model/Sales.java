package com.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sales {
	private String id;    //unique id for every sales
	private Date date ;   //date of sales
	private List<Donut> salesItem=new ArrayList<>();    //contain donut sales in 1 submission 
	private double totalAmount; //the total amount of single sales
    DecimalFormat df= new DecimalFormat("#0.00");   //set decimal format to 2 decimal places
	private static int salesCount = 0;  //calculated number of sales
	private int itemCount;  //calculate number of sales donut i
	private boolean valid;
	
	public Sales()  //default constructor
	{
		id = String.valueOf(10000+salesCount);  //declare unique id of sales
		date = new Date();  //set date for sales
		salesItem = new ArrayList<>();  //list of sales donut
		itemCount = 0;  //number of item within sales list
        salesCount+=1;
        valid=true;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void addItem(Donut donut)
	{
		salesItem.add(donut);   //add donut selected into list
        totalAmount+=(donut.getPrice()*donut.getOrder());  //get total amount of a sales
		this.itemCount++;    //item within a sales increase by 1 once 1 donut is add
	} 
	public List<Donut> getSalesItem() {
		return salesItem;
	}
	public void setSalesItem(List<Donut> salesItem) {
		this.salesItem = salesItem;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public DecimalFormat getDf() {
		return df;
	}
	public void setDf(DecimalFormat df) {
		this.df = df;
	}
	public static int getSalesCount() {
		return salesCount;
	}
	public static void setSalesCount(int salesCount) {
		Sales.salesCount = salesCount;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	public String getId() {
		return id;
	}
	public Date getDate() {
		return date;
	}
	@Override
	public String toString() {
		return "Sales [id=" + id + ", date=" + date + ", salesItem=" + salesItem + ", totalAmount=" + totalAmount
				+  ", itemCount=" + itemCount + "]";
	}
}
