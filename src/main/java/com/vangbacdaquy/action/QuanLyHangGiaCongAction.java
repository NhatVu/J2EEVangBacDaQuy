package com.vangbacdaquy.action;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.vangbacdaquy.constant.DatabaseConstant;
import com.vangbacdaquy.dao.HangGiaCongDAO;
import com.vangbacdaquy.dao.ThoGiaCongDAO;
import com.vangbacdaquy.dto.DichVuDTO;
import com.vangbacdaquy.dto.HangGiaCongDTO;
import com.vangbacdaquy.dto.ThoGiaCongDTO;

public class QuanLyHangGiaCongAction extends AbstractAction{
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
	
	private HangGiaCongDAO hgcDAO= new HangGiaCongDAO();
	private ThoGiaCongDAO tgcDAO = new ThoGiaCongDAO();
	private Integer maLoaiGC;
	private String tenLoaiGC;
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
	
	public String updateHangGiaCong(){
	    result.put("error", true);
        result.put("message", "Cập nhật thất bại!");
        try {
            
            HangGiaCongDTO hgc = new HangGiaCongDTO();
            hgc.setMaLoaiGC(maLoaiGC);
            hgc.setTenLoaiGC(tenLoaiGC);
            hgc.setDonGia(donGia);
            System.out.println(hgc);
            
            if(hgcDAO.update(hgc)){
                result.put("error", false);
                result.put("message", "Cập nhật thành công!");
            }
        } catch (Exception e) {
            result.put("error", true);
            result.put("message", "Có lỗi vui lòng kiểm tra lại thao tác!");
        }
        return "json";
	}
	
	public String removeHangGiaCong(){
	    result.put("error", true);
        result.put("message", "Xoá hàng gia công thất bại!");
        try {   
            if(maLoaiGC != null && maLoaiGC > 0){
                HangGiaCongDTO hgc = new HangGiaCongDTO();
                hgc.setMaLoaiGC(maLoaiGC);
                if(hgcDAO.delete(hgc)){
                  result.put("error", false);
                  result.put("message", "Xóa hàng gia công thành công!");
                }
            }

        } catch (Exception e) {
            result.put("error", true);
            result.put("message", "Có lỗi vui lòng kiểm tra lại thao tác!");
        }
        return "json";
	}
	
	public String addHangGiaCong(){
        result.put("error", true);
        result.put("message", "Thêm mới thất bại!");
        try {

            HangGiaCongDTO hgc = new HangGiaCongDTO();
            maLoaiGC = hgcDAO.getNexId();
            hgc.setMaLoaiGC(maLoaiGC);
            hgc.setTenLoaiGC(tenLoaiGC);
            hgc.setDonGia(donGia);
            
            if(hgcDAO.insert(hgc)){
                result.put("error", false);
                result.put("message", "Thêm mới thành công!");
            }
        } catch (Exception e) {
            result.put("error", true);
            result.put("message", "Có lỗi vui lòng kiểm tra lại thao tác!");
        }
        return "json";
    }
	
	public String getAllHangGiaCong(){
	    result.put("error", true);
	    List<HangGiaCongDTO> listSanPham = new ArrayList<HangGiaCongDTO>();
	    try {
	        listSanPham = hgcDAO.getAllHangGiaCong();
	        result.put("error", false);
        } catch (Exception e) {
            result.put("error", true);
        }
	    result.put("data", listSanPham);
		return "json";
	}
	
	public String getAllThoGiaCong(){
        result.put("error", true);
        List<ThoGiaCongDTO> list = new ArrayList<ThoGiaCongDTO>();
        try {
            list = tgcDAO.getAllThoGiaCong();
            result.put("error", false);
        } catch (Exception e) {
            result.put("error", true);
        }
        result.put("data", list);
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

    public Integer getMaLoaiGC() {
        return maLoaiGC;
    }

    public void setMaLoaiGC(Integer maLoaiGC) {
        this.maLoaiGC = maLoaiGC;
    }

    public String getTenLoaiGC() {
        return tenLoaiGC;
    }

    public void setTenLoaiGC(String tenLoaiGC) {
        this.tenLoaiGC = tenLoaiGC;
    }

    public Integer getDonGia() {
        return donGia;
    }

    public void setDonGia(Integer donGia) {
        this.donGia = donGia;
    }

    
	
	
}