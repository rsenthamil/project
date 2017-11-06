package com.Project.serviceimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.Project.dao.AddProductDAO;
import com.Project.model.AddProduct;
import com.Project.model.Category;

@Service("AddProductDAO")
public class AddProductImpl implements AddProductDAO {
		
	
	    @Autowired
		SessionFactory sessionFactory;
		public void addproduct(AddProduct ap) {
			System.out.println("AddProduct DAO");
			//UserCredential uc=new UserCredential();
			//uc.setUsername(r.getUsername());
			//uc.setPassword(r.getPassword());
			//System.out.println("User Credentials");
			try
			{
			Session session= sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			//tx.begin();
			session.save(ap);
			
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
	       public List<AddProduct> getProducts() {
		    	Session session =sessionFactory.openSession();
		    	//System.out.println("view product session object"+session);
		    	 Transaction transaction =  session.beginTransaction();
		    	List<AddProduct> productList=null;
     	        try {
     	        productList= session.createQuery("from AddProduct").list();   
             	    transaction.commit();                 
               }
              catch (Exception e) {
              transaction.rollback();
              e.printStackTrace();
		       }
     	     session.close();
			 return productList;
		    }
	    
	       public void edit_list(AddProduct adp){
	    	   Session session =sessionFactory.openSession();
	    	  // System.out.println("edit session"+session);
		    	 Transaction transaction =  session.beginTransaction();
		    	List<AddProduct> editlist=null;
   	        try {
   			    //int id=adp.getpid();
   	        	   int pid=adp.getpid();
   			   // System.out.println("id******"+id);
   		        editlist=  session.createQuery("from AddProduct where pid=:pid").setParameter("pid",pid).list();
    		   // System.out.println("editlist *********"+editlist);
   		        		     		       
   		        editlist.get(0).setpid(adp.getpid());
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
	    
	       public AddProduct single_object(int pid)
	       {
              Session session =sessionFactory.openSession();
             // System.out.println("single object session"+session);
		      Transaction transaction =  session.beginTransaction();
		      List<AddProduct> b4=null;
		    	try
		        {
		    	//String query=.list();
		    	//System.out.println(query);
	            b4 =  session.createQuery("from AddProduct where pid= :pid").setParameter("pid",pid).list();
	         //  System.out.println("*****"+b4.get(0));
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
	       
	       public void deleteRow(int pid) {  
	  	    	   Session session =sessionFactory.openSession();
		       	   Transaction transaction =  session.beginTransaction();
			       List<AddProduct> del=null;
			       try{
			    	 del=session.createQuery("from AddProduct where pid=:pid").setParameter("pid", pid).list();
	    	          session.delete(del.get(0));
	    	          transaction.commit();
	  	            session.close();
	     	    
			       }
	          catch(Exception e){
                  transaction.rollback();
                  e.printStackTrace();
	        }
  }
	       public AddProduct find(int id) {
	    	   return null;
	    	  }
          
	       public List<Category> getAllCategories() {
	    		// TODO Auto-generated method stub
	    		Session session=sessionFactory.openSession();
	    		Transaction transaction=session.beginTransaction();
	    		Query query=session.createQuery("from Category");
	    		List<Category> categories=query.list();
	    		return categories;
	    	}
	       
  
}
		


		