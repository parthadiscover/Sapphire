package com.sapphire.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VENDOR")
public class Vendor {
	
	@Id
	@Column(name="VENDOR_ID")
	private  Long vid;
	@Column(name="VENDOR_NAME")
	private  String vname;
	@Column(name="VENDOR_ADDRESS")
	private  String vaddress;
	@Column(name="VENDOR_STATE")
	private  String vstate;
	@Column(name="VENDOR_PIN")
	private  String vpostalCode;
	@Column(name="VENDOR_CITY")
	private  String vcity;
	@Column(name="VENDOR_COMMENTS")
	private  String vcomments;
	
	public Vendor(){
		
	}

	public Vendor(String vname, String vaddress, String vstate, String vpostalCode, String vcity, String vcomments) {

		this.vname = vname;
		this.vaddress = vaddress;
		this.vstate = vstate;
		this.vpostalCode = vpostalCode;
		this.vcity = vcity;
		this.vcomments = vcomments;

	}



	public Long getVid() {
		return vid;
	}

	public void setVid(Long vid) {
		this.vid = vid;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getVaddress() {
		return vaddress;
	}

	public void setVaddress(String vaddress) {
		this.vaddress = vaddress;
	}

	public String getVstate() {
		return vstate;
	}

	public void setVstate(String vstate) {
		this.vstate = vstate;
	}

	public String getVpostalCode() {
		return vpostalCode;
	}

	public void setVpostalCode(String vpostalCode) {
		this.vpostalCode = vpostalCode;
	}

	public String getVcity() {
		return vcity;
	}

	public void setVcity(String vcity) {
		this.vcity = vcity;
	}

	public String getVcomments() {
		return vcomments;
	}

	public void setVcomments(String vcomments) {
		this.vcomments = vcomments;
	}

	

}
