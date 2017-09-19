package com.MoonLikeCats.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="sp_language")
public class SP_Language {

	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="sp_publicInfo"))
	private int spId;
	private String mandarin;
	private String cantonese;
	private String english;
	private String hakka;
	private String hokien;
	private String malay;
	private String others;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private SP_PublicInfo sp_publicInfo;
	
	public SP_Language() {
		
	}

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public String getMandarin() {
		return mandarin;
	}

	public void setMandarin(String mandarin) {
		this.mandarin = mandarin;
	}

	public String getCantonese() {
		return cantonese;
	}

	public void setCantonese(String cantonese) {
		this.cantonese = cantonese;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getHakka() {
		return hakka;
	}

	public void setHakka(String hakka) {
		this.hakka = hakka;
	}

	public String getHokien() {
		return hokien;
	}

	public void setHokien(String hokien) {
		this.hokien = hokien;
	}

	public String getMalay() {
		return malay;
	}

	public void setMalay(String malay) {
		this.malay = malay;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public SP_PublicInfo getSp_publicInfo() {
		return sp_publicInfo;
	}

	public void setSp_publicInfo(SP_PublicInfo sp_publicInfo) {
		this.sp_publicInfo = sp_publicInfo;
	}

	@Override
	public String toString() {
		return "SP_Language [spId=" + spId + ", mandarin=" + mandarin + ", cantonese=" + cantonese + ", english="
				+ english + ", hakka=" + hakka + ", hokien=" + hokien + ", malay=" + malay + ", others=" + others
				+ ", sp_publicInfo=" + sp_publicInfo + "]";
	}

}
