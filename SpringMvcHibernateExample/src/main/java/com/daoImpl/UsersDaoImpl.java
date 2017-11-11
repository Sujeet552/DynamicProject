package com.daoImpl;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
//import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
//import jbr.springmvc.dao.UserMapper;
import com.entities.*;
@Repository
@Transactional
public class UsersDaoImpl implements UserDao{
    @Autowired
	SessionFactory session;
    
    
    public boolean saveOrUpdate(User users){
    	System.out.println("saveOrUpdate is working");
    	session.getCurrentSession().saveOrUpdate(users);
		return true;
    	
    }
    
    public List<User> list(){
    	
		return session.getCurrentSession().createQuery("from User").list();	// TAble is users but the entity name is User
    }
    
 public List<User> searchlist(String searchValue){
    	String SQL_Query="from User where username like '%"+searchValue+"%'" ;
		return session.getCurrentSession().createQuery(SQL_Query).list();	// TAble is users but the entity name is User
    }
    
    public boolean delete(User users){
    	try{
    		
    		System.out.println("Its working in delete");
    		session.getCurrentSession().delete(users);
    		
    	}catch(Exception ex){
    		
    		return false;	
    	}
    	
    
    	
    	return true;	
	}
    
    
    public void register(User user) {
		  
 	    session.getCurrentSession().save(user);//
 		
 	  }
 	  
 	  public int validateUser(Login login) {
 		 
 		//SessionFactory sessionFactory;
		//Session session = sessionFactory.openSession();
 		  int userFound=0;
 		System.out.println("login.getUsername()= "+ login.getUsername()); 
 		System.out.println("login.getPassword()= "+ login.getPassword());  
 	    String sql = "from User where username='" + login.getUsername() + "' and password='" + login.getPassword()+ "'";
 	    
 	   //String sql = "from User where username=:username and password=:password";
 	    System.out.println("SQL Statement: "+sql);
 	  
		List list = session.getCurrentSession().createQuery(sql).list();

		if ((list != null) && (list.size() > 0)) {
			userFound= 1;
			System.out.println("users count= "+ userFound);
		}
 	    
 	    
 	    
 	    System.out.println("users count= "+ userFound);
 	    return userFound;
 	    
 	    
 	  }
 	  
 	 public boolean saveStudent(AddStudentEntity addStud)
 	 {
 		
 		//System.out.println("saveOrUpdate is working");
    	session.getCurrentSession().save(addStud);
    		
		return true;
    			
 		
 	 }
   
 	 public boolean saveStudentFee(FeesEntity AddFee)
 	 {
 	
 		//System.out.println("saveOrUpdate is working");
    	session.getCurrentSession().save(AddFee);
    	
		return true;
    			
 		
 	 }
    
 	 
 	public List<AddStudentEntity> NextEnrollmentNum(){
 		
 		String SQL_Query="from AddStudentEntity where ID= (select MAX(ID) from AddStudentEntity)";	   
 		
		return 	session.getCurrentSession().createQuery(SQL_Query).list();
 	}
	
    public List<AddStudentEntity> listStudent(){
    	
		return session.getCurrentSession().createQuery("from AddStudentEntity").list();	// TAble is users but the entity name is User
    }
    
	
}
