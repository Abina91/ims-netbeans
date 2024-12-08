<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    
</head>
<style>
/* General styles */
body {
    font-family: 'Roboto', sans-serif; /* Modern, clean font */
    background-image: url('images/dd.jpeg'); /* Background image */
    background-size: cover; /* Ensure the image covers the entire background */
    background-position: center;
    background-repeat: no-repeat;
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
    align-items: center;
    color: #333; /* General text color */
}

/* Header styling */
header {
    width: 100%;
    background-color:black; /* Deep blue for the header background */
    padding: 20px 0;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Subtle shadow for depth */
    color: white;
    text-align: center;
}

header h1 {
    font-size: 28px;
    margin: 0;
}

/* Navigation styles */
.nav-list {
    margin-top: 10px; /* Reduce the gap between the title and nav */
}

.nav-list ul {
    padding: 0;
    list-style: none; /* Remove bullet points */
}

.nav-list ul li {
    display: inline-block; /* Horizontal list */
    margin: 0 20px;
}

.nav-list ul li a {
    color: white;
    font-size: 18px;
    text-decoration: none;
    padding: 12px 25px;
    background-color: #0056b3; /* Medium blue background for the links */
    border-radius: 8px;
    transition: background-color 0.3s ease;
    box-shadow: 0 3px 6px rgba(0, 0, 0, 0.2); /* Shadow for buttons */
}

.nav-list ul li a:hover {
    background-color: #004494; /* Darker blue on hover */
}

/* Main container styles */
.container {
    background-color: rgba(255, 255, 255, 0.9); /* Semi-transparent white background */
    border-radius: 15px;
    padding: 40px;
    box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2); /* Add depth to the box */
    max-width: 800px;
    margin-top: 30px;
    width: 90%;
}

.container h2 {
    text-align: center;
    color: #007BFF; /* Blue heading color */
    font-size: 24px;
    margin-bottom: 30px; /* Space below the heading */
}

/* Form styles */
form {
    display: flex;
    flex-direction: column;
    align-items: center;
}

form label {
    font-weight: bold;
    font-size: 16px;
    margin-bottom: 10px;
}

form input[type="text"], form input[type="submit"] {
    width: 100%;
    max-width: 400px;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

form input[type="submit"] {
    background-color: #007BFF;
    color: white;
    font-size: 16px;
    cursor: pointer;
    transition: background-color 0.3s;
}

form input[type="submit"]:hover {
    background-color: #0056b3;
}

/* Table styles */
table {
    width: 100%;
    margin-top: 30px;
    border-collapse: collapse;
    text-align: left;
}

table, th, td {
    border: 1px solid #ccc;
    padding: 10px;
}

th {
    background-color: #007BFF;
    color: white;
}

td a {
    color: #007BFF;
    text-decoration: none;
}

td a:hover {
    text-decoration: underline;
}

p {
    margin: 15px 0;
}

h3 {
    color: #333;
}


</style>
<body>
    <header>
        <h1>Admin Dashboard</h1>
        <nav class="nav-list">
            <ul>
                <li><a href="adminHome.jsp">Home</a></li>
                <li><a href="adminDashboard.jsp">Dashboard</a></li>
                <li><a href="addIntern.jsp">Add Internship</a></li>
                <li><a href="interndetails.jsp">Added Internship</a></li>
                <li><a href="logout.jsp">Logout</a></li>
            </ul>
        </nav>
    </header>

    <div class="container">
        <h2>Search Student Details</h2>
        <form method="post" action="adminDashboard.jsp">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <input type="submit" value="Search">
        </form>

        <%
            if ("POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("username") != null) {
                String username = request.getParameter("username");
                Connection con = null;
                PreparedStatement ps = null;
                ResultSet rs = null;

                try {
                    // Database connection
                    String url = "jdbc:derby://localhost:1527/internn";
                    String dbUsername = "intern";
                    String dbPassword = "intern123";
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    con = DriverManager.getConnection(url, dbUsername, dbPassword);

                    // Query to fetch student details and their internship details by username, including the certification link
                    String query = "SELECT u.username, u.email, u.phone_number, u.branch, u.course, u.college_name, u.cgpa, u.passout_year, u.current_year, " +
                                   "i.title, i.company_name, i.duration, i.role, i.status, i.description, i.certification_link " + // Add certification_link
                                   "FROM users u LEFT JOIN intern i ON u.username = i.username " +
                                   "WHERE u.username = ?";
                    ps = con.prepareStatement(query);
                    ps.setString(1, username);
                    rs = ps.executeQuery();

                    if (rs.next()) {
                        // Display student details
                        out.println("<h3>Student Details</h3>");
                        out.println("<p>Username: " + rs.getString("username") + "</p>");
                        out.println("<p>Email: " + rs.getString("email") + "</p>");
                        out.println("<p>Phone Number: " + rs.getString("phone_number") + "</p>");
                        out.println("<p>Branch: " + rs.getString("branch") + "</p>");
                        out.println("<p>Course: " + rs.getString("course") + "</p>");
                        out.println("<p>College Name: " + rs.getString("college_name") + "</p>");
                        out.println("<p>CGPA: " + rs.getString("cgpa") + "</p>");
                        out.println("<p>Academic Passout Year: " + rs.getString("passout_year") + "</p>");
                        out.println("<p>Current Year: " + rs.getString("current_year") + "</p>");

                        // Display internship details
                        out.println("<h3>Internship Details</h3>");
                        out.println("<table border='1'>");
                        out.println("<tr><th>Title</th><th>Company</th><th>Duration</th><th>Role</th><th>Status</th><th>Description</th><th>Certification</th></tr>");
                        
                        do {
                            out.println("<tr>");
                            out.println("<td>" + (rs.getString("title") != null ? rs.getString("title") : "N/A") + "</td>");
                            out.println("<td>" + (rs.getString("company_name") != null ? rs.getString("company_name") : "N/A") + "</td>");
                            out.println("<td>" + (rs.getString("duration") != null ? rs.getString("duration") : "N/A") + "</td>");
                            out.println("<td>" + (rs.getString("role") != null ? rs.getString("role") : "N/A") + "</td>");
                            out.println("<td>" + (rs.getString("status") != null ? rs.getString("status") : "N/A") + "</td>");
                            out.println("<td>" + (rs.getString("description") != null ? rs.getString("description") : "N/A") + "</td>");
                            
                            // Display the certification link (if available)
                            String certificationLink = rs.getString("certification_link");
                            if (certificationLink != null && !certificationLink.isEmpty()) {
                                out.println("<td><a href='" + certificationLink + "' target='_blank'>View Certification</a></td>");
                            } else {
                                out.println("<td>No Certification Available</td>");
                            }
                            out.println("</tr>");
                        } while (rs.next());
                        
                        out.println("</table>");
                    } else {
                        out.println("<p style='color:red;'>No student found with the given username.</p>");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
                } finally {
                    try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                    try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                    try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
            }
        %>
    </div>
    
</body>
</html>
