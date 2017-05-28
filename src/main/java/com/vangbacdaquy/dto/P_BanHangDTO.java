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
public class P_BanHangDTO {
    /*
     * Properties
     */

    private int maP_BH;
    private int maP_Thu;

    /*
     * Constructor
     */
    public P_BanHangDTO() {

    }

    public P_BanHangDTO(int maP_BH, int maP_Thu) {
        this.maP_BH = maP_BH;
        this.maP_Thu = maP_Thu;
    }

    public int getMaP_BH() {
        return maP_BH;
    }

    public void setMaP_BH(int maP_BH) {
        this.maP_BH = maP_BH;
    }

    public int getMaP_Thu() {
        return maP_Thu;
    }

    /*
     * Getters and Setters
     */
    public void setMaP_Thu(int maP_Thu) {
        this.maP_Thu = maP_Thu;
    }

}
