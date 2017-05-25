/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vangbacdaquy.bo;

import com.vangbacdaquy.dao.UserDAO;
import com.vangbacdaquy.dto.UserDTO;

/**
 *
 * @author HNTIN
 */
public class UserBO {

    public boolean isUserExist(String username, String password) throws Exception {
        UserDAO mapper = null;
        boolean isExist = false;
        try {
            mapper = new UserDAO();
            isExist = mapper.isUserExist(username, password);
        } catch (Exception e) {
            throw e;
        } finally {
            mapper.closeConnection();
        }
        return isExist;
    }
    
    public UserDTO getUserDTO(int id) throws Exception {
        UserDAO mapper = null;
        UserDTO userDTO;
        try {
            mapper = new UserDAO();
            userDTO = mapper.getUserDTO(id);
        } catch (Exception e) {
            throw e;
        } finally {
            mapper.closeConnection();
        }
        return userDTO;
    }

    public UserDTO getUserDTO(String username, String password) throws Exception {
        UserDAO mapper = null;
        UserDTO userDTO;
        try {
            mapper = new UserDAO();
            userDTO = mapper.getUserDTO(username, password);
        } catch (Exception e) {
            throw e;
        } finally {
            mapper.closeConnection();
        }
        return userDTO;
    }

}
