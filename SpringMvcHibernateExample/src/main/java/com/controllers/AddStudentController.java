package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entities.AddStudentEntity;
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
		
		ModelAndView mav = new ModelAndView("admissionsuccess");
		
		if(userService.saveStudent(AddStud)){
			
			System.out.println("Record Saved successfully !!!");
			mav.addObject("msg","Record has been inserted successfully to the database with Enrollment Number: "+AddStud.getEnrollmentNumber()+" !!!");
			//mav.addObject("enrollmentId",AddStud.getEnrollmentNumber());
			
		}else{
			
			System.out.println("Record has not been saved due to invalid data entry. !!!");
			mav.addObject("msg","Record has not been saved due to invalid data entry. !!!");
			
		}
		
		
		return mav;
	}
	

}
