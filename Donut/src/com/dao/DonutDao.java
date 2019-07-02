package com.dao;
import com.model.Donut;
import com.model.Sales;
import com.model.Report;
import com.model.DonutList;
public interface DonutDao {
	public Sales DonutOrder(String id,int order);
	public Sales DonutListOrder(DonutList donutList);
	public Donut getDonut(String id);
	public DonutList DonutList();
	public Report getReport();
}
