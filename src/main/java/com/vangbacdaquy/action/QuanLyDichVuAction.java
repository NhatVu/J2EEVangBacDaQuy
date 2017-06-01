package com.vangbacdaquy.action;

import java.util.ArrayList;
import java.util.List;

import com.vangbacdaquy.constant.DatabaseConstant;
import com.vangbacdaquy.dao.DichVuDAO;
import com.vangbacdaquy.dto.DichVuDTO;
import com.vangbacdaquy.dto.SanPhamDTO;

public class QuanLyDichVuAction extends AbstractAction{
	private String logConsole;
	private Integer id;
	private String key;
	private String value;
	// 0: off, 1: on
	private Integer streaming;
	private String statusStreaming = "Đã ngừng hoạt động!";
	private String statusBackgound = "label-danger";
	
	// crawl Link
	private String url = "";
			
	private static final long serialVersionUID = 1L;
	
	private DichVuDAO dvDAO= new DichVuDAO();
	private Integer maDV;
	private String tenDV;
	private Integer donGia;
	public String getLogConsole() {
		return logConsole;
	}

	public void setLogConsole(String logConsole) {
		this.logConsole = logConsole;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
	}
	
	@Override
	public String execute() throws Exception {
		return "success";
	}
	
	public String updateDichVu(){
	    result.put("error", true);
        result.put("message", "Cập nhật thất bại!");
        try {

            DichVuDTO dv = new DichVuDTO();
            dv.setMaDV(maDV);
            dv.setTenDV(tenDV);
            dv.setDonGia(donGia);
            System.out.println(dv);
            
            if(dvDAO.update(dv)){
                result.put("error", false);
                result.put("message", "Cập nhật thành công!");
            }
        } catch (Exception e) {
            result.put("error", true);
            result.put("message", "Có lỗi vui lòng kiểm tra lại thao tác!");
        }
        return "json";
	}
	
	public String removeDichVu(){
	    result.put("error", true);
        result.put("message", "Xoá sản phẩm thất bại!");
        try {   
            if(maDV != null && maDV > 0){
                DichVuDTO dv = new DichVuDTO();
                dv.setMaDV(maDV);
                System.out.println(dv);
                if(dvDAO.delete(dv)){
                  result.put("error", false);
                  result.put("message", "Xóa sản phẩm thành công!");
                }
            }

        } catch (Exception e) {
            result.put("error", true);
            result.put("message", "Có lỗi vui lòng kiểm tra lại thao tác!");
        }
        return "json";
	}
	
	public String addDichVu(){
        result.put("error", true);
        result.put("message", "Thêm mới thất bại!");
        try {

            DichVuDTO dv = new DichVuDTO();
            maDV = dvDAO.getNexId();
            dv.setMaDV(maDV);
            dv.setTenDV(tenDV);
            dv.setDonGia(donGia);
            System.out.println(dv);
            
            if(dvDAO.insert(dv)){
                result.put("error", false);
                result.put("message", "Thêm mới thành công!");
            }
        } catch (Exception e) {
            result.put("error", true);
            result.put("message", "Có lỗi vui lòng kiểm tra lại thao tác!");
        }
        return "json";
    }
	
	public String getAllDichVu(){
	    result.put("error", true);
	    List<DichVuDTO> listSanPham = new ArrayList<DichVuDTO>();
	    try {
	        listSanPham = dvDAO.getAllDichVu();
	        result.put("error", false);
        } catch (Exception e) {
            result.put("error", true);
        }
	    result.put("data", listSanPham);
		return "json";
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getStreaming() {
		return streaming;
	}

	public void setStreaming(Integer streaming) {
		this.streaming = streaming;
	}

	public String getStatusStreaming() {
		return statusStreaming;
	}

	public void setStatusStreaming(String statusStreaming) {
		this.statusStreaming = statusStreaming;
	}

	public String getStatusBackgound() {
		return statusBackgound;
	}

	public void setStatusBackgound(String statusBackgound) {
		this.statusBackgound = statusBackgound;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

    public Integer getMaDV() {
        return maDV;
    }

    public void setMaDV(Integer maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public Integer getDonGia() {
        return donGia;
    }

    public void setDonGia(Integer donGia) {
        this.donGia = donGia;
    }

    
	
	
}