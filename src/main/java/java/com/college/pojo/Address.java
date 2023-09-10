package com.college.pojo;

public class Address {

	private int addressId;
	private int flatNumber;
	private String landmark;
	private String city;
	private String district;
	private String state;
	private int pinCode;
	private String country;
	private int isEnable;
	
	public Address() {
		super();
	
	}

	public Address(int addressId, int flatNumber, String landmark, String city, String district, String state,
			int pinCode, String country, int isEnable) {
		super();
		this.addressId = addressId;
		this.flatNumber = flatNumber;
		this.landmark = landmark;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pinCode = pinCode;
		this.country = country;
		this.isEnable = isEnable;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", flatNumber=" + flatNumber + ", landmark=" + landmark + ", city="
				+ city + ", district=" + district + ", state=" + state + ", pinCode=" + pinCode + ", country="
				+ country + ", isEnable=" + isEnable + "]";
	}
	
}
