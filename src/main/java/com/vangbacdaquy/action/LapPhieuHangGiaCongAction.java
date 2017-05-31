package com.vangbacdaquy.action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vangbacdaquy.dto.CTP_GiaCongDTO;
import com.vangbacdaquy.dto.HangGiaCongDTO;
import com.vangbacdaquy.dto.P_GiaCongDTO;
import com.vangbacdaquy.models.PhieuGiaCongModel;
import com.vangbacdaquy.utility.ValidateUtil;


public class LapPhieuHangGiaCongAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	private Long tongTien;
	private Integer maPhieu;
	private Integer maKH;
	private String ngayBan;
	private String ngayThanhToan;
	private String hoTen;
	private String diaChi;
	private List<HangGiaCongDTO> listSP = new ArrayList<HangGiaCongDTO>();
	private PhieuGiaCongModel pgcModel = new PhieuGiaCongModel();

	@Override
	public void prepare() throws Exception {
		super.prepare();
		maPhieu = pgcModel.getNextIdOfPhieuGiaCong();
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
	
	public String luuPhieuHangGiaCong(){
	    String message = "";
        result.put("error", true);
        result.put("message", "Lưu phiếu hàng không thành công!");
        try {

            // validate dữ liệu
            message = checkMaxLenthAndValidate(hoTen==null? "":hoTen, maKH, diaChi==null?"":diaChi, ngayThanhToan);
            if(message.length() != 0){
                result.put("message", message);
                return "json";
            }
            if (listSP != null && listSP.size() > 0) {

                
                int nextIdOfPhieuGiaCong = pgcModel.getNextIdOfPhieuGiaCong();
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date dBan = format.parse(ngayBan);
                Date dThanhToan = format.parse(ngayThanhToan);
                P_GiaCongDTO pGiaCong = new P_GiaCongDTO(
                        nextIdOfPhieuGiaCong,
                        maKH,
                        new Timestamp(dBan.getTime()),
                        new Timestamp(dThanhToan.getTime()), tongTien==null ? 0 : tongTien);
                pgcModel.insertP_GiaCong(pGiaCong);

                /*
                 * insert CTP_BanHangDTO
                 */
                for (HangGiaCongDTO sp : listSP) {

                    int soLuong = sp.getSoLuong();
                    int maSP = sp.getMaLoaiGC();
                    int thanhtien = (int) (sp.getSoLuong() * sp.getDonGia());
                    CTP_GiaCongDTO ctp = new CTP_GiaCongDTO(
                            pgcModel.getNextIdOfCTPGC(),
                            nextIdOfPhieuGiaCong, maSP, soLuong, thanhtien);
                    pgcModel.insertCTP_GiaCong(ctp);

                }
                result.put("error", false);
                result.put("message", "Lưu phiếu hàng thành công!");
            }else{
                result.put("message", "Chưa chọn danh sách hàng gia công!");
            }
        
        } catch (Exception e) {
            result.put("error", true);
            result.put("message", "Có lỗi vui lòng kiểm tra lại thao tác!");
        }
        return "json";
    }

    private String checkMaxLenthAndValidate(String hoTen, Integer maKH,
            String diaChi, String ngayThanhToan) {
        if(ngayThanhToan.trim().length() == 0){
            return "Ngày thanh toán không được để trống";
        }
        return "";
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

    public List<HangGiaCongDTO> getListSP() {
        return listSP;
    }

    public void setListSP(List<HangGiaCongDTO> listSP) {
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

    public Long getTongTien() {
        return tongTien;
    }

    public void setTongTien(Long tongTien) {
        this.tongTien = tongTien;
    }
    
    
    
	
}