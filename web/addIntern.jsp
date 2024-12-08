<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Internship</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <header>
        <h1>Admin Internship</h1>
        <nav>
            <ul class="nav-list">
                <li><a href="adminHome.jsp">Home</a></li>
                <li><a href="adminDashboard.jsp">Dashboard</a></li>
                <li><a href="addIntern.jsp">Add Internship</a></li>
                       <li><a href="interndetails.jsp">Added Internship</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </nav>
    </header>

    <div class="container">
        <h2>New Internship Details</h2>
        <form method="post" action="addIntern.jsp">
            <label for="title">Internship Title:</label>
            <input type="text" id="title" name="title" required>

            <label for="companyName">Company Name:</label>
            <input type="text" id="companyName" name="companyName" required>

            <label for="duration">Duration:</label>
            <input type="text" id="duration" name="duration" required>

            <label for="role">Role:</label>
            <input type="text" id="role" name="role" required>

            <label for="description">Description:</label>
            <textarea id="description" name="description" required></textarea>

            <input type="submit" value="Add Internship">
        </form>

        <%
            if ("POST".equalsIgnoreCase(request.getMethod())) {
                String title = request.getParameter("title");
                String companyName = request.getParameter("companyName");
                String duration = request.getParameter("duration");
                String role = request.getParameter("role");
                String description = request.getParameter("description");

                Connection con = null;
                PreparedStatement ps = null;

                try {
                    // Database connection
                    String url = "jdbc:derby://localhost:1527/internn";
                    String dbUsername = "intern";
                    String dbPassword = "intern123";
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    con = DriverManager.getConnection(url, dbUsername, dbPassword);

                    // Insert the internship into the intern table
                    String query = "INSERT INTO intern (title, company_name, duration, role, description, added_by_admin) VALUES (?, ?, ?, ?, ?, ?)";
                    ps = con.prepareStatement(query);
                    ps.setString(1, title);
                    ps.setString(2, companyName);
                    ps.setString(3, duration);
                    ps.setString(4, role);
                    ps.setString(5, description);
                    ps.setBoolean(6, true);  // Set to true because the admin is adding this
                    int rowsInserted = ps.executeUpdate();

                    if (rowsInserted > 0) {
                        out.println("<p>Internship added successfully!</p>");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
                } finally {
                    try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                    try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
            }
        %>
    </div>
  
</body>
</html>
