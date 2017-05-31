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
public class HangGiaCongDTO {
    /*
     * Properties
     */

    private int maLoaiGC;
    private String tenLoaiGC;
    private double donGia;
    private int soLuong;

    public HangGiaCongDTO(int maLoaiGC, String tenLoaiGC, double donGia) {
        this.maLoaiGC = maLoaiGC;
        this.tenLoaiGC = tenLoaiGC;
        this.donGia = donGia;
    }

    /*
     * Constructor
     */
    public HangGiaCongDTO() {

    }

    /*
     * Getters and Setters
     */
    public int getMaLoaiGC() {
        return maLoaiGC;
    }

    public void setMaLoaiGC(int maLoaiGC) {
        this.maLoaiGC = maLoaiGC;
    }

    public String getTenLoaiGC() {
        return tenLoaiGC;
    }

    public void setTenLoaiGC(String tenLoaiGC) {
        this.tenLoaiGC = tenLoaiGC;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
}
