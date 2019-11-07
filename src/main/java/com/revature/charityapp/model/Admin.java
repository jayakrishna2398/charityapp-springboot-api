package com.revature.charityapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/*****************************THIS CLASS IS THE MODEL FOR ADMIN DAO IMPLEMENTATIONS****************************/
@Entity
@Table(name="admin")
public class Admin {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	private int adminId;
	
	@Column(name="password")
	private String adminPassword;
	
	@Column(name="email_id")
	private String adminEmailId;
	 
	@Column(name="name")
	private String adminName;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminEmailId() {
		return adminEmailId;
	}

	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminPassword=" + adminPassword + ", adminEmailId=" + adminEmailId
				+ ", adminName=" + adminName + "]";
	}

}