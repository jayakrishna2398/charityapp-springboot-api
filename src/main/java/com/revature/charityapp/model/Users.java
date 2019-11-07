package com.revature.charityapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/****************************THIS MODEL IS USED TO ACCESS THE USER IMPLEMENTATIONS OF USER DAO**********************/
@Entity
@Table(name="donor")
public class Users {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	private int donorId;
	
	@Column(name="name")
	private String donorName;
	
	@Column(name="email_id")
	private String donorEmailId;
	
	@Column(name="password")
	private String donorPassword;
	
	@Column(name="gender")
	private String gender;

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public String getDonorEmailId() {
		return donorEmailId;
	}

	public void setDonorEmailId(String donorEmailId) {
		this.donorEmailId = donorEmailId;
	}

	public String getDonorPassword() {
		return donorPassword;
	}

	public void setDonorPassword(String donorPassword) {
		this.donorPassword = donorPassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Users [donorId=" + donorId + ",donorName=" + donorName + ", donorEmailId=" + donorEmailId
				+ ", donorPassword=" + donorPassword + ", gender=" + gender + "]";
	}

}
