package com.Project.serviceimpl;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.dao.Addproductdao;
import com.Project.model.Addproduct;

@Service
public class Addproductimpl implements Addproductdao {
			@Autowired
		SessionFactory sessionFactory;
		public void addproduct(Addproduct p) {
			System.out.println("Addproduct DAO");
			System.out.println(p.getpName());
			//UserCredential uc=new UserCredential();
			//uc.setUsername(r.getUsername());
			//uc.setPassword(r.getPassword());
			//System.out.println("User Credentials");
			try
			{
			Session session= sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			//tx.begin();
			session.save(p);
			//session.save(uc);
			tx.commit();
			session.flush();
			session.close();
			} 
			catch(Exception e)
			{
				System.out.println("Error"+e);
			}		
		}
		public void editproduct(int i)
		{
			
		}
		public void delproduct(int i)
		{
			
		}
		public void showproduct()
		{
			
		}
		
		public void getinfo()
		{
			
		}
}


		