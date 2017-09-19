package com.MoonLikeCats.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.InheritanceType;

@Entity
@Table(name="User")
@Inheritance(strategy=InheritanceType.JOINED) 
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name = "email", unique = true, nullable = false, length = 45)
	private String email;
	private String password;
	private String role;
	private String address;
	@UpdateTimestamp
	private Timestamp lastModified;
	@CreationTimestamp
	private Timestamp dateCreated;
	
	public User() {
		
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getLastModified() {
		return lastModified;
	}

	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", address=" + address + ", lastModified=" + lastModified + ", dateCreated=" + dateCreated + "]";
	}
}
