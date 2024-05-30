<%-- 
    Document   : AddTeacher
    Created on : 21-May-2024, 00:02:07
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add new Teacher</h1>
        <form action="teacheradd" method="Get" >
            TeacherID: <input type="text" name="id">
            <br>UserName: <input type="text" name="username">
            <br>PassWord <input type="text" name="pass">
            <br>Name <input type="text" name="name">
            <br>Gender <input type="text" name="gender">
            <br>Email <input type="text" name="email">
            <br>Phone: <input type="text" name="phone">
            <br>Address <input type="text" name="address">
            <br>Subject <input type="text" name="subject">
            <br>ImgUrl <input type="image" name="imgUrl" src="path-to-your-image.jpg" alt="Submit">
            <br>join_date <input type="datetime" name="join_date">
            <br>City <input type="text" name="city">
            <br>State <input type="text" name="state">
            <br>Active <input type="text" name="active">
            <br><br>
            <input type="submit" value="ADD" >
    </body>
</html>
