package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class AddStudentEntity {
	
	
	String EnrollmentNumber,FirstName,MiddleName,Lastname,Qualification,Address,City,State,Zip,EmailAddress,DateOfJoining, Course;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	int ID;
	
	@Column(name="MobileNo")
	long PhoneNumber;

	public String getEnrollmentNumber() {
		return EnrollmentNumber;
	}

	public void setEnrollmentNumber(String enrollmentNumber) {
		EnrollmentNumber = enrollmentNumber;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getQualification() {
		return Qualification;
	}

	public void setQualification(String qualification) {
		Qualification = qualification;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getZip() {
		return Zip;
	}

	public void setZip(String zip) {
		Zip = zip;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public String getDateOfJoining() {
		return DateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		DateOfJoining = dateOfJoining;
	}

	public String getCourse() {
		return Course;
	}

	public void setCourse(String course) {
		Course = course;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public long getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "AddStudentEntity [EnrollmentNumber=" + EnrollmentNumber + ", FirstName=" + FirstName + ", MiddleName="
				+ MiddleName + ", Lastname=" + Lastname + ", Qualification=" + Qualification + ", Address=" + Address
				+ ", City=" + City + ", State=" + State + ", Zip=" + Zip + ", EmailAddress=" + EmailAddress
				+ ", DateOfJoining=" + DateOfJoining + ", Course=" + Course + ", ID=" + ID + ", PhoneNumber="
				+ PhoneNumber + "]";
	}
	
	
}
