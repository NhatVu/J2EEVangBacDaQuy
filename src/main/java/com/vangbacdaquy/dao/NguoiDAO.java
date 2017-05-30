/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vangbacdaquy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vangbacdaquy.dto.NguoiDTO;

/**
 *
 * @author Administrator
 */
public class NguoiDAO extends SuperDAO {

	// Properties of table
	private static final String maNguoi = "MANGUOI";
	private static final String shortId = "SHORTID";
	private static final String hoten = "HOTEN";
	private static final String diachi = "DIACHI";

	private static final String insertStatement = "{call NGUOI_Ins(?,?,?,?)}";
	private static final String updateStatement = "{call NGUOI_Upd(?,?,?,?)}";
	private static final String deleteStatement = "{call NGUOI_Del(?)}";

	// TAG
	private static final String TAG = NguoiDAO.class.getSimpleName();

	public NguoiDAO() {

	}

	/*
	 * CRUD
	 */
	public boolean insert(NguoiDTO n) {
		try {
			this.getConnection();
			call = connection.prepareCall(insertStatement);

			call.setInt(maNguoi, n.getMaLoaiNguoi());
			call.setInt(shortId, n.getShortID());
			call.setString(hoten, n.getHoTen());
			call.setString(diachi, n.getDiaChi());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public boolean update(NguoiDTO n) {
		try {
			this.getConnection();
			call = connection.prepareCall(updateStatement);
			call.setInt(maNguoi, n.getMaLoaiNguoi());
			call.setInt(shortId, n.getShortID());
			call.setString(hoten, n.getHoTen());
			call.setString(diachi, n.getDiaChi());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public boolean delete(NguoiDTO n) {
		try {
			this.getConnection();
			call = connection.prepareCall(deleteStatement);
			call.setInt(maNguoi, n.getMaLoaiNguoi());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public NguoiDTO getNguoiFromMaNguoi(int maNguoi) {
		try {
			this.getConnection();
			String query = "select * from NGUOI WHERE NGUOI.MANGUOI ="
					+ maNguoi;
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			if (rs.first() != false) {
				String diachi = rs.getString("DIACHI");
				String ten = rs.getString("HOTEN");
				int shortId = rs.getInt("SHORTID");
				NguoiDTO ng = new NguoiDTO(maNguoi, ten, diachi, shortId);
				st.close();
				return ng;
			}
		} catch (SQLException ex) {
			Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
				}
			}
		}
		return null;
	}

	public int getLastID() {
		try {
			this.getConnection();
			call = connection.prepareCall("{call NGUOI_getLastID(?)}");
			call.registerOutParameter(1, java.sql.Types.VARCHAR);

			call.execute();
			return call.getInt(1);

		} catch (SQLException ex) {
			Logger.getLogger(NguoiDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} // <editor-fold defaultstate="collapsed" desc="finally">
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(NguoiDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(NguoiDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		// </editor-fold>
		return 0;
	}

	public int getNexId() {
		return getLastID() + 1;

	}
}
