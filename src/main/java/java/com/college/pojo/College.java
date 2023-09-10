package com.college.pojo;

public class College {
	private int collegeId;
	private String collegeName;
	private int fees;
	private int numberOfStaffs;
    private int addreId;
	private int studId;
	private int deptId;
	private int isEnable;
	

	public College() {
		super();

	}


	public College(int collegeId, String collegeName, int fees, int numberOfStaffs, int addreId, int studId, int deptId,
			int isEnable) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.fees = fees;
		this.numberOfStaffs = numberOfStaffs;
		this.addreId = addreId;
		this.studId = studId;
		this.deptId = deptId;
		this.isEnable = isEnable;
	}


	public int getCollegeId() {
		return collegeId;
	}


	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}


	public String getcollegeName() {
		return collegeName;
	}


	public void setcollegeName(String collegeName) {
		this.collegeName = collegeName;
	}


	public int getFees() {
		return fees;
	}


	public void setFee(int fees) {
		this.fees = fees;
	}


	public int getNumberOfStaffs() {
		return numberOfStaffs;
	}


	public void setNumberOfStaffs(int numberOfStaffs) {
		this.numberOfStaffs = numberOfStaffs;
	}


	public int getAddreId() {
		return addreId;
	}


	public void setAddreId(int addreId) {
		this.addreId = addreId;
	}


	public int getStudId() {
		return studId;
	}


	public void setStudId(int studId) {
		this.studId = studId;
	}


	public int getDeptId() {
		return deptId;
	}


	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}


	public int getIsEnable() {
		return isEnable;
	}


	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}


	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", fees=" + fees + ", numberOfStaffs="
				+ numberOfStaffs + ", addreId=" + addreId + ", studId=" + studId + ", deptId=" + deptId + ", isEnable="
				+ isEnable + "]";
	}



	

}
