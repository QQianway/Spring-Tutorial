package com.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.model.Donut;
import com.model.DonutList;
import com.model.Sales;
import com.model.Report;
import com.service.DonutService;


@Controller
public class DonutController {
	@RequestMapping(path="/")
	public String Home() {
		return "home";
	}
	@RequestMapping(value="home")
	public String home2() {
		return "home";
	}
	@Autowired
	DonutService donutService;
	@RequestMapping(value="donutList")
	public ModelAndView donutList(ModelAndView model){
	    DonutList donutList = donutService.DonutList();
	    model.addObject("donutList", donutList);
	    model.setViewName("donutList");
	    return model;
	}
	@RequestMapping(value="donutView",method=RequestMethod.GET)
	public ModelAndView donutView(HttpServletRequest request,HttpServletResponse response){
		Donut donutSelected= new Donut();
		ModelAndView mav = new ModelAndView("donut");
	    String donutID = request.getParameter("id");
	    donutSelected= donutService.getDonut(donutID);
	    mav.addObject("donutSelected",donutSelected);
	    mav.setViewName("donutSelect");
	    return mav;
	}
	@RequestMapping(value="donutListOverview")
	public ModelAndView donutListOverview(ModelAndView model){
	    DonutList donutList = donutService.DonutList();
	    model.addObject("donutListOverview", donutList);
	    model.setViewName("donutListOverview");
	    return model;
	}
	@RequestMapping(value="donutListOrder",method=RequestMethod.POST)
	public ModelAndView donutListOrder(@ModelAttribute("donutListOverview") DonutList donutList){
		ModelAndView mav=new ModelAndView("result");
		Sales sales=donutService.DonutListOrder(donutList);
		mav.addObject("sales",sales);
		mav.setViewName("salesOverview");
	    return mav;
	}
	@RequestMapping(value="donutSelectedOrder",method=RequestMethod.POST)
	public ModelAndView donutOrderUpdate(Donut donut){
		ModelAndView mav=new ModelAndView("result");
		Sales sales=donutService.DonutOrder(donut.getID(),donut.getOrder());
		mav.addObject("sales",sales);
		mav.setViewName("salesOverview");
		return mav;
	}
	@RequestMapping(value="report")
	public ModelAndView getReport(ModelAndView mav){
		Report report = new Report();
	    report = donutService.getReport();
//	    String report=donutService.getReport();
		mav.addObject("salesCount", report.getSalesCount());
		mav.addObject("total",report.getTotalOfTotal());
		mav.addObject("salesList",report.getSalesList());
	    mav.setViewName("report");
	    return mav;
	}
}
