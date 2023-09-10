package com.college.dao;

import java.util.List;

import com.college.pojo.Staff;

public interface StaffInterface {
	public Staff saveStaff(Staff staff);

	//public List<Staff> getStaffList();

	// public static List<Staff> getStaffList();

	public List<Staff> saveStaffList(List<Staff> staffList);

	public boolean isStaffExist(Staff staff);

	public Staff updateStaff(Staff staff, int id);

	public void deleteStaff(Staff Staff);

	public boolean disableStaff(int disable, int id);

	public boolean isStaffEnable(int id, int isEnable);

}
