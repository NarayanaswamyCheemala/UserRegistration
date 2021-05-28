package com.javatpoint;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javatpoint.dao.UserDao;
import com.javatpoint.dao.exception.UserException;
import com.javatpoint.entity.User;


@Controller
public class HelloController {
	
	@Autowired
	UserDao dao;
	
@RequestMapping("/")
	public String display()
	{
		return "index";
	}	

@RequestMapping(value = "/register")
public String showRegister() {
  return "register";
}

@RequestMapping(value="/save",method = RequestMethod.POST)  
public ModelAndView save(@ModelAttribute("usr") User usr) throws UserException{ 
 System.out.println("Controller login "+ usr);
 	dao.save(usr);
	
	 ModelAndView model = new ModelAndView();
	 model.addObject("msg",	 "Successfully added data");
	 model.setViewName("register");
	
    return model;//will redirect to viewemp request mapping  
} 

@RequestMapping(value="/viewUsers",method = RequestMethod.GET)  
public ModelAndView viewUserData() throws UserException{ 
 System.out.println("Started bringing user data  ");
 	
 List<User> userlists = dao.getUserData();
	
	  ModelAndView model = new ModelAndView(); 
	  model.addObject("list", userlists);
	  model.setViewName("viewUser");	 
	
    return model;//will redirect to viewemp request mapping  
} 


}
