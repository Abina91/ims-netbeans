package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class addInternship_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Add Internship</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"> <!-- Link to your CSS file -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\"> <!-- Font Awesome for icons -->\n");
      out.write("    \n");
      out.write("    <script>\n");
      out.write("        function toggleCertificationLink() {\n");
      out.write("            var statusCompleted = document.getElementById(\"statusCompleted\").checked;\n");
      out.write("            var certificationDiv = document.getElementById(\"certificationDiv\");\n");
      out.write("            certificationDiv.style.display = statusCompleted ? \"block\" : \"none\";\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <h1>Internship Management System</h1>\n");
      out.write("        <nav>\n");
      out.write("            <ul class=\"nav-list\">\n");
      out.write("                <li><a href=\"home.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"viewInternships.jsp\">View Internships</a></li>\n");
      out.write("                <li><a href=\"addInternship.jsp\">Add Internship</a></li>\n");
      out.write("             \n");
      out.write("                <li><a href=\"dashboard.jsp\">Dashboard</a></li>\n");
      out.write("             \n");
      out.write("        </nav>\n");
      out.write("        <div class=\"profile-icon\">\n");
      out.write("            <div class=\"dropdown\">\n");
      out.write("                <i class=\"fas fa-user-circle\"></i>\n");
      out.write("                <div class=\"dropdown-content\">\n");
      out.write("                    <a href=\"profile.jsp\"><i class=\"fas fa-user\"></i> My Profile</a>\n");
      out.write("                    <a href=\"viewInternships.jsp\"><i class=\"fas fa-briefcase\"></i> View Internships</a>\n");
      out.write("                    <a href=\"addInternship.jsp\"><i class=\"fas fa-plus\"></i> Add Internship</a>\n");
      out.write("                    <a href=\"logout.jsp\"><i class=\"fas fa-sign-out-alt\"></i> Logout</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </header>\n");
      out.write("    </header>\n");
      out.write("    \n");
      out.write("    <h2>Add New Internship</h2>\n");
      out.write("\n");
      out.write("    ");

        Connection con = null;
        PreparedStatement ps = null;

        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String title = request.getParameter("title");
            String companyName = request.getParameter("companyName");
            String duration = request.getParameter("duration");
            String role = request.getParameter("role");
            String status = request.getParameter("status");
            String description = request.getParameter("description");
            String username = (String) session.getAttribute("username");
            String certificationLink = request.getParameter("certificationLink"); // Get the certification link

            try {
                String dbUrl = "jdbc:derby://localhost:1527/internn";
                String dbUser = "intern";
                String dbPassword = "intern123";
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

                // Insert internship with optional certification link
                String query = "INSERT INTO intern (title, company_name, duration, role, status, description, username, certification_link) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                ps = con.prepareStatement(query);
                ps.setString(1, title);
                ps.setString(2, companyName);
                ps.setString(3, duration);
                ps.setString(4, role);
                ps.setString(5, status);
                ps.setString(6, description);
                ps.setString(7, username);

                // If the status is "Completed," add the certification link
                if ("Completed".equals(status) && certificationLink != null && !certificationLink.isEmpty()) {
                    ps.setString(8, certificationLink);
                } else {
                    ps.setNull(8, Types.VARCHAR);
                }

                int result = ps.executeUpdate();
                if (result > 0) {
                    out.println("<p class='message success'>Internship added successfully!</p>");
                } else {
                    out.println("<p class='message error'>Failed to add internship. Please try again.</p>");
                }

            } catch (Exception e) {
                e.printStackTrace();
                out.println("<p class='message error'>Error: " + e.getMessage() + "</p>");
            } finally {
                try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    
      out.write("\n");
      out.write("\n");
      out.write("    <form method=\"post\" action=\"addInternship.jsp\">\n");
      out.write("        <label for=\"title\">Internship Title:</label>\n");
      out.write("        <input type=\"text\" id=\"title\" name=\"title\" required>\n");
      out.write("\n");
      out.write("        <label for=\"companyName\">Company Name:</label>\n");
      out.write("        <input type=\"text\" id=\"companyName\" name=\"companyName\" required>\n");
      out.write("\n");
      out.write("        <label for=\"duration\">Duration:</label>\n");
      out.write("        <input type=\"text\" id=\"duration\" name=\"duration\" required>\n");
      out.write("\n");
      out.write("        <label for=\"role\">Role:</label>\n");
      out.write("        <input type=\"text\" id=\"role\" name=\"role\" required>\n");
      out.write("\n");
      out.write("        <label>Status:</label>\n");
      out.write("        <table>\n");
      out.write("            <td>\n");
      out.write("                <span class=\"radio-label\">\n");
      out.write("                    <input type=\"radio\" id=\"statusCompleted\" name=\"status\" value=\"Completed\" onclick=\"toggleCertificationLink()\" required>\n");
      out.write("                    <label for=\"statusCompleted\">Completed</label>\n");
      out.write("                </span>\n");
      out.write("        \n");
      out.write("            </td>\n");
      out.write("            <td>\n");
      out.write("                <span class=\"radio-label\">\n");
      out.write("                    <input type=\"radio\" id=\"statusOngoing\" name=\"status\" value=\"Ongoing\" onclick=\"toggleCertificationLink()\" required>\n");
      out.write("                    <label for=\"statusOngoing\">Ongoing</label>\n");
      out.write("                </span>\n");
      out.write("            </td>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        <div id=\"certificationDiv\" style=\"display:none;\">\n");
      out.write("            <label for=\"certificationLink\">Certification Link:</label>\n");
      out.write("            <input type=\"text\" id=\"certificationLink\" name=\"certificationLink\" placeholder=\"Enter certification link (if any)\">\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <label for=\"description\">Description:</label>\n");
      out.write("        <textarea id=\"description\" name=\"description\" rows=\"4\" required></textarea>\n");
      out.write("\n");
      out.write("        <input type=\"submit\" value=\"Add Internship\">\n");
      out.write("    </form>\n");
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
