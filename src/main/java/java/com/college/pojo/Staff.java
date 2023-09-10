

 package com.college.pojo;

public class Staff {
	private int id;
	private String name;
	private String position;
	private int experience;
	private double salary;
	private int deptId;
	private int clgId;
	private int isEnable;
	private String qulification;
	
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff(int id, String name, String position, int experience, double salary, int deptId, int clgId,
			int isEnable, String qulificatoin) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.experience = experience;
		this.salary = salary;
		this.deptId = deptId;
		this.clgId = clgId;
		this.isEnable = isEnable;
		this.qulification = qulification;
	}
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public int getClgId() {
		return clgId;
	}
	public void setClgId(int clgId) {
		this.clgId = clgId;
	}
	public int getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}
	
	public String getQulification() {
		return qulification;
	}
	public void setQulification(String qulification) {
		this.qulification = qulification;
	}
	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + ", position=" + position + ", experience=" + experience
				+ ", salary=" + salary + ", deptId=" + deptId + ", clgId=" + clgId + ", isEnable=" + isEnable + ", qulification=" + qulification +"]";
	}
	
	

}
