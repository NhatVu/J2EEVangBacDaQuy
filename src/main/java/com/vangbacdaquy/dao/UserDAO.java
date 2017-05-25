package com.vangbacdaquy.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vangbacdaquy.constant.DatabaseConstant;
import com.vangbacdaquy.dto.UserDTO;

/**
 *
 * @author HNTIN
 */
public class UserDAO extends MySQLDAO {

    public UserDAO() throws Exception {
        super();
    }

    public boolean isUserExist(String username, String password) throws Exception {
        boolean isExist = false;

        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT * FROM " + DatabaseConstant.MySQLDBName + "." + DatabaseConstant.User + " u");
            sql.append(" WHERE u.Username = ?");
            sql.append(" AND u.Password = ?");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if ((rs != null) && (rs.next())) {
                isExist = true;
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
            throw e;
        }
        return isExist;
    }

    public UserDTO getUserDTO(int id) throws Exception {
        UserDTO userDTO = new UserDTO();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT * FROM " + DatabaseConstant.MySQLDBName + "." + DatabaseConstant.User + " u,");
            sql.append(DatabaseConstant.MySQLDBName + "." + DatabaseConstant.UserType + " t");
            sql.append(" WHERE u.UserTypeId = t.Id");
            sql.append(" AND u.Id = ?");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if ((rs != null) && (rs.next())) {
            	userDTO.setId(rs.getInt("Id"));
            	userDTO.setUsername(rs.getString("Username"));
            	userDTO.setPassword(rs.getString("Password"));
            	userDTO.setEmail(rs.getString("Email"));
            	userDTO.setFullName(rs.getString("Fullname"));
            	userDTO.setPhone(rs.getString("Phone"));
            	userDTO.setUserTypeID(rs.getInt("UserTypeId"));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return userDTO;
    }
   
    public UserDTO getUserDTO(String username, String password) throws Exception {
        UserDTO userDTO = new UserDTO();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT * FROM " + DatabaseConstant.MySQLDBName + "." + DatabaseConstant.User + " u");
            sql.append(" WHERE u.Username = ?");
            sql.append(" AND u.Password = ?");
            PreparedStatement stmt = getConnection().prepareStatement(sql.toString());
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if ((rs != null) && (rs.next())) {
            	userDTO.setId(rs.getInt("Id"));
            	userDTO.setUsername(rs.getString("Username"));
            	userDTO.setPassword(rs.getString("Password"));
            	userDTO.setEmail(rs.getString("Email"));
            	userDTO.setFullName(rs.getString("Fullname"));
            	userDTO.setPhone(rs.getString("Phone"));
            	userDTO.setUserTypeID(rs.getInt("UserTypeId"));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return userDTO;
    }
}
