package com.vangbacdaquy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vangbacdaquy.dto.CTP_DichVuDTO;
import com.vangbacdaquy.dto.CTP_DichVuDTO;

public class CTP_DichVuDAO extends SuperDAO {
	private String TAG = CTP_DichVuDAO.class.getSimpleName();

	/*
	 * CRUD
	 */
	public boolean insert(CTP_DichVuDTO ctp_DV) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_DICHVU_Ins(?,?,?,?,?)}");

			call.setInt("MACTP_DV", ctp_DV.getMaCTP_DV());
			call.setInt("MAP_DV", ctp_DV.getMaP_DV());
			call.setInt("MADV", ctp_DV.getMaDV());
			call.setInt("SOLUONG", ctp_DV.getSoLuong());
			call.setDouble("THANHTIEN", ctp_DV.getThanhTien());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(CTP_DichVuDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_DichVuDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public boolean update(CTP_DichVuDTO ctp_DV) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_DICHVU_Ins(?,?,?,?,?)}");

			call.setInt("MACTP_DV", ctp_DV.getMaCTP_DV());
			call.setInt("MAP_DV", ctp_DV.getMaP_DV());
			call.setInt("MADV", ctp_DV.getMaDV());
			call.setInt("SOLUONG", ctp_DV.getSoLuong());
			call.setDouble("THANHTIEN", ctp_DV.getThanhTien());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(CTP_DichVuDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_DichVuDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public boolean delete(CTP_DichVuDTO ctp_DV) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_DICHVU_Del(?)}");
			call.setInt("MACTP_DV", ctp_DV.getMaCTP_DV());

			if(call.executeUpdate() > 0)
				return true;

		} catch (SQLException ex) {
			Logger.getLogger(CTP_DichVuDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_DichVuDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
		}
		return false;
	}

	public int getLastID() {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_DICHVU_getLastID(?)}");
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
		return 0;
	}
	
	public ArrayList<CTP_DichVuDTO> getCTPDichVuByMaPBH(int maPDV) {
		try {
			this.getConnection();
			ArrayList<CTP_DichVuDTO> result = new ArrayList<CTP_DichVuDTO>();
			String query = "SELECT * FROM CTP_DICHVU where MAP_DV=" + maPDV;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				int maCTP_BH = resultSet.getInt("MACTP_DV");
				int maP_DV = resultSet.getInt("MAP_DV");
				int maSP = resultSet.getInt("MADV");
				int soLuong = resultSet.getInt("SOLUONG");
				int thanhTien = resultSet.getInt("THANHTIEN");
			
			
				CTP_DichVuDTO ctp_DichVuDTO = new CTP_DichVuDTO( maCTP_BH,  maP_DV, maSP,  soLuong,  thanhTien);

				result.add(ctp_DichVuDTO);

			}
			statement.close();
			return result;
		} catch (SQLException ex) {
			Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					// TODO: handle exception
					Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
				}
			}
		}

		return null;
	}

	public int getNexId() {
		return getLastID() + 1;

	}
}
