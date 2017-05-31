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

import com.vangbacdaquy.dto.HangGiaCongDTO;
import com.vangbacdaquy.dto.NguoiDTO;

/**
 *
 * @author Administrator
 */
public class HangGiaCongDAO extends SuperDAO {

	// Properties of table
	private static final String maLoaiGiaCong = "MALOAIGC";
	private static final String tenLoaiGiaCong = "TENLOAIGC";
	private static final String donGia = "DONGIA";

	private static final String insertStatement = "{call HANGGIACONG_Ins(?,?,?)}";
	private static final String updateStatement = "{call HANGGIACONG_Upd(?,?,?)}";
	private static final String deleteStatement = "{call CTP_GIACONG_Del(?)}";
	// TAG
	private static final String TAG = HangGiaCongDAO.class.getSimpleName();

	public HangGiaCongDAO() {

	}

	/*
	 * CRUD
	 */
	public boolean insert(HangGiaCongDTO n) {
		try {
			this.getConnection();
			call = connection.prepareCall(insertStatement);

			call.setInt(maLoaiGiaCong, n.getMaLoaiGC());
			call.setString(tenLoaiGiaCong, n.getTenLoaiGC());
			call.setDouble(donGia, n.getDonGia());

			return call.execute();

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

	public boolean update(HangGiaCongDTO n) {
		try {
			this.getConnection();
			call = connection.prepareCall(updateStatement);
			call.setInt(maLoaiGiaCong, n.getMaLoaiGC());
			call.setString(tenLoaiGiaCong, n.getTenLoaiGC());
			call.setDouble(donGia, n.getDonGia());

			return call.execute();

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
			call.setInt(maLoaiGiaCong, n.getMaLoaiNguoi());

			return call.execute();

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

	public ArrayList<HangGiaCongDTO> getAllHangGiaCong() {
		try {
			this.getConnection();
			ArrayList<HangGiaCongDTO> result = new ArrayList<HangGiaCongDTO>();
			String query = "SELECT * FROM HANGGIACONG";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				int maGC = rs.getInt("MALOAIGC");
				String tenGC = rs.getString("TENLOAIGC");
				double dongia = Double.parseDouble(rs.getString("DONGIA"));
				HangGiaCongDTO dv = new HangGiaCongDTO(maGC, tenGC, dongia);
				result.add(dv);
			}
			st.close();
			return result;
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
}
