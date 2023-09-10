package com.clg.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clg.connection.DBConnection;
import com.college.dao.StaffInterface;
import com.college.pojo.Department;
import com.college.pojo.Staff;

public class StaffImpl implements StaffInterface {

	private static final String getAllStaff = "select * from staff";
	private static final String saveStaff = "insert into staff (id,name,position, experience, salary, dept_id, clg_id,is_enable,qualification) values(?,?,?,?,?,?,?,?,?)";
	public static final String getUpdateStaff = "Update  staff set name=? where id=? ";
	public static final String getDeleteStaff = "delete from staff where id=?";
	public static final String getDisableStaff = "update staff set is_enable =? where id =?";
	public static final String getIsEnableStaff = "select * from staff where id=?  and is_enable=?";

	public static List<Staff> getStaffList() {
		List<Staff> staffList = new ArrayList<Staff>();
		Connection conn = null;
		// String sql = "select * from staff";
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(getAllStaff);
			Staff staff = null;
			while (rs.next()) {
				staff = new Staff();
				staff.setId(rs.getInt("id"));
				staff.setName(rs.getString("name"));
				staff.setPosition(rs.getString("position"));
				staff.setExperience(rs.getInt("experience"));
				staff.setSalary(rs.getDouble("salary"));
				staff.setDeptId(rs.getInt("dept_id"));
				staff.setClgId(rs.getInt("clg_id"));
				staff.setIsEnable(rs.getInt("is_enable"));
				staff.setQulification(rs.getString("qualification"));
				staffList.add(staff);

			}
			for (Staff s : staffList) {
				// if (cust.getStaffId() == 5)
				System.out.println(s);

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

		return staffList;
	}

	@Override
	public Staff saveStaff(Staff staff) {

		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		int pos = 0;

		// String sql="insert into staff
		// (id,name,position, experience, salary, dept_id,
		// clg_id,is_enable,qualification) values(?,?,?,?,?,?,?,?,?)";
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			preSts = conn.prepareStatement(saveStaff, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, staff.getId());
			preSts.setString(++pos, staff.getName());
			preSts.setString(++pos, staff.getPosition());
			preSts.setInt(++pos, staff.getExperience());
			preSts.setDouble(++pos, staff.getSalary());
			preSts.setInt(++pos, staff.getDeptId());
			preSts.setInt(++pos, staff.getClgId());
			preSts.setInt(++pos, staff.getIsEnable());
			preSts.setString(++pos, staff.getQulification());
			result = preSts.executeUpdate();
			if (result > 0) {
				conn.commit();
				System.out.println(staff.getName() + " inserted into  DB with " + staff.getId());
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

		return staff;
	}

	@Override
	public List<Staff> saveStaffList(List<Staff> staffList) {
		List<Staff> staffList1 = new ArrayList<Staff>();

		Connection conn = null;
		// String sql = "select * from staff";
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(getAllStaff);
			Staff staff = null;
			while (rs.next()) {
				staff = new Staff();
				staff.setId(rs.getInt("id"));
				staff.setName(rs.getString("name"));
				staff.setPosition(rs.getString("position"));
				staff.setExperience(rs.getInt("experience"));
				staff.setSalary(rs.getDouble("salary"));
				staff.setDeptId(rs.getInt("dept_id"));
				staff.setClgId(rs.getInt("clg_id"));
				staff.setIsEnable(rs.getInt("is_enable"));
				staff.setQulification(rs.getString("qualification"));
				staffList1.add(staff);

			}
			for (Staff s : staffList) {
				// if (cust.getStaffId() == 5)
				System.out.println(s);

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

		return staffList;
	}

	@Override
	public boolean isStaffExist(Staff staff) {
		boolean result = false;

		List<Staff> staffList = null;

		try {
			staffList = getStaffList();

			for (Staff st : staffList) {

				if (st.getId() == staff.getId() && st.getName().equalsIgnoreCase(staff.getName())) {

					result = true;

					System.out.println("Staff with staff Id " + staff.getId() + " is already Exist ");
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;

	}

	@Override
	public Staff updateStaff(Staff staff, int id) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		// String sql = "Update staff set name=? where id=? ";
		// int pos=0;
		try {
			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getUpdateStaff, preSts.RETURN_GENERATED_KEYS);
			preSts.setString(1, staff.getName());
			preSts.setInt(2, id);
			result = preSts.executeUpdate();
			System.out.println(staff.getName() + " Table is updated in " + id);

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

		return staff;

	}

	@Override
	public void deleteStaff(Staff staff) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		// String sql = "delete from staff where id=?";
		int pos = 0;
		try {

			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getDeleteStaff, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, staff.getId());
			result = preSts.executeUpdate();
			System.out.println(staff.getId() + " deleted with DB ");
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
	public boolean disableStaff(int disable, int id) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		// String sql = "update staff set is_enable =? where id =?";
		int pos = 0;
		try {
			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getDisableStaff, preSts.RETURN_GENERATED_KEYS);
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
	public boolean isStaffEnable(int id, int isEnable) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement preSts = null;
		// String sql = "select * from staff where id=? and is_enable=?";
		int result = 0;
		int pos = 0;
		ResultSet rs = null;
		try {

			con = DBConnection.getConnection();
			preSts = con.prepareStatement(getIsEnableStaff, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, id);
			preSts.setInt(++pos, isEnable);

			rs = preSts.executeQuery();

			if (rs.next()) {
				flag = true;
				System.out.println(" Staff is Active " + id);
			} else {
				System.out.println("Staff is not Active " + id);
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