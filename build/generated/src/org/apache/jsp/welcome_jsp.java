package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
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

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!-- header.jsp -->\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Internship Management System</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles.css\">\n");
      out.write("    <style>\n");
      out.write("        /* Add your CSS styling here, or link to a CSS file */\n");
      out.write("        body {\n");
      out.write("            font-family: Arial, sans-serif;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        header {\n");
      out.write("            background-color: #004f9f;\n");
      out.write("            color: white;\n");
      out.write("            padding: 10px;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav ul {\n");
      out.write("            list-style-type: none;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            overflow: hidden;\n");
      out.write("            background-color: #333;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav ul li {\n");
      out.write("            float: left;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav ul li a {\n");
      out.write("            display: block;\n");
      out.write("            color: white;\n");
      out.write("            text-align: center;\n");
      out.write("            padding: 14px 16px;\n");
      out.write("            text-decoration: none;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav ul li a:hover {\n");
      out.write("            background-color: #111;\n");
      out.write("        }\n");
      out.write("        .dropdown {\n");
      out.write("            position: relative;\n");
      out.write("            display: inline-block;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .dropdown-content {\n");
      out.write("            display: none;\n");
      out.write("            position: absolute;\n");
      out.write("            background-color: white;\n");
      out.write("            min-width: 160px;\n");
      out.write("            box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);\n");
      out.write("            z-index: 1;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .dropdown-content a {\n");
      out.write("            color: black;\n");
      out.write("            padding: 12px 16px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            display: block;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .dropdown-content a:hover {\n");
      out.write("            background-color: #f1f1f1;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .dropdown:hover .dropdown-content {\n");
      out.write("            display: block;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .dropbtn {\n");
      out.write("            background-color: #0056b3;\n");
      out.write("            color: white;\n");
      out.write("            padding: 10px 20px;\n");
      out.write("            font-size: 16px;\n");
      out.write("            border: none;\n");
      out.write("            cursor: pointer;\n");
      out.write("            border-radius: 5px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        /* Optional: For smooth scrolling between sections */\n");
      out.write("        html {\n");
      out.write("            scroll-behavior: smooth;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <!-- Header Section -->\n");
      out.write("    <header>\n");
      out.write("        <h1>Internship Management System Platform</h1>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <!-- Navigation -->\n");
      out.write("    <nav>\n");
      out.write("        <ul>\n");
      out.write("            <li><a href=\"welcome.jsp\">Home</a></li>\n");
      out.write("            <li><a href=\"welcome.jsp#about\">About Us</a></li>\n");
      out.write("            <li><a href=\"welcome.jsp#contact\">Contact Us</a></li>\n");
      out.write("            <li class=\"dropdown\">\n");
      out.write("                    <button class=\"dropbtn\">Login</button>\n");
      out.write("                    <div class=\"dropdown-content\">\n");
      out.write("                        <a href=\"#\">Lab Login</a>\n");
      out.write("                        <a href=\"#\">Course Login</a>\n");
      out.write("                    </div>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </nav>\n");
      out.write(" <!-- Include the header -->\n");
      out.write("\n");
      out.write("<!-- Home Section -->\n");
      out.write("<section id=\"home\">\n");
      out.write("    <h2>Welcome to Internship Management System Platform</h2>\n");
      out.write("    <p>This platform offers a range of online training programs designed to enhance your skills in technology. Join us today!</p>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("<!-- About Us Section -->\n");
      out.write("<section id=\"about\">\n");
      out.write("    <h2>About Us</h2>\n");
      out.write("    <p>The Internship Management System is a comprehensive platform designed to streamline and manage the entire internship process at the Centre for Development of Advanced Computing. This system is aimed at students, staff, and internship coordinators, providing an efficient and user-friendly interface for all participants in the internship lifecycle.</p>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Contact Us Section -->\n");
      out.write("<section id=\"contact\">\n");
      out.write("    <h2>Contact Us</h2>\n");
      out.write("    <p>If you have any questions, feel free to reach out to us at <a href=\"mailto:nec.edu.in\">nec.edu.in</a>.</p>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- footer.jsp -->\n");
      out.write("<footer>\n");
      out.write("    <p style=\"text-align: center;\">&copy; 2024 Internship Management System Platform. All rights reserved.</p>\n");
      out.write("</footer>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write(" <!-- Include the footer -->\n");
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
