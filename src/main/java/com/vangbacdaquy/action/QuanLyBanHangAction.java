package com.vangbacdaquy.action;

import java.util.ArrayList;
import java.util.List;

import com.vangbacdaquy.dto.NguoiDTO;
import com.vangbacdaquy.dto.SanPhamDTO;
import com.vangbacdaquy.models.PhieuBanHangModel;


public class QuanLyBanHangAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	private Integer maPhieu;
	private Integer maKH;
	private String ngayBan;
	private String ngayThanhToan;
	private String hoTen;
	private String diaChi;
	private List<SanPhamDTO> listSP = new ArrayList<SanPhamDTO>();
	private PhieuBanHangModel pbhModel = new PhieuBanHangModel();

	@Override
	public void prepare() throws Exception {
		super.prepare();
		maPhieu = pbhModel.getNextIdOfPhieuBanHang();
	}
	
	@Override
	public String execute() throws Exception {
		return "success";
	}
	
	public String getNextCustomerId(){
        try {
            String nextId = String.valueOf(System.currentTimeMillis()).substring(4);
            result.put("error", false);
            result.put("data", nextId);
        } catch (Exception e) {
            result.put("error", true);
            result.put("message", "Có lỗi vui lòng kiểm tra lại thao tác!");
        }
        return "json";
	}
	public String checkKhachQuen(){
	    result.put("error", true);
	    result.put("message", "Bạn không phải là khách quen");
	    try {
	        if(maKH != null && maKH > 0){
	            NguoiDTO nguoiDTO = pbhModel.kiemTraKhachQuen(maKH);
	            if (nguoiDTO != null) {
	                result.put("error", false);
	                result.put("data", nguoiDTO);
	            } else {
	                result.put("message", "Bạn không phải là khách quen");
	            }
	        }
	    } catch (Exception e) {
	        result.put("error", true);
	        result.put("message", "Có lỗi vui lòng kiểm tra lại thao tác!");
	    }
	    return "json";
	}
	
	public String luuPhieuBanHang(){
        result.put("error", true);
        result.put("message", "Lưu phiếu hàng không thành công!");
        try {
            System.out.println(listSP);
            if(maKH != null && maKH > 0){
                NguoiDTO nguoiDTO = pbhModel.kiemTraKhachQuen(maKH);
                if (nguoiDTO != null) {
                    result.put("error", false);
                    result.put("data", nguoiDTO);
                } else {
                    result.put("message", "Lưu phiếu hàng thành công!");
                }
            }
        } catch (Exception e) {
            result.put("error", true);
            result.put("message", "Có lỗi vui lòng kiểm tra lại thao tác!");
        }
        return "json";
    }

    public Integer getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(Integer maPhieu) {
        this.maPhieu = maPhieu;
    }

    public Integer getMaKH() {
        return maKH;
    }

    public void setMaKH(Integer maKH) {
        this.maKH = maKH;
    }

    public List<SanPhamDTO> getListSP() {
        return listSP;
    }

    public void setListSP(List<SanPhamDTO> listSP) {
        this.listSP = listSP;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    
	
}