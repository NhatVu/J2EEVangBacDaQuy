/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vangbacdaquy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vangbacdaquy.dto.P_BanHangDTO;

/**
 *
 * @author Minh Nhat
 */
public class P_BanHangDAO extends SuperDAO {

	private final String maP_BH = "MAP_BH";
	private final String maP_Thu = "MAP_THU";

	private final String insertProcedure = "{call P_BANHANG_Ins(?,?)}";
	private final String updateProcedure = "{call P_BANHANG_Upd(?,?)}";
	private final String deleteProcedure = "{call P_BANHANG_Del(?)}";

	public P_BanHangDAO() {

	}

	/*
	 * CRUD
	 */
	public boolean insert(P_BanHangDTO p_BH) {
		try {
			this.getConnection();
			call = connection.prepareCall(insertProcedure);
			call.setInt(maP_BH, p_BH.getMaP_BH());
			call.setInt(maP_Thu, p_BH.getMaP_Thu());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_BanHangDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_BanHangDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return false;
	}

	public boolean update(P_BanHangDTO p_BH) {
		try {
			this.getConnection();
			call = connection.prepareCall(updateProcedure);
			call.setInt(maP_BH, p_BH.getMaP_BH());
			call.setInt(maP_Thu, p_BH.getMaP_Thu());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_BanHangDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_BanHangDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return false;
	}

	public boolean delete(P_BanHangDTO p_BH) {
		try {
			this.getConnection();
			call = connection.prepareCall(deleteProcedure);
			call.setInt(maP_BH, p_BH.getMaP_BH());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_BanHangDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_BanHangDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		return false;
	}

	/*
	 * 1. Intent: - Lấy mã khách hàng, họ tên dựa vào mã phiếu bán hàng 2.
	 * Paramiter - In: maP_BH = mã phiếu bán hàng - Out: tmptList[0] = maKH -
	 * Out: tmptList[1] = HoTen
	 */
	public void getMaKHHoTenByMaP_BH(int maP_BH, String tmptList[]) {
		try {
			this.getConnection();
			call = connection
					.prepareCall("{call P_BanHang_getMaKHHoTenByMaP_BH(?)}");
			call.setInt(1, maP_BH);

			ResultSet rs = call.executeQuery();
			while (rs.next()) {
				tmptList[0] = String.valueOf(rs.getInt(1));
				tmptList[1] = rs.getString(2);
			}

		} catch (SQLException ex) {
			Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_BanHangDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_BanHangDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}

	/*
	 * 1. Intent - Lấy mã phiếu thu dựa vào mã phiếu bán hàng 2. Return - Trả về
	 * mã phiếu bán hàng
	 */
	public int getMaP_ThuByMaP_BH(int maP_BH) {
		try {
			this.getConnection();
			call = connection
					.prepareCall("{call P_BanHang_getMaP_ThuByMaP_BH(?,?)}");
			call.setInt(1, maP_BH);
			call.registerOutParameter(2, java.sql.Types.INTEGER);

			call.execute();
			return call.getInt(2);

		} catch (SQLException ex) {
			Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} // <editor-fold defaultstate="collapsed" desc="finally">
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_BanHangDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_BanHangDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		// </editor-fold>
		return 0;
	}

	/*
	 * Lấy mã sản phẩm, tổng số lượng bán nhóm theo mã sản phẩm trong bảng
	 * ctp_banHang 1. từ ngày lập tồn kho gần nhất đến ngày lập tồn kho hiện
	 * tại, có bao nhiêu phiếu bán hàng được lập 2. Dựa vào số phiếu bán hàng
	 * này -> lấy maSP và tổng lượng bán của sản phẩm
	 */
	public void getMaSPTongBan(Timestamp lastedNgayBC, Timestamp newNgayBC,
			Map<Integer, Integer> lRs) {

		try {
			this.getConnection();
			call = connection
					.prepareCall("{call P_BanHang_getMaSPTongBan(?,?)}");
			call.setTimestamp(1, lastedNgayBC);
			call.setTimestamp(2, newNgayBC);

			ResultSet rs = call.executeQuery();
			while (rs.next()) {
				lRs.put(rs.getInt(1), rs.getInt(2));
			}

		} catch (SQLException ex) {
			Logger.getLogger(CTP_BanHangDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} // <editor-fold defaultstate="collapsed" desc="finally">
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_BanHangDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_BanHangDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
		// </editor-fold>
	}

	public int getLastID() {
		try {
			this.getConnection();
			call = connection.prepareCall("{call P_BANHANG_getLastID(?)}");
			call.registerOutParameter(1, java.sql.Types.VARCHAR);

			call.execute();
			return call.getInt(1);

		} catch (SQLException ex) {
			Logger.getLogger(P_BanHangDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(P_BanHangDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_BanHangDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

		return 0;
	}

	public int getNexId() {
		return getLastID() + 1;

	}
}
