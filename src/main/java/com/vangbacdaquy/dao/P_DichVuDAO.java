package com.vangbacdaquy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vangbacdaquy.dto.P_DichVuDTO;
import com.vangbacdaquy.dto.P_ThuDTO;

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
	
	public ArrayList<P_ThuDTO> getAllP_DichVu() {
		try {
			this.getConnection();
			ArrayList<P_ThuDTO> result = new ArrayList<P_ThuDTO>();
			String query = "SELECT * FROM P_DICHVU AS b inner join P_THU as t on t.MAP_THU = b.MAP_THU";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				int maP_DV = resultSet.getInt("MAP_DV");
				int maKH = resultSet.getInt("MAKH");
				Timestamp ngayLapPhieu = resultSet.getTimestamp("NGAYLAPPHIEU");
				Timestamp ngayKetThuc = resultSet.getTimestamp("NGAYKETTHUC");
				int tongCong = resultSet.getInt("TONGCONG");
			
				P_ThuDTO p_BanHangDTO = new P_ThuDTO();
				p_BanHangDTO.setMaP_DV(maP_DV);
				p_BanHangDTO.setMaKH(maKH);
				p_BanHangDTO.setNgayLapPhieu(ngayLapPhieu);
				p_BanHangDTO.setNgayKetThuc(ngayKetThuc);
				p_BanHangDTO.setTongCong(tongCong);

				result.add(p_BanHangDTO);

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

}
