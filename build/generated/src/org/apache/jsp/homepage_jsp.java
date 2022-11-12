package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\t<title>Homepage</title>\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"imageHome/styleHome.css\">\n");
      out.write("\t<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\n");
      out.write("\t<link href=\"https://fonts.googleapis.com/css2?family=Yanone+Kaffeesatz:wght@500&display=swap\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div class=\"navbar\">\n");
      out.write("\t\t\t<img src=\"imageHome/logo.png\" class=\"logo\">\n");
      out.write("\t\t\t<nav>\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t<li><a href=\"#homepage\">Home</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"#about\">About</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"tips.jsp\">Tips</li>\n");
      out.write("\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t<div class=\"dropdown\"><a>Login</a>\n");
      out.write("\t\t\t\t    <div class=\"dropdown-content\">\n");
      out.write("\t\t\t\t      <a href=\"loginAdmin.jsp\">Admin</a>\n");
      out.write("\t\t\t\t      <a href=\"loginOrg.html\">Organization</a>\n");
      out.write("\t\t\t\t      <a href=\"loginDonor.html\">Donor</a>\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("\t\t\t\t\t</div></li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</nav>\n");
      out.write("\t\t\t<img src=\"imageHome/menu.png\" class=\"menu-icon\">\n");
      out.write("\t\t</div>\n");
      out.write("<a id=\"homepage\">\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t\t<div class=\"col\">\n");
      out.write("\t\t\t\t<h1>Donate Your Blood</h1>\n");
      out.write("\t\t\t\t<h5>Be a hero to someone. You can make a difference in the lives of others. </h5>\n");
      out.write("\t\t\t    <button><a href=\"about.html\" class=\"card-link\">Read More</a></button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"col\">\n");
      out.write("\t\t\t\t<a href=\"#tips\"><div class=\"card card1\"></div></a>\n");
      out.write("\t\t\t\t<a href=\"#misconception\"><div class=\"card card2\"></div></a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<a id=\"about\">\n");
      out.write("\t\t<div class=\"row\" >\n");
      out.write("\t\t\t<div class=\"image\">\n");
      out.write("                    <img src=\"imageHome/logo.png\" width=\"400\" height=\"500\">\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"text\">\n");
      out.write("                    <p>MERCY is a registered body, to promote the interest and welfare of society throughout the nation, irrespective on their race, religion, gender or political inclination.\n");
      out.write("\n");
      out.write("                    We believe there are a good numbers blood donors in the country and hoped that many will sign in as donor.\n");
      out.write("\n");
      out.write("                    We will also negotiate with public and private sectors for the granting of special privileges to the donors as their token of appreciation for what they contribute to the community and as an incentives for them to continue to be blood donors.</p>\n");
      out.write("                  </div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</a>\n");
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
