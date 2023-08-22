package com.college.pojo;

public class Student {

	private int id;
	private String firstName;
	private String lastName;
	private int rollNo;
	private String sem;
    private int attends;
	private String subject;
	private int phoneNo;
	private int aadhrNo;
	private int marks;
	private int isEnable;
	private int clgId;
	private int deptId;
	private String courseId;
	private int addId;
	private Address address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public int getAttends() {
		return attends;
	}
	public void setAttends(int attends) {
		this.attends = attends;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getAadhrNo() {
		return aadhrNo;
	}
	public void setAadhrNo(int aadhrNo) {
		this.aadhrNo = aadhrNo;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}
	public int getClgId() {
		return clgId;
	}
	public void setClgId(int clgId) {
		this.clgId = clgId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", rollNo=" + rollNo
				+ ", sem=" + sem + ", attends=" + attends + ", subject=" + subject + ", phoneNo=" + phoneNo
				+ ", aadhrNo=" + aadhrNo + ", marks=" + marks + ", isEnable=" + isEnable + ", clgId=" + clgId
				+ ", deptId=" + deptId + ", courseId=" + courseId + ", addId=" + addId + ", address=" + address + "]";
	}
	
	
}
