/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Customer extends DBContext{
    String id,username,pass,name,email,phone,gender,address,type;
    Connection cnn;//ket noi
    Statement stm;//thuc thi cau lenh sql
    ResultSet rs;//luu tru du lieu va xu li
    PreparedStatement pstm;//thuc thi cau lenh sql
   
    private void connect(){
        cnn=connection;
        if(cnn!=null){
            System.out.println("Connect success");
        }else{
            System.out.println("Connect Fail");
        }
    }
    public Customer() {
        connect();
    }
    
    public Customer(String username, String pass) {
        this.username = username;
        this.pass = pass;
        connect();
    }
    
    public Customer(String username, String pass, String email) {
        this.username = username;
        this.pass = pass;
        this.email = email;
        connect();
    }

    public Customer(String id, String username, String pass, String name, String email, String phone, String gender, String address, String type) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.type = type;
        connect();
    }

   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public boolean checkUsername(String uname){
        try {
            String strSelect = "select username from Customer where username= ? union select username from Administrator where username= ?";
                    
            pstm=cnn.prepareStatement(strSelect);
            pstm.setString(1, uname);
            pstm.setString(2, uname);
            rs=pstm.executeQuery();
            while (rs.next()) {
              return false;
            }
        } catch (Exception e) {
            System.out.println("CheckUsernameFail:"+e.getMessage());
        }
        return true;
    }
    public boolean checkUserFacebook(String idf){
        try {
            String strSelect = "select * from Customer where idf="+idf+"";
                    
            pstm=cnn.prepareStatement(strSelect);
            
            rs=pstm.executeQuery();
            while (rs.next()) {
              return false;
            }
        } catch (Exception e) {
            System.out.println("CheckUsernameFail:"+e.getMessage());
        }
        return true;
    }
    public void registerCustomer() {
        try{
            String strAdd=
                    "insert into Customer (username,password,email ) values(?,?,?)";
           
            pstm=cnn.prepareStatement(strAdd);
            pstm.setString(1, username);
            pstm.setString(2,pass);
            pstm.setString(3, email);
        
            pstm.execute();
        } catch(Exception e){
            System.out.println("register fail:"+e.getMessage());

       }
    }
    public Customer checkCustomer(){
        try {
            String strSelect = "select * from Customer "
                    + "where username=? "
                    + "and password=?";
            pstm=cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            pstm.setString(2, pass);
            rs=pstm.executeQuery();
            while (rs.next()) {
                String id=String.valueOf(rs.getInt(1));
                String email=rs.getString(5);
                String fname=rs.getString(4);
                String gender="Femail";
                if(rs.getBoolean(7)){
                    gender="Male";
                }
                String phone=rs.getString(6);
                String address=rs.getString(8);
                String type=String.valueOf(rs.getInt(9));
                
                
                return new Customer(id, username, pass, fname, email, phone, gender, address, type);
            }
        } catch (Exception e) {
            System.out.println("Checkname:"+e.getMessage());
        }
        return null;
    }
    public ArrayList<Customer> getListNewUser(){
        ArrayList<Customer> data = new ArrayList<>();
        try {
            String strSelect = "select * from Customer p,Categories c where p.CategoryID=c.CategoryID";
//        + "where account='"+account+"' "
//        + "and password='"+password+"'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                String id=String.valueOf(rs.getInt(1));
                String email=rs.getString(5);
                String fname=rs.getString(4);
                String gender="Femail";
                if(rs.getBoolean(7)){
                    gender="Male";
                }
                String phone=rs.getString(6);
                String address=rs.getString(8);
                String type=String.valueOf(rs.getInt(9));
               data.add(new Customer(id, username, pass, fname, email, phone, gender, address, type));

            }
        } catch (Exception e) {
            System.out.println("getListUser:"+e.getMessage());
        }
        return data;
    }

    public void RegisteFacebook(String id, String name, String email) {
    try{
            String strAdd=
                    "insert into Customer (fullname,email,idF ) values(?,?,?)";
           
            pstm=cnn.prepareStatement(strAdd);
            pstm.setString(1, name);
            pstm.setString(2,email);
            pstm.setString(3, id);
        
            pstm.execute();
        } catch(Exception e){
            System.out.println("register fail:"+e.getMessage());

       }
    
    }

    public int checkEmailReturnID(String email) {
         try {
            String strSelect = "select * from Customer where email='"+email+"'";
                    
            pstm=cnn.prepareStatement(strSelect);
            
            rs=pstm.executeQuery();
            while (rs.next()) {
              return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("CheckEmail:"+e.getMessage());
        }
        return 0;
    }

    public void updatePass(String toSHA1,int id) {
         try{    String strUpdate="update Customer "
                    + "set password='"+toSHA1+"' " 
                    +"where customer_id="+id+"";
            pstm=cnn.prepareStatement(strUpdate);
            pstm.execute();
        }catch(Exception e){
            System.out.println("Update:"+e.getMessage());
        }
    }
}
