package com.clg.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clg.connection.DBConnection;
import com.college.dao.AddressInterface;
import com.college.pojo.Address;


public class AddressImpl implements AddressInterface {
	private static final String getAllAddress = "select * from address";
	private static final String saveAddress = "insert into address(flat_number,land_mark,city,district,state,country,pin_code,is_enable)values(?,?,?,?,?,?,?,?)";
	public static final String getUpdateAddress = "update address set city=? where id=?";
	public static final String getDeleteAddress = "delete from address  where id=?";
	public static final String getDisableAddress = "update address set is_enable=? where id=?";
	public static final String getIsEnableAddress = "select * from address where id=?  and is_enable=?";

	@Override
	public List<Address> getAddressList() {

		Connection conn = null;
		String sql = "select * from address";
		Address address = null;
		Statement st = null;/// PreparedStatment,Callable
		ResultSet rs = null;
		List<Address> addressList = null;

		try {
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			addressList = new ArrayList<Address>();

			while (rs.next()) {
				address = new Address();
				address.setAddressId(rs.getInt("id"));
				address.setFlatNumber(rs.getInt("flat_number"));
				address.setLandmark(rs.getString("land_mark"));
				address.setCity(rs.getString("city"));
				address.setDistrict(rs.getString("district"));
				address.setState(rs.getString("State"));
				address.setCountry(rs.getString("country"));
				address.setPinCode(rs.getInt("pin_code"));
				addressList.add(address);

			}

			for (Address ad : addressList) {

				// if (ad.getAddressId() == 13)
				System.out.println("Address are:" + ad);
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

		return addressList;
	}

	@Override
	public int saveAddress(Address address) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		ResultSet rs = null;
		int addressId = 0;
		Statement st = null;
		// String sql="insert into
		// address(flat_number,land_mark,city,district,state,country,pin_code,is_enable)values(?,?,?,?,?,?,?,?)";
		int pos = 0;
		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			preSts = conn.prepareStatement(saveAddress, preSts.RETURN_GENERATED_KEYS);
			// preSts.setInt(1, address.getAddressId());
			preSts.setInt(++pos, address.getFlatNumber());
			preSts.setString(++pos, address.getLandmark());
			preSts.setString(++pos, address.getCity());
			preSts.setString(++pos, address.getDistrict());
			preSts.setNString(++pos, address.getState());
			preSts.setString(++pos, address.getCountry());
			preSts.setInt(++pos, address.getPinCode());
			preSts.setInt(++pos, address.getIsEnable());
			result = preSts.executeUpdate();
			rs = preSts.getGeneratedKeys();
			if (rs.next()) {
				conn.commit();
				addressId = rs.getInt(1);
				System.out.println(address.getCity() + " inserted into DB with " + addressId);
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
			if (preSts != null) {
				try {
					preSts.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}

		return addressId;
	}

	public Address updateAddress(Address address, int id, String state) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		// String sql = "Update address set city=? , land_mark=? where id=? and
		// state=?";
		int pos = 0;
		try {

			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getUpdateAddress, preSts.RETURN_GENERATED_KEYS);
			preSts.setString(++pos, address.getCity());
			preSts.setString(++pos, address.getLandmark());
			preSts.setInt(++pos, id);
			preSts.setString(++pos, state);
			result = preSts.executeUpdate();

			System.out.println(address.getCity() + " Table is updated in " + id);

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

		return address;

	}

	@Override
	public void deleteAddress(Address address) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		// String sql = "delete from address where id=?";
		int pos = 0;
		try {

			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getDeleteAddress, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, address.getAddressId());
			result = preSts.executeUpdate();
			System.out.println(address.getAddressId() + " deleted with DB ");
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
	public List<Address> saveAddressList(List<Address> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAddressExist(Address address) {
		boolean result = false;

		List<Address> existingAddressList = null;

		try {
			existingAddressList = getAddressList();

			for (Address add : existingAddressList) {

				if (add.getAddressId() == address.getAddressId() && add.getCity().equalsIgnoreCase(address.getCity())) {

					result = true;

					// System.out.println("Address is exist" + address.getAddressId());

					System.out.println("Address with address Id " + address.getAddressId() + " is already Exist ");
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return result;
	}

	@Override
	public boolean disableAddress(int disable, int id) {
		Connection conn = null;
		PreparedStatement preSts = null;
		int result = 0;
		// String sql = "Update address set is_enable=? where id=? ";
		int pos = 0;
		try {

			conn = DBConnection.getConnection();
			preSts = conn.prepareStatement(getDisableAddress, preSts.RETURN_GENERATED_KEYS);
			preSts.setInt(++pos, disable);
			preSts.setInt(++pos, id);

			result = preSts.executeUpdate();

			System.out.println(" Table is updated in " + id);

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
	public boolean isAddressEnable(int id, int isEnable) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement preset = null;
		// String sql = "select * from address where id=? and is_enable=?";
		int result = 0;
		int pos = 0;
		ResultSet rs = null;
		try {

			con = DBConnection.getConnection();
			preset = con.prepareStatement(getIsEnableAddress, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, id);
			preset.setInt(++pos, isEnable);

			rs = preset.executeQuery();

			if (rs.next()) {
				flag = true;
				System.out.println(" Address is enable " + id);
			} else {
				System.out.println("Address  is not enable " + id);
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
			if (preset != null) {
				try {
					preset.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		}
		return flag;
	}

	
}
