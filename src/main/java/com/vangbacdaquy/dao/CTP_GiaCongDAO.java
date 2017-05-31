/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vangbacdaquy.dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vangbacdaquy.dto.CTP_GiaCongDTO;

/**
 *
 * @author Administrator
 */
public class CTP_GiaCongDAO extends SuperDAO {

	// Properties of table
	private static final String maChiTietPhieuGiaCong = "MACTP_GC";
	private static final String maPhieuGiaCong = "MAP_GC";
	private static final String maLoaiGiaCong = "MALOAIGC";
	private static final String soluong = "SOLUONG";
	private static final String thanhTien = "THANHTIEN";

	private static final String insertStatement = "{call CTP_GIACONG_Ins(?,?,?,?,?)}";
	private static final String updateStatement = "{call CTP_GIACONG_Upd(?,?,?,?,?)}";
	private static final String deleteStatement = "{call CTP_GIACONG_Del(?)}";

	// TAG
	private static final String TAG = CTP_GiaCongDAO.class.getSimpleName();

	/*
	 * CRUD
	 */
	public boolean insert(CTP_GiaCongDTO n) {
		try {
			this.getConnection();
			call = connection.prepareCall(insertStatement);

			call.setInt(maChiTietPhieuGiaCong, n.getMaCTP_GC());
			call.setInt(maPhieuGiaCong, n.getMaP_GC());
			call.setInt(maLoaiGiaCong, n.getMaLoaiGC());
			call.setInt(soluong, n.getSoLuong());
			call.setDouble(thanhTien, n.getThanhTien());

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

	public boolean update(CTP_GiaCongDTO n) {
		try {
			this.getConnection();
			call = connection.prepareCall(updateStatement);
			call.setInt(maChiTietPhieuGiaCong, n.getMaCTP_GC());
			call.setInt(maPhieuGiaCong, n.getMaP_GC());
			call.setInt(maLoaiGiaCong, n.getMaLoaiGC());
			call.setInt(soluong, n.getSoLuong());
			call.setDouble(thanhTien, n.getThanhTien());

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

	public boolean delete(CTP_GiaCongDTO n) {
		try {
			this.getConnection();
			call = connection.prepareCall(deleteStatement);
			call.setInt(maChiTietPhieuGiaCong, n.getMaCTP_GC());

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

	public int getLastID() {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_GIACONG_getLastID(?)}");
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
					Logger.getLogger(P_NoDAO.class.getName()).log(Level.SEVERE,
							null, ex);
				}
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
		return getLastID() + 1;

	}
}
