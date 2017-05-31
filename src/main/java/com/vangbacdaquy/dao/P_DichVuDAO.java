package com.vangbacdaquy.dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vangbacdaquy.dto.P_DichVuDTO;

public class P_DichVuDAO extends SuperDAO {

	private String TAG = P_DichVuDAO.class.getSimpleName();

	public P_DichVuDAO() {

	}

	/*
	 * CRUD
	 */
	public boolean insert(P_DichVuDTO p_DV) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call P_DICHVU_Ins(?,?)}");

			call.setInt("MAP_DV", p_DV.getMaP_DV());
			call.setInt("MAP_THU", p_DV.getMaP_Thu());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(P_DichVuDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(P_DichVuDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public boolean update(P_DichVuDTO p_DV) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call P_DICHVU_Upd(?,?)}");

			call.setInt("MAP_DV", p_DV.getMaP_DV());
			call.setInt("MAP_THU", p_DV.getMaP_Thu());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(P_DichVuDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(P_DichVuDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public boolean delete(P_DichVuDTO p_DV) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call P_DICHVU_Del(?)}");
			call.setInt("MAP_DV", p_DV.getMaP_DV());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(P_DichVuDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(P_DichVuDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public int getLastID() {
		try {
			this.getConnection();
			call = connection.prepareCall("{call P_DICHVU_getLastID(?)}");
			call.registerOutParameter(1, java.sql.Types.VARCHAR);

			call.execute();

			return call.getInt(1);

		} catch (SQLException ex) {
			Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
		} // <editor-fold defaultstate="collapsed" desc="finally">
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
			}
		}
		// </editor-fold>
		return 0;
	}

	public int getNexId() {
		return getLastID() + 1;

	}

}
