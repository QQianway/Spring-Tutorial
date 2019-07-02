package com.service;

import com.model.DonutList;
import com.model.Sales;
import com.model.Donut;
import com.model.Report;

public interface DonutService {
	public Sales DonutOrder(String id, int order);
	public DonutList DonutList();
	public Donut getDonut(String id);
	public Sales DonutListOrder(DonutList donutList);
	public Report getReport();
}
