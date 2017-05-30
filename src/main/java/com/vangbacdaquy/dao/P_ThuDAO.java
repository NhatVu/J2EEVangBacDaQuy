package com.vangbacdaquy.dao;

import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vangbacdaquy.dto.P_ThuDTO;

public class P_ThuDAO extends SuperDAO {

	public P_ThuDAO() {

	}

	/*
	 * CRUD
	 */
	public boolean insert(P_ThuDTO p_T) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call P_THU_Ins(?,?,?,?,?)}");

			call.setInt("MAP_THU", p_T.getMaP_Thu());
			call.setInt("MAKH", p_T.getMaKH());
			call.setTimestamp("NGAYLAPPHIEU", p_T.getNgayLapPhieu());
			call.setTimestamp("NGAYKETTHUC", p_T.getNgayKetThuc());
			call.setDouble("TONGCONG", p_T.getTongCong());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(P_ThuDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(P_ThuDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public boolean update(P_ThuDTO p_T) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call P_THU_Upd(?,?,?,?,?)}");

			call.setInt("MAP_THU", p_T.getMaP_Thu());
			call.setInt("MAKH", p_T.getMaKH());
			call.setTimestamp("NGAYLAPPHIEU", p_T.getNgayLapPhieu());
			call.setTimestamp("NGAYKETTHUC", p_T.getNgayKetThuc());
			call.setDouble("TONGCONG", p_T.getTongCong());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(P_ThuDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(P_ThuDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public boolean delete(P_ThuDTO p_T) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call P_THU_Del(?)}");
			call.setInt("MAP_THU", p_T.getMaP_Thu());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(P_ThuDAO.class.getName()).log(Level.SEVERE, null,
					ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(P_ThuDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	/*
	 * 1. Intent: Lấy thông tin tiền còn lại, ngày thu - Nếu phiếu thu đã lập =>
	 * lấy theo bảng phiếu nợ - Nếu phiếu thu chưa lập => kiểm tra , nếu là
	 * khách quen => cho lập - 1,2 ko thỏa => trả về conLao = 0, ngayLap =
	 * "0000-00-00
	 * 
	 * 2. Paramiter : - In : maKH = mã khách hàng ; maP_Thu = mã phiếu thu - Out
	 * : tmpList[0] = tiền còn lại - Out : tmpList[1] = ngày trả
	 */
	public void getLastConLaiNgayTraByMaP_Thu(int maKH, int maP_Thu,
			String tmptList[]) {
		try {
			this.getConnection();
			call = connection
					.prepareCall("{call P_Thu_getLastConLaiNgayTraByMaP_Thu(?,?,?,?)}");
			call.setInt(1, maKH);
			call.setInt(2, maP_Thu);
			call.registerOutParameter(3, Types.DECIMAL);
			call.registerOutParameter(4, Types.TIMESTAMP);

			call.execute();
			tmptList[0] = String.valueOf(call.getDouble(3));
			tmptList[1] = String.valueOf(call.getTimestamp(4).getTime());

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
			call = connection.prepareCall("{call P_THU_getLastID(?)}");
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
					Logger.getLogger(P_ThuDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(P_ThuDAO.class.getName()).log(Level.SEVERE,
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
