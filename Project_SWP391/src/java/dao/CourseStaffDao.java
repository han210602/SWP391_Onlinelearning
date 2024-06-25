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
public class CourseStaffDao extends DBContext{
   
    public ArrayList<Course> getListCourses(int pageIndex,int pageSize,int ids){
        ArrayList<Course>data=new ArrayList<>();
        String sql = "SELECT [course_id],[title],co.description,[price],[duration],[isActive],[imageUrl],[administrator_id],t.name,ca.category_name ,[discount],[rate],startdate\n" +
"FROM Courses co  join Categories ca on co.category_id=ca.category_id  join Teachers t on co.teacher_id=t.teacher_id where co.administrator_id="+ids+" "
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
                String startdate=String.valueOf(rs.getDate(13));
                String count=String.valueOf(getCourseOrder(Integer.parseInt(id)));
                data.add(new Course(id, title, description, price, duration, isActive, imageUrl, nameTeacher, nameCate, rate, nameTeacher, nameCate, discount,startdate,count,"1"));
                
                
        
                        


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
    public int getTotalCourse(int ids) {
        String sql = "SELECT count(*) from Courses where administrator_id="+ids+"";
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
    public int getCourseOrder(int idc) {
        String sql = "select count(*) from OrderDetails where course_id="+idc+"";
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
    public ArrayList<Course> getListCourseByCate(int cateid, int pageIndex, int pageSize,int ids) {
        ArrayList<Course>data=new ArrayList<>();
        String sql = "SELECT [course_id],[title],co.description,[price],[duration],[isActive],[imageUrl],[administrator_id],t.name,ca.category_name ,[discount],[rate]\n" +
"FROM Courses co  join Categories ca on co.category_id=ca.category_id  join Teachers t on co.teacher_id=t.teacher_id where co.category_id="+cateid+" and co.administrator_id="+ids+""
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
    public int getTotalCourseByCate(int cateid,int ids) {
        String sql = "SELECT count(*) from Courses where category_id="+cateid+" and administrator_id="+ids+" ";
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
    public int getTotalCourseByActive(int approve,int ids) {
         String sql = "SELECT count(*) from Courses where isActive="+approve+" and administrator_id="+ids+" ";
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
    public ArrayList<Course> getListCourseByActive(int approve, int pageIndex, int pageSize,int ids) {
    ArrayList<Course>data=new ArrayList<>();
        String sql = "SELECT [course_id],[title],co.description,[price],[duration],[isActive],[imageUrl],[administrator_id],t.name,ca.category_name ,[discount],[rate]\n" +
"FROM Courses co  join Categories ca on co.category_id=ca.category_id  join Teachers t on co.teacher_id=t.teacher_id where co.isActive="+approve+" and co.administrator_id="+ids+""
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
    public int getTotalCourseBySearch(String search ,int ids) {
        String sql = "SELECT count(*) from Courses where title like '%"+search+"%' and administrator_id="+ids+"";
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
    public ArrayList<Course> getListCourseBySearch(String search, int pageIndex, int pageSize,int ids) {
        ArrayList<Course>data=new ArrayList<>();
        String sql = "SELECT [course_id],[title],co.description,[price],[duration],[isActive],[imageUrl],[administrator_id],t.name,ca.category_name ,[discount],[rate]\n" +
"FROM Courses co  join Categories ca on co.category_id=ca.category_id  join Teachers t on co.teacher_id=t.teacher_id where co.title like '%"+search+"%' and co.administrator_id="+ids+" "
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

    public void AddCourse(String title, String cateid, String start, String teacherid, String price, String discount, String description, String filename,String staffid,String duration) {

           try {
            String sql = "INSERT INTO [dbo].[Courses] ([title],[description],[price], [duration], [isActive], [imageUrl],[category_id],[administrator_id],[teacher_id], [discount], [startdate] )\n" +
"VALUES ('"+title+"', '"+description+"',?,?,?, '"+filename+"',  ?,?,?,?,'"+start+" ')";
            PreparedStatement pstm = connection.prepareCall(sql);
            pstm.setFloat(1, Float.parseFloat(price));
            pstm.setInt(2, Integer.parseInt(duration));
            pstm.setBoolean(3, false);
            pstm.setInt(4, Integer.parseInt(cateid));
            pstm.setInt(5, Integer.parseInt(staffid));
            pstm.setInt(6, Integer.parseInt(teacherid));
            pstm.setFloat(7, Float.parseFloat(discount));


           
            pstm.executeUpdate();
        } catch (Exception e) {
               System.out.println("loiadd:"+e.getMessage());
        }
    
    
    }

    public Course getCourseById(int id) {
        String sql = "SELECT [course_id],[title],co.description,[price],[duration],[isActive],[imageUrl],co.category_id,co.teacher_id,[administrator_id],t.name,ca.category_name ,[discount],[rate],[startdate]\n" +
"FROM Courses co  join Categories ca on co.category_id=ca.category_id  join Teachers t on co.teacher_id=t.teacher_id \n" +
"where co.course_id="+id+" ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id1=String.valueOf(rs.getInt(1));
                String title=rs.getString(2);                
                String description=rs.getString(3);
                String price=rs.getString(4);
                String duration=String.valueOf(rs.getInt(5));
                String isActive=String.valueOf(rs.getBoolean(6));
                String imageUrl=rs.getString(7);
                String cid=rs.getString(8);
                String tid=rs.getString(9);
                String nameTeacher=rs.getString(11);
                String nameCate=rs.getString(12);
                String discount=rs.getString(13);
                String rate=rs.getString(14);
                String start=String.valueOf(rs.getDate(15));

                return new Course(tid, title, description, price, duration, isActive, imageUrl, cid, tid, rate, nameTeacher, nameCate, discount, start, tid);
   //Course(String id, String title, String description, String price, String duration, String isActive, String imgUrl, String cateId, String adId, String rate, String nameTeacher, String nameCate, String discount,String start)             
     //   String id, String title, String description, String price, String duration, String isActive, String imgUrl, String cateId, String adId, String rate, String nameTeacher, String nameCate, String discount, String start, String idcate, String idteacher
                        


            }
        } catch (Exception e) {
            System.out.println("loi:"+e.getMessage());;
        }
        return null;
    }

    public void UpdateCourse(String id, String title, String cateid, String start, String teacherid, String price, String discount, String description, String filename, String duration) {
    
     try {
            String sql = "UPDATE [dbo].[Courses]\n" +
"SET \n" +
"    [title] = '"+title+"',\n" +
"    [description] = '"+description+"',\n" +
"    [price] = "+Float.parseFloat(price)+",\n" +
"    [duration] = "+Integer.parseInt(duration)+",\n" +
"    [imageUrl] = '"+filename+"',\n" +
"    [category_id] = "+Integer.parseInt(cateid)+",\n" +
"    [teacher_id] = "+Integer.parseInt(teacherid)+",\n" +
"    [discount] = "+Float.parseFloat(discount)+",\n" +
"    [startdate] = '"+start+"'\n" +
"WHERE \n" +

"    [course_id] = "+Integer.parseInt(id)+"";
            PreparedStatement pstm = connection.prepareCall(sql);
       


           
            pstm.executeUpdate();
        } catch (Exception e) {
               System.out.println("loiadd:"+e.getMessage());
        }
    
    
    }
}
