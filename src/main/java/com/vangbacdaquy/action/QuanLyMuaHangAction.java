package com.vangbacdaquy.action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vangbacdaquy.dto.CTP_MuaHangDTO;
import com.vangbacdaquy.dto.KhachHangDTO;
import com.vangbacdaquy.dto.NguoiDTO;
import com.vangbacdaquy.dto.P_MuaHangDTO;
import com.vangbacdaquy.dto.SanPhamDTO;
import com.vangbacdaquy.models.PhieuMuaHangModel;
import com.vangbacdaquy.utility.ValidateUtil;


public class QuanLyMuaHangAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	private Long tongTien;
	private Integer maPhieu;
	private Integer maKH;
	private String ngayBan;
	private String ngayThanhToan;
	private String hoTen;
	private String diaChi;
	private List<SanPhamDTO> listSP = new ArrayList<SanPhamDTO>();
	private PhieuMuaHangModel pmhModel = new PhieuMuaHangModel();

	@Override
	public void prepare() throws Exception {
		super.prepare();
		maPhieu = pmhModel.getNextIdOfPhieuMuaHang();
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
	            NguoiDTO nguoiDTO = pmhModel.kiemTraKhachQuen(maKH);
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
	
	public String luuPhieuMuaHang(){
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
            if (listSP != null && listSP.size() > 0) {
                /*
                 * insert NguoiiDTO, KhachHangDTO
                 */
                int shortId = maKH;
                NguoiDTO nguoi = pmhModel.kiemTraKhachQuen(shortId);
                maKH = 0;
                if (nguoi == null) {
                    int nextNguoiId = pmhModel.getNextIdOfNguoi();
                    maKH = pmhModel.getNextIdOfKhacHang();
                    NguoiDTO nguoiDTO = new NguoiDTO(nextNguoiId, hoTen, diaChi, shortId);
                    KhachHangDTO khachHangDTO = new KhachHangDTO(maKH, nextNguoiId, false);
                    pmhModel.insertKhachHang(nguoiDTO, khachHangDTO);
                } else {
                    maKH = pmhModel.getMaKhById(shortId);
                }

                /*
                 * insert p_MuaHangDTO
                 */
                int nextIdPhieuMuaHang = pmhModel.getNextIdOfChiTietPhieuMuaHang();
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date dBan = format.parse(ngayBan);
                Date dThanhToan = format.parse(ngayThanhToan);
                P_MuaHangDTO p_MuaHangDTO = new P_MuaHangDTO(
                        nextIdPhieuMuaHang,
                        maKH,
                        new Timestamp(dBan.getTime()),
                        new Timestamp(dThanhToan.getTime()), tongTien==null ? 0 : tongTien);
                pmhModel.insertPhieuMuaHang(p_MuaHangDTO);

                /*
                 * insert CTP_BanHangDTO
                 */
                for (SanPhamDTO sp : listSP) {

                    int maSP = sp.getMaSP();
                    int soLuongTon = 0; // được lấy lên từ Database
                    
                    for (SanPhamDTO sanPhamDTO : pmhModel.getAllSanPham()) {
                        if (maSP == sanPhamDTO.getMaSP()) {
                            soLuongTon = sanPhamDTO.getSoLuongTon();
                            sp.setDonGiaBan(sanPhamDTO.getDonGiaBan());
                            break;
                        }
                    }

                    int soLuong = sp.getSoLuong();
                    int thanhtien = (int) (sp.getSoLuong() * sp.getDonGiaBan());
                    CTP_MuaHangDTO ctp_MuaHangDTO = new CTP_MuaHangDTO(
                            pmhModel.getNextIdOfChiTietPhieuMuaHang(),
                            nextIdPhieuMuaHang,
                            maSP,
                            soLuong,
                            thanhtien
                            );
                    pmhModel.insertChiTietPhieuMuaHang(ctp_MuaHangDTO);

                    /*
                     *  update SoLuongTon của SanPham
                     */
                    soLuongTon += soLuong;
                    pmhModel.updateSoLuongTonOfSanPham(soLuongTon, maSP);

                }
                result.put("error", false);
                result.put("message", "Lưu phiếu hàng thành công!");
            }else{
                result.put("message", "Chưa chọn danh sách sản phẩm");
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

    public Long getTongTien() {
        return tongTien;
    }

    public void setTongTien(Long tongTien) {
        this.tongTien = tongTien;
    }
    
    
    
	
}