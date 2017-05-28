package com.vangbacdaquy.models;

import java.util.ArrayList;

import com.vangbacdaquy.dao.CTP_BanHangDAO;
import com.vangbacdaquy.dao.KhachHangDAO;
import com.vangbacdaquy.dao.NguoiDAO;
import com.vangbacdaquy.dao.P_BanHangDAO;
import com.vangbacdaquy.dao.P_ThuDAO;
import com.vangbacdaquy.dao.SanPhamDAO;
import com.vangbacdaquy.dto.CTP_BanHangDTO;
import com.vangbacdaquy.dto.KhachHangDTO;
import com.vangbacdaquy.dto.NguoiDTO;
import com.vangbacdaquy.dto.P_BanHangDTO;
import com.vangbacdaquy.dto.P_ThuDTO;
import com.vangbacdaquy.dto.SanPhamDTO;

public class PhieuBanHangModel {
	
	private NguoiDAO nguoiDAO;
	private KhachHangDAO khachHangDAO;
	private P_ThuDAO p_ThuDAO;
	private P_BanHangDAO p_BanHangDAO;
	private CTP_BanHangDAO ctp_BanHangDAO;
	private SanPhamDAO sanPhamDAO;
	
	public PhieuBanHangModel() {
		// TODO Auto-generated constructor stub
		nguoiDAO = new NguoiDAO();
		khachHangDAO = new KhachHangDAO();
		p_ThuDAO = new P_ThuDAO();
		p_BanHangDAO = new P_BanHangDAO();
		ctp_BanHangDAO = new CTP_BanHangDAO();
		sanPhamDAO = new SanPhamDAO();
	}
	
	public int getNextIdOfNguoi()
	{
		return nguoiDAO.getNexId();
	}
	
	public int getNextIdOfKhachHang()
	{
		return khachHangDAO.getNexId();
	}
	
	public int getNextIdOfPhieuThu()
	{
		return p_ThuDAO.getNexId();
	}
	
	public int getNextIdOfPhieuBanHang()
	{
		return p_BanHangDAO.getNexId();
	}
	
	public int getNextIdOfChiTietPhieuBanHang()
	{
		return ctp_BanHangDAO.getNexId();
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
	
	public void insertPhieuThu( P_ThuDTO p_ThuDTO )
	{
		p_ThuDAO.insert(p_ThuDTO);
	}
	
	public void insertPhieuBanHang( P_BanHangDTO p_BanHangDTO )
	{
		p_BanHangDAO.insert(p_BanHangDTO);
	}
	
	public void insertChiTietPhieuBanHang( CTP_BanHangDTO ctp_BanHangDTO )
	{
		ctp_BanHangDAO.insert(ctp_BanHangDTO);
	}
	
	public int getMaKhById( int id )
	{
		return khachHangDAO.getMaKhachHangByName(id);
	}
	
	
}
