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
public class SanPhamDTO {
    /*
     * Properties
     */

    private int maSP;
    private String tenSP;
    private double donGiaMua = 0;
    private double donGiaBan = 0;
    private int soLuongTon = 0;
    private int soLuong = 0;

    /*
     * Constructor
     */
    /*
     * Getters and Setters
     */
    public SanPhamDTO(int maSP, String tenSP, double donGiaMua, double donGiaBan, int soLuongTon) {
        super();
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGiaMua = donGiaMua;
        this.donGiaBan = donGiaBan;
        this.soLuongTon = soLuongTon;
    }

    public SanPhamDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getDonGiaBan() {
        return donGiaBan;
    }

    public void setDonGiaBan(double donGiaBan) {
        this.donGiaBan = donGiaBan;
    }

    public double getDonGiaMua() {
        return donGiaMua;
    }

    public void setDonGiaMua(double donGiaMua) {
        this.donGiaMua = donGiaMua;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public int getSoLuong() {
        return soLuong;
    }
    
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    @Override
    public String toString() {
        return "SanPhamDTO [maSP=" + maSP + ", tenSP=" + tenSP + ", donGiaMua="
                + donGiaMua + ", donGiaBan=" + donGiaBan + ", soLuongTon="
                + soLuongTon + "]";
    }


    
}
