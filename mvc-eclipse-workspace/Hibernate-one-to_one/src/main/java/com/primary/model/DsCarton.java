package com.primary.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Columns;

@Entity(name="sharedPrimaryKeydsCartonEntity")
@Table(name="dsCarton",uniqueConstraints= 
		{@UniqueConstraint(columnNames="ID")})
public class DsCarton implements Serializable {
	
	private static final long serialVersionUID = -1798070786993154676L;

	 @Id
	 @Column(name="ID",unique=true,nullable=false)
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer cartonId;
	 
	 @Column(name="carton_no",nullable=false,length=10)
	 private Integer cartonNo;
	 
	 @Column(name="carton_weight",nullable=false,length=10)
	 private Integer weight;
	 
	 @Column(name="quentity",nullable=false,length=10)
	 private Integer qty;

	 @Column(name="item_name",nullable=false,length=50)
	 private String itemName;
	 
	 @OneToOne(cascade=CascadeType.ALL)
	 @PrimaryKeyJoinColumn
	 private DsInvoice invoice;

	public Integer getCartonId() {
		return cartonId;
	}

	public void setCartonId(Integer cartonId) {
		this.cartonId = cartonId;
	}

	public Integer getCartonNo() {
		return cartonNo;
	}

	public void setCartonNo(Integer cartonNo) {
		this.cartonNo = cartonNo;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public DsInvoice getInvoice() {
		return invoice;
	}

	public void setInvoice(DsInvoice invoice) {
		this.invoice = invoice;
	}

	 
	 


}
