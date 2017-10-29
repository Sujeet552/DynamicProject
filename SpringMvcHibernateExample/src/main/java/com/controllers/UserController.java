package com.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entities.User;
//import com.entities.Users;
import com.services.UserServices;
@Controller
@RequestMapping(value="users")
public class UserController {

	@Autowired
	UserServices userServices;
	
	
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ModelAndView getPage(){
		
		ModelAndView view = new ModelAndView("hello");
		return view;
	}
	
	@RequestMapping(value="/saveOrUpdate",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSaved(User users){
		
		System.out.println("saveOrUpdate is working");
		Map<String,Object> map=new HashMap<String,Object>();
		if(userServices.saveOrUpdate(users)){
		map.put("status", "200");
		map.put("message", "Your record have been saved successfully.");
		}
		return map;
				
	}
	
	@RequestMapping(value="/list",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getAll(User users){
		
		Map<String,Object> map=new HashMap<String,Object>();		
		List<User> list = userServices.list();
		System.out.println("*****Users******");
		
		
        System.out.println(list);
       	    
		if(list != null){
		    map.put("status", "200");
		    map.put("message", "Data found.");
		    map.put("data",list);
		}else{
			
			map.put("status", "404");
			map.put("message", "Data not found.");	
		}
		return map;
				
	}
	
	@RequestMapping(value="/searchlist",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSearchedAll(HttpServletRequest request){
		
		String searchValue=request.getParameter("search");
		System.out.println("String Value : "+searchValue);
		
		Map<String,Object> map=new HashMap<String,Object>();		
		List<User> list = userServices.searchlist(searchValue);
		
		
          System.out.println(list);
   
		   		    
		if(list != null){
		    map.put("status", "200");
		    map.put("message", "Data found.");
		    map.put("data",list);
		}else{
			
			map.put("status", "404");
			map.put("message", "Data not found.");	
		}
		return map;
				
	}
	
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> delete(User users){
		
		System.out.println("ID: "+users.getUser_id());
		Map<String,Object> map=new HashMap<String,Object>();
		
		if(userServices.delete(users)){
		map.put("status", "200");
		map.put("message", "Your record have been deleted successfully.");
		}
		return map;
				
	}
	
	
	
}
