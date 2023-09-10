package com.college.dao;

import java.util.List;

import com.college.pojo.Student;



public interface StudentInterface {
	public Student saveStudent(Student student);

//	public  List<Student> getStudentList();

	// public static List<Student> getStudentList();

	public List<Student> saveStudentList(List<Student> studentList);

	public boolean isStudentExist(Student student);

	public Student updateStudent(Student student, int id);

	public void deleteStudent(Student student);

	public boolean disableStudent(int disable, int id);

	public boolean isStudentEnable(int id, int isEnable);


}
