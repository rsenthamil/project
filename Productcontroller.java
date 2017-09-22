package com.Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Project.model.Addproduct;
import com.Project.serviceimpl.Addproductimpl;


@Controller("Productcontroller")
public class Productcontroller {
	@Autowired
	Addproductimpl apdao;
		@RequestMapping(value="Addproduct", method=RequestMethod.GET)
	public ModelAndView getLogin(@ModelAttribute("Addproduct")Addproduct addproduct)
	{
			System.out.println("Addproduct");	
			ModelAndView model=new ModelAndView("Addproduct");
			return model;
	}
	
	@RequestMapping(value="Addproduct", method=RequestMethod.POST)
	public ModelAndView Success(Addproduct ap, Model m)
	{
			apdao.addproduct(ap);
			ModelAndView model=new ModelAndView("viewproduct","Addproduct", new Addproduct());
			return model;
	}
	
}

