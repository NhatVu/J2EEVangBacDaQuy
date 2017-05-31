/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vangbacdaquy.models;

import java.util.ArrayList;

import com.vangbacdaquy.dao.CTP_DichVuDAO;
import com.vangbacdaquy.dao.DichVuDAO;
import com.vangbacdaquy.dao.KhachHangDAO;
import com.vangbacdaquy.dao.NguoiDAO;
import com.vangbacdaquy.dao.P_DichVuDAO;
import com.vangbacdaquy.dao.P_ThuDAO;
import com.vangbacdaquy.dto.CTP_DichVuDTO;
import com.vangbacdaquy.dto.DichVuDTO;
import com.vangbacdaquy.dto.KhachHangDTO;
import com.vangbacdaquy.dto.NguoiDTO;
import com.vangbacdaquy.dto.P_DichVuDTO;
import com.vangbacdaquy.dto.P_ThuDTO;

/**
 *
 * @author Administrator
 */
public class PhieuDichVuModel {
    private P_DichVuDAO mPhieuDichVuDAO;
    private KhachHangDAO mKhachHangDAO;
    private DichVuDAO mDichVu;
    private CTP_DichVuDAO mCTPDV;
    private NguoiDAO mNguoiDAO;
    private P_ThuDAO mPhieuThuDAO;
    

    public PhieuDichVuModel() {
        mPhieuDichVuDAO = new P_DichVuDAO();
        mKhachHangDAO = new KhachHangDAO();
        mDichVu = new DichVuDAO();
        mCTPDV = new CTP_DichVuDAO();
        mNguoiDAO = new NguoiDAO();
        mPhieuThuDAO = new P_ThuDAO();
    }
    
    public int getNextIdOfPhieuDichVu()
    {
        return mPhieuDichVuDAO.getNexId();
    }
    
    public int getNextIdOfKhachHang()
    {
        return mKhachHangDAO.getNexId();
    }
    
    public int getNextIdOfNguoi()
    {
        return mNguoiDAO.getNexId();
    }
    
    public int getNextIdOfPhieuThu()
    {
        return mPhieuThuDAO.getNexId();
    }
    
    public int getNextIdOfCTPDV()
    {
        return mCTPDV.getNexId();
    }
    
    public NguoiDTO kiemtraKhachQuen(int shortId)
    {
        return mKhachHangDAO.checkKhachHangQuen(shortId);
    }
    
    public ArrayList<DichVuDTO> getAllDichVu()
    {
        return mDichVu.getAllDichVu();
    }
    
    public void insertCTPDichVu(CTP_DichVuDTO ctp_DV)
    {
        mCTPDV.insert(ctp_DV);
    }
    
    public void insertP_DichVu(P_DichVuDTO p_DV)
    {
        mPhieuDichVuDAO.insert(p_DV);
    }
    
    public void insertKhachHang(KhachHangDTO kh,NguoiDTO nguoi)
    {
    	mNguoiDAO.insert(nguoi);
        mKhachHangDAO.insert(kh);
    }
    
    public void insertP_Thu(P_ThuDTO pThu)
    {
        mPhieuThuDAO.insert(pThu);
    }
    
    public int getMaKhByName(int id)
    {
        return mKhachHangDAO.getMaKhachHangByName(id);
    }
    

}
