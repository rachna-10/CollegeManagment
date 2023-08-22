package com.college.pojo;

public class Course {

	private int courseId;
	private String name;
	private int departmentId;
	private String staffId;
	private int duration;
	private int credit;
	private boolean isEnable;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", departmentId=" + departmentId + ", staffId="
				+ staffId + ", duration=" + duration + ", credit=" + credit + ", isEnable=" + isEnable + "]";
	}

}
