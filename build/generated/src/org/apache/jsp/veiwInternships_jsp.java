package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public final class veiwInternships_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>View Internships</title>\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"> <!-- Link to your CSS file -->\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <header>\n");
      out.write("        <h1>Internship Management System</h1>\n");
      out.write("        <nav>\n");
      out.write("            <ul class=\"nav-list\">\n");
      out.write("                <li><a href=\"home.jsp\">Home</a></li>\n");
      out.write("                <li><a href=\"viewInternships.jsp\">View Internships</a></li>\n");
      out.write("                <li><a href=\"addInternship.jsp\">Add Internship</a></li>\n");
      out.write("                <li><a href=\"profile.jsp\">Profile</a></li>\n");
      out.write("                <li><a href=\"logout.jsp\">Logout</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </nav>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>Your Internships</h2>\n");
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>Title</th>\n");
      out.write("                <th>Company</th>\n");
      out.write("                <th>Duration</th>\n");
      out.write("                <th>Role</th>\n");
      out.write("                <th>Description</th>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            ");

                Connection con = null;
                PreparedStatement ps = null;
                ResultSet rs = null;

                try {
                    String url = "jdbc:derby://localhost:1527/intern";
                    String dbUsername = "intern";
                    String dbPassword = "intern123";

                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    con = DriverManager.getConnection(url, dbUsername, dbPassword);
                    
                    // Fetch the username from session
                    String username = (String) session.getAttribute("username");
                    
                    // Fetch internship details for the logged-in user using the username
                    ps = con.prepareStatement("SELECT * FROM intern WHERE username = ?");
                    ps.setString(1, username); // Match username in 'intern' table with the session username
                    rs = ps.executeQuery();

                    while (rs.next()) {
            
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( rs.getString("title") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("company_name") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("duration") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("role") );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( rs.getString("description") );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            ");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
                } finally {
                    try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                    try { if (ps != null) ps.close(); } catch (SQLException e) { e.printStackTrace(); }
                    try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("<!-- footer.jsp -->\n");
      out.write("<footer>\n");
      out.write("    <p style=\"text-align: center;\">&copy; 2024 Internship Management System Platform. All rights reserved.</p>\n");
      out.write("</footer>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
