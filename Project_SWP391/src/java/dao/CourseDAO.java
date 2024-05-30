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
     public ArrayList<Course> getListCourses(int pageIndex,int pageSize){
        ArrayList<Course>data=new ArrayList<>();
        String sql = "SELECT [course_id],[title],co.description,[price],[duration],[isActive],[imageUrl],[administrator_id],t.name,ca.category_name ,[discount],[rate]\n" +
"FROM Courses co  join Categories ca on co.category_id=ca.category_id  join Teachers t on co.teacher_id=t.teacher_id "
                + "ORDER BY co.course_id OFFSET ? ROWS FETCH NEXT "+pageSize+" ROWS ONLY ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (pageIndex-1)*pageSize);
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

    public void setActive(int id, int i) {
        ArrayList<Course>data=new ArrayList<>();
        String sql = "update Courses set isActive="+i+" where course_id="+id+" ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteCourse(int id) {
   
     try {
            String sql = "delete from  Courses where course_id="+id+"" ;
            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();


        } catch (Exception e) {
        }
    }

    public int getTotalCourse() {
        String sql = "SELECT count(*) from Courses ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              return rs.getInt(1);
                
        
                        


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }

    public ArrayList<Course> getListCourseByCate(int cateid, int pageIndex, int pageSize) {
        ArrayList<Course>data=new ArrayList<>();
        String sql = "SELECT [course_id],[title],co.description,[price],[duration],[isActive],[imageUrl],[administrator_id],t.name,ca.category_name ,[discount],[rate]\n" +
"FROM Courses co  join Categories ca on co.category_id=ca.category_id  join Teachers t on co.teacher_id=t.teacher_id where co.category_id="+cateid+""
                + "ORDER BY co.course_id OFFSET ? ROWS FETCH NEXT "+pageSize+" ROWS ONLY ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (pageIndex-1)*pageSize);
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

    public int getTotalCourseByCate(int cateid) {
        String sql = "SELECT count(*) from Courses where category_id="+cateid+"";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              return rs.getInt(1);
          }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int getTotalCourseByActive(int approve) {
         String sql = "SELECT count(*) from Courses where isActive="+approve+"";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              return rs.getInt(1);
          }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Course> getListCourseByActive(int approve, int pageIndex, int pageSize) {
    ArrayList<Course>data=new ArrayList<>();
        String sql = "SELECT [course_id],[title],co.description,[price],[duration],[isActive],[imageUrl],[administrator_id],t.name,ca.category_name ,[discount],[rate]\n" +
"FROM Courses co  join Categories ca on co.category_id=ca.category_id  join Teachers t on co.teacher_id=t.teacher_id where co.isActive="+approve+""
                + "ORDER BY co.course_id OFFSET ? ROWS FETCH NEXT "+pageSize+" ROWS ONLY ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (pageIndex-1)*pageSize);
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

    public int getTotalCourseBySearch(String search) {
        String sql = "SELECT count(*) from Courses where title like '%"+search+"%'";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
              return rs.getInt(1);
          }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Course> getListCourseBySearch(String search, int pageIndex, int pageSize) {
        ArrayList<Course>data=new ArrayList<>();
        String sql = "SELECT [course_id],[title],co.description,[price],[duration],[isActive],[imageUrl],[administrator_id],t.name,ca.category_name ,[discount],[rate]\n" +
"FROM Courses co  join Categories ca on co.category_id=ca.category_id  join Teachers t on co.teacher_id=t.teacher_id where co.title like '%"+search+"%'"
                + "ORDER BY co.course_id OFFSET ? ROWS FETCH NEXT "+pageSize+" ROWS ONLY ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (pageIndex-1)*pageSize);
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
