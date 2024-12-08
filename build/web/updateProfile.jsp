<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.servlet.http.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Profile</title>
    <link rel="stylesheet" type="text/css" href="styles.css"> <!-- Link to your CSS file -->
</head>
<body>
    <header>
    <h1>Internship Management System</h1>
    <nav>
        <ul class="nav-list">
            <li><a href="home.jsp">Home</a></li>
            <li><a href="viewInternships.jsp">View Internships</a></li>
            <li><a href="addInternship.jsp">Add Internship</a></li>
            <li><a href="profile.jsp">Profile</a></li>
             <li><a href="dashboard.jsp">DashBoard</a></li>
            <li><a href="logout.jsp">Logout</a></li>
        </ul>
    </nav>
</header>
<div class="container">
    <h2>Update Profile</h2>

    <%
        // Ensure the user is logged in
        String userIdStr = request.getParameter("userId");
        Integer userId = null;

        if (userIdStr != null) {
            try {
                userId = Integer.parseInt(userIdStr);
            } catch (NumberFormatException e) {
                out.println("<p style='color:red;'>Invalid user ID format.</p>");
                return;
            }
        }

        if (userId == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Connection con = null;
        PreparedStatement ps = null;

        try {
            String url = "jdbc:derby://localhost:1527/internn";
            String dbUsername = "intern"; 
            String dbPassword = "intern123"; 

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(url, dbUsername, dbPassword);
            
            // Retrieve form data
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String course = request.getParameter("course");
            String branch = request.getParameter("branch");
            String phoneNumber = request.getParameter("phoneNumber");
            String collegeName = request.getParameter("collegeName");
            String academicPassoutYear = request.getParameter("academicPassoutYear");
            String cgpa = request.getParameter("cgpa");
            String currentYear = request.getParameter("currentYear");

            // Update user details in the database
            String updateQuery = "UPDATE Users SET name=?, email=?, course=?, branch=?, phone_number=?, college_name=?, passout_year=?, cgpa=?, current_year=? WHERE id=?";
            ps = con.prepareStatement(updateQuery);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);
            ps.setString(4, branch);
            ps.setString(5, phoneNumber);
            ps.setString(6, collegeName);
            ps.setString(7, academicPassoutYear);
            ps.setString(8, cgpa);
            ps.setString(9, currentYear);
            ps.setInt(10, userId);

            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                out.println("<p>Profile updated successfully!</p>");
                out.println("<a href='profile.jsp'>Go back to Profile</a>");
            } else {
                out.println("<p style='color:red;'>No changes were made to the profile.</p>");
                out.println("<a href='profile.jsp'>Go back to Profile</a>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p style='color:red;'>Database Error: " + e.getMessage() + "</p>");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("<p style='color:red;'>JDBC Driver not found.</p>");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        } finally {
            try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    %>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>
