package com.revature.charityapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/****************************THIS MODEL WILL BE USED TO IMPLEMENT THE USER TRANSACTION DAO*******************************/
@Entity
@Table(name="transaction_details")
public class UsersTransaction {
	@Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int transactionId;
	
	@Column(name="donor_id")
	private int donorId;
	
	@Column(name="fund_id")
	private int fundRequestId;
	
	@Column(name="amount_funded")
	private double targetAmount;
	


	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public int getFundRequestId() {
		return fundRequestId;
	}

	public void setFundRequestId(int fundRequestId) {
		this.fundRequestId = fundRequestId;
	}

	public double getTargetAmount() {
		return targetAmount;
	}

	public void setTargetAmount(double targetAmount) {
		this.targetAmount = targetAmount;
	}

	@Override
	public String toString() {
		return "UsersTransaction [donorId=" + donorId + ", fundRequestId=" + fundRequestId + ", targetAmount="
				+ targetAmount + ", transactionId=" + transactionId + "]";
	}

}
