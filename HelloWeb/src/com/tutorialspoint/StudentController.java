package com.tutorialspoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
public class StudentController {
   @RequestMapping(path="/")
   public String index() {
	   return "index";
   }
   
   @RequestMapping(value = "/student", method = RequestMethod.GET)
   public ModelAndView student() {
      return new ModelAndView("student", "command", new Student());
   }
   
   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
   @ExceptionHandler({SpringException.class})
   public String addStudent( @ModelAttribute("HelloWeb")Student student, 
      ModelMap model) {
      
      if(student.getName().length() < 5 || student.getAge() < 10 ){
         throw new SpringException("Given name is too short or age is too low");
      } else {
    	  model.addAttribute("name", student.getName());    	  
    	  model.addAttribute("age", student.getAge());
          model.addAttribute("id", student.getId());
          return "result";
      }
    
   }
}