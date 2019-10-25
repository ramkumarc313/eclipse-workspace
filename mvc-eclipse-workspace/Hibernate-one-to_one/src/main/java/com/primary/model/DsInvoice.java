package com.primary.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name="sharedPrimaryKeydsInvoiceEntity")
@Table(name="dsInvoice",uniqueConstraints= {@UniqueConstraint(columnNames="ID")})

public class DsInvoice implements Serializable {
	
	private static final long serialVersionUID = -6790693372846798580L;

	
	@Id
	@Column(name="ID",unique=true,nullable=false)
	@GeneratedValue(generator="gen1")
	@GenericGenerator(name="gen1",strategy="foreign",parameters=@Parameter(name="property", value="carton"))
	private Integer invoiceId;
	
	@Column(name="invoice_no",unique=true,nullable=false,length=15)
	private String invoiceNo;
	
	@Column(name="shipper",unique=true,nullable=false,length=15)
	private String shipper;

	@Column(name="consignee",unique=true,nullable=false,length=15)
	private String consignee;

	@Column(name="state",unique=true,nullable=false,length=15)
	private String state;
	
	@OneToOne(mappedBy="invoice",cascade=CascadeType.ALL)
	private DsCarton carton;

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getShipper() {
		return shipper;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public DsCarton getCarton() {
		return carton;
	}

	public void setCarton(DsCarton carton) {
		this.carton = carton;
	}

	
	
	
	

}
