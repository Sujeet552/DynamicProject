package com.services;

import java.util.List;

import com.entities.AddStudentEntity;
import com.entities.Login;
import com.entities.User;

public interface UserServices {

	public List<User> list();
	public List<User> searchlist(String searchValue);
	public boolean delete(User users);
	public boolean saveOrUpdate(User users);
	
	public int validateUser(Login login);

	public void register(User user);
	public boolean saveStudent(AddStudentEntity addStud);
	
	
	
	public List<AddStudentEntity> NextEnrollmentNum();
	public List<AddStudentEntity> listStudent();
	
}
