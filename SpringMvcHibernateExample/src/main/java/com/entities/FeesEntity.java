package com.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fees_detail")
public class FeesEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="recipt_num")
	int reciptNum;
	
	@Column(name="paid_amount")
	int paidAmount;
	
	@Column(name="EnrollmentNumber")
	String EnrollmentNumber;
	
	@Column(name="paid_date")
	String paymentDate;

	int totalfees;
	
	public int getReciptNum() {
		return reciptNum;
	}

	public void setReciptNum(int reciptNum) {
		this.reciptNum = reciptNum;
	}

	public int getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getEnrollmentNumber() {
		return EnrollmentNumber;
	}

	public void setEnrollmentNumber(String enrollmentNumber) {
		EnrollmentNumber = enrollmentNumber;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getTotalfees() {
		return totalfees;
	}

	public void setTotalfees(int totalfees) {
		this.totalfees = totalfees;
	}

	@Override
	public String toString() {
		return "FeesEntity [reciptNum=" + reciptNum + ", paidAmount=" + paidAmount + ", EnrollmentNumber="
				+ EnrollmentNumber + ", paymentDate=" + paymentDate + "]";
	}
	
	
	
}
