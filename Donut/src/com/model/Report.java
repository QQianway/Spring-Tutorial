package com.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Report {
	 private List<Sales> salesList = new ArrayList<>(); //every sales was stored within SalesList
	 private double totalOfTotal=0;//total amount of sales
	 DecimalFormat df= new DecimalFormat("#0.00");//set decimal format to 2 decimal places
	 private int salesCount=0;//number of sales add into salesList
	 public Report(){//default constructor;
	 }
	 
	 public List<Sales> getSalesList() {
		return salesList;
	}

	public void setSalesList(List<Sales> salesList) {
		this.salesList = salesList;
	}

	
	public double getTotalOfTotal() {
		return totalOfTotal;
	}

	public void setTotalOfTotal(double totalOfTotal) {
		this.totalOfTotal = totalOfTotal;
	}

	public int getSalesCount() {
		return salesCount;
	}

	public void setSalesCount(int salesCount) {
		this.salesCount = salesCount;
	}

	public void addSales(Sales a){
		Sales sales=new Sales();
		sales=a;
	    this.salesList.add(sales);// add sales into sales lists report
	    this.salesCount++;//the number of sales increases once sales is added
	 }
	 public void calTOT(){
	    Sales temp =new Sales();
	    totalOfTotal=0;
	    for (int i=0;i<salesCount;i++){
	        temp=salesList.get(i);
	        totalOfTotal+= temp.getTotalAmount();
	    }
	 }
	 @Override
	 public String toString(){
	    calTOT();    
	    String d="";           
	    for (int i = 0; i < salesCount; i++){                  
		    Sales temp=salesList.get(i); 
		    d+=temp.getId()+"\t\t"+df.format(temp.getTotalAmount())+"\n";           
		} 
	    return ("\nID\t\tPrice(RM)"+"\n"+d+"\nTotal Amount (RM): "+ df.format(totalOfTotal)); 
	}
}
