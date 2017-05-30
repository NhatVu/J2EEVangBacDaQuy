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
public class P_MuaHangDTO {
    /*
     * Properties
     */

    private int maP_MH;
    private int maKH;
    private Timestamp ngayMua = null;
    private Timestamp ngayThanhToan = null;
    private double tongCong = 0;

    /*
     * Constructor
     */
    public P_MuaHangDTO() {

    }

    public P_MuaHangDTO(int maP_MH, int maKH, Timestamp ngayMua, Timestamp ngayThanhToan, double tongCong) {
        super();
        this.maP_MH = maP_MH;
        this.maKH = maKH;
        this.ngayMua = ngayMua;
        this.ngayThanhToan = ngayThanhToan;
        this.tongCong = tongCong;
    }

    public int getMaP_MH() {
        return maP_MH;
    }

    public void setMaP_MH(int maP_MH) {
        this.maP_MH = maP_MH;
    }

    public int getMaKH() {
        return maKH;
    }

    /*
     * Getters and Setters
     */
    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public Timestamp getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Timestamp ngayMua) {
        this.ngayMua = ngayMua;
    }

    public Timestamp getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Timestamp ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public double getTongCong() {
        return tongCong;
    }

    public void setTongCong(double tongCong) {
        this.tongCong = tongCong;
    }

}
