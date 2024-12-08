package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class studentLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Student Login - Internship Management System</title>\n");
      out.write("<!--    <link rel=\"stylesheet\" href=\"styles.css\">-->\n");
      out.write("\n");
      out.write("    \n");
      out.write("    <style>\n");
      out.write("        /* Basic CSS reset */\n");
      out.write("* {\n");
      out.write("    margin: 0;\n");
      out.write("    padding: 0;\n");
      out.write("    box-sizing: border-box;\n");
      out.write("}\n");
      out.write("\n");
      out.write("body {\n");
      out.write("    font-family: 'Arial', sans-serif;\n");
      out.write("    background-color: #f4f4f9;\n");
      out.write("    display: flex;\n");
      out.write("    justify-content: center;\n");
      out.write("    align-items: center;\n");
      out.write("    height: 100vh;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".container {\n");
      out.write("    background-color: #ffffff;\n");
      out.write("    width: 100%;\n");
      out.write("    max-width: 400px;\n");
      out.write("    padding: 30px;\n");
      out.write("    border-radius: 10px;\n");
      out.write("    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n");
      out.write("}\n");
      out.write("\n");
      out.write("h2 {\n");
      out.write("    text-align: center;\n");
      out.write("    margin-bottom: 20px;\n");
      out.write("    color: #333333;\n");
      out.write("}\n");
      out.write("\n");
      out.write("form {\n");
      out.write("    display: flex;\n");
      out.write("    flex-direction: column;\n");
      out.write("}\n");
      out.write("\n");
      out.write("label {\n");
      out.write("    margin-bottom: 8px;\n");
      out.write("    font-weight: bold;\n");
      out.write("    color: #555555;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=\"text\"],\n");
      out.write("input[type=\"password\"] {\n");
      out.write("    padding: 10px;\n");
      out.write("    margin-bottom: 20px;\n");
      out.write("    border: 1px solid #cccccc;\n");
      out.write("    border-radius: 5px;\n");
      out.write("    font-size: 14px;\n");
      out.write("    width: 100%;\n");
      out.write("    background-color: #f9f9f9;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=\"submit\"] {\n");
      out.write("    padding: 10px;\n");
      out.write("    background-color: #3498db;\n");
      out.write("    color: #ffffff;\n");
      out.write("    border: none;\n");
      out.write("    border-radius: 5px;\n");
      out.write("    cursor: pointer;\n");
      out.write("    font-size: 16px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("input[type=\"submit\"]:hover {\n");
      out.write("    background-color: #2980b9;\n");
      out.write("}\n");
      out.write("\n");
      out.write("p {\n");
      out.write("    text-align: center;\n");
      out.write("    margin-top: 20px;\n");
      out.write("    color: #777777;\n");
      out.write("}\n");
      out.write("\n");
      out.write("a {\n");
      out.write("    color: #3498db;\n");
      out.write("    text-decoration: none;\n");
      out.write("}\n");
      out.write("\n");
      out.write("a:hover {\n");
      out.write("    text-decoration: underline;\n");
      out.write("}\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("   \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <h2>Student Login</h2>\n");
      out.write("        <form action=\"login.jsp\" method=\"post\">\n");
      out.write("            <label for=\"username\">Username:</label>\n");
      out.write("            <input type=\"text\" id=\"username\" name=\"username\" required>\n");
      out.write("\n");
      out.write("            <label for=\"password\">Password:</label>\n");
      out.write("            <input type=\"password\" id=\"password\" name=\"password\" required>\n");
      out.write("\n");
      out.write("            <input type=\"submit\" value=\"Login\">\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <p>Don't have an account? <a href=\"signup.jsp\">Sign up here</a></p>\n");
      out.write("        \n");
      out.write("    </div>\n");
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
