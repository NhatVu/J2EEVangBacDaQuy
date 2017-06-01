package com.vangbacdaquy.action;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.vangbacdaquy.constant.DatabaseConstant;
import com.vangbacdaquy.dao.SanPhamDAO;
import com.vangbacdaquy.dto.SanPhamDTO;

public class QuanLySanPhamAction extends AbstractAction{
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
		
	private List<Document> listDocument = new ArrayList<Document>();
	
	private static final long serialVersionUID = 1L;
	
	private SanPhamDAO spDAO= new SanPhamDAO();
	private Integer maSP;
	private String tenSP;
	private Integer donGiaMua;
	private Integer donGiaBan;
	private Integer soLuongTon;
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
	
	public String updateSanPham(){
	    result.put("error", true);
        result.put("message", "Cập nhật thất bại!");
        try {

            SanPhamDTO sp = new SanPhamDTO();
            sp.setMaSP(maSP);
            sp.setTenSP(tenSP);
            sp.setDonGiaMua(donGiaMua);
            sp.setDonGiaBan(donGiaBan);
            sp.setSoLuongTon(soLuongTon);
            System.out.println(sp);
            
            if(spDAO.update(sp)){
                result.put("error", false);
                result.put("message", "Cập nhật thành công!");
            }
        } catch (Exception e) {
            result.put("error", true);
            result.put("message", "Có lỗi vui lòng kiểm tra lại thao tác!");
        }
        return "json";
	}
	
	public String removeSanPham(){
	    result.put("error", true);
        result.put("message", "Xoá sản phẩm thất bại!");
        try {   
            if(maSP != null && maSP > 0){
                SanPhamDTO sp = new SanPhamDTO();
                sp.setMaSP(maSP);
                if(spDAO.delete(sp)){
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
	
	public String addKeyword(){
        result.put("error", true);
        result.put("message", "Thêm mới thất bại!");
        try {

            SanPhamDTO sp = new SanPhamDTO();
            maSP = spDAO.getNexId();
            sp.setMaSP(maSP);
            sp.setTenSP(tenSP);
            sp.setDonGiaMua(donGiaMua);
            sp.setDonGiaBan(donGiaBan);
            sp.setSoLuongTon(soLuongTon);
            System.out.println(sp);
            
            if(spDAO.insert(sp)){
                result.put("error", false);
                result.put("message", "Thêm mới thành công!");
            }
        } catch (Exception e) {
            result.put("error", true);
            result.put("message", "Có lỗi vui lòng kiểm tra lại thao tác!");
        }
        return "json";
    }
	
	public String getAllSanPham(){
	    result.put("error", true);
	    List<SanPhamDTO> listSanPham = new ArrayList<SanPhamDTO>();
	    try {
	        listSanPham = spDAO.getAllSanPham();
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

	public List<Document> getListDocument() {
		return listDocument;
	}

	public void setListDocument(List<Document> listDocument) {
		this.listDocument = listDocument;
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

    public Integer getMaSP() {
        return maSP;
    }

    public void setMaSP(Integer maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Integer getDonGiaMua() {
        return donGiaMua;
    }

    public void setDonGiaMua(Integer donGiaMua) {
        this.donGiaMua = donGiaMua;
    }

    public Integer getDonGiaBan() {
        return donGiaBan;
    }

    public void setDonGiaBan(Integer donGiaBan) {
        this.donGiaBan = donGiaBan;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }	
	
	
}