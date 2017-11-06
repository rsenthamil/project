package com.Project.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Project.model.Category;
import com.Project.serviceimpl.CategoryImpl;
@Controller("categorycontroller")
public class CategoryController {
	int id;
	//@Resource(name="CategoryDAO")
	@Autowired
	CategoryImpl cdao;
		@RequestMapping(value="Category", method=RequestMethod.GET)
	public ModelAndView getLogin(@ModelAttribute("Category")Category Category)
	{
			System.out.println("Category");	
			ModelAndView model=new ModelAndView("Category");
			return model;
	}
	
	@RequestMapping(value="Category", method=RequestMethod.POST)
	public ModelAndView Success(Category apt, Model m)
	{
			cdao.addcategory(apt);
			//Category a=new Category();
			ModelAndView model=new ModelAndView("redirect:viewcategory","Category", new Category());
			List<Category> teams = cdao.getProducts();
 	        //System.out.println("obj:"+teams);
            model.addObject("lists", teams);
			return model;
	}
	 @RequestMapping(value="viewcategory")
	    public ModelAndView listOfTeams() {
		 //Category addp=new Category();
	        ModelAndView modelAndView = new ModelAndView("viewcategory");
	         	        List<Category> teams = cdao.getProducts();
	         	        //System.out.println("obj:"+teams);
	        modelAndView.addObject("lists", teams);
	        	        return modelAndView;
	    }
	  
	 @RequestMapping("/editcategory/{id}")  
	 public ModelAndView editUser(@PathVariable int id) {  
	  Category apobj = cdao.single_object(id);  
	  return new ModelAndView("editcategory", "command",apobj );  
	 }  
	
	 @RequestMapping(value="/editcategory/update",method=RequestMethod.POST)  
	 public ModelAndView updateUser(@ModelAttribute("apobj") Category adp) { 
		id=adp.getid();
	  cdao.edit_list(adp);  
	  ModelAndView model=new ModelAndView("viewcategory");
	  List<Category> teams = cdao.getProducts();
       //System.out.println("obj:"+teams);
      model.addObject("lists", teams);
		return model;
	  
	 }  
	
	 @RequestMapping(value="/delete1/{id}",method=RequestMethod.POST)  
	 public ModelAndView deleteUser(@PathVariable int id) {  
	  cdao.deleteRow(id); 
	  ModelAndView model=new ModelAndView("viewcategory");
	  List<Category> teams = cdao.getProducts();
       //System.out.println("obj:"+teams);
      model.addObject("lists", teams);
		return model;
	  
	  //return new ModelAndView("viewcategory");  
	 }  
     
	 

}

