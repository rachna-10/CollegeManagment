package com.main;

import com.clg.impl.AddressImpl;
import com.clg.impl.CollegeImpl;
import com.clg.impl.CourseImpl;
import com.clg.impl.DepartmentImpl;
import com.clg.impl.StaffImpl;
import com.clg.impl.StudentImpl;
import com.college.pojo.Address;
import com.college.pojo.College;
import com.college.pojo.Course;
import com.college.pojo.Department;
import com.college.pojo.Staff;
import com.college.pojo.Student;

public class CollegeMain {
	public static void main(String[] args) {

		Student s1 = new Student();
		s1.setId(1);
		s1.setFirstName("Riya");
		s1.setLastName("Mehar");
		s1.setRollNo(61);
		s1.setSem("3rd");
		s1.setAttends(75);
		s1.setAadhrNo(223344);
		s1.setMarks(60);
		s1.setIsEnable(0);
		s1.setCourseId("3");
		s1.setPhoneNo(999999999);
		s1.setClgId(1);

		Student s2 = new Student();
		s2.setId(22);
		s2.setFirstName("Rahul");
		s2.setLastName("Hatwar");
		s2.setRollNo(62);
		s2.setSem("4th");
		s2.setAttends(79);
		s2.setAadhrNo(44223344);
		s2.setMarks(70);
		s2.setIsEnable(1);
		s2.setCourseId("2");
		s2.setPhoneNo(8888888);
		s2.setClgId(2);

		StudentImpl impl = new StudentImpl();
		// impl.saveStudent(s2);
		// impl.disableStudent(0, 1);
		// impl.deleteStudent(s2);
		// impl.isStudentEnable(10, 0);
		// impl.saveStudentList(null);
		// impl.updateStudent(s2, 11);
		//impl.getStudentList();

		
		
		Address add = new Address();
		add.setFlatNumber(888);
		add.setDistrict("HAdpasar");
		add.setState("Maharashtra");
		add.setCity("Pune");
		add.setCountry("India");
		add.setLandmark("shitalwadi");
		add.setPinCode(441106);
		add.setIsEnable(1);

		Address address = new Address();
		// address.setAddressId(21);
		address.setFlatNumber(120);
		address.setDistrict("Nagpur");
		address.setState("Maharashtra");
		address.setCity("Ramtek");
		address.setCountry("India");
		address.setLandmark("T point");
		address.setPinCode(441106);

		Address ad = new Address();
		ad.setAddressId(1);
		ad.setDistrict("Haridwar");
		ad.setCity("Haridwar");
		ad.setLandmark("Shanti park");

		AddressImpl a = new AddressImpl();
		// a.saveAddress(address);
		// a.getAddressList();
		// a.updateAddress(add, 1, null);
		// a.deleteAddress(ad);
		// a.disableAddress(0, 7);
		// a.isAddressEnable(4, 0);
		// a.isAddressExist(ad);

		
		
		Department d = new Department();
		d.setId(11);
		d.setName("EE");
		d.setNumberOfStaff(50);
		d.setClgId(5);
		d.setCourseId(5);
		d.setIsEnable(1);
		d.setStudId(1);

		Department d1 = new Department();
		d1.setName("ME");

		DepartmentImpl dept = new DepartmentImpl();
		// dept.saveDepartment(d);
		// dept.updateDepartment(d1, 1);
		// dept.deleteDepartment(d);
		// dept.disableDepartment(0, 2);
		// dept.isDepartmentEnable(6, 1);
		// dept.isDepartmentExist(d1);
		// dept.saveDepartmentList(null);
		//dept.getDepartmentList();

		
		
		College c = new College();
		c.setCollegeId(11);
		c.setcollegeName("COEP");
		c.setFee(90000);
		c.setAddreId(2);
		c.setDeptId(4);
		c.setStudId(5);
		c.setIsEnable(0);

		College cl = new College();
		// cl.setCollegeId(41);
		cl.setcollegeName("kits");

		CollegeImpl clg = new CollegeImpl();
		// clg.saveCollege(c);
		// clg.updateCollege(cl, 1);
		// clg.deleteCollege(c);
		// clg.disableCollege(0, 10);
		// clg.isCollegeEnable(3, 0);
		// clg.isCollegeExist(cl);
		//clg.getCollegeList();

		
		
		Staff s = new Staff();
		s.setId(9);
		s.setName("Mr.Deshmukha");
		s.setExperience(10);
		s.setPosition("lecture");
		s.setSalary(67000);
		s.setQulification("Diploma,B.Tech");
		s.setClgId(7);
		s.setDeptId(6);
		s.setIsEnable(0);

		Staff st = new Staff();

		st.setName("Miss.Rane");

		StaffImpl staff = new StaffImpl();
		// staff.saveStaff(s);
		// staff.updateStaff(st, 2);
		// staff.deleteStaff(s);
		// staff.disableStaff(0, 6);
		// staff.isStaffEnable(4, 0);
		// staff.isStaffExist(s);
		//staff.getStaffList();

		
		
		
		Course course = new Course();
		course.setId(10);
		course.setName("BA");
		course.setDuration(4);
		course.setFee(50000);
		course.setClgId(1);
		course.setIsEnable(0);
		course.setStaffId(3);
		course.setStudId(4);

		CourseImpl cimpl = new CourseImpl();
		// cimpl.disableCourse(0, 1);
		// cimpl.getCourseList();
	}

}
