/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vangbacdaquy.dto;

/**
 *
 * @author Minh Nhat
 */
public class CTP_MuaHangDTO {
    /*
     * Properties
     */

    private int maCTP_MH;
    private int maP_MH;
    private int maSP;
    private int soLuong = 0;
    private double thanhTien = 0;

    /*
     * Constructor
     */
    public CTP_MuaHangDTO() {
    }

    /*
     * Getters and Setters
     */
    public CTP_MuaHangDTO(int maCTP_MH, int maP_MH, int maSP, int soLuong, double thanhTien) {
        super();
        this.maCTP_MH = maCTP_MH;
        this.maP_MH = maP_MH;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public int getMaCTP_MH() {
        return maCTP_MH;
    }

    public void setMaCTP_MH(int maCTP_MH) {
        this.maCTP_MH = maCTP_MH;
    }

    public int getMaP_MH() {
        return maP_MH;
    }

    public void setMaP_MH(int maP_MH) {
        this.maP_MH = maP_MH;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

}
