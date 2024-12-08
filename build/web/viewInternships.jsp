<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Internships</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <header>
        <h1>Internship Management System</h1>
        <nav>
            <ul class="nav-list">
                <li><a href="home.jsp">Home</a></li>
                <li><a href="viewInternships.jsp">View Internships</a></li>
                <li><a href="addInternship.jsp">Add Internship</a></li>
                <li><a href="dashboard.jsp">Dashboard</a></li>
                <li><a href="profile.jsp">Profile</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </nav>
    </header>

    <div class="container">
        <h2>Your Internships</h2>

        <%
            // Check if the user is logged in
            String username = (String) session.getAttribute("username");
            if (username == null) {
                response.sendRedirect("login.jsp"); // Redirect to login page if the username is null
                return; // Stop further processing
            }
        %>

        <table>
            <tr>
                <th>Title</th>
                <th>Company</th>
                <th>Duration</th>
                <th>Role</th>
                <th>Status</th>
                <th>Description</th>
            </tr>

            <%
                Connection con = null;
                PreparedStatement ps = null;
                ResultSet rs = null;

                try {
                    String url = "jdbc:derby://localhost:1527/internn";
                    String dbUsername = "intern";
                    String dbPassword = "intern123";

                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    con = DriverManager.getConnection(url, dbUsername, dbPassword);
                    
                    // Fetch internship details for the logged-in user
                    ps = con.prepareStatement("SELECT title, company_name, duration, role, status, description FROM intern WHERE username = ?");
                    ps.setString(1, username); // Match username in intern table with the session username
                    rs = ps.executeQuery();

                    while (rs.next()) {
            %>
                <tr>
                    <td><%= rs.getString("title") %></td>
                    <td><%= rs.getString("company_name") %></td>
                    <td><%= rs.getString("duration") %></td>
                    <td><%= rs.getString("role") %></td>
                    <td><%= rs.getString("status") %></td>
                    <td><%= rs.getString("description") %></td>
                </tr>
            <%
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
                } finally {
                    try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                    try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                    try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
            %>
        </table>
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>