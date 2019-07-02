package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.dao.DonutDao;
import com.model.Sales;
import com.model.Donut;
import com.model.Report;
import com.model.DonutList;
public class DonutServiceImpl implements DonutService {
	@Autowired
	public DonutDao donutDao;
	public Sales DonutOrder(String id,int order) {
		return donutDao.DonutOrder(id,order);
	}
	public DonutList DonutList(){
		return donutDao.DonutList();
	}
	public Donut getDonut(String id) {
		return donutDao.getDonut(id);
	}
	public Sales DonutListOrder(DonutList donutList) {
		return donutDao.DonutListOrder(donutList);
	}
	public Report getReport() {
		return donutDao.getReport();
	}
}
