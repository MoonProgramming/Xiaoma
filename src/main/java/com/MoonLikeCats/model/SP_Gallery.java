package com.MoonLikeCats.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="gallery")
public class SP_Gallery {
	
	@Id
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="sp_publicInfo"))
	private int spId;
	private Blob galleryPic1;
	private Blob galleryPic2;
	private Blob galleryPic3;
	private Blob galleryPic4;
	private Blob galleryPic5;
	private Blob galleryPic6;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private SP_PublicInfo sp_publicInfo;

	public SP_Gallery() {
		// TODO Auto-generated constructor stub
	}

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public Blob getGalleryPic1() {
		return galleryPic1;
	}

	public void setGalleryPic1(Blob galleryPic1) {
		this.galleryPic1 = galleryPic1;
	}

	public Blob getGalleryPic2() {
		return galleryPic2;
	}

	public void setGalleryPic2(Blob galleryPic2) {
		this.galleryPic2 = galleryPic2;
	}

	public Blob getGalleryPic3() {
		return galleryPic3;
	}

	public void setGalleryPic3(Blob galleryPic3) {
		this.galleryPic3 = galleryPic3;
	}

	public Blob getGalleryPic4() {
		return galleryPic4;
	}

	public void setGalleryPic4(Blob galleryPic4) {
		this.galleryPic4 = galleryPic4;
	}

	public Blob getGalleryPic5() {
		return galleryPic5;
	}

	public void setGalleryPic5(Blob galleryPic5) {
		this.galleryPic5 = galleryPic5;
	}

	public Blob getGalleryPic6() {
		return galleryPic6;
	}

	public void setGalleryPic6(Blob galleryPic6) {
		this.galleryPic6 = galleryPic6;
	}

	public SP_PublicInfo getSp_publicInfo() {
		return sp_publicInfo;
	}

	public void setSp_publicInfo(SP_PublicInfo sp_publicInfo) {
		this.sp_publicInfo = sp_publicInfo;
	}

	@Override
	public String toString() {
		return "Gallery [spId=" + spId + ", galleryPic1=" + galleryPic1 + ", galleryPic2=" + galleryPic2
				+ ", galleryPic3=" + galleryPic3 + ", galleryPic4=" + galleryPic4 + ", galleryPic5=" + galleryPic5
				+ ", galleryPic6=" + galleryPic6 + ", sp_publicInfo=" + sp_publicInfo + "]";
	}
}
