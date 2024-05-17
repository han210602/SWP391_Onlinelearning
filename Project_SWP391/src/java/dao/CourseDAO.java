/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Course;
/**
 *
 * @author admin
 */
public class CourseDAO extends DBContext{
    public ArrayList<Course> getListCourses(){
        ArrayList<Course>data=new ArrayList<>();
        String sql = "SELECT [course_id],[title],co.description,[price],[duration],[isActive],[imageUrl],[administrator_id],t.name,ca.category_name ,[discount],[rate]\n" +
"FROM Courses co  join Categories ca on co.category_id=ca.category_id  join Teachers t on co.teacher_id=t.teacher_id ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id=String.valueOf(rs.getInt(1));
                String title=rs.getString(2);                
                String description=rs.getString(3);
                String price=rs.getString(4);
                String duration=String.valueOf(rs.getInt(5));
                String isActive=String.valueOf(rs.getBoolean(6));
                String imageUrl=rs.getString(7);
                String nameTeacher=rs.getString(9);
                String nameCate=rs.getString(10);
                String discount=rs.getString(11);
                String rate=rs.getString(12);
              
                data.add(new Course(id, title, description, price, duration, isActive, imageUrl, nameTeacher, nameCate, rate, nameTeacher, nameCate, discount));
                
                
        
                        


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
