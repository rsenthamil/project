package com.Project.serviceimpl;


import java.io.Serializable;
import java.util.List;

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
		public List<Addproduct> getproducts() {
	    	Session session =sessionFactory.openSession();
	    	 Transaction transaction =  session.beginTransaction();
	    	List<Addproduct> productList=null;
	    	System.out.println(productList);
 	        try {
 	        productList= session.createQuery("from Addproduct").list();   
         	    transaction.commit();                 
           }
          catch (Exception e) {
          transaction.rollback();
          e.printStackTrace();
	       }
 	     session.close();
		 return productList;
	    }
		public void edit_list(Addproduct adp){
	    	   Session session =sessionFactory.openSession();
	    	  // System.out.println("edit session"+session);
		    	 Transaction transaction =  session.beginTransaction();
		    	List<Addproduct> editlist=null;
	        try {
			    int id=adp.getPid();
	        	   //int pid=adp.getPid();
			   // System.out.println("id******"+id);
		        editlist=  session.createQuery("from Addproduct where pid=:pid").setParameter("pid",id).list();
 		    System.out.println("editlist *********"+editlist);
		        		     		       
		        editlist.get(0).setPid(adp.getPid());
		        editlist.get(0).setpName(adp.getpName());
		        editlist.get(0).setpDes(adp.getpDes());
		        editlist.get(0).setpPrize(adp.getpPrize());
		        editlist.get(0).setpPer(adp.getpPer());
		        session.saveOrUpdate(editlist.get(0));
		        transaction.commit();
   	        }
	           catch (Exception e) {
	               transaction.rollback();
	               e.printStackTrace();
	 		       }  
	          session.close();
	        }
	    
	       public Addproduct single_object(int pid)
	       {
           Session session =sessionFactory.openSession();
          // System.out.println("single object session"+session);
		      Transaction transaction =  session.beginTransaction();
		      List<Addproduct> b4=null;
		    	try
		        {
		    	//String query=.list();
		    	//System.out.println(query);
		    	 //int id=getPid();
	            b4 =  session.createQuery("from Addproduct where pid= :pid").setParameter("pid",pid).list();
	           System.out.println("*****"+b4.get(0));
	            transaction.commit();
	            session.close();
	                        
		    }        
		    catch (Exception e) 
		    {
	           transaction.rollback();
	           e.printStackTrace();
	        }
	  	     return b4.get(0);
	       }
}