/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Skill;

/**
 *
 * @author admin
 */
public class SkillDAO extends DBContext{
     public ArrayList<Skill> getListCategory(){
        ArrayList<Skill>data=new ArrayList<>();
        String sql = "SELECT * from Skill ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id=String.valueOf(rs.getInt(1));
                String name=rs.getString(2);                
                String description=rs.getString(3);
                data.add(new Skill(id, name, description));
        
                        


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
      public void addSkill(String name,String description) {
        try {
            String sql = "insert into Skill(skill_name,description) values('"+name+"','"+description+"')" ;
            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            } catch (Exception e) {
                System.out.println(e.getMessage());
        }
    }
    public void updateSkill(String id,String name,String description) {
        try {
            String sql = "insert into Skill(skill_name,description) values('"+name+"','"+description+"')" ;
            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            } catch (Exception e) {
        }
    }
     public void deleteSkill(String id) {
        try {
            String sql = "delete from  Skill where skill_id="+Integer.parseInt(id)+"" ;
            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();
            } catch (Exception e) {
        }
    }
      
     
     
}
