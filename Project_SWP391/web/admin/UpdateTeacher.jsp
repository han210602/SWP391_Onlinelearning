<%-- 
    Document   : UpdateTeacher
    Created on : 21-May-2024, 09:47:28
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update new Teacher</h1>
        <c:set var="t" value="${requestScope.teacher}"/>
        <form action="teacherupdate" method="post">
            TeacherID: <input type="text" name="id" value="${t.getId()}"/><br/>
            UserName: <input type="text" name="username" value="${t.getUsername()}"/><br/>
            PassWord: <input type="text" name="pass" value="${t.getPass()}"/><br/>
            Name <input type="text" name="name" value="${t.getName()}"/><br/>
            Gender <input type="text" name="gender" value="${t.getGender()}"/>
            Email <input type="text" name="email" value="${t.getEmail()}"/>
            Phone: <input type="text" name="phone" value="${t.getPhone()}"/>
            Address <input type="text" name="address" value="${t.getAddress()}"/>
            Subject <input type="text" name="subject" value="${t.getSubject()}"/>
            ImgUrl <input type="image" name="imgUrl" src="path-to-your-image.jpg" alt="Submit" value="${t.getImgUrl()}"/>
            join_date <input type="datetime" name="join_date" value="${t.getJoin_date()}"/>
            City <input type="text" name="city" value="${t.getCity()}"/>
            State <input type="text" name="state" value="${t.getState()}"/>
            Active <input type="text" name="active" value="${t.getActive()}"/>

            <input type="submit" value="UPDATE"/>
        </form>





    </body>
</html>
