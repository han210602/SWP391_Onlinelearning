
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="assets/images/favicon.ico.png">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://cdn.ckeditor.com/4.16.2/standard/ckeditor.js"></script>
        <style>
            form {
                display: grid;
                gap: 10px;
                grid-template-columns: 1fr 3fr;
                max-width: 90%; /* Adjust as needed */
                margin: 0 auto; /* Center the form */
            }

            label {
                text-align: right;
                padding-right: 10px;
                line-height: 30px; /* Adjust as needed */
            }

            input[type="text"],
            input[type="number"],
            select {
                width: 100%;
                padding: 5px;
                box-sizing: border-box;
            }

            button[type="submit"] {
                margin-left: 50%;
                margin-top: 10px;
            }
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }

            .container {
                max-width: 600px;
                margin: 50px auto;
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            label {
                display: flex;
                margin-bottom: 8px;
                margin-left: 25%;
            }

            input, select, textarea {
                width: 50%;
                padding: 8px;

                box-sizing: border-box;
            }

            button {
                background-color: blue;
                color: #fff;
                padding: 10px 15px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
            h1{
                font-size: 20px;
                margin-left: 10%;
                color: blue;
            }
        </style>
        <title>Management Category</title>
    </head>
    <body>
        <button onclick="history.back()">Go Back</button>
        <h1>${doing} a category!</h1>
        <h1 style="color: red">${error}</h1>
        <c:set var="o" value="${requestScope.category}"/>
        <div style="text-align: center">
            <form action="managecategory" method="post">
                <input type="text" hidden="true" name="id" value="${o.id}">
                <label for="name">Category Name:</label>
                <c:if test="${o.name != null}">
                    <input type="text" readonly="" id="name" name="name" value="${o.name}"required>
                </c:if>
                <c:if test="${o.name == null}">
                    <input type="text" id="name" name="name" value="${o.name}"required>
                </c:if>   
                
                <label for="description">Description:</label>  
                <textarea rows="707px" cols="100px" id="description" name="description" required>${o.description}</textarea>
                
                </br><button type="submit">${doing} Category</button>
            </form>
        </div>
        <script>
            CKEDITOR.replace('description');
        </script>
    </body>
</html>
