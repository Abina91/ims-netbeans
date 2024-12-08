<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Available Admin-Added Internships</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <header>
        <h1>Student Dashboard</h1>
        <nav>
            <ul class="nav-list">
                <li><a href="adminHome.jsp">Home</a></li>
                <li><a href="interndetails.jsp">Added Internship</a></li>
                <li><a href="adminDashboard.jsp">Dashboard</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </nav>
    </header>

    <div class="container">
        <h2>Available Admin-Added Internships</h2>
        <table>
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Company Name</th>
                    <th>Duration</th>
                    <th>Role</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Connection con = null;
                    Statement stmt = null;
                    ResultSet rs = null;

                    try {
                        // Database connection
                        String url = "jdbc:derby://localhost:1527/internn";
                        String dbUsername = "intern";
                        String dbPassword = "intern123";
                        Class.forName("org.apache.derby.jdbc.ClientDriver");
                        con = DriverManager.getConnection(url, dbUsername, dbPassword);

                        // Query to get all admin-added internships
                        String query = "SELECT title, company_name, duration, role, description FROM intern WHERE added_by_admin = true";
                        stmt = con.createStatement();
                        rs = stmt.executeQuery(query);

                        // Display the internships in the table
                        while (rs.next()) {
                            String title = rs.getString("title");
                            String companyName = rs.getString("company_name");
                            String duration = rs.getString("duration");
                            String role = rs.getString("role");
                            String description = rs.getString("description");

                            out.println("<tr>");
                            out.println("<td>" + title + "</td>");
                            out.println("<td>" + companyName + "</td>");
                            out.println("<td>" + duration + "</td>");
                            out.println("<td>" + role + "</td>");
                            out.println("<td>" + description + "</td>");
                            out.println("</tr>");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
                    } finally {
                        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
                    }
                %>
            </tbody>
        </table>
    </div>


  
</body>
</html>
