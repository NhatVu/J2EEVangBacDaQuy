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
public class CTP_GiaCongDTO {
    /*
     * Properties
     */

    private int maCTP_GC;
    private int maLoaiGC;
    private int maP_GC;
    private int soLuong;
    private double thanhTien;

    public CTP_GiaCongDTO(int maCTP_GC, int maLoaiGC, int maP_GC, int soLuong, double thanhTien) {
        this.maCTP_GC = maCTP_GC;
        this.maLoaiGC = maLoaiGC;
        this.maP_GC = maP_GC;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    /*
     * Constructor
     */
    public CTP_GiaCongDTO() {
    }

    /*
     * Getters and Setters
     */
    public int getMaCTP_GC() {
        return maCTP_GC;
    }

    public void setMaCTP_GC(int maCTP_GC) {
        this.maCTP_GC = maCTP_GC;
    }

    public int getMaLoaiGC() {
        return maLoaiGC;
    }

    public void setMaLoaiGC(int maLoaiGC) {
        this.maLoaiGC = maLoaiGC;
    }

    public int getMaP_GC() {
        return maP_GC;
    }

    public void setMaP_GC(int maP_GC) {
        this.maP_GC = maP_GC;
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
