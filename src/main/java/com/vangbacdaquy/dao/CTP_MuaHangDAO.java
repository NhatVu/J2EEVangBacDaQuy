/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vangbacdaquy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vangbacdaquy.dto.CTP_MuaHangDTO;
import com.vangbacdaquy.dto.P_MuaHangDTO;

/**
 *
 * @author Minh Nhat
 */
public class CTP_MuaHangDAO extends SuperDAO {
	private String TAG = CTP_MuaHangDAO.class.getSimpleName();

	/*
	 * CRUD
	 */
	public boolean insert(CTP_MuaHangDTO ctp_MH) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_MUAHANG_Ins(?,?,?,?,?)}");
			call.setInt("MACTP_MH", ctp_MH.getMaCTP_MH());
			call.setInt("MASP", ctp_MH.getMaSP());
			call.setInt("MAP_MH", ctp_MH.getMaP_MH());
			call.setInt("SOLUONG", ctp_MH.getSoLuong());
			call.setDouble("THANHTIEN", ctp_MH.getThanhTien());

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
		}
		return false;
	}

	public boolean update(CTP_MuaHangDTO ctp_MH) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_MUAHANG_Upd(?,?,?,?,?)}");
			call.setInt("MACTP_MH", ctp_MH.getMaCTP_MH());
			call.setInt("MASP", ctp_MH.getMaSP());
			call.setInt("MAP_MH", ctp_MH.getMaP_MH());
			call.setInt("SOLUONG", ctp_MH.getSoLuong());
			call.setDouble("THANHTIEN", ctp_MH.getThanhTien());

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
		}
		return false;
	}

	public boolean delete(CTP_MuaHangDTO ctp_MH) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_MUAHANG_Del(?)}");
			call.setInt("MACTP_MH", ctp_MH.getMaCTP_MH());

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
		}
		return false;
	}

	public int getLastID() {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_MUAHANG_getLastID(?)}");
			call.registerOutParameter(1, java.sql.Types.VARCHAR);

			call.execute();
			return call.getInt(1);

		} catch (SQLException ex) {
			Logger.getLogger(CTP_MuaHangDAO.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(CTP_MuaHangDAO.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}

			try {
				call.close();
			} catch (SQLException ex) {
				Logger.getLogger(CTP_MuaHangDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

		return 0;
	}

	public int getNexId() {
		return getLastID() + 1;

	}
	
	public ArrayList<CTP_MuaHangDTO> getCTPMuaHangByMaPMH(int maPMH) {
		try {
			this.getConnection();
			ArrayList<CTP_MuaHangDTO> result = new ArrayList<CTP_MuaHangDTO>();
			String query = "SELECT * FROM CTP_MUAHANG where MAP_MH=" + maPMH;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				int maCTP_MH = resultSet.getInt("MACTP_MH");
				int maP_MH = resultSet.getInt("MAP_MH");
				int maSP = resultSet.getInt("MASP");
				int soLuong = resultSet.getInt("SOLUONG");
				int thanhTien = resultSet.getInt("THANHTIEN");
			
			
				CTP_MuaHangDTO ctp_MuaHangDTO = new CTP_MuaHangDTO( maCTP_MH,  maP_MH, maSP,  soLuong,  thanhTien);

				result.add(ctp_MuaHangDTO);

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
