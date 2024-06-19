/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;

/**
 *
 * @author admin
 */
public class UserDAO extends DBContext {

    public List<Customer> getUsers(String username) {
        try {
            List<Customer> list = new ArrayList<>();
            String sql = "SELECT * from Customer";
            if(username != null && !username.trim().isEmpty()){
                sql += " where username like ?";
            }
            PreparedStatement ps = connection.prepareStatement(sql);
             if(username != null && !username.trim().isEmpty()){
                ps.setString(1, "%" + username + "%");
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer user = new Customer();
                user.setId(rs.getString(1));
                user.setUsername(rs.getString(2));
                user.setPass(rs.getString(3));
                user.setName(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setPhone(rs.getString(6));
                user.setGender(rs.getBoolean(7) == true ? "male" : "female");
                user.setAddress(rs.getString(8));
                user.setType(rs.getString(9));
                list.add(user);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
      public Customer getUserById(int id) {
        try {
            
            String sql = "SELECT * from Customer WHERE customer_id = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer user = new Customer();
                user.setId(rs.getString(1));
                user.setUsername(rs.getString(2));
                user.setPass(rs.getString(3));
                user.setName(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setPhone(rs.getString(6));
                user.setGender(rs.getBoolean(7) == true ? "male" : "female");
                user.setAddress(rs.getString(8));
                user.setType(rs.getString(9));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      
      public Customer getUserByEmail(String email) {
        try {
            
            String sql = "SELECT * from Customer WHERE email = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer user = new Customer();
                user.setId(rs.getString(1));
                user.setUsername(rs.getString(2));
                user.setPass(rs.getString(3));
                user.setName(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setPhone(rs.getString(6));
                user.setGender(rs.getBoolean(7) == true ? "male" : "female");
                user.setAddress(rs.getString(8));
                user.setType(rs.getString(9));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertUser(String username, String password, String email, String fullname, String gender, String address, String phone) {
        try {
            String sql = "INSERT INTO Customer (  [username]\n" +
"      ,[password]\n" +
"      ,[fullname]\n" +
"      ,[email]\n" +
"      ,[phone]\n" +
"      ,[gender]\n" +
"      ,[address]\n" +
"      ) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullname);
            ps.setString(4, email);
             ps.setString(5, phone);
            ps.setBoolean(6, "male".equals(gender));
            ps.setString(7, address);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteUser(int id) {
        try {
            String sql = "DELETE FROM Customer WHERE customer_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateUser(int id, String username, String password, String email, String fullname, String gender, String address, String phone) {
        try {
            String sql = "UPDATE Customer SET [username] = ? \n" +
"      ,[password] = ? \n" +
"      ,[fullname] = ? \n" +
"      ,[email] = ? \n" +
"      ,[phone] = ? \n" +
"      ,[gender] = ? \n" +
"      ,[address] = ? \n" +
                                      " WHERE [customer_id] = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
             ps.setString(3, fullname);
            ps.setString(4, email);
            ps.setString(5, phone);
            ps.setBoolean(6, "male".equals(gender));
            ps.setString(7, address);
          
            ps.setInt(8, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
