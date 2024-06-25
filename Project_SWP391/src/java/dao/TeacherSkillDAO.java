/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.TeacherSkill;

/**
 *
 * @author admin
 */
public class TeacherSkillDAO extends DBContext{
   
      public ArrayList<TeacherSkill> getListSlillByTeacher(int id){
        ArrayList<TeacherSkill>data=new ArrayList<>();
        String sql = "select ts.teacher_id,ts.skill_id,ts.certificateImg,s.skill_name from Teacher_Skill ts join Skill s on ts.skill_id=s.skill_id where ts.teacher_id= "+id+" ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String idt=String.valueOf(rs.getInt(1));
                String ids=String.valueOf(rs.getInt(2));
                String image=rs.getString(3);

                String name=rs.getString(4);
                data.add(new TeacherSkill(idt, ids,name,image));
        
                        


            }
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        return data;
    }
       public ArrayList<TeacherSkill> getListTeacherBySkill(int id){
        ArrayList<TeacherSkill>data=new ArrayList<>();
        String sql = "select t.name,ts.certificateImg from Teacher_Skill ts join Skill s on ts.skill_id=s.skill_id join Teachers t on t.teacher_id=ts.teacher_id\n" +
"where  ts.skill_id = "+id+" ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String idt=rs.getString(1);
                String ids=rs.getString(2);
               
                data.add(new TeacherSkill(idt,ids,idt));
        
                        


            }
        } catch (Exception e) {
            System.out.println("Loi ne"+e.getMessage());
        }
        return data;
    }

    public TeacherSkill checkSkill(String id, String ids) {
        
        return null;
    }

    public void addNewSkill(String id, String ids ,String img) {
        try {
            String sql = "insert into Teacher_Skill(teacher_id,skill_id,certificateImg) values("+Integer.parseInt(id)+","+Integer.parseInt(ids)+",'"+img+"')" ;
            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();


        } catch (Exception e) {
        }
    }

    public void delete(String id, String ids) {
         try {
            String sql = "delete from Teacher_Skill where teacher_id="+Integer.parseInt(id)+" and skill_id="+Integer.parseInt(ids)+"" ;
            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();


        } catch (Exception e) {
        }
    }
}
