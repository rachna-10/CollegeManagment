package com.college.dao;

import java.util.List;

import com.college.pojo.Address;
import com.college.pojo.Course;

public interface CourseInterface {
	public Course saveCourse(Course course);
	
	//public List<Course> getCourseList();

	 //public static List<Course> getCourseList() ;

	public List<Course> saveCourseList(List<Course> collegeList);

	public boolean isCourseExist(Course course);

	public Course updateCourse(Course course, int id);

	public void deleteCourse(Course course);

	public boolean disableCourse(int disable, int id);

	public boolean isCourseEnable(int id, int isEnable);

}
