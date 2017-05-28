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
public class NguoiDTO {
    /*
     * Property
     */

    private int maLoaiNguoi;
    private String hoTen;
    private String diaChi;
    private int shortID;

    public NguoiDTO(int maLoaiNguoi, String hoTen, String diaChi, int shortID) {
        this.maLoaiNguoi = maLoaiNguoi;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.shortID = shortID;
    }

    /*
     * Constructor 
     */
    public NguoiDTO() {

    }

    /*
     * Getters and setters
     */
    public int getMaLoaiNguoi() {
        return maLoaiNguoi;
    }

    public void setMaLoaiNguoi(int maLoaiNguoi) {
        this.maLoaiNguoi = maLoaiNguoi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getShortID() {
        return shortID;
    }

    public void setShortID(int shortID) {
        this.shortID = shortID;
    }

}
