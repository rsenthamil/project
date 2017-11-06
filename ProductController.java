package com.Project.controller;




import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.Resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.Project.model.AddProduct;
import com.Project.model.Category;
import com.Project.serviceimpl.AddProductImpl;


@Controller("ProductController")
public class ProductController {
	int id;
	@Resource(name="AddProductDAO")
	@Autowired
	AddProductImpl apdao;
		@RequestMapping(value="AddProduct", method=RequestMethod.GET)
	public ModelAndView getLogin(@ModelAttribute("AddProduct")AddProduct addproduct,Model model1)
	{
			System.out.println("AddProduct");	
			List<Category> categories=apdao.getAllCategories();
			model1.addAttribute("categories", categories);
			model1.addAttribute("product",new AddProduct());
			ModelAndView model=new ModelAndView("AddProduct");
            return model;
	}
	@Bean
	public MultipartResolver multipartresolver(){
		CommonsMultipartResolver multipartresolver=new CommonsMultipartResolver();
		return multipartresolver;
	}
	@RequestMapping(value="AddProduct", method=RequestMethod.POST)
	public ModelAndView Success(AddProduct apt, Model m)
	{
		    List<Category> categories=apdao.getAllCategories();
		    m.addAttribute("categories", categories);
			apdao.addproduct(apt);
			MultipartFile image=apt.getImage();
		       if(image != null && !image.isEmpty())
		       {
		      	Path path=Paths.get("D://Firstproject/Project/src/main/webapp/images/"+apt.getpid()+".png");
		      	try {
		   			image.transferTo(new File(path.toString()));
		   		} catch (IllegalStateException e) {
		   			// TODO Auto-generated catch block
		 			e.printStackTrace();
		  		} catch (IOException e) {
		 			// TODO Auto-generated catch block
		  			e.printStackTrace();
		   		}
		       }
			ModelAndView model=new ModelAndView("redirect:viewproduct","AddProduct", new AddProduct());
			List<AddProduct> teams = apdao.getProducts();
 	        //System.out.println("obj:"+teams);
            model.addObject("lists", teams);
			return model;
	}
	 @RequestMapping(value="viewproduct")
	    public ModelAndView listOfTeams() {
		 //AddProduct addp=new AddProduct();
		 //List<AddProduct> products=apdao.getAllAddproducts();
		 
	        ModelAndView modelAndView = new ModelAndView("viewproduct");
	         	        List<AddProduct> teams = apdao.getProducts();
	         	        //System.out.println("obj:"+teams);
	        modelAndView.addObject("lists", teams);
	        	        return modelAndView;
	    }
	  
	 @RequestMapping("/editproduct/{pid}")  
	 public ModelAndView editUser(@PathVariable int pid) {  
	  AddProduct apobj = apdao.single_object(pid);  
	  return new ModelAndView("editproduct", "command",apobj );  
	 }  
	
	 @RequestMapping(value="/editproduct/update",method=RequestMethod.POST)  
	 public ModelAndView updateUser(@ModelAttribute("apobj") AddProduct adp) { 
		id=adp.getpid();
	  apdao.edit_list(adp);  
	  ModelAndView model=new ModelAndView("viewproduct");
	  List<AddProduct> teams = apdao.getProducts();
       //System.out.println("obj:"+teams);
      model.addObject("lists", teams);
		return model;
	  
	 }  
	 @RequestMapping(value="/delete/{pid}",method=RequestMethod.POST)  
	 public ModelAndView deleteUser(@PathVariable int pid) {  
	  apdao.deleteRow(pid); 
	  ModelAndView model=new ModelAndView("viewproduct");
	  List<AddProduct> teams = apdao.getProducts();
       //System.out.println("obj:"+teams);
      model.addObject("lists", teams);
		return model;
	  
	 //return new ModelAndView("viewproduct");  
	 }  
}
     

