package com.MoonLikeCats.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="sp_publicInfo")
public class SP_PublicInfo {

	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="serviceProvider"))
	private int spId;
	private Date birthdate;
	private String countryISO;
	private String experience;
	private String nickName;
	private boolean searchable;
	private String description;
	private String state;
	private boolean veryfied;
	private boolean work24hours;
	@OneToOne
	@PrimaryKeyJoinColumn
	private ServiceProvider serviceProvider;
	
	@OneToOne(mappedBy = "sp_publicInfo", cascade=CascadeType.ALL)
	private SP_Language sp_language;
	
	@OneToOne(mappedBy = "sp_publicInfo", cascade=CascadeType.ALL)
	private SP_Gallery gallery;
	
	public SP_PublicInfo() {
		
	}

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getCountryISO() {
		return countryISO;
	}

	public void setCountryISO(String countryISO) {
		this.countryISO = countryISO;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public boolean isSearchable() {
		return searchable;
	}

	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isVeryfied() {
		return veryfied;
	}

	public void setVeryfied(boolean veryfied) {
		this.veryfied = veryfied;
	}

	public boolean isWork24hours() {
		return work24hours;
	}

	public void setWork24hours(boolean work24hours) {
		this.work24hours = work24hours;
	}
	
	
	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}
	
	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public SP_Language getSp_language() {
		return sp_language;
	}

	public void setSp_language(SP_Language sp_language) {
		this.sp_language = sp_language;
	}

	public SP_Gallery getGallery() {
		return gallery;
	}

	public void setGallery(SP_Gallery gallery) {
		this.gallery = gallery;
	}

	@Override
	public String toString() {
		return "SP_PublicInfo [spId=" + spId + ", birthdate=" + birthdate + ", countryISO=" + countryISO
				+ ", experience=" + experience + ", nickName=" + nickName + ", searchable=" + searchable
				+ ", description=" + description + ", state=" + state + ", veryfied=" + veryfied + ", work24hours="
				+ work24hours + ", serviceProvider=" + serviceProvider + ", sp_language=" + sp_language + ", gallery="
				+ gallery + "]";
	}	
}
