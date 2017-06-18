package com.sapphire.org.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Items {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ITEM_ID")
	private  Integer itemId;
	@Column(name="ITEM_BARCODE")
	private  String itemBrcd;
	@Column(name="ITEM_NAME")
	private  String itemDesc;
	@Column(name="ITEM_TYPE")
	private  String itemType;
	@Column(name="ITEM_QTY_TOTAL")
	private  Integer itemQtyTotal;
	@Column(name="ITEM_QTY_PEND")
	private  Integer itemQtyPend;
	@Column(name="ITEM_RATE")
	private  Double itemRate;
	@Column(name="ITEM_VAT_PERC")
	private  Double itenVat;
	@Column(name="CREATED_USER")
	private  Integer createdUser;
	@Column(name="CREATED_TIMESTAMP")
	private  String createdTimeStamp;
	@Column(name="MODIFIED_USER")
	private  Integer modifiedUser;
	@Column(name="MODIFIED_TIMESTAMP")
	private  String  modifiedTimeStamp;
	@Column(name="DELETED")
	private  String  isDeleted;
	
	
	
	
	
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemBrcd() {
		return itemBrcd;
	}
	public void setItemBrcd(String itemBrcd) {
		this.itemBrcd = itemBrcd;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public Integer getItemQtyTotal() {
		return itemQtyTotal;
	}
	public void setItemQtyTotal(Integer itemQtyTotal) {
		this.itemQtyTotal = itemQtyTotal;
	}
	public Integer getItemQtyPend() {
		return itemQtyPend;
	}
	public void setItemQtyPend(Integer itemQtyPend) {
		this.itemQtyPend = itemQtyPend;
	}
	public Double getItemRate() {
		return itemRate;
	}
	public void setItemRate(Double itemRate) {
		this.itemRate = itemRate;
	}
	public Double getItenVat() {
		return itenVat;
	}
	public void setItenVat(Double itenVat) {
		this.itenVat = itenVat;
	}
	public Integer getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(Integer createdUser) {
		this.createdUser = createdUser;
	}
	public String getCreatedTimeStamp() {
		return createdTimeStamp;
	}
	public void setCreatedTimeStamp(String createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}
	public Integer getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(Integer modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public String getModifiedTimeStamp() {
		return modifiedTimeStamp;
	}
	public void setModifiedTimeStamp(String modifiedTimeStamp) {
		this.modifiedTimeStamp = modifiedTimeStamp;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	
	public Property getStringProperty(String _strObj) {
		return new SimpleStringProperty(_strObj);
	}
	public Property getIntegerProperty(Integer _intObj) {
		return new SimpleIntegerProperty(_intObj);		
	}
	public Property getDoubleProperty(Double _dbObj) {
		return new SimpleDoubleProperty(_dbObj);		
	}
	
}
