package com.vangbacdaquy.models;

import java.util.ArrayList;

import com.vangbacdaquy.dao.CTP_MuaHangDAO;
import com.vangbacdaquy.dao.KhachHangDAO;
import com.vangbacdaquy.dao.NguoiDAO;
import com.vangbacdaquy.dao.P_MuaHangDAO;
import com.vangbacdaquy.dao.SanPhamDAO;
import com.vangbacdaquy.dto.CTP_MuaHangDTO;
import com.vangbacdaquy.dto.KhachHangDTO;
import com.vangbacdaquy.dto.NguoiDTO;
import com.vangbacdaquy.dto.P_MuaHangDTO;
import com.vangbacdaquy.dto.SanPhamDTO;

public class PhieuMuaHangModel {
	
	private NguoiDAO nguoiDAO;
	private KhachHangDAO khachHangDAO;
	private P_MuaHangDAO p_MuaHangDAO;
	private CTP_MuaHangDAO ctp_MuaHangDAO;
	private SanPhamDAO sanPhamDAO;
	
	public PhieuMuaHangModel()
	{
		nguoiDAO = new NguoiDAO();
		khachHangDAO = new KhachHangDAO();
		p_MuaHangDAO = new P_MuaHangDAO();
		ctp_MuaHangDAO = new CTP_MuaHangDAO();
		sanPhamDAO = new SanPhamDAO();
	}
	
	
	public int getNextIdOfNguoi()
	{
		return nguoiDAO.getNexId();
	}
	
	public int getNextIdOfKhacHang()
	{
		return khachHangDAO.getNexId();
	}
	
	public int getNextIdOfPhieuMuaHang()
	{
		return p_MuaHangDAO.getNexId();
	}
	
	public int getNextIdOfChiTietPhieuMuaHang()
	{
		return ctp_MuaHangDAO.getNexId();
	}
	
	public NguoiDTO kiemTraKhachQuen( int shortId )
	{
		return khachHangDAO.checkKhachHangQuen(shortId);
	}
	
	public ArrayList<SanPhamDTO> getAllSanPham()
	{	
		return sanPhamDAO.getAllSanPham();
	}
	
	public boolean updateSoLuongTonOfSanPham(int updateSoLuongTon, int maSP)
	{
		return sanPhamDAO.updateSLTSanPham(updateSoLuongTon, maSP);
	}
	
	public void insertKhachHang( NguoiDTO nguoiDTO, KhachHangDTO khachHangDTO )
	{
		nguoiDAO.insert(nguoiDTO);
		khachHangDAO.insert(khachHangDTO);
	}
	
	public void insertPhieuMuaHang( P_MuaHangDTO p_MuaHangDTO )
	{
		p_MuaHangDAO.insert(p_MuaHangDTO);
	}
	
	public void insertChiTietPhieuMuaHang( CTP_MuaHangDTO ctp_MuaHangDTO )
	{
		ctp_MuaHangDAO.insert(ctp_MuaHangDTO);
	}
	
	public int getMaKhById( int id )
	{
		return khachHangDAO.getMaKhachHangByName(id);
	}
}
