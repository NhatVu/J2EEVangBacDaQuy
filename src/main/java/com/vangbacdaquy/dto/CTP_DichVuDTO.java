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
public class CTP_DichVuDTO {

    /*
     * Properties
     */
    private int maCTP_DV;
    private int maP_DV;
    private int maDV;
    private int soLuong;
    private double thanhTien;

    public CTP_DichVuDTO(int maCTP_DV, int maP_DV, int maDV, int soLuong, double thanhTien) {
        this.maCTP_DV = maCTP_DV;
        this.maP_DV = maP_DV;
        this.maDV = maDV;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    /*
     * Constructor
     */
    public CTP_DichVuDTO() {
    }

    /*
     * Getters and Setters
     */
    public int getMaCTP_DV() {
        return maCTP_DV;
    }

    public void setMaCTP_DV(int maCTP_DV) {
        this.maCTP_DV = maCTP_DV;
    }

    public int getMaP_DV() {
        return maP_DV;
    }

    public void setMaP_DV(int maP_DV) {
        this.maP_DV = maP_DV;
    }

    public int getMaDV() {
        return maDV;
    }

    public void setMaDV(int maDV) {
        this.maDV = maDV;
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
