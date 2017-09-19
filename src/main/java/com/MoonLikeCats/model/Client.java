package com.MoonLikeCats.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="client")
@PrimaryKeyJoinColumn(name="userId")
public class Client extends User{
	
	private String displayName;
	private String phone;
	private Date childBirthdate;
	//private Set<Favorite> Favorites;
	
	public Client() {
	}
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getChildBirthdate() {
		return childBirthdate;
	}

	public void setChildBirthdate(Date childBirthdate) {
		this.childBirthdate = childBirthdate;
	}
	
	
//	public Set<Favorite> getFavorites() {
//		return Favorites;
//	}
//
//	public void setFavorites(Set<Favorite> favorites) {
//		Favorites = favorites;
//	}
	@Override
	public String toString() {
		return "Client [displayName=" + displayName + ", phone=" + phone + ", childBirthdate=" + childBirthdate + "]";
	}

}
