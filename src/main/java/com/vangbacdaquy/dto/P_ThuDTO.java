/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vangbacdaquy.dto;

import java.sql.Timestamp;

/**
 *
 * @author Minh Nhat
 */
public class P_ThuDTO {
    /*
     * Properties
     */

    private int maP_Thu;
    private int maKH;
    private Timestamp ngayLapPhieu;
    private Timestamp ngayKetThuc;
    private double tongCong;
    private int maP_BH;
    private int maP_DV;

    public P_ThuDTO(int maP_Thu, int maKH, Timestamp ngayLapPhieu, Timestamp ngayKetThuc, double tongCong) {
        this.maP_Thu = maP_Thu;
        this.maKH = maKH;
        this.ngayLapPhieu = ngayLapPhieu;
        this.ngayKetThuc = ngayKetThuc;
        this.tongCong = tongCong;
    }

    /*
     * Constructor
     */
    public P_ThuDTO() {

    }

    /*
     * Getters and Setters
     */
    public int getMaP_Thu() {
        return maP_Thu;
    }

    public void setMaP_Thu(int maP_Thu) {
        this.maP_Thu = maP_Thu;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public Timestamp getNgayLapPhieu() {
        return ngayLapPhieu;
    }

    public void setNgayLapPhieu(Timestamp ngayLapPhieu) {
        this.ngayLapPhieu = ngayLapPhieu;
    }

    public Timestamp getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Timestamp ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public double getTongCong() {
        return tongCong;
    }

    public void setTongCong(double tongCong) {
        this.tongCong = tongCong;
    }

	public int getMaP_BH() {
		return maP_BH;
	}

	public void setMaP_BH(int maP_BH) {
		this.maP_BH = maP_BH;
	}

	public int getMaP_DV() {
		return maP_DV;
	}

	public void setMaP_DV(int maP_DV) {
		this.maP_DV = maP_DV;
	}
    
    

}
