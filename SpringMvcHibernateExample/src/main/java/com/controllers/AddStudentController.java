package com.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entities.AddStudentEntity;
import com.entities.FeesEntity;
import com.services.UserServices;

@Controller
public class AddStudentController {
	
	 @Autowired
	 UserServices userService;
	
	@RequestMapping(value="/AddStudent",method = RequestMethod.POST)
	public ModelAndView AddStudent(@ModelAttribute ("AddStud") AddStudentEntity AddStud)
	{
		
		 System.out.println("hi AddStudent");
		 System.out.println(AddStud);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		 LocalDate localDate = LocalDate.now();
		
		 
		 /* List<FeesEntity> nextEnrollmentNum;
		  ModelAndView mav = new ModelAndView("register");
		  nextEnrollmentNum = userService.NextEnrollmentNum();
		  */
		ModelAndView mav = new ModelAndView("studentfeesdetail");
		
		//mav.addObject("AddStud", AddStud);
		if(userService.saveStudent(AddStud)){
			
			System.out.println("Record Saved successfully !!!");
			mav.addObject("EnrollmentNumber", AddStud.getEnrollmentNumber());
			mav.addObject("localDate", dtf.format(localDate));
			
		}else{
			
			System.out.println("Record has not been saved due to invalid data entry. !!!");
			mav.addObject("msg","Record has not been saved due to invalid data entry. !!!");
			
		}
		
		
		return mav;
	}
	
	
	
	@RequestMapping(value="/AddAll",method = RequestMethod.POST)
	public ModelAndView AddAll(@ModelAttribute ("AddFee") FeesEntity AddFee)
	{
		
	//	System.out.println("hi AddStudent");
		System.out.println(AddFee);
		//AddStudentEntity addStud = new AddStudentEntity();
		
		ModelAndView mav = new ModelAndView("admissionsuccess");
		
		if(userService.saveStudentFee(AddFee)){
			
			System.out.println("Record Saved successfully !!!");
			mav.addObject("msg","Record has been inserted successfully to the database with Enrollment Number:<b> "+AddFee.getEnrollmentNumber()+"</b> !!!");
			//mav.addObject("enrollmentId",AddStud.getEnrollmentNumber());
			
		}else{
			
			System.out.println("Record has not been saved due to invalid data entry. !!!");
			mav.addObject("msg","Record has not been saved due to invalid data entry. !!!");
			
		}
		
		
		return mav;
	}
	

}
