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
public class P_DichVuDTO {
    /*
     * Properties
     */

    private int maP_DV;
    private int maP_Thu;

    public P_DichVuDTO(int maP_DV, int maP_Thu) {
        this.maP_DV = maP_DV;
        this.maP_Thu = maP_Thu;
    }

    /*
     * Constructor
     */
    public P_DichVuDTO() {

    }

    /*
     * Getters and Setters
     */
    public int getMaP_DV() {
        return maP_DV;
    }

    public void setMaP_DV(int maP_DV) {
        this.maP_DV = maP_DV;
    }

    public int getMaP_Thu() {
        return maP_Thu;
    }

    public void setMaP_Thu(int maP_Thu) {
        this.maP_Thu = maP_Thu;
    }

}
