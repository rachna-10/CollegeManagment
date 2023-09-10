package com.college.dao;


import java.util.List;

import com.college.pojo.Address;



public interface AddressInterface {
	public int saveAddress(Address address);
	
	public List<Address> getAddressList();
	
	

	// public static List<Address> getAddressList();

	public List<Address> saveAddressList(List<Address> list);

	public boolean isAddressExist(Address address);

	public Address updateAddress(Address address, int id, String state);

	public void deleteAddress(Address address);

	public boolean disableAddress(int disable, int id);

	public boolean isAddressEnable( int id, int isEnable);
	 



}
