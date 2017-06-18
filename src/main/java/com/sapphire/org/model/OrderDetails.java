package com.sapphire.org.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ORDERDETAILS")
public class OrderDetails extends BaseModel{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDER_ID")
	private Integer orderNo;
	@Column(name="ITEM_QTY")
	private Integer orderItemQty;
	@Column(name="ITEM_SELL_PRC")
	private Double orderItemSellPrc;
	@Column(name="ITEM_NET_PRC")
	private Double orderItemNetPrc;
	@Column(name="ITEM_VAT")
	private Double orderItemVatAmt;
	@Column(name="ITEM_GROSS_PRC")
	private Double orderItemGrossPrc;
	@Column(name="ITEM_DISC_AMT")
	private Double orderItemDisc;
	@Column(name="ORDER_DATE")
	private Date orderDate;
	@Column(name="DELETED")
	private String isDeleted;
	@Transient
	private Items item;
	
	
	public OrderDetails(Items item){
		this.item = item;
	}
	

	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getOrderItemQty() {
		return orderItemQty;
	}
	public void setOrderItemQty(Integer orderItemQty) {
		this.orderItemQty = orderItemQty;
	}
	public Double getOrderItemSellPrc() {
		return orderItemSellPrc;
	}
	public void setOrderItemSellPrc(Double orderItemSellPrc) {
		this.orderItemSellPrc = orderItemSellPrc;
	}
	public Double getOrderItemNetPrc() {
		return orderItemNetPrc;
	}
	public void setOrderItemNetPrc(Double orderItemNetPrc) {
		this.orderItemNetPrc = orderItemNetPrc;
	}
	
	public Double getOrderItemVatAmt() {
		return orderItemVatAmt;
	}

	public void setOrderItemVatAmt(Double orderItemVatAmt) {
		this.orderItemVatAmt = orderItemVatAmt;
	}

	public Double getOrderItemGrossPrc() {
		return orderItemGrossPrc;
	}
	public void setOrderItemGrossPrc(Double orderItemGrossPrc) {
		this.orderItemGrossPrc = orderItemGrossPrc;
	}
	public Double getOrderItemDisc() {
		return orderItemDisc;
	}
	public void setOrderItemDisc(Double orderItemDisc) {
		this.orderItemDisc = orderItemDisc;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	public Items getItem() {
		return item;
	}
	public void setItem(Items item) {
		this.item = item;
	}
	

	
	
	
	
	
	
	
	

	

}
