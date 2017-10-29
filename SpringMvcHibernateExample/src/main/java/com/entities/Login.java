package com.entities;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;

//@Entity
//@Table(name="users")
public class Login {
	
 // @Column(name="username")
  private String username;
//  @Column(name="password")
  private String password;
  
  public String getUsername() {
	  
     return username;
  }
  public void setUsername(String username) {
	System.out.println("Username: "+username);  
  this.username = username;
  
  }
  
  public String getPassword() {
  
	  return password;
  }
  public void setPassword(String password) {
	  System.out.println("Password: "+password);
	  this.password = password;
  }
}