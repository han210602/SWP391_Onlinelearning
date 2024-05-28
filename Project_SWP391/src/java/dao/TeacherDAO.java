/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Teachers;

/**
 *
 * @author admin
 */
public class TeacherDAO extends DBContext {

    public ArrayList<Teachers> getListTeachers(int index) {
        ArrayList<Teachers> data = new ArrayList<>();
        String sql = "select*from Teachers "
                + "order by teacher_id "
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT 3 ROWS ONLY";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (index - 1) * 3);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt(1));
                String username = rs.getString(2);
                String pass = rs.getString(3);
                String name = rs.getString(4);
                String gender = String.valueOf(rs.getInt(5));
                String email = rs.getString(6);
                String phone = rs.getString(7);
                String address = rs.getString(8);
                String subject = rs.getString(9);
                String imgUrl = rs.getString(10);
                String join_date = rs.getString(11);
                String city = rs.getString(12);
                String state = rs.getString(13);
                String active = String.valueOf(rs.getBoolean(14));

                data.add(new Teachers(id, username, pass, name, gender, email, phone, address, subject, imgUrl, join_date, city, state, active));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void setActive(String id, int active) {
        String sql = "Update Teachers set active=? where teacher_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, active);
            st.setInt(2, Integer.parseInt(id));
            ResultSet rs = st.executeQuery();

        } catch (Exception e) {
            System.out.println("UpdateFail:" + e.getMessage());
        }

    }

    public void deleteTeacher(String id) {

        String sql = "Delete from Teachers where teacher_id=? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(id));
            ResultSet rs = st.executeQuery();

        } catch (Exception e) {
            System.out.println("DeleteFail:" + e.getMessage());
        }

    }

    public int getTotal() {
        String sql = "Select count(*) from Teachers ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return 0;

    }

    public void insert(Teachers tNew) {
        String sql = "INSERT INTO [dbo].[Teachers]\n"
                + "           ([teacher_id]\n"
                + "           ,[username]\n"
                + "           ,[password]\n"
                + "           ,[name]\n"
                + "           ,[gender]\n"
                + "           ,[email]\n"
                + "           ,[phone]\n"
                + "           ,[address]\n"
                + "           ,[subject]\n"
                + "           ,[imgUrl]\n"
                + "           ,[join_date]\n"
                + "           ,[city]\n"
                + "           ,[state]\n"
                + "           ,[active])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tNew.getId());
            st.setString(2, tNew.getUsername());
            st.setString(3, tNew.getPass());
            st.setString(4, tNew.getName());
            st.setString(5, tNew.getGender());
            st.setString(6, tNew.getEmail());
            st.setString(7, tNew.getPhone());
            st.setString(8, tNew.getAddress());
            st.setString(9, tNew.getSubject());
            st.setString(10, tNew.getImgUrl());
            st.setString(11, tNew.getJoin_date());
            st.setString(12, tNew.getCity());
            st.setString(13, tNew.getState());
            st.setString(14, tNew.getActive());

            st.executeUpdate();

        } catch (Exception e) {
            System.out.println("insertFail:" + e.getMessage());
        }

    }

    public Teachers getTeacherById(String id) {
        String sql = "select*from Teachers where teacher_id =? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            //set ?
            st.setInt(1, Integer.parseInt(id));
            ResultSet rs = st.executeQuery();
            //1
            if (rs.next()) {
                
                String username = rs.getString(2);
                String pass = rs.getString(3);
                String name = rs.getString(4);
                String gender = String.valueOf(rs.getInt(5));
                String email = rs.getString(6);
                String phone = rs.getString(7);
                String address = rs.getString(8);
                String subject = rs.getString(9);
                String imgUrl = rs.getString(10);
                String join_date = rs.getString(11);
                String city = rs.getString(12);
                String state = rs.getString(13);
                String active = String.valueOf(rs.getBoolean(14));
                
                return new Teachers(id, username, pass, name, gender, email, phone, address, subject, imgUrl, join_date, city, state, active);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;

    }

    public void Update(Teachers t) {
         String sql = "UPDATE teachers SET username = ?, password = ?, name = ?, gender = ?,"
                 + " email = ?, phone = ?, address = ?, subject = ?, imgUrl = ?, join_date = ?,"
                 + " city = ?, state = ?, active = ? WHERE teacher_id = ?";
          try {
            PreparedStatement st = connection.prepareStatement(sql);
           // st.setInt(1, Integer.parseInt(t.getId()));
            st.setString(1, t.getUsername());
            st.setString(2, t.getPass());
            st.setString(3, t.getName());
            st.setBoolean(4, Boolean.parseBoolean(t.getGender()));
            st.setString(5, t.getEmail());
            st.setString(6, t.getPhone());
            st.setString(7, t.getAddress());
            st.setString(8, t.getSubject());
            st.setString(9, t.getImgUrl());
            st.setString(10, t.getJoin_date());
            st.setString(11, t.getCity());
            st.setString(12, t.getState());
            st.setString(13, t.getActive());
            st.setString(14, t.getId());

            st.executeUpdate();

        } catch (Exception e) {
            System.out.println("insertFail:" + e.getMessage());
        }

    }

    public ArrayList<Teachers> getListTeachers(int pageIndex, int pageSize) {
        ArrayList<Teachers> data = new ArrayList<>();
        String sql = "select*from Teachers "
                + "order by teacher_id "
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT ? ROWS ONLY";
        System.out.println(pageSize);

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (pageIndex - 1) * pageSize);
            st.setInt(2, pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = String.valueOf(rs.getInt(1));
                String username = rs.getString(2);
                String pass = rs.getString(3);
                String name = rs.getString(4);
                String gender = String.valueOf(rs.getInt(5));
                String email = rs.getString(6);
                String phone = rs.getString(7);
                String address = rs.getString(8);
                String subject = rs.getString(9);
                String imgUrl = rs.getString(10);
                String join_date = rs.getString(11);
                String city = rs.getString(12);
                String state = rs.getString(13);
                String active = String.valueOf(rs.getBoolean(14));

                data.add(new Teachers(id, username, pass, name, gender, email, phone, address, subject, imgUrl, join_date, city, state, active));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
        

    }

}
