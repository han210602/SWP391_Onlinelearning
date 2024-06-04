<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>404 Not Found</title>
        <style>
            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }

            body {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                background-color: #f3f4f6;
                font-family: 'Arial', sans-serif;
                color: #333;
            }

            .container {
                text-align: center;
            }

            h1 {
                font-size: 6rem;
                color: #e63946;
            }

            p {
                font-size: 1.5rem;
                margin: 20px 0;
            }

            a {
                display: inline-block;
                padding: 10px 20px;
                font-size: 1rem;
                color: #fff;
                background-color: #007bff;
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s;
            }

            a:hover {
                background-color: #0056b3;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <h1>404</h1>
            <h3 class="mb-4">Page Not Found</h3>
            <h2 style="color: red">${error}</h2>
            <a href="homePage.jsp" class="btn btn-primary mt-2">Go To Home</a>
        </div>
    </body>
</html>