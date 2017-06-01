package com.vangbacdaquy.action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vangbacdaquy.dto.CTP_BanHangDTO;
import com.vangbacdaquy.dto.CTP_DichVuDTO;
import com.vangbacdaquy.dto.DichVuDTO;
import com.vangbacdaquy.dto.KhachHangDTO;
import com.vangbacdaquy.dto.NguoiDTO;
import com.vangbacdaquy.dto.P_DichVuDTO;
import com.vangbacdaquy.dto.P_ThuDTO;
import com.vangbacdaquy.dto.SanPhamDTO;
import com.vangbacdaquy.models.PhieuDichVuModel;
import com.vangbacdaquy.utility.ValidateUtil;


public class LapPhieuDichVuAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	private Long tongTien;
	private Integer maPhieu;
	private Integer maKH;
	private String ngayBan;
	private String ngayThanhToan;
	private String hoTen;
	private String diaChi;
	private List<DichVuDTO> listDV = new ArrayList<DichVuDTO>();
	private PhieuDichVuModel pdvModel = new PhieuDichVuModel();

	@Override
	public void prepare() throws Exception {
		super.prepare();
		maPhieu = pdvModel.getNextIdOfPhieuDichVu();
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
	            NguoiDTO nguoiDTO = pdvModel.kiemtraKhachQuen(maKH);
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
	
	public String luuPhieuDichVu(){
	    String message = "";
        result.put("error", true);
        result.put("message", "Lưu phiếu hàng không thành công!");
        try {

            // validate dữ liệu
            message = checkMaxLenthAndValidate(hoTen, maKH, diaChi, ngayThanhToan);
            if(message.length() != 0){
                result.put("message", message);
                return "json";
            }
            if (listDV != null && listDV.size() > 0) {
            	 for (DichVuDTO dv : listDV) {
                     Integer maSP = dv.getMaDV();
                     for (DichVuDTO sanPhamDTO : pdvModel.getAllDichVu()) {
                         if (maSP==sanPhamDTO.getMaDV()) {
                        	 dv.setDonGia(sanPhamDTO.getDonGia());
                             break;
                         }
                     }
            	 }
                /*
                 * insert NguoiiDTO, KhachHangDTO
                 */
                int shortId = maKH;
                NguoiDTO nguoi = pdvModel.kiemtraKhachQuen(shortId);
                maKH = 0;
                if (nguoi == null) {
                    int nextNguoiId = pdvModel.getNextIdOfNguoi();
                    maKH = pdvModel.getNextIdOfKhachHang();
                    NguoiDTO nguoiDTO = new NguoiDTO(nextNguoiId, hoTen, diaChi, shortId);
                    KhachHangDTO khachHangDTO = new KhachHangDTO(maKH, nextNguoiId, false);
                    pdvModel.insertKhachHang(khachHangDTO, nguoiDTO);
                } else {
                    maKH = pdvModel.getMaKhByName(shortId);
                }

                /*
                 * insert P_ThuDTO
                 */
                int nextIdPhieuThu = pdvModel.getNextIdOfPhieuThu();
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date dBan = format.parse(ngayBan);
                Date dThanhToan = format.parse(ngayThanhToan);
                P_ThuDTO p_ThuDTO = new P_ThuDTO(
                        nextIdPhieuThu,
                        maKH,
                        new Timestamp(dBan.getTime()),
                        new Timestamp(dThanhToan.getTime()), tongTien==null ? 0 : tongTien);
                pdvModel.insertP_Thu(p_ThuDTO);

                /*
                 * insert P_BanHangDTO
                 */
                int nextIdPhieuDichVu = pdvModel.getNextIdOfPhieuDichVu();
                P_DichVuDTO pDichVu = new P_DichVuDTO(
                        nextIdPhieuDichVu, nextIdPhieuThu);
                pdvModel.insertP_DichVu(pDichVu);

                /*
                 * insert CTP_BanHangDTO
                 */
                for (DichVuDTO dv : listDV) {

                    int soLuong = dv.getSoLuong();
                    int maDV = dv.getMaDV();
                    int thanhtien = (int) (dv.getSoLuong() * dv.getDonGia());
                    CTP_DichVuDTO ctp_DichVuDTO = new CTP_DichVuDTO(
                            pdvModel.getNextIdOfCTPDV(),
                            nextIdPhieuDichVu, maDV, soLuong, thanhtien);
                    pdvModel.insertCTPDichVu(ctp_DichVuDTO);

                }
                result.put("error", false);
                result.put("message", "Lưu phiếu hàng thành công!");
            }else{
                result.put("message", "Chưa chọn danh sách dịch vụ!");
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
        if(maKH == null || maKH.toString().trim().length() == 0){
            return "Mã khách hàng không được để trống";
        }
        if(ValidateUtil.checkMaxLength(maKH.toString(), 50)){
            return  "Mã KH không được vượt quá 50 ký tự!";
        }
        if(hoTen.trim().length() == 0){
            return "Họ tên không được để trống";
        }
        if(ValidateUtil.checkMaxLength(hoTen, 50)){
            return  "Họ tên không được vượt quá 50 ký tự!";
        }
        if(ValidateUtil.validateFormatName(hoTen)){
            return  "Họ tên không được chứa ký tự đặc biệt!";
        }
        
        if(diaChi.trim().length() == 0){
            return "Địa chỉ không được để trống";
        }
        if(ValidateUtil.checkMaxLength(diaChi, 100)){
            return  "Địa chỉ không được vượt quá 100 ký tự!";
        }
        
        if(ValidateUtil.validateFormatAddress(diaChi)){
            return "Địa chỉ không được chứa ký tự đặc biệt!";
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

    public List<DichVuDTO> getListDV() {
        return listDV;
    }

    public void setListDV(List<DichVuDTO> listDV) {
        this.listDV = listDV;
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