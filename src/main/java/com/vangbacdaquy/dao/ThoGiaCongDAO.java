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

import com.vangbacdaquy.dto.ThoGiaCongDTO;

/**
 *
 * @author Administrator
 */
public class ThoGiaCongDAO extends SuperDAO {
	// Properties of table
	private static final String maTho = "MATHOGC";
	private static final String maNguoi = "MANGUOI";

	private static final String insertStatement = "{call THOGIACONG_Ins(?,?)}";
	private static final String updateStatement = "{call THOGIACONG_Upd(?,?)}";
	private static final String deleteStatement = "{call THOGIACONG_Del(?)}";

	// TAG
	private static final String TAG = ThoGiaCongDAO.class.getSimpleName();

	public ThoGiaCongDAO() {

	}

	/*
	 * CRUD
	 */
	public boolean insert(ThoGiaCongDTO n) {
		try {
			this.getConnection();
			call = connection.prepareCall(insertStatement);

			call.setInt(maTho, n.getMaTho());
			call.setInt(maNguoi, n.getMaNguoi());

			return call.execute();

		} catch (SQLException ex) {
			Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
				}
		}
		return false;
	}

	public boolean update(ThoGiaCongDTO n) {
		try {
			this.getConnection();
			call = connection.prepareCall(updateStatement);
			call.setInt(maTho, n.getMaTho());
			call.setInt(maNguoi, n.getMaNguoi());

			return call.execute();

		} catch (SQLException ex) {
			Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
				}
		}
		return false;
	}

	public boolean delete(ThoGiaCongDTO n) {
		try {
			this.getConnection();
			call = connection.prepareCall(deleteStatement);
			call.setInt(maTho, n.getMaTho());

			return call.execute();

		} catch (SQLException ex) {
			Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
				}
		}
		return false;
	}

	public ArrayList<ThoGiaCongDTO> getAllThoGiaCong() {
		try {
			this.getConnection();
			ArrayList<ThoGiaCongDTO> result = new ArrayList<ThoGiaCongDTO>();
			String query = "SELECT * FROM THOGIACONG t join NGUOI n on t.MANGUOI = n.MANGUOI;";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				int maTho = rs.getInt("MATHOGC");
				int maNguoi = rs.getInt("MANGUOI");
				String tenTho = rs.getString("HOTEN");
				String diaChi = rs.getString("DIACHI");
				ThoGiaCongDTO dv = new ThoGiaCongDTO(maTho, maNguoi, tenTho, diaChi);
				result.add(dv);
			}
			st.close();
			return result;
		} catch (SQLException ex) {
			Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException ex) {
					Logger.getLogger(TAG).log(Level.SEVERE, null, ex);
				}
		}
		return null;
	}

}
