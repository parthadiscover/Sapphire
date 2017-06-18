package com.sapphire.org.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Order extends BaseModel{
	
	

	@Column(name="ORDER_ID")
	private String orderNo;
	@Column(name="ORDER_GROSS_AMT")
	private Double orderGrossAmt;
	@Column(name="ORDER_GROSS_VAT")
	private Double orderGrossVat;
	@Column(name="ORDER_DATE")
	private Date orderDate;
	@Column(name="COMMENTS")
	private String comments;
	@Column(name="ORDER_COMPLETED")
	private String isOrderCompleted;
	@Column(name="DELETED")
	private String isDeleted;
}
