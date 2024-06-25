/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class TeacherSkill {
    String idt,ids,name,image,tname;

    public String getTname() {
        return tname;
    }

    public TeacherSkill(String name, String image, String tname) {
        this.name = name;
        this.image = image;
        this.tname = tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public TeacherSkill() {
    }

    public TeacherSkill(String idt, String ids) {
        this.idt = idt;
        this.ids = ids;
    }

    public TeacherSkill(String idt, String ids, String name,String image) {
        this.idt = idt;
        this.ids = ids;
        this.name = name;
        this.image= image;
    }

    public String getIdt() {
        return idt;
    }

    public void setIdt(String idt) {
        this.idt = idt;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
