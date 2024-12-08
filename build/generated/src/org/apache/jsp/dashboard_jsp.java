package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Available Admin-Added Internships</title>\n");
      out.write("    <style>\n");
      out.write("        /* Navigation List Styles */\n");
      out.write(".nav-list {\n");
      out.write("    list-style-type: none;\n");
      out.write("    padding: 0;\n");
      out.write("    margin: 0;\n");
      out.write("    display: flex;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".nav-list li {\n");
      out.write("    margin-right: 15px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".nav-list li a {\n");
      out.write("    text-decoration: none;\n");
      out.write("    color: #333;\n");
      out.write("    padding: 10px;\n");
      out.write("    transition: background-color 0.3s, color 0.3s;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".nav-list li a.active {\n");
      out.write("    background-color: #0056b3; /* Highlight active link */\n");
      out.write("    color: white;\n");
      out.write("    border-radius: 5px;\n");
      out.write("    padding: 10px 15px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Table Styles */\n");
      out.write(".internships-table {\n");
      out.write("    width: 100%;\n");
      out.write("    border-collapse: collapse;\n");
      out.write("    margin-top: 20px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".internships-table th, .internships-table td {\n");
      out.write("    border: 1px solid #ddd;\n");
      out.write("    padding: 8px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".internships-table th {\n");
      out.write("    background-color: #f2f2f2;\n");
      out.write("    font-weight: bold;\n");
      out.write("    text-align: left;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".internships-table tr:hover {\n");
      out.write("    background-color: #f1f1f1;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Container and Header */\n");
      out.write(".container {\n");
      out.write("    padding: 20px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("h2 {\n");
      out.write("    margin-bottom: 20px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("/* Footer */\n");
      out.write("footer {\n");
      out.write("    text-align: center;\n");
      out.write("    margin-top: 20px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <h1>Student Dashboard</h1>\n");
      out.write("        <nav>\n");
      out.write("            <ul class=\"nav-list\">\n");
      out.write("             <li><a href=\"home.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"viewInternships.jsp\">View Internships</a></li>\n");
      out.write("                <li><a href=\"addInternship.jsp\">Add Internship</a></li>\n");
      out.write("                <li><a href=\"profile.jsp\">Profile</a></li>\n");
      out.write("                <li><a href=\"dashboard.jsp\">Dashboard</a></li>\n");
      out.write("                <li><a href=\"logout.jsp\">Logout</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>Available Admin-Added Internships</h2>\n");
      out.write("        <table>\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Title</th>\n");
      out.write("                    <th>Company Name</th>\n");
      out.write("                    <th>Duration</th>\n");
      out.write("                    <th>Role</th>\n");
      out.write("                    <th>Description</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

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
                
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles.css\"> \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("   \n");
      out.write("    <footer>\n");
      out.write("        <p>&copy; 2024 Internship Management System. All rights reserved.</p>\n");
      out.write("    </footer>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("  \n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
