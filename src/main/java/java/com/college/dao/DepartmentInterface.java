package com.college.dao;

import java.util.List;

import com.college.pojo.Department;



public interface DepartmentInterface {
	public Department saveDepartment(Department department);
	
	//public List<Department> getDepartmentList();

	// public static List<Department> getDepartmentList();

	public List<Department> saveDepartmentList(List<Department> departmentList);

	public boolean isDepartmentExist(Department department);

	public Department updateDepartment(Department department, int id);

	public void deleteDepartment(Department department);

	public boolean disableDepartment(int disable, int id);

	public boolean isDepartmentEnable(int id, int isEnable);


}
