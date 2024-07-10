/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Course;
import model.OrderDetail;

/**
 *
 * @author admin
 */
public class OrderDetailDAO extends DBContext{
     public ArrayList<OrderDetail> getListOrderDetail(int id){
        ArrayList<OrderDetail>data=new ArrayList<>();
        String sql = "select o.order_id,o.course_id,c.title,c.description,c.price,c.duration,c.imageUrl ,t.name,discount,startdate\n" +
"from OrderDetails o join Courses c on o.course_id=c.course_id join Teachers t on c.teacher_id=t.teacher_id\n" +
"where o.order_id="+id+" ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String orderId=String.valueOf(rs.getInt(1));
                String courseId=String.valueOf(rs.getInt(2));
                String title=rs.getString(3);                
                String description=rs.getString(4);
                String price=rs.getString(5);
                String duration=String.valueOf(rs.getInt(6));
                String imageUrl=rs.getString(7);
                String nameTeacher=rs.getString(8);
                String discount=rs.getString(9);
                String startDate=String.valueOf(rs.getDate(10));
//String id,                String title,                String description,                String price,                String duration,                String isActive,                String imgUrl,                String cateId,                String adId,                String rate,                String nameTeacher,                String nameCate,                String discount,                String start,                String idteacher)
                data.add(new OrderDetail(orderId, courseId, "1", "0", new Course(courseId, title, description, price, duration, null, imageUrl, null, null, null, nameTeacher, null, discount,startDate,null)));
                
                
        
                        


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
     }
}
