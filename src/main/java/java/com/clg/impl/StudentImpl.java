package com.clg.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clg.connection.DBConnection;
import com.college.dao.StudentInterface;
import com.college.pojo.Department;
import com.college.pojo.Student;

public class StudentImpl implements StudentInterface {
	private static final String getAllStudent = "select * from student";
	private static final String saveStudent = "insert into student (id,first_name,last_name,roll_no,attends,coures_id, phone_no, aadhr_no,is_enable) values(?,?,?,?,?,?,?,?,?)";
	public static final String getUpdateStudent = "Update  student set first_name=? where id=? ";
	public static final String getDeleteStudent = "delete from student where id=?";
	public static final String getDisableStudent = "update student set is_enable =? where id =?";
	public static final String getIsEnableStudent = "select * from student where id=?  and is_enable=?";

	public static List<Student> getStudentList() {
		List<Student> studentList = new ArrayList<Student>();

		Connection conn = null;
		// String sql = "select * from student";
		Statement st = null;
		ResultSet rs = null;
		

		try {
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(getAllStudent);
			Student student = null;
			while (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setRollNo(rs.getInt("roll_no"));
				student.setAttends(rs.getInt("attends"));
				student.setCourseId(rs.getString("coures_id"));
				student.setPhoneNo(rs.getInt("phone_no"));
				student.setAadhrNo(rs.getInt("aadhr_no"));
				student.setIsEnable(rs.getInt("is_enable"));

				studentList.add(student);

			}
			for (Student std : studentList) {
				// if (cust.getStudentId() == 5)
				System.out.println(std);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}

		return studentList;
	}

	@Override
	public Student saveStudent(Student student) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		int pos = 0;

		// String sql="insert into student
		// (id,first_name,last_name,roll_no,attends,coures_id, phone_no,
		// aadhr_no,is_enable) values(?,?,?,?,?,?,?,?,?)";
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			preSts = conn.prepareStatement(saveStudent, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, student.getId());
			preSts.setString(++pos, student.getFirstName());
			preSts.setString(++pos, student.getLastName());
			preSts.setInt(++pos, student.getRollNo());
			preSts.setDouble(++pos, student.getAttends());
			preSts.setString(++pos, student.getCourseId());
			preSts.setInt(++pos, student.getPhoneNo());
			preSts.setInt(++pos, student.getAadhrNo());
			preSts.setInt(++pos, student.getIsEnable());
			result = preSts.executeUpdate();
			if (result > 0) {
				conn.commit();
				System.out.println(student.getFirstName() + " inserted into  DB with " + student.getId());
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (preSts != null) {
				try {
					preSts.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}

		return student;
	}

	@Override
	public List<Student> saveStudentList(List<Student> studentList) {

		List<Student> studentList1 = new ArrayList<Student>();

		Connection conn = null;
		// String sql = "select * from student";
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(getAllStudent);
			Student student = null;
			while (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setRollNo(rs.getInt("roll_no"));
				student.setAttends(rs.getInt("attends"));
				student.setCourseId(rs.getString("coures_id"));
				student.setPhoneNo(rs.getInt("phone_no"));
				student.setAadhrNo(rs.getInt("aadhr_no"));
				student.setIsEnable(rs.getInt("is_enable"));

				studentList1.add(student);

			}
			for (Student std : studentList) {
				// if (cust.getStudentId() == 5)
				System.out.println(std);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}

		return studentList;
	}

	@Override
	public boolean isStudentExist(Student student) {
		boolean result = false;

		List<Student> studentList = null;

		try {
			studentList = getStudentList();

			for (Student std : studentList) {

				if (std.getId() == student.getId() && std.getFirstName().equalsIgnoreCase(student.getFirstName())) {

					result = true;

					// System.out.println("Address is exist" + address.getAddressId());

					System.out.println("Student with student Id " + student.getId() + " is already Exist ");
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;

	}

	@Override
	public Student updateStudent(Student student, int id) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		// String sql = "Update student set first_name=? where id=? ";
		// int pos=0;
		try {
			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getUpdateStudent, preSts.RETURN_GENERATED_KEYS);
			preSts.setString(1, student.getFirstName());
			preSts.setInt(2, id);
			result = preSts.executeUpdate();
			System.out.println(student.getFirstName() + " Table is updated in " + id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (preSts != null) {
				try {
					preSts.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}

		return student;

	}

	@Override
	public void deleteStudent(Student student) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		// String sql = "delete from student where id=?";
		int pos = 0;
		try {

			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getDeleteStudent, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, student.getId());
			result = preSts.executeUpdate();
			System.out.println(student.getId() + " deleted with DB ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (preSts != null) {
				try {
					preSts.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}

	}

	@Override
	public boolean disableStudent(int disable, int id) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		// String sql = "update student set is_enable =? where id =?";
		int pos = 0;
		try {
			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getDisableStudent, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, disable);
			preSts.setInt(++pos, id);
			result = preSts.executeUpdate();
			System.out.println("Table is updated in " + id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (preSts != null) {
				try {
					preSts.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}

		return false;
	}

	@Override
	public boolean isStudentEnable(int id, int isEnable) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement preSts = null;
		// String sql = "select * from student where id=? and is_enable=?";
		int result = 0;
		int pos = 0;
		ResultSet rs = null;
		try {

			con = DBConnection.getConnection();
			preSts = con.prepareStatement(getIsEnableStudent, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, id);
			preSts.setInt(++pos, isEnable);

			rs = preSts.executeQuery();

			if (rs.next()) {
				flag = true;
				System.out.println(" Student is Active " + id);
			} else {
				System.out.println("Student  is not Active " + id);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (preSts != null) {
				try {
					preSts.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		}
		return flag;
	}

}