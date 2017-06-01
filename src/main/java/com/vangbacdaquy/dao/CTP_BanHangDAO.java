/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vangbacdaquy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vangbacdaquy.dto.CTP_BanHangDTO;
import com.vangbacdaquy.dto.CTP_MuaHangDTO;

/**
 *
 * @author Minh Nhat
 */
public class CTP_BanHangDAO extends SuperDAO {
	private String TAG = CTP_BanHangDAO.class.getSimpleName();

	/*
	 * CRUD
	 */
	public boolean insert(CTP_BanHangDTO ctp_BH) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_BANHANG_Ins(?,?,?,?,?)}");
			call.setInt("MACTP_BH", ctp_BH.getMaCTP_BH());
			call.setInt("MAP_BH", ctp_BH.getMaP_BH());
			call.setInt("MASP", ctp_BH.getMaSP());
			call.setInt("SOLUONG", ctp_BH.getSoLuong());
			call.setDouble("THANHTIEN", ctp_BH.getThanhTien());

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

	public boolean update(CTP_BanHangDTO ctp_BH) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_BANHANG_Upd(?,?,?,?,?)}");
			call.setInt("MACTP_BH", ctp_BH.getMaCTP_BH());
			call.setInt("MAP_BH", ctp_BH.getMaP_BH());
			call.setInt("MASP", ctp_BH.getMaSP());
			call.setInt("SOLUONG", ctp_BH.getSoLuong());
			call.setDouble("THANHTIEN", ctp_BH.getThanhTien());

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

	public boolean delete(CTP_BanHangDTO ctp_BH) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call CTP_BANHANG_Del(?)}");
			call.setInt("MACTP_BH", ctp_BH.getMaCTP_BH());

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
			call = connection.prepareCall("{call CTP_BANHANG_getLastID(?)}");
			call.registerOutParameter(1, java.sql.Types.VARCHAR);

			call.execute();
			return call.getInt(1);

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
				Logger.getLogger(CTP_BanHangDAO.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}

		return 0;
	}

	public int getNexId() {
		return getLastID() + 1;

	}
	
	public ArrayList<CTP_BanHangDTO> getCTPBanHangByMaPBH(int maPBH) {
		try {
			this.getConnection();
			ArrayList<CTP_BanHangDTO> result = new ArrayList<CTP_BanHangDTO>();
			String query = "SELECT * FROM CTP_BANHANG where MAP_BH=" + maPBH;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				int maCTP_BH = resultSet.getInt("MACTP_BH");
				int maP_BH = resultSet.getInt("MAP_BH");
				int maSP = resultSet.getInt("MASP");
				int soLuong = resultSet.getInt("SOLUONG");
				int thanhTien = resultSet.getInt("THANHTIEN");
			
			
				CTP_BanHangDTO ctp_BanHangDTO = new CTP_BanHangDTO( maCTP_BH,  maP_BH, maSP,  soLuong,  thanhTien);

				result.add(ctp_BanHangDTO);

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
	
	public static void main(String[] args) {
        CTP_BanHangDAO ctp = new CTP_BanHangDAO();
        System.out.println("Next Id: " + ctp.getNexId());
    }
}
