package com.college.pojo;

public class Course {
private int id;
private String name;
private double fee;
private int staffId;
private int duration;
private int clgId;
private int studId;
private int isEnable;

public Course() {
	super();
	
}
public Course(int id, String name, double fee, int staffId, int duration, int clgId, int studId, int isEnable) {
	super();
	this.id = id;
	this.name = name;
	this.fee = fee;
	this.staffId = staffId;
	this.duration = duration;
	this.clgId = clgId;
	this.studId = studId;
	this.isEnable = isEnable;
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
public double getFee() {
	return fee;
}
public void setFee(double fee) {
	this.fee = fee;
}
public int getStaffId() {
	return staffId;
}
public void setStaffId(int staffId) {
	this.staffId = staffId;
}

public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public int getClgId() {
	return clgId;
}
public void setClgId(int clgId) {
	this.clgId = clgId;
}
public int getStudId() {
	return studId;
}
public void setStudId(int studId) {
	this.studId = studId;
}
public int getIsEnable() {
	return isEnable;
}
public void setIsEnable(int isEnable) {
	this.isEnable = isEnable;
}
@Override
public String toString() {
	return "course [id=" + id + ", name=" + name + ", fee=" + fee + ", staffId=" + staffId + ", duration=" + duration
			+ ", clgId=" + clgId + ", studId=" + studId + ", isEnable=" + isEnable + "]";
}


}
