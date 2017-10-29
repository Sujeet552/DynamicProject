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
		
		if(userService.saveStudent(AddStud)){
			
			System.out.println("Record Saved successfully !!!");
		}else{
			
			System.out.println("Sorry... Record not Saved !!!");
		}
		
		return new ModelAndView("welcome","","");
	}
	

}
