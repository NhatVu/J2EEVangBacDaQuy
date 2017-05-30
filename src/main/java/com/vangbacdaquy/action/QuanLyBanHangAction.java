package com.vangbacdaquy.action;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vangbacdaquy.dto.CTP_BanHangDTO;
import com.vangbacdaquy.dto.KhachHangDTO;
import com.vangbacdaquy.dto.NguoiDTO;
import com.vangbacdaquy.dto.P_BanHangDTO;
import com.vangbacdaquy.dto.P_ThuDTO;
import com.vangbacdaquy.dto.SanPhamDTO;
import com.vangbacdaquy.models.PhieuBanHangModel;
import com.vangbacdaquy.utility.ValidateUtil;


public class QuanLyBanHangAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	private Long tongTien;
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
                
                // check tồn kho trước khi tạo phiếu
                Map<Integer, SanPhamDTO> mapO = new HashMap<Integer, SanPhamDTO>();
                for (SanPhamDTO sp : listSP) {
                    Integer maSP = sp.getMaSP();
                    for (SanPhamDTO sanPhamDTO : pbhModel.getAllSanPham()) {
                        if (maSP==sanPhamDTO.getMaSP()) {
                            sp.setTenSP(sanPhamDTO.getTenSP());
                            sp.setDonGiaMua(sanPhamDTO.getDonGiaMua());
                            sp.setSoLuongTon(sanPhamDTO.getSoLuongTon());
                            sp.setDonGiaBan(sanPhamDTO.getDonGiaBan());
                            break;
                        }
                    }
                    if(mapO.get(maSP) != null){
                        SanPhamDTO sanpham = mapO.get(maSP);
                        int total = sanpham.getSoLuong() + sp.getSoLuong();
                        sanpham.setSoLuong(total);
                        mapO.put(maSP, sanpham);
                    }else{
                        mapO.put(maSP, sp);
                    }
                }
                
                for(Integer i : mapO.keySet()){
                    SanPhamDTO sp = mapO.get(i);
                    if(sp.getSoLuong() > sp.getSoLuongTon()){
                        message = "Số lượng SP "+ sp.getTenSP() +" trong kho không đủ, hiện chỉ còn: " + sp.getSoLuongTon() +"\n";
                    }
                }
                
                if(message.length() != 0){
                    result.put("message", message);
                    return "json";
                }
                /*
                 * insert NguoiiDTO, KhachHangDTO
                 */
                int shortId = maKH;
                NguoiDTO nguoi = pbhModel.kiemTraKhachQuen(shortId);
                maKH = 0;
                if (nguoi == null) {
                    int nextNguoiId = pbhModel.getNextIdOfNguoi();
                    maKH = pbhModel.getNextIdOfKhachHang();
                    NguoiDTO nguoiDTO = new NguoiDTO(nextNguoiId, hoTen, diaChi, shortId);
                    KhachHangDTO khachHangDTO = new KhachHangDTO(maKH, nextNguoiId, false);
                    pbhModel.insertKhachHang(nguoiDTO, khachHangDTO);
                } else {
                    maKH = pbhModel.getMaKhById(shortId);
                }

                /*
                 * insert P_ThuDTO
                 */
                int nextIdPhieuThu = pbhModel.getNextIdOfPhieuThu();
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date dBan = format.parse(ngayBan);
                Date dThanhToan = format.parse(ngayThanhToan);
                P_ThuDTO p_ThuDTO = new P_ThuDTO(
                        nextIdPhieuThu,
                        maKH,
                        new Timestamp(dBan.getTime()),
                        new Timestamp(dThanhToan.getTime()), tongTien==null ? 0 : tongTien);
                pbhModel.insertPhieuThu(p_ThuDTO);

                /*
                 * insert P_BanHangDTO
                 */
                int nextIdPhieuBanHang = pbhModel.getNextIdOfPhieuBanHang();
                P_BanHangDTO p_BanHangDTO = new P_BanHangDTO(
                        nextIdPhieuBanHang, nextIdPhieuThu);
                pbhModel.insertPhieuBanHang(p_BanHangDTO);

                /*
                 * insert CTP_BanHangDTO
                 */
                for (SanPhamDTO sp : listSP) {

                    int soLuong = sp.getSoLuong();
                    int soLuongTon = sp.getSoLuongTon();
                    int maSP = sp.getMaSP();
                    int thanhtien = (int) (sp.getSoLuong() * sp.getDonGiaBan());
                    CTP_BanHangDTO ctp_BanHangDTO = new CTP_BanHangDTO(
                            pbhModel.getNextIdOfChiTietPhieuBanHang(),
                            nextIdPhieuBanHang, maSP, soLuong, thanhtien);
                    pbhModel.insertChiTietPhieuBanHang(ctp_BanHangDTO);

                    /*
                     * update SoLuongTon của SanPham
                     */
                    soLuongTon -= soLuong;
                    pbhModel.updateSoLuongTonOfSanPham(soLuongTon, maSP);

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