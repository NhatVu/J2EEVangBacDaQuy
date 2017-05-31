package com.vangbacdaquy.dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vangbacdaquy.dto.P_NoDTO;

public class P_NoDAO extends SuperDAO {
	public P_NoDAO() {

	}

	/*
	 * CRUD
	 */
	public boolean insert(P_NoDTO p_N) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call P_NO_Ins(?,?,?,?,?,?)}");
			call.setInt("MAP_NO", p_N.getMaP_No());
			call.setInt("MAP_THU", p_N.getMaP_Thu());
			call.setTimestamp("NGAYNO", p_N.getNgayNo());
			call.setDouble("SOTIENNO", p_N.getSoTienNo());
			call.setTimestamp("NGAYTRA", p_N.getNgayTra());
			call.setDouble("SOTIENTRA", p_N.getSoTienTra());

			if (call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE,
							null, ex);
				}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return false;
	}

	public boolean update(P_NoDTO p_N) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call P_NO_Upd(?,?,?,?,?,?)}");

			call.setInt("MAP_NO", p_N.getMaP_No());
			call.setInt("MAP_THU", p_N.getMaP_Thu());
			call.setTimestamp("NGAYNO", p_N.getNgayNo());
			call.setDouble("SOTIENNO", p_N.getSoTienNo());
			call.setTimestamp("NGAYTRA", p_N.getNgayTra());
			call.setDouble("SOTIENTRA", p_N.getSoTienTra());

			if (call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE,
							null, ex);
				}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return false;
	}

	public boolean delete(P_NoDTO p_N) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call P_NO_Del(?)}");
			call.setInt("MAP_NO", p_N.getMaP_No());

			if (call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		// <editor-fold defaultstate="collapsed" desc="finally">
		finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE,
							null, ex);
				}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		// </editor-fold>
		return false;
	}

	/*
	 * 1. Intent - Lấy mã phiếu nợ tiếp theo sẽ được thêm vào bảng phiếu nợ. 2.
	 * Return - Trả về mã phiếu nợ.
	 */
	public int getLastID() {
		try {
			this.getConnection();
			call = connection.prepareCall("{call P_No_getLastID(?)}");
			call.registerOutParameter(1, java.sql.Types.VARCHAR);

			call.execute();
			return call.getInt(1);

		} catch (SQLException ex) {
			Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		// <editor-fold defaultstate="collapsed" desc="finally">
		finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE,
							null, ex);
				}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		// </editor-fold>
		return 0;
	}

	public int getNexId() {
		int maPhieu = 1;
		if (this.getLastID() != 0) {

			maPhieu = getLastID() + 1;
		}
		return maPhieu;
	}
}
