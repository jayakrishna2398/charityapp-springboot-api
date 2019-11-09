package com.revature.charityapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**************************THIS CLASS IS THE MODEL FOR FUND REQUEST DAO IMPLEMENTATION*****************************/
@Entity
@Table(name="fund_request")
public class FundRequest {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	private int fundId;
	
    @Column(name="request_type")
	private String reqType;
    
    @Column(name="target_amount")
	private int amount;
    
   @Column(name="fund_raised")
   private double fundRaised;
   
   @Column(name="fund_p")
   private double fundPending;
   

	public double getFundRaised() {
	return fundRaised;
}

public void setFundRaised(double fundRaised) {
	this.fundRaised = fundRaised;
}

public double getFundPending() {
	return fundPending;
}

public void setFundPending(double fundPending) {
	this.fundPending = fundPending;
}

	public int getFundId() {
		return fundId;
	}

	public void setFundId(int fundId) {
		this.fundId = fundId;
	}

	/*
	 * public int getAdminId() { return adminId; }
	 * 
	 * public void setAdminId(int adminId) { this.adminId = adminId; }
	 */

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "FundRequest [fundId=" + fundId + ", reqType=" + reqType + ", amount=" + amount + ", fundRaised="
				+ fundRaised + ", fundPending=" + fundPending + "]";
	}


}
