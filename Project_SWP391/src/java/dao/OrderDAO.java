/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Course;
import model.Order;

/**
 *
 * @author admin
 */
public class OrderDAO extends DBContext{
       public ArrayList<Order> getListOrder(int pageIndex,int pageSize){
        ArrayList<Order>data=new ArrayList<>();
        String sql = "SELECT [order_id],o.[customer_id],[order_date],[total_amount],[payment] ,c.fullname,c.phone,c.email,c.address\n" +
"FROM [Orders] o left join Customer c on o.customer_id=c.customer_id\n" +
"ORDER BY o.order_id OFFSET ? ROWS FETCH NEXT "+pageSize+" ROWS ONLY";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (pageIndex-1)*pageSize);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id=String.valueOf(rs.getInt(1));
                String idc=String.valueOf(rs.getInt(2));                
                String orderdate=String.valueOf(rs.getDate(3));
                String total=String.valueOf(rs.getDouble(4));
                String payment=rs.getString(5);
                String namec=rs.getString(6);
                String phone=rs.getString(7);
                String email=rs.getString(8);
                String address=rs.getString(9);

                
        data.add(new Order(id, idc, orderdate, total, payment, namec, phone, email, address));
    //  public Order(String order_id, String customer_id, String orderdate, String total, String payment, String c_name, String c_phone, String c_email, String c_address) {
         }
        } catch (Exception e) {
            System.out.println(e.getMessage());        }
        return data;
    }
       public int getTotalOrder() {
        String sql = "SELECT count(*) from Orders ";
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
}
