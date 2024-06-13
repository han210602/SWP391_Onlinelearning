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
import model.Category;
import model.Course;

/**
 *
 * @author admin
 */
public class CategoryDAO extends DBContext{
     public ArrayList<Category> getListCategory(){
        ArrayList<Category>data=new ArrayList<>();
        String sql = "SELECT * from Categories";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id=String.valueOf(rs.getInt(1));
                String name=rs.getString(2);                
                String description=rs.getString(3);
                data.add(new Category(Integer.parseInt(id), name, description));
        
                        


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
       //get all category
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Categories";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category p = new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //get total of category
    public int getTotalCategory() {
        String sql = "SELECT COUNT(*) FROM Categories";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    //pagination by search text and order it by orderBy 
    public List<Category> pagingCategory(String searchTxt, String orderBy, int index, int num) {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Categories "
                + "WHERE category_name LIKE '%" + searchTxt + "%'"
                + " ORDER BY " + orderBy + " offset ? rows fetch next " + num + " rows only";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (index - 1) * num);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category p = new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    //get category by id
    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM Categories WHERE category_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    //get category by id
    public Category getCategoryByName(String name) {
        String sql = "SELECT * FROM Categories WHERE [category_name] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //create a category
    public void createCategory(String name, String description) {
        String sql = "INSERT INTO [dbo].[Categories]\n"
                + "           ([category_name]\n"
                + "           ,[description])\n"
                + "     VALUES\n"
                + "           (?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, description);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    //update a category with category's id
    public void updateCategory(String name, String description, int id) {
        String sql = "UPDATE [dbo].[Categories]\n"
                + "   SET [category_name] = ?\n"
                + "      ,[description] = ?\n"
                + " WHERE category_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, description);
            st.setInt(3, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
