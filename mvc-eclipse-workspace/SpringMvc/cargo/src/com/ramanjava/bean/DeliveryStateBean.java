package com.ramanjava.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_ds_deliverystate")
public class DeliveryStateBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="delivery_stateId")
	private Integer deliverySateId;
	
	@Column(name="delivery_stateName")
	private String deliveryStateName;
	
	@Column(name="delivery_stateCode")
	private String deliveryStateCode;

	public Integer getDeliverySateId() {
		return deliverySateId;
	}

	public void setDeliverySateId(Integer deliverySateId) {
		this.deliverySateId = deliverySateId;
	}

	public String getDeliveryStateName() {
		return deliveryStateName;
	}

	public void setDeliveryStateName(String deliveryStateName) {
		this.deliveryStateName = deliveryStateName;
	}

	public String getDeliveryStateCode() {
		return deliveryStateCode;
	}

	public void setDeliveryStateCode(String deliveryStateCode) {
		this.deliveryStateCode = deliveryStateCode;
	}

	

}
