package com.Project.dao;

import org.springframework.stereotype.Service;

import com.Project.model.Addproduct;

@Service("Addproductdao")
public interface Addproductdao {
	public void addproduct(Addproduct p);
	public void editproduct(int i);
	public void delproduct(int i);
	public void showproduct();
	}

