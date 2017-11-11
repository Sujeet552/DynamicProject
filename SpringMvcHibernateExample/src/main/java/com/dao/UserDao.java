package com.dao;
import com.entities.AddStudentEntity;
import com.entities.FeesEntity;
import com.entities.Login;
import com.entities.User;
import java.util.List;
public interface UserDao {

	public List<User> list();
	public List<User> searchlist(String searchValue);
	public boolean delete(User users);
	public boolean saveOrUpdate(User users);
	public int validateUser(Login login);

	public void register(User user);
	public boolean saveStudent(AddStudentEntity addStud);
	public boolean saveStudentFee(FeesEntity addFee);
	
	public List<AddStudentEntity> NextEnrollmentNum();
	public List<AddStudentEntity> listStudent();
}
