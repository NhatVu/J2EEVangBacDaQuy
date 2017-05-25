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
public class CTP_BanHangDTO {
    /*
     * Properties
     */

    private int maCTP_BH = 0;
    private int maP_BH = 0;
    private int maSP = 0;
    private int soLuong = 0;
    private double thanhTien = 0;

    /*
     * Constructor
     */
    public CTP_BanHangDTO() {

    }

    /*
     * Getters and Setters
     */
    public CTP_BanHangDTO(int maCTP_BH, int maP_BH, int maSP, int soLuong, double thanhTien) {
        super();
        this.maCTP_BH = maCTP_BH;
        this.maP_BH = maP_BH;
        this.maSP = maSP;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public int getMaCTP_BH() {
        return maCTP_BH;
    }

    public void setMaCTP_BH(int maCTP_BH) {
        this.maCTP_BH = maCTP_BH;
    }

    public int getMaP_BH() {
        return maP_BH;
    }

    public void setMaP_BH(int maP_BH) {
        this.maP_BH = maP_BH;
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
