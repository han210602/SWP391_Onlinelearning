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
import model.Administrator;

/**
 *
 * @author admin
 */
public class StaffDAO extends DBContext {

    public List<Administrator> getAll() {
        List<Administrator> list = new ArrayList<>();
        String sql = "Select * from Administrator where roles_id=2";
        try {

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt("administrator_id"));
                String email = rs.getString("email");
                String fname = rs.getString("fullname");
                String gender = "female";
                if (rs.getBoolean("gender")) {
                    gender = "Male";
                }
                String address = rs.getString("address");
                String roleId = String.valueOf(rs.getInt("roles_id"));
                String username = rs.getString("username");
                String password = rs.getString("password");
                String image = rs.getString("imageUrl");
                list.add(new Administrator(id, username, image, email, fname, gender, address, roleId, image));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Administrator getById(int id) {
        String sql = "Select * from Administrator where roles_id=2 and administrator_id=?";
        try {

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String email = rs.getString("email");
                String fname = rs.getString("fullname");
                String gender = "female";
                if (rs.getBoolean("gender")) {
                    gender = "Male";
                }
                String address = rs.getString("address");
                String roleId = String.valueOf(rs.getInt("roles_id"));
                String username = rs.getString("username");
                String password = rs.getString("password");
                String image = rs.getString("imageUrl");
                Administrator a = new Administrator(String.valueOf(id), username, password, email, fname, gender, address, roleId, image);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insertStaff(Administrator a) {
        String sql = "INSERT INTO Administrator VALUES \n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, a.getUsername());
            st.setString(2, a.getPass());
            st.setString(3, a.getEmail());
            st.setString(4, a.getFullname());
            String gender = a.getGender();
            boolean genderBit = "Male".equalsIgnoreCase(gender) ? false : true;
            st.setBoolean(5, genderBit);

            st.setString(6, a.getAddress());
            st.setInt(7, Integer.parseInt(a.getRoles_id()));
            st.setString(8, a.getImgUrl());
                        st.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void updateStaff(int id, Administrator a) {
        String sql = "UPDATE [dbo].[Administrator]\n"
                + "   SET [username] = ?\n"
                + "      ,[password] = ?\n"
                + "      ,[email] = ?\n"
                + "      ,[fullname] = ?\n"
                + "      ,[gender] = ?\n"
                + "      ,[address] = ?\n"
                + "      ,[roles_id] = ?\n"
                + "      ,[imageUrl] = ?\n"
                + " WHERE administrator_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getUsername());
            st.setString(2, a.getPass());
            st.setString(3, a.getEmail());
            st.setString(4, a.getFullname());
            String gender = a.getGender();
            boolean genderBit = "Male".equalsIgnoreCase(gender) ? false : true;
            st.setBoolean(5, genderBit);

            st.setString(6, a.getAddress());
            st.setInt(7, Integer.parseInt(a.getRoles_id()));
            st.setString(8, a.getImgUrl());
            st.setInt(9, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        StaffDAO sd = new StaffDAO();
        System.out.println(sd.getById(9).getGender());
       
    }
}
