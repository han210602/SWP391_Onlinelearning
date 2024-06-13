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
    String id,username,pass,email,fullname,gender,address,roles_id,imgUrl,occ,company,phone,city,state,dob;
    
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
        connect();
    }
//id, username, image, email, fname, gender, address, roleId, image
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
   //Administrator(String.valueOf(id), username, password, email, fname, gender, address, roleId, image)

    public Administrator(String id, String username, String pass, String email, String fullname, String gender, String address, String roles_id, String imgUrl) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.email = email;
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
        this.roles_id = roles_id;
        this.imgUrl = imgUrl;
    }
    

    public Administrator(String id, String username, String pass, String email, String fullname, String gender, String address, String roles_id, String imgUrl, String occ, String company, String phone, String city, String state, String dob) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.email = email;
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
        this.roles_id = roles_id;
        this.imgUrl = imgUrl;
        this.occ = occ;
        this.company = company;
        this.phone = phone;
        this.city = city;
        this.state = state;
        this.dob = dob;
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

    public String getOcc() {
        return occ;
    }

    public void setOcc(String occ) {
        this.occ = occ;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
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

    public Administrator getAdminstratorByUsername(String username) {
        try {
            String strSelect = "select * from Administrator "
                    + "where username=? ";
            pstm=cnn.prepareStatement(strSelect);
            pstm.setString(1, username);
            rs=pstm.executeQuery();
            while (rs.next()) {
                String id=String.valueOf(rs.getInt(1));
                String pass=rs.getString(3);
                String email=rs.getString(4);
                String fname=rs.getString(5);
                String gender="Femail";
                if(rs.getBoolean(6)){
                    gender="Male";
                }
                String address=rs.getString(7);
                String roleId=String.valueOf(rs.getInt(8));

                String image=rs.getString(9);
                String occ=rs.getString(10);
                String company=rs.getString(11);
                String phone=rs.getString(12);
                String city=rs.getString(13);
                String state=rs.getString(14);
                String dob=rs.getString(15);
                return new Administrator(id, username, pass, email, fname, gender, address, roleId, image, occ, company, phone, city, state, dob);
            }
 //public Administrator(String id, String username, String pass, String email, String fullname, String gender, String address, String roles_id, String imgUrl, String occ, String company, String phone, String city, String state, String dob) {
           
        } catch (Exception e) {
            System.out.println("Checkname:"+e.getMessage());
        }
        return null;
    }

    public void UpdateProfile(String id, String uname, String pass, String fname, String dob, String gender, String phone, String email, String occ, String company, String address, String city, String state, String filenamedb) {
try {
            String sql = "UPDATE [dbo].[Administrator]\n" +
"SET \n" +
"    [username] = '"+uname+"',\n" +
"    [password] = '"+pass+"',\n" +
"    [email] = '"+email+"',\n" +
"    [fullname] = '"+fname+"',\n" +
"    [gender] = ?, \n" +
"    [address] = '"+address+"',\n" +
"    [imageUrl] = '"+filenamedb+"',\n" +
"    [occupation] = '"+occ+"',\n" +
"    [companyname] = '"+company+"',\n" +
"    [phone] = '"+phone+"',\n" +
"    [City] = '"+city+"',\n" +
"    [State] = '"+state+"',\n" +
"    [dob] = '"+dob+"'\n" +
"WHERE\n" +
"    [administrator_id] = ? ";
            PreparedStatement pstm = connection.prepareCall(sql);
          
            pstm.setBoolean(1, Boolean.parseBoolean(gender));
         pstm.setInt(2, Integer.parseInt(id));


           
            pstm.executeUpdate();
        } catch (Exception e) {
               System.out.println("loiupateprofile:"+e.getMessage());
        }
    
    
    
    }
    
  
}
