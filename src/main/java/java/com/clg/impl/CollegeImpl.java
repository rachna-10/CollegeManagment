package com.clg.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clg.connection.DBConnection;
import com.college.dao.CollegeInterface;
import com.college.pojo.Address;
import com.college.pojo.College;
import com.college.pojo.Department;


public class CollegeImpl implements CollegeInterface {
	private static final String getAllCollege = "select * from college";
	private static final String saveCollege = "insert into college (id,college_name,fees,addr_id, stud_id,dept_id,is_enable) values(?,?,?,?,?,?,?)";
	public static final String getUpdateCollege = "Update  college set college_name=? where id=? ";
	public static final String getDeleteCollege = "delete from college where id=?";
	public static final String getDisableCollege = "update college set is_enable =? where id =?";
	public static final String getIsEnableCollege = "select * from college where id=?  and is_enable=?";

	
	
	public static List<College> getCollegeList() {
		List<College> collegeList = new ArrayList<College>();

		Connection conn = null;
		// String sql = "select * from college";
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(getAllCollege);
			College college = null;
			while (rs.next()) {
				college = new College();
				college.setCollegeId(rs.getInt("id"));
				college.setcollegeName(rs.getString("college_name"));
				college.setFee(rs.getInt("fees"));
				college.setAddreId(rs.getInt("addr_id"));
				college.setStudId(rs.getInt("stud_id"));
				college.setDeptId(rs.getInt("dept_id"));
				college.setIsEnable(rs.getInt("is_enable"));

				collegeList.add(college);

			}
			for (College c : collegeList) {
				// if (c.getCollegeId() == 5)
				System.out.println(c);

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

		return collegeList ;

	}
	

	@Override
	public College saveCollege(College college) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		int pos = 0;

		// String sql="insert into college
		// (id,college_name,fee,addr_id, stud_id,
		// dept_id,is_enable) values(?,?,?,?,?,?,?)";
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			preSts = conn.prepareStatement(saveCollege, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, college.getCollegeId());
			preSts.setString(++pos, college.getcollegeName());
			preSts.setInt(++pos, college.getFees());
			preSts.setInt(++pos, college.getAddreId());
			preSts.setInt(++pos, college.getStudId());
			preSts.setInt(++pos, college.getDeptId());
			preSts.setInt(++pos, college.getIsEnable());
			result = preSts.executeUpdate();
			if (result > 0) {
				conn.commit();
				System.out.println(college.getcollegeName() + " inserted into  DB with " + college.getCollegeId());
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

		return college;
	}

	@Override
	public List<College> saveCollegeList(List<College> collegeList) {
		
		return collegeList;

	}

	@Override
	public boolean isCollegeExist(College college) {
		boolean result = false;

		List<College> collegeList = null;

		try {
			collegeList = getCollegeList();

			for (College c : collegeList) {

				if (c.getCollegeId() == college.getCollegeId()
						&& c.getcollegeName().equalsIgnoreCase(college.getcollegeName())) {
					result = true;

					System.out.println("College with college Id " + college.getCollegeId() + " is already Exist ");
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return result;

	}

	

	@Override
	public College updateCollege(College college, int id) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		// String sql = "Update college set college_name=? where id=? ";
		// int pos=0;
		try {
			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getUpdateCollege, preSts.RETURN_GENERATED_KEYS);
			preSts.setString(1, college.getcollegeName());
			preSts.setInt(2, id);
			result = preSts.executeUpdate();
			System.out.println(college.getcollegeName() + " Table is updated in " + id);

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

		return college;

	}

	@Override
	public void deleteCollege(College college) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		// String sql = "delete from college where id=?";
		int pos = 0;
		try {

			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getDeleteCollege, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, college.getCollegeId());
			result = preSts.executeUpdate();
			System.out.println(college.getCollegeId() + " deleted with DB ");
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
	public boolean disableCollege(int disable, int id) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		// String sql = "update college set is_enable =? where id =?";
		int pos = 0;
		try {
			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getDisableCollege, preSts.RETURN_GENERATED_KEYS);
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
	public boolean isCollegeEnable(int id, int isEnable) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement preSts = null;
		// String sql = "select * from college where id=? and is_enable=?";
		int result = 0;
		int pos = 0;
		ResultSet rs = null;
		try {

			con = DBConnection.getConnection();
			preSts = con.prepareStatement(getIsEnableCollege, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, id);
			preSts.setInt(++pos, isEnable);

			rs = preSts.executeQuery();

			if (rs.next()) {
				flag = true;
				System.out.println(" College is Active " + id);
			} else {
				System.out.println("College is not Active " + id);
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

