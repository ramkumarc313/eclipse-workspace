package com.spring.springajaxintegration.persistence.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "COUNTRY")
public class CountryEntity implements Serializable {

	private static final long serialVersionUID = -6632368072306224997L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false, length = 5)
	private Long countryId;

	@Column(unique = true, length = 2)
	private String countryCode;

	@Column(unique = true, nullable = false, length = 80)
	private String countryName;

	@Column(unique = true, nullable = false, length = 80)
	private String longName;

	@Column(unique = false, nullable = true, length = 5)
	private String iso3;

	@Column(nullable = false, length = 6)
	private String numCode;

	@Column(nullable = false, length = 12)
	private String unNumber;

	@Column(nullable = false, length = 8)
	private String callingCode;

	@Column(nullable = false, length = 5)
	private String cctld;
	
	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getLongName() {
		return longName;
	}

	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public String getNumCode() {
		return numCode;
	}

	public void setNumCode(String numCode) {
		this.numCode = numCode;
	}

	public String getUnNumber() {
		return unNumber;
	}

	public void setUnNumber(String unNumber) {
		this.unNumber = unNumber;
	}

	public String getCallingCode() {
		return callingCode;
	}

	public void setCallingCode(String callingCode) {
		this.callingCode = callingCode;
	}

	public String getCctld() {
		return cctld;
	}

	public void setCctld(String cctld) {
		this.cctld = cctld;
	}
}