package com.college.pojo;

public class Department {
	private int id;
	private String name;
	private int numberOfStaff;
	private int studId;
	private int clgId;
	private int courseId;
	//private int isEnable;
	//comment

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNumberOfStaff() {
		return numberOfStaff;
	}


	public void setNumberOfStaff(int numberOfStaff) {
		this.numberOfStaff = numberOfStaff;
	}


	public int getStudId() {
		return studId;
	}


	public void setStudId(int studId) {
		this.studId = studId;
	}


	public int getClgId() {
		return clgId;
	}


	public void setClgId(int clgId) {
		this.clgId = clgId;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public int getIsEnable() {
		return isEnable;
	}


	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}


	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", numberOfStaff=" + numberOfStaff + ", studId=" + studId
				+ ", clgId=" + clgId + ", courseId=" + courseId + ", isEnable=" + isEnable + "]";
	}
	

}
