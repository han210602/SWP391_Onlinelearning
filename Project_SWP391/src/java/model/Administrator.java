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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 *
 * @author admin
 */
public class Administrator extends DBContext{
    String id,username,pass,email,fullname,gender,address,roles_id,imgUrl;
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
    public Administrator() {
    }

    public Administrator(String username, String pass) {
        this.username = username;
        this.pass = pass;
        connect();
    }

    public Administrator(String id, String username, String pass, String email, String fullname, String gender, String address, String roles_id) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.email = email;
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
        this.roles_id = roles_id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(String roles_id) {
        this.roles_id = roles_id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    
   
   
    public Administrator checkAdministrator(){
        try {
            String strSelect = "select * from Administrator "
                    + "where username=? "
                    + "and password=?";
            pstm=cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            pstm.setString(2, pass);
            rs=pstm.executeQuery();
            while (rs.next()) {
                String id=String.valueOf(rs.getInt(1));
                String email=rs.getString(4);
                String fname=rs.getString(5);
                String gender="Femail";
                if(rs.getBoolean(6)){
                    gender="Male";
                }
                String address=rs.getString(7);
                String roleId=String.valueOf(rs.getInt(8));

                String image=rs.getString(9);
                
                return new Administrator(id, username, pass, email, fname, gender, address, roleId);
            }
        } catch (Exception e) {
            System.out.println("Checkname:"+e.getMessage());
        }
        return null;
    }

    public int checkEmailReturnID(String email) {
        try {
            String strSelect = "select * from Administrator where email='"+email+"'";
                    
            pstm=cnn.prepareStatement(strSelect);
            
            rs=pstm.executeQuery();
            while (rs.next()) {
              return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("CheckEmailAC:"+e.getMessage());
        }
        return 0;
    }

    public void updatePass(String toSHA1,int id) {
         try{    String strUpdate="update Administrator "
                    + "set password='"+toSHA1+"' " 
                    +"where administrator_id ="+id+"";
            pstm=cnn.prepareStatement(strUpdate);
            pstm.execute();
        }catch(Exception e){
            System.out.println("Update:"+e.getMessage());
        }
    }
    
  
}
