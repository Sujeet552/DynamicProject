package com.entities;

//import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
    
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="user_id")
	private int user_id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
    private String password;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
    private String lastname;
	@Column(name="email")
    private String email;
	@Column(name="address")
    private String address;
	
	@Column(name="phone")
    private int phone;
	
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
  
  public String getUsername() {
 
	  System.out.println("UserNAme: "+username);
	  return username;
	  
  }
  
  public void setUsername(String username) {
  
	  this.username = username;
  }
  public String getPassword() {
 
	  System.out.println("Password: "+password);
	  return password;
  }
  public void setPassword(String password) {
	  
	  
	  this.password = password;
  }
  public String getFirstname() {
	  
	  System.out.println("FirstNAme: "+firstname);
	  return firstname;
  }
  public void setFirstname(String firstname) {
	 
	  this.firstname = firstname;
  }
  public String getLastname() {
	  System.out.println("LAstNAme: "+lastname);
	  return lastname;
  }
  public void setLastname(String lastname) {
  
	  this.lastname = lastname;
  }
  
  public String getEmail() {
	  System.out.println("Email: "+email);
	  return email;
  }
  public void setEmail(String email) {
  
	  this.email = email;
  }
  public String getAddress() {
	  System.out.println("Address: "+address);
	  return address;
  }
  public void setAddress(String address) {
  
	  this.address = address;
  }
  public int getPhone() {
	  
	  System.out.println("Phone: "+phone);
	  return phone;
  }
  public void setPhone(int phone) {
  
	  this.phone = phone;
  }
}