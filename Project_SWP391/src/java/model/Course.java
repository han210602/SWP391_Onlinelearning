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

/**
 *
 * @author admin
 */
public class Course extends DBContext{
    String id,title,description,price,duration,isActive,imgUrl,cateId,adId,rate,nameTeacher,nameCate,discount,start,idcate,idteacher,count;
 
    public Course() {
    }

    public String getIdcate() {
        return idcate;
    }

    public void setIdcate(String idcate) {
        this.idcate = idcate;
    }

    public String getIdteacher() {
        return idteacher;
    }

    public void setIdteacher(String idteacher) {
        this.idteacher = idteacher;
    }
        

    public Course(String id, String title, String description, String price, String duration, String isActive, String imgUrl, String cateId, String adId, String rate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.isActive = isActive;
        this.imgUrl = imgUrl;
        this.cateId = cateId;
        this.adId = adId;
        this.rate = rate;
    }

    public Course(String id, String title, String description, String price, String duration, String isActive, String imgUrl, String cateId, String adId, String rate, String nameTeacher, String nameCate, String discount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.isActive = isActive;
        this.imgUrl = imgUrl;
        this.cateId = cateId;
        this.adId = adId;
        this.rate = rate;
        this.nameTeacher = nameTeacher;
        this.nameCate = nameCate;
        this.discount = discount;
    }
 public Course(String id, String title, String description, String price, String duration, String isActive, String imgUrl, String cateId, String adId, String rate, String nameTeacher, String nameCate, String discount,String start,String count,String abc) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.isActive = isActive;
        this.imgUrl = imgUrl;
        this.cateId = cateId;
        this.adId = adId;
        this.rate = rate;
        this.nameTeacher = nameTeacher;
        this.nameCate = nameCate;
        this.discount = discount;
        this.start=start;
        this.count=count;
        this.idteacher=abc;

    }

    public Course(String id, String title, String description, String price, String duration, String isActive, String imgUrl, String cateId, String adId, String rate, String nameTeacher, String nameCate, String discount, String start,  String idteacher) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.isActive = isActive;
        this.imgUrl = imgUrl;
        this.cateId = cateId;
        this.adId = adId;
        this.rate = rate;
        this.nameTeacher = nameTeacher;
        this.nameCate = nameCate;
        this.discount = discount;
        this.start = start;
        this.idteacher = idteacher;
    }
 

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCateId() {
        return cateId;
    }

    public void setCateId(String cateId) {
        this.cateId = cateId;
    }

    public String getAdId() {
        return adId;
    }

    public void setAdId(String adId) {
        this.adId = adId;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
    
}
