package com.dao;
import com.model.Donut;
import com.model.Report;
import com.model.Sales;
import com.model.DonutList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


public class DonutDaoImpl implements DonutDao{
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	Report report = new Report();
	public Sales DonutOrder(String id,int order) {
		String selectSql = "select * from donut where id=" +id;
		List<Donut> donutSelect = jdbcTemplate.query(selectSql, new DonutMapper());
		Sales sales=new Sales();
		if (donutSelect.size()>1||donutSelect.size()==0){
			sales.setValid(false);
		}
		else {
			donutSelect.get(0).setOrder(order);
			int store= donutSelect.get(0).getStore();
			int afterOrder = store-order;
			String updateSql = "update Donut set store=? where ID=?";
			jdbcTemplate.update(updateSql,afterOrder,id);
			sales.addItem(donutSelect.get(0));
			report.addSales(sales);
		}
		return sales;
	}
	public Sales DonutListOrder(DonutList donutList) {
		String fail="";
		String success="";
		Sales sales =new Sales();
		for(int i=0;i<donutList.getDonut().size();i++) {
			int order = donutList.getDonut().get(i).getOrder();
			String selectSql = "select * from donut where id=" +donutList.getDonut().get(i).getID();
			List<Donut> donutSelect = jdbcTemplate.query(selectSql, new DonutMapper());
			if (donutSelect.size()>1||donutSelect.size()==0){
				sales.setValid(false);
				int len=donutSelect.size();
				fail=fail+ "Order Fail "+len+" "+ donutList.getDonut().get(i).getID();
				return sales;
			}
			else {
				if (order==0) {
					
				}
				else{
					Donut donutTemp = new Donut();
					donutSelect.get(0).setOrder(order);
					donutTemp = donutSelect.get(0);
					int store= donutTemp.getStore();
					int afterOrder = store-order;
					afterOrder=20;
					String updateSql = "update Donut set store=? where ID=?";
					jdbcTemplate.update(updateSql,afterOrder,donutTemp.getID());
					sales.addItem(donutTemp);
					success=success+ donutTemp.getName()+" Order Success " + "Store = " +afterOrder+" Order = "+order+"\n";
				}
			}
		}
		report.addSales(sales);
		return sales;
	}

	public Donut getDonut(String id) {
		String selectSql = "select * from donut where id="+id;
		List <Donut> donutSelect= jdbcTemplate.query(selectSql, new DonutMapper());
		return donutSelect.get(0);
	}
	public DonutList DonutList() {
		String donutListSql= "select * from donut";
		List<Donut> list = jdbcTemplate.query(donutListSql, new DonutMapper());
		DonutList donutList = new DonutList();
		donutList.setDonut(list);
		return donutList;
	}
	public Report getReport() {
		report.calTOT();
		return report;
	}
	class DonutMapper implements RowMapper<Donut> {
		public Donut mapRow(ResultSet rs,int arg1)throws SQLException{
			Donut donut= new Donut();
			donut.setID(rs.getString("ID"));
			donut.setName(rs.getString("name"));
			donut.setPrice(rs.getDouble("price"));
			donut.setStore(rs.getInt("store"));
			return donut;
		}
	}
}
