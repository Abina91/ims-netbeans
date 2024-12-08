<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Login - Internship Management System</title>
<!--    <link rel="stylesheet" href="styles.css">-->

    
    <style>
        /* Basic CSS reset */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'Arial', sans-serif;
    background-color: #f4f4f9;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.container {
    background-color: #ffffff;
    width: 100%;
    max-width: 400px;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #333333;
}

form {
    display: flex;
    flex-direction: column;
}

label {
    margin-bottom: 8px;
    font-weight: bold;
    color: #555555;
}

input[type="text"],
input[type="password"] {
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #cccccc;
    border-radius: 5px;
    font-size: 14px;
    width: 100%;
    background-color: #f9f9f9;
}

input[type="submit"] {
    padding: 10px;
    background-color: #3498db;
    color: #ffffff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
}

input[type="submit"]:hover {
    background-color: #2980b9;
}

p {
    text-align: center;
    margin-top: 20px;
    color: #777777;
}

a {
    color: #3498db;
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}

    </style>
   
</head>
<body>
    <div class="container">
        <h2>Student Login</h2>
        <form action="login.jsp" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>

            <input type="submit" value="Login">
        </form>
        
        <p>Don't have an account? <a href="signup.jsp">Sign up here</a></p>
        
    </div>
</body>
</html>
