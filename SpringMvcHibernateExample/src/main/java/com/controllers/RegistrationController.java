package com.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.entities.AddStudentEntity;
import com.entities.User;
import com.services.UserServices;
@Controller
public class RegistrationController {
	
  @Autowired
  public UserServices userService;
  
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	  List<AddStudentEntity> nextEnrollmentNum;
	  ModelAndView mav = new ModelAndView("register");
	  nextEnrollmentNum = userService.NextEnrollmentNum();
	  
	  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	  LocalDate localDate = LocalDate.now();
	  System.out.println(dtf.format(localDate)); //2016/11/16
	  
	  System.out.println("Next Serial Number: "+nextEnrollmentNum.get(0).getID());
	  mav.addObject("user", new User());
	  mav.addObject("SerialNo", nextEnrollmentNum.get(0).getID()+1);
	  mav.addObject("localDate", dtf.format(localDate));
      return mav;
  }
  
  @RequestMapping(value = "/viewstudents", method = RequestMethod.GET)
  public ModelAndView viewStudents(HttpServletRequest request, HttpServletResponse response) {
   
	  ModelAndView mav = new ModelAndView("viewstudents");
     // mav.addObject("user", new User());
      return mav;
  }
  
  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(@ModelAttribute("user") User user) {
	   
	  userService.register(user);
	  System.out.println("User FirstNAme: " +user.getFirstname());
	  
      return new ModelAndView("welcome", "firstname", user.getFirstname());
  }
  
  
  
  @RequestMapping(value="/studentlist",method=RequestMethod.POST)
 	public @ResponseBody Map<String,Object> getStudentList(){
 		
 		//String searchValue=request.getParameter("search");
 	//	System.out.println("String Value : "+searchValue);
 		
 		Map<String,Object> map = new HashMap<String,Object>();	
 		
 		List<AddStudentEntity> list = userService.listStudent();
 				
 		
        System.out.println(list);
      
 		   		    
 		if(list != null){
 		    map.put("status", "200");
 		    map.put("message", "Data found.");
 		    map.put("data",list);
 		    //System.out.println(map);
 		}else{
 			
 			map.put("status", "404");
 			map.put("message", "Data not found.");	
 		}
 		return map;
 				
 	}
  
  
  
}