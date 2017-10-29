package com.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.entities.Login;
import com.entities.User;
import com.services.UserServices;
@Controller
public class LoginController {
  @Autowired
  UserServices userService;
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());
    return mav;
  }
  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("login") Login login) {
	  
	System.out.println("Username login: "+login.getUsername()); 
    ModelAndView mav = null;
    int count = userService.validateUser(login);
    if (count != 0) {
    mav = new ModelAndView("welcome");
    mav.addObject("firstname", login.getUsername());
    } else {
    mav = new ModelAndView("login");
    mav.addObject("message", "Username or Password is wrong!!");
    }
    return mav;
  }
  
  
  @RequestMapping(value="/searchlist",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getSearchedAll(HttpServletRequest request){
		
		String searchValue=request.getParameter("search");
		System.out.println("String Value : "+searchValue);
		
		Map<String,Object> map=new HashMap<String,Object>();		
		List<User> list = userService.searchlist(searchValue);
		System.out.println("*****Users******");
		
		for(int i = 0; i < list.size(); i++) {
          System.out.println(list.get(i).getUsername()+" "+list.get(i).getUser_id());
      }
		   		    
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
  
  
  
}