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
@Table(name="ds_cartonitemdetails")
public class DsCartonItemBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cartonitem_id")
	private Integer cartonItemid;
	
	@Column(name="carton_itemname")
	private String cartonItemName;
	
	@Column(name="quantity")
	private Integer quantity;	
	
	@Column(name="goods_value")
	private double goodsValue;	
	
	@OneToOne
	@JoinColumn(name="carton_id")
	private DsCartonBean dsCarton;
	
	
	public Integer getCartonItemid() {
		return cartonItemid;
	}

	public void setCartonItemid(Integer cartonItemid) {
		this.cartonItemid = cartonItemid;
	}

	public String getCartonItemName() {
		return cartonItemName;
	}

	public void setCartonItemName(String cartonItemName) {
		this.cartonItemName = cartonItemName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getGoodsValue() {
		return goodsValue;
	}

	public void setGoodsValue(double goodsValue) {
		this.goodsValue = goodsValue;
	}

	public DsCartonBean getDsCarton() {
		return dsCarton;
	}

	public void setDsCarton(DsCartonBean dsCarton) {
		this.dsCarton = dsCarton;
	}


	

}
