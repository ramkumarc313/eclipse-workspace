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
@Table(name="ds_district")
public class DistrictBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="district_id")
	private Integer districtId;
	
	@Column(name="district_name")
	private String districtName;
	
	@Column(name="district_code")
	private String districtCode;
	

	@OneToOne
	@JoinColumn(name="delivery_stateId")
	private DeliveryStateBean dsState;

	
	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public DeliveryStateBean getDsState() {
		return dsState;
	}

	public void setDsState(DeliveryStateBean dsState) {
		this.dsState = dsState;
	}


}
