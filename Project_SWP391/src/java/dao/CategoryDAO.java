/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
                data.add(new Category(id, name, description));
        
                        


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
