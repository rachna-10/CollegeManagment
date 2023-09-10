package com.college.dao;

import java.util.List;

import com.college.pojo.*;





public interface CollegeInterface {
	public College saveCollege(College college);
	
	//public List<College> getCollegeList();

	// public static List<College> getCollegeList();

	public List<College> saveCollegeList(List<College> collegeList);

	public boolean isCollegeExist(College college);

	public College updateCollege(College college, int id);

	public void deleteCollege(College college);

	public boolean disableCollege(int disable, int id);

	public boolean isCollegeEnable(int id, int isEnable);

}
