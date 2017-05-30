/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vangbacdaquy.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.vangbacdaquy.dto.SanPhamDTO;

/**
 *
 * @author Minh Nhat
 */
public class SanPhamDAO extends SuperDAO {

	private String TAG = SanPhamDAO.class.getSimpleName();

	public SanPhamDAO() {

	}

	/*
	 * CRUD
	 */
	public boolean insert(SanPhamDTO sp) {
		// procedure SANPHAM_Ins (MASP varchar(10), TENLOAISP varchar(30),
		// DONGIAMUA decial, DONGIABAN decimal, SOLUONGTON int )
		try {
			this.getConnection();
			call = connection.prepareCall("{call SANPHAM_Ins(?,?,?,?,?)}");
			call.setInt("MASP", sp.getMaSP());
			call.setString("TENLOAISP", sp.getTenSP());
			call.setDouble("DONGIAMUA", sp.getDonGiaMua());
			call.setDouble("DONGIABAN", sp.getDonGiaBan());
			call.setInt("SOLUONGTON", sp.getSoLuongTon());

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
				Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return false;
	}

	public boolean update(SanPhamDTO sp) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call SANPHAM_Upd(?,?,?,?,?)}");
			call.setInt("MASP", sp.getMaSP());
			call.setString("TENLOAISP", sp.getTenSP());
			call.setDouble("DONGIAMUA", sp.getDonGiaMua());
			call.setDouble("DONGIABAN", sp.getDonGiaBan());
			call.setInt("SOLUONGTON", sp.getSoLuongTon());

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
				Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return false;
	}

	public boolean delete(SanPhamDTO sp) {
		try {
			this.getConnection();
			call = connection.prepareCall("{call SANPHAM_Del(?)}");
			call.setInt("MASP", sp.getMaSP());

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
				Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return false;
	}

	public ArrayList<SanPhamDTO> getAllSanPham() {
		try {
			this.getConnection();
			ArrayList<SanPhamDTO> result = new ArrayList<SanPhamDTO>();
			String query = "SELECT * FROM SANPHAM";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				int maSP = resultSet.getInt("MASP");
				String tenLoaiSP = resultSet.getString("TENLOAISP");
				double donGiaMua = Double.parseDouble(resultSet
						.getString("DONGIAMUA"));
				double donGiaBan = Double.parseDouble(resultSet
						.getString("DONGIABAN"));
				int soLuongTon = Integer.parseInt(resultSet
						.getString("SOLUONGTON"));

				SanPhamDTO sanPhamDTO = new SanPhamDTO(maSP, tenLoaiSP,
						donGiaMua, donGiaBan, soLuongTon);

				result.add(sanPhamDTO);

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

	/*
	 * Cập nhật lại giá trị của SoLuongTon trong table sanpham + Tham Số 1: Số
	 * lương tồn sau khi được cập nhật + Tham số 2: Mã số của dòng được cập nhật
	 */
	public boolean updateSLTSanPham(int updateSoLuongTon, int maSP) {
		PreparedStatement preparedStatement = null;

		try {
			this.getConnection();
			String sql = "update SANPHAM set SOLUONGTON = ? where MASP = ?";

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, updateSoLuongTon);
			preparedStatement.setInt(2, maSP);

			int rows = preparedStatement.executeUpdate();

			if (rows != 0) {
				return true; // khi update thành công
			}

		} catch (SQLException ex) {
			// TODO: handle exception
			ex.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (Exception e) {

			}

			try {
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return false; // khi update không thành công
	}

	public List<Integer> getMaSP() {
		try {
			this.getConnection();
			List<Integer> result = new ArrayList<Integer>();
			call = connection.prepareCall("{call SanPham_getSanPham()}");

			ResultSet rs = call.executeQuery();
			while (rs.next()) {
				result.add(rs.getInt(1));
			}
			return result;

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
				Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return null;
	}

	public List<Double> getDonGiaBan() {
		try {
			this.getConnection();
			List<Double> result = new ArrayList<Double>();
			call = connection.prepareCall("{call SanPham_getDonGiaBan()}");

			ResultSet rs = call.executeQuery();
			while (rs.next()) {
				result.add(rs.getDouble(1));
			}
			return result;
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
				Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}

		return null;
	}

	public List<Double> getDonGiaMua() {
		try {
			this.getConnection();
			List<Double> result = new ArrayList<Double>();
			call = connection.prepareCall("{call SanPham_getDonGiaMua()}");

			ResultSet rs = call.executeQuery();
			while (rs.next()) {
				result.add(rs.getDouble(1));
			}
			return result;
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
				Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}

		return null;
	}

	public List<Integer> getSoLuongTon() {
		try {
			this.getConnection();
			List<Integer> result = new ArrayList<Integer>();
			call = connection.prepareCall("{call SanPham_getSoLuongTon()}");

			ResultSet rs = call.executeQuery();
			while (rs.next()) {
				result.add(rs.getInt(1));
			}
			return result;
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
				Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}

		return null;
	}

	public int getLastID() {
        try {
            this.getConnection();
            call = connection.prepareCall("{call SANPHAM_getLastID(?)}");
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
	
	public static void main(String[] args) {
        SanPhamDAO sp = new SanPhamDAO();
        System.out.println("Next Id: " + sp.getAllSanPham());
        System.out.println("Last Id" + sp.getNexId());
    }
}
