package com.MoonLikeCats.model;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="serviceProvider")
@PrimaryKeyJoinColumn(name="userId")
public class ServiceProvider extends User{
	
	private String fullName;
	private String icNumber;
	private Blob icPicture;
	
	@OneToOne(mappedBy = "serviceProvider", cascade=CascadeType.ALL)
	private SP_PublicInfo sp_publicInfo;
	
	public ServiceProvider() {
		
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIcNumber() {
		return icNumber;
	}

	public void setIcNumber(String icNumber) {
		this.icNumber = icNumber;
	}

	public Blob getIcPicture() {
		return icPicture;
	}

	public void setIcPicture(Blob icPicture) {
		this.icPicture = icPicture;
	}
	
	public SP_PublicInfo getSp_publicInfo() {
		return sp_publicInfo;
	}

	public void setSp_publicInfo(SP_PublicInfo sp_publicInfo) {
		this.sp_publicInfo = sp_publicInfo;
	}
	@Override
	public String toString() {
		return "ServiceProvider [fullName=" + fullName + ", icNumber=" + icNumber + ", icPicture=" + icPicture + "]";
	}
	
}
