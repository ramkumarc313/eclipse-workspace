package com.ramanjava.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ds_carton")
public class DsCartonBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="carton_id")
	private Integer cartonId;
	
	@Column(name="carton_no")
	private Integer cartonNo;
	
	@Column(name="weight")
	private Double weight;
	
	@OneToOne
	@JoinColumn(name="invoice_Id")
	private DsInvoiceBean dsInvoice;
	
	
	@Column(name="itemType")
	private String itemType;


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


	public Double getWeight() {
		return weight;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
	}


	public DsInvoiceBean getDsInvoice() {
		return dsInvoice;
	}


	public void setDsInvoice(DsInvoiceBean dsInvoice) {
		this.dsInvoice = dsInvoice;
	}


	public String getItemType() {
		return itemType;
	}


	public void setItemType(String itemType) {
		this.itemType = itemType;
	}


	
	

}
