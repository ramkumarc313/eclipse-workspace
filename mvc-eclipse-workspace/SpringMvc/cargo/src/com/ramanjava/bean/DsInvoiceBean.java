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
@Table(name="ds_invoice")
public class DsInvoiceBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="invoice_Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int invoiceId;
	
	@Column(name="invoice_no")
	private String invoiceNo;
	
	@Column(name="shipper_name")
	private String shipperName;
	
	@Column(name="shipper_address")
	private String shipperAddress;
	
	@Column(name="shipper_mobile")
	private String shipperMobile;
	
	@Column(name="receiver_name")
	private String receiverName;
	
	@Column(name="receiver_address")
	private String receiverAddress;
	
	@Column(name="receiver_mobile")
	private String receiverMobile;
	
	@OneToOne
	@JoinColumn(name="delivery_stateId")
	private DeliveryStateBean dsState;
	
	@Column(name="district_name")
	private DistrictBean district;

	public DistrictBean getDistrict() {
		return district;
	}

	public void setDistrict(DistrictBean district) {
		this.district = district;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	public String getShipperAddress() {
		return shipperAddress;
	}

	public void setShipperAddress(String shipperAddress) {
		this.shipperAddress = shipperAddress;
	}

	public String getShipperMobile() {
		return shipperMobile;
	}

	public void setShipperMobile(String shipperMobile) {
		this.shipperMobile = shipperMobile;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public DeliveryStateBean getDsState() {
		return dsState;
	}

	public void setDsState(DeliveryStateBean dsState) {
		this.dsState = dsState;
	}

	

	



}
