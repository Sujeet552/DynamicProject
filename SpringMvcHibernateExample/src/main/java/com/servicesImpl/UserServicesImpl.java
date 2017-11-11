package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.entities.AddStudentEntity;
import com.entities.FeesEntity;
import com.entities.Login;
//import com.entities.Login;
import com.entities.User;
//import com.entities.Users;
import com.services.UserServices;
@Service
public class UserServicesImpl implements UserServices{
	
	@Autowired
	UserDao userDao;

	public List<User> list() {
		// TODO Auto-generated method stub
		return userDao.list();
	}

	public List<User> searchlist(String searchValue) {
		// TODO Auto-generated method stub
		return userDao.searchlist(searchValue);
	}
	
	public boolean delete(User users) {
		// TODO Auto-generated method stub
		return userDao.delete(users);
	}

	public boolean saveOrUpdate(User users) {
		// TODO Auto-generated method stub
		return userDao.saveOrUpdate(users);
	}
	
	public int validateUser(Login login){
		
		return userDao.validateUser(login);
	}

	public void register(User user){
		
		userDao.register(user);
	}

	public boolean saveStudent(AddStudentEntity addStud)
	{
		return userDao.saveStudent(addStud);
	}
	public boolean saveStudentFee(FeesEntity addFee)
	{
		return userDao.saveStudentFee(addFee);
	}
	
	
	public List<AddStudentEntity> NextEnrollmentNum(){
		
		return userDao.NextEnrollmentNum();
	}
		
	public List<AddStudentEntity> listStudent(){
		
		return userDao.listStudent();
	}
	

}
