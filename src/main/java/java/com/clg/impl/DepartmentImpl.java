package com.clg.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clg.connection.DBConnection;
import com.college.dao.DepartmentInterface;
import com.college.pojo.Department;

public class DepartmentImpl implements DepartmentInterface {
	private static final String getAllDepartment = "select * from department";
	private static final String saveDepartment = "insert into department (id,name,no_of_staff , stud_id,clg_id,is_enable) values(?,?,?,?,?,?)";
	public static final String getUpdateDepartment = "Update  department set name=? where id=? ";
	public static final String getDeleteDepartment = "delete from department where id=?";
	public static final String getDisableDepartment = "update department set is_enable =? where id =?";
	public static final String getIsEnableDepartment = "select * from department where id=?  and is_enable=?";

	public static List<Department> getDepartmentList() {
		List<Department> departmentList = new ArrayList<Department>();
		Connection conn = null;
		// String sql = "select * from department";
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(getAllDepartment);
			Department department = null;
			while (rs.next()) {
				department = new Department();
				department.setId(rs.getInt("id"));
				department.setName(rs.getString("name"));
				department.setNumberOfStaff(rs.getInt("no_of_staff"));
				department.setStudId(rs.getInt("stud_id"));
				department.setClgId(rs.getInt("clg_id"));
				department.setIsEnable(rs.getInt("is_enable"));
                departmentList.add(department);

			}
			for (Department dept : departmentList) {
				// if (cust.getDepartmentId() == 5)
				System.out.println(dept);

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

		return departmentList;
	}

	@Override
	public Department saveDepartment(Department department) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		int pos = 0;

		// String sql="insert into department
		// (id,name,no_of_staff , stud_id,clg_id,is_enable) values(?,?,?,?,?,?)";
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			preSts = conn.prepareStatement(saveDepartment, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, department.getId());
			preSts.setString(++pos, department.getName());
			preSts.setInt(++pos, department.getNumberOfStaff());
			preSts.setInt(++pos, department.getStudId());
			preSts.setInt(++pos, department.getClgId());
			preSts.setInt(++pos, department.getIsEnable());
			result = preSts.executeUpdate();
			if (result > 0) {
				conn.commit();
				System.out.println(department.getName() + " inserted into  DB with " + department.getId());
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

		return department;

	}

	@Override
	public List<Department> saveDepartmentList(List<Department> departmentList) {
		List<Department> departmentList1 = new ArrayList<Department>();

		Connection conn = null;
		// String sql = "select * from department";
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(getAllDepartment);
			Department department = null;
			while (rs.next()) {
				department = new Department();
				department.setId(rs.getInt("id"));
				department.setName(rs.getString("name"));
				department.setNumberOfStaff(rs.getInt("no_of_staff"));
				department.setStudId(rs.getInt("stud_id"));
				department.setClgId(rs.getInt("clg_id"));
				department.setIsEnable(rs.getInt("is_enable"));

				departmentList1.add(department);

			}
			for (Department dept : departmentList) {
				// if (cust.getDepartmentId() == 5)
				System.out.println(dept);

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

		return departmentList;
	}

	@Override
	public boolean isDepartmentExist(Department department) {
		boolean result = false;

		List<Department> departmentList = null;

		try {
			departmentList = getDepartmentList();

			for (Department dept : departmentList) {

				if (dept.getId() == department.getId() && dept.getName().equalsIgnoreCase(department.getName())) {

					result = true;

					System.out.println("Department with department Id " + department.getId() + " is already Exist ");
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;

	}

	@Override
	public Department updateDepartment(Department department, int id) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		// String sql = "Update department set name=? where id=? ";
		// int pos=0;
		try {
			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getUpdateDepartment, preSts.RETURN_GENERATED_KEYS);
			preSts.setString(1, department.getName());
			preSts.setInt(2, id);
			result = preSts.executeUpdate();
			System.out.println(department.getName() + " Table is updated in " + id);

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

		return department;

	}

	@Override
	public void deleteDepartment(Department department) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		// String sql = "delete from department where id=?";
		int pos = 0;
		try {

			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getDeleteDepartment, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, department.getId());
			result = preSts.executeUpdate();
			System.out.println(department.getId() + " deleted with DB ");
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
	public boolean disableDepartment(int disable, int id) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		// String sql = "update department set is_enable =? where id =?";
		int pos = 0;
		try {
			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getDisableDepartment, preSts.RETURN_GENERATED_KEYS);
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
	public boolean isDepartmentEnable(int id, int isEnable) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement preSts = null;
		// String sql = "select * from department where id=? and is_enable=?";
		int result = 0;
		int pos = 0;
		ResultSet rs = null;
		try {

			con = DBConnection.getConnection();
			preSts = con.prepareStatement(getIsEnableDepartment, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, id);
			preSts.setInt(++pos, isEnable);

			rs = preSts.executeQuery();

			if (rs.next()) {
				flag = true;
				System.out.println(" Department is Active " + id);
			} else {
				System.out.println("Department is not Active " + id);
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
