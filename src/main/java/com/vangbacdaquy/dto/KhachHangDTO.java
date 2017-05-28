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
public class KhachHangDTO {
    /*
     * Properties
     */

    private int maKH;
    private int maNguoi;
    private boolean laKhachQuen;

    /*
     * Constructor
     */
    public KhachHangDTO(int maKH, int maNguoi, boolean laKhachQuen) {
        this.maKH = maKH;
        this.maNguoi = maNguoi;
        this.laKhachQuen = laKhachQuen;
    }

    public int getMaKH() {
        return maKH;
    }

    /*
     * Gettes and setters
     */
    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getMaNguoi() {
        return maNguoi;
    }

    public void setMaNguoi(int maNguoi) {
        this.maNguoi = maNguoi;
    }

    public boolean isLaKhachQuen() {
        return laKhachQuen;
    }

    public void setLaKhachQuen(boolean laKhachQuen) {
        this.laKhachQuen = laKhachQuen;
    }

}
