package com.clg.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clg.connection.DBConnection;
import com.college.dao.CourseInterface;
import com.college.pojo.Address;
import com.college.pojo.Course;
import com.college.pojo.Department;
import com.college.pojo.Staff;

public class CourseImpl implements CourseInterface {
	private static final String getAllCourse = "select * from coures";
	private static final String saveCourse = "insert into coures (id,name,fee, Duration, clg_id,stud_id,is_enable) values(?,?,?,?,?,?,?,)";
	public static final String getUpdateCourse = "Update  coures set name=? where id=? ";
	public static final String getDeleteCourse = "delete from coures where id=?";
	public static final String getDisableCourse = "update coures set is_enable =? where id =?";
	public static final String getIsEnableCourse = "select * from coures where id=?  and is_enable=?";

	
	
	public static List<Course> getCourseList() {
		List<Course> courseList = new ArrayList<Course>();
		Connection conn = null;
		String sql = "select * from course";
		Address address = null;
		Statement st = null;/// PreparedStatment,Callable
		ResultSet rs = null;
		Course course =null;

		try {
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			courseList = new ArrayList<Course>();

			while (rs.next()) {
				course = new Course();
				
				course.setId(rs.getInt("id"));
				course.setName(rs.getString("name"));
				course.setFee(rs.getDouble("fee"));
				course.setDuration(rs.getInt("Duration"));
				course.setClgId(rs.getInt("clg_id"));
				course.setStudId(rs.getInt("stud_id"));
				course.setIsEnable(rs.getInt("is_enable"));
				courseList.add(course);

			}

			for (Course c : courseList) {

				// if (c.getCourseId() == 13)
				System.out.println("Course are:" + c);
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

		return courseList;
	}

	
	@Override
	public Course saveCourse(Course course) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		int pos = 0;

		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			preSts = conn.prepareStatement(saveCourse, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, course.getId());
			preSts.setString(++pos, course.getName());
			preSts.setInt(++pos, course.getClgId());
			preSts.setInt(++pos, course.getStudId());
			preSts.setInt(++pos, course.getDuration());
			preSts.setInt(++pos, course.getStaffId());
            preSts.setInt(++pos, course.getIsEnable());
			result = preSts.executeUpdate();
			if (result > 0) {
				conn.commit();
				System.out.println(course.getName() + " inserted into  DB with " + course.getId());
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

		
		return course;
	}

	@Override
	public List<Course> saveCourseList(List<Course> collegeList) {
		return collegeList;

		
	}

	@Override
	public boolean isCourseExist(Course course) {
		boolean result = false;

		List<Course> courseList = null;

		try {
			courseList = getCourseList();

			for (Course c : courseList) {

				if (c.getId() == course.getId() && c.getName().equalsIgnoreCase(course.getName())) {

					result = true;

					System.out.println("Course with course Id " + course.getId() + " is already Exist ");
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;

	}

	@Override
	public Course updateCourse(Course course, int id) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		// int pos=0;
		try {
			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getUpdateCourse, preSts.RETURN_GENERATED_KEYS);
			preSts.setString(1, course.getName());
			preSts.setInt(2, id);
			result = preSts.executeUpdate();
			System.out.println(course.getName() + " Table is updated in " + id);

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

		return course;

	}

	@Override
	public void deleteCourse(Course course) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		int pos = 0;
		try {

			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getDeleteCourse, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, course.getId());
			result = preSts.executeUpdate();
			System.out.println(course.getId() + " deleted with DB ");
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
	public boolean disableCourse(int disable, int id) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		int pos = 0;
		try {
			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getDisableCourse, preSts.RETURN_GENERATED_KEYS);
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
	public boolean isCourseEnable(int id, int isEnable) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement preSts = null;
		int result = 0;
		int pos = 0;
		ResultSet rs = null;
		try {

			con = DBConnection.getConnection();
			preSts = con.prepareStatement(getIsEnableCourse, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, id);
			preSts.setInt(++pos, isEnable);

			rs = preSts.executeQuery();

			if (rs.next()) {
				flag = true;
				System.out.println(" Course is Active " + id);
			} else {
				System.out.println("Course is not Active " + id);
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
