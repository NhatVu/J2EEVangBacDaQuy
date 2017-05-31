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
public class ThoGiaCongDTO {
    /*
     * Properties
     */

    private int maTho;
    private int maNguoi;
    private String tenTho;
    private String diaChi;

    public ThoGiaCongDTO(int maTho, int maNguoi) {
        this.maTho = maTho;
        this.maNguoi = maNguoi;
    }
    public ThoGiaCongDTO(int maTho, int maNguoi, String tenTho) {
        this.maTho = maTho;
        this.maNguoi = maNguoi;
        this.tenTho = tenTho;
    }
    
    public ThoGiaCongDTO(int maTho, int maNguoi, String tenTho, String diaChi) {
        this.maTho = maTho;
        this.maNguoi = maNguoi;
        this.tenTho = tenTho;
        this.diaChi = diaChi;
    }

    /*
     * Constructor
     */
    public ThoGiaCongDTO() {

    }

    /*
     * Getters and Setters
     */
    public int getMaTho() {
        return maTho;
    }

    public void setMaTho(int maTho) {
        this.maTho = maTho;
    }

    public int getMaNguoi() {
        return maNguoi;
    }

    public void setMaNguoi(int maNguoi) {
        this.maNguoi = maNguoi;
    }

    public String getTenTho() {
        return tenTho;
    }

    public void setTenTho(String tenTho) {
        this.tenTho = tenTho;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
    
}
