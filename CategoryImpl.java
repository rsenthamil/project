package com.Project.serviceimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.model.AddProduct;
import com.Project.model.Category;

@Service("CategoryDAO")
public class CategoryImpl {
	@Autowired
	SessionFactory sessionFactory;
	public void addcategory(Category ap) {
		//System.out.println("AddProduct DAO");
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
       public List<Category> getProducts() {
	    	Session session =sessionFactory.openSession();
	    	//System.out.println("view product session object"+session);
	    	 Transaction transaction =  session.beginTransaction();
	    	List<Category> productList=null;
 	        try {
 	        productList= session.createQuery("from Category").list();   
         	    transaction.commit();                 
           }
          catch (Exception e) {
          transaction.rollback();
          e.printStackTrace();
	       }
 	     session.close();
		 return productList;
	    }
    
       public void edit_list(Category adp){
    	   Session session =sessionFactory.openSession();
    	  // System.out.println("edit session"+session);
	    	 Transaction transaction =  session.beginTransaction();
	    	List<Category> editlist=null;
	        try {
			    int id=adp.getid();
			  //  System.out.println("@@@@@@@"+id);
	        	   //int pid=adp.getid();
			   // System.out.println("id******"+id);
		        editlist=  session.createQuery("from Category where id=:id").setParameter("id",id).list();
		   // System.out.println("editlist *********"+editlist); 		     		       
		        editlist.get(0).setid(adp.getid());
		        editlist.get(0).setName(adp.getName());
		        editlist.get(0).setDesc(adp.getDesc());
		        session.saveOrUpdate(editlist.get(0));
		        transaction.commit();
  	        }
           catch (Exception e) {
               transaction.rollback();
               e.printStackTrace();
 		       }  
	          session.close();
        }
    
       public Category single_object(int id)
       {
          Session session =sessionFactory.openSession();
         // System.out.println("single object session"+session);
	      Transaction transaction =  session.beginTransaction();
	      List<Category> b4=null;
	    	try
	        {
	    	//String query=.list();
	    	//System.out.println(query);
            b4 =  session.createQuery("from Category where id= :id").setParameter("id",id).list();
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
       
       public void deleteRow(int id) {  
  	    	   Session session =sessionFactory.openSession();
	       	   Transaction transaction =  session.beginTransaction();
		       List<Category> del=null;
		       try{
		    	 del=session.createQuery("from Category where id=:id").setParameter("id", id).list();
    	          session.delete(del.get(0));
    	          transaction.commit();
  	            session.close();
     	    
		       }
          catch(Exception e){
              transaction.rollback();
              e.printStackTrace();
        }
}
       public List<Category> getCategories() {
    	   return getProducts();
    	  }
       public List<AddProduct> getAllAddproducts() {
   		// TODO Auto-generated method stub
    	   Session session=sessionFactory.openSession();
   		Transaction transaction=session.beginTransaction();
   		Query query=session.createQuery("from AddProduct");
   		List<AddProduct> products=query.list();
   		return products;
   	}

}
