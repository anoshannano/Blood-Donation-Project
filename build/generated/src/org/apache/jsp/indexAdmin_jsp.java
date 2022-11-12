package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Admin;
import java.util.*;

public final class indexAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_query_var_dataSource;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sql_query_var_dataSource = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_sql_query_var_dataSource.release();
    _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.release();
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

//prevent Caching of JSP pages
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
//get the session and check if session is null, redirect to login page
if(session.getAttribute("currentSessionUser")==null)
response.sendRedirect("loginAdmin.jsp");

      out.write('\n');
      out.write('\n');
      if (_jspx_meth_sql_setDataSource_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <title>ADMIN</title>\n");
      out.write("\n");
      out.write("  <!-- Google Font: Source Sans Pro -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback\">\n");
      out.write("  <!-- Font Awesome Icons -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"plugins/fontawesome-free/css/all.min.css\">\n");
      out.write("  <!-- Theme style -->\n");
      out.write("  <link rel=\"stylesheet\" href=\"dist/css/adminlte.min.css\">\n");
      out.write("</head>\n");
      out.write("<body class=\"hold-transition sidebar-mini\">\n");
      out.write("<div class=\"wrapper\">\n");
      out.write("\n");
      out.write("  <!-- Navbar -->\n");
      out.write("  <nav class=\"main-header navbar navbar-expand navbar-white navbar-light\">\n");
      out.write("    <!-- Left navbar links -->\n");
      out.write("    <ul class=\"navbar-nav\">\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link\" data-widget=\"pushmenu\" href=\"#\" role=\"button\"><i class=\"fas fa-bars\"></i></a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item d-none d-sm-inline-block\">\n");
      out.write("        <a href=\"homepage.jsp\" class=\"nav-link\">Logout</a>\n");
      out.write("      </li>\n");
      out.write("    </ul>\n");
      out.write("    <!-- Right navbar links -->\n");
      out.write("\n");
      out.write("        <!-- /.dropdown-user -->\n");
      out.write("  </nav>\n");
      out.write("  <!-- /.navbar -->\n");
      out.write("\n");
      out.write("  <!-- Main Sidebar Container -->\n");
      out.write("  <aside class=\"main-sidebar sidebar-dark-primary elevation-4\">\n");
      out.write("     <!-- BRAND LOGO -->\n");
      out.write("    <a href=\"#\" class=\"brand-link\">\n");
      out.write("      <img src=\"imageHome/logo.png\" alt=\"ourlogo\" class=\"brand-image img-circle elevation-3\" style=\"opacity: .8\">\n");
      out.write("      <span class=\"brand-text font-weight-light\">MERCY</span>\n");
      out.write("    </a>\n");
      out.write("\n");
      out.write("    <!-- Sidebar -->\n");
      out.write("    <div class=\"sidebar\">\n");
      out.write("      <!-- Sidebar user panel (optional) -->\n");
      out.write("      <div class=\"user-panel mt-3 pb-3 mb-3 d-flex\">\n");
      out.write("        <div class=\"info\">\n");
      out.write("            <input type=\"hidden\" value=\"");
      out.print( session.getAttribute("currentSessionUser") );
      out.write("\" />\n");
      out.write("          <a href=\"#\" class=\"d-block\">ADMIN</a>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <nav class=\"mt-2\">\n");
      out.write("        <ul class=\"nav nav-pills nav-sidebar flex-column\" data-widget=\"treeview\" role=\"menu\" data-accordion=\"false\">\n");
      out.write("          <!-- Add icons to the links using the .nav-icon class\n");
      out.write("               with font-awesome or any other icon font library -->\n");
      out.write("          <li class=\"nav-item menu-open\">\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a href=\"indexAdmin.jsp\" class=\"nav-link\">\n");
      out.write("              <i class=\"nav-icon fas fa-th\"></i>\n");
      out.write("              <p>\n");
      out.write("                Profile\n");
      out.write("              </p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a href=\"viewOrgAdmin.jsp\" class=\"nav-link\">\n");
      out.write("              <i class=\"nav-icon fas fa-th\"></i>\n");
      out.write("              <p>\n");
      out.write("                View Organization\n");
      out.write("              </p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a href=\"reqBlood.jsp\" class=\"nav-link\">\n");
      out.write("              <i class=\"nav-icon fas fa-th\"></i>\n");
      out.write("              <p>\n");
      out.write("                Request List\n");
      out.write("              </p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("           <li class=\"nav-item\">\n");
      out.write("            <a href=\"bloodBank.jsp\" class=\"nav-link\">\n");
      out.write("              <i class=\"nav-icon fas fa-th\"></i>\n");
      out.write("              <p>\n");
      out.write("                Blood Bank\n");
      out.write("              </p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"nav-item\">\n");
      out.write("            <a href=\"admChangePass.jsp\" class=\"nav-link\">\n");
      out.write("              <i class=\"nav-icon fas fa-th\"></i>\n");
      out.write("              <p>\n");
      out.write("                Change Password\n");
      out.write("              </p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("        </ul>\n");
      out.write("      </nav>\n");
      out.write("      <!-- /.sidebar-menu -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /.sidebar -->\n");
      out.write("  </aside>\n");
      out.write("\n");
      out.write("  <!-- Content Wrapper. Contains page content -->\n");
      out.write("  <div class=\"content-wrapper\">\n");
      out.write("    <!-- Content Header (Page header) -->\n");
      out.write("    <div class=\"content-header\">\n");
      out.write("    </div>\n");
      out.write("    <!-- /.content-header -->\n");
      out.write("\n");
      out.write("    <!-- Main content -->\n");
      out.write("    <div class=\"content\">\n");
      out.write("      <div class=\"container-fluid\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"col-lg-12\">\n");
      out.write("            <div class=\"card\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"card card-primary card-outline\">\n");
      out.write("              <div class=\"card-body\">\n");
      out.write("                  ");
 String admIC = (String)session.getAttribute("currentSessionUser"); 
      out.write("\n");
      out.write("                   ");
      //  sql:query
      org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_query_0 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _jspx_tagPool_sql_query_var_dataSource.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
      _jspx_th_sql_query_0.setPageContext(_jspx_page_context);
      _jspx_th_sql_query_0.setParent(null);
      _jspx_th_sql_query_0.setVar("result");
      _jspx_th_sql_query_0.setDataSource((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${myDatasource}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      int[] _jspx_push_body_count_sql_query_0 = new int[] { 0 };
      try {
        int _jspx_eval_sql_query_0 = _jspx_th_sql_query_0.doStartTag();
        if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_push_body_count_sql_query_0[0]++;
            _jspx_th_sql_query_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_sql_query_0.doInitBody();
          }
          do {
            out.write("\n");
            out.write("                    SELECT *  FROM ADMIN WHERE ADMIC = '");
            out.print(admIC );
            out.write("'\n");
            out.write("                    ");
            int evalDoAfterBody = _jspx_th_sql_query_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
            out = _jspx_page_context.popBody();
            _jspx_push_body_count_sql_query_0[0]--;
        }
        if (_jspx_th_sql_query_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_sql_query_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_sql_query_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_sql_query_0.doFinally();
        _jspx_tagPool_sql_query_var_dataSource.reuse(_jspx_th_sql_query_0);
      }
      out.write("\n");
      out.write("                    \n");
      out.write("                <form action=\"updateAdminForm.jsp\" method=\"POST\">\n");
      out.write("                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                </form>\n");
      out.write("              </div>\n");
      out.write("\n");
      out.write("            </div><!-- /.card -->\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.row -->\n");
      out.write("      </div><!-- /.container-fluid -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /.content -->\n");
      out.write("  </div>\n");
      out.write("  <!-- /.content-wrapper -->\n");
      out.write("<!-- REQUIRED SCRIPTS -->\n");
      out.write("\n");
      out.write("<!-- jQuery -->\n");
      out.write("<script src=\"plugins/jquery/jquery.min.js\"></script>\n");
      out.write("<!-- Bootstrap 4 -->\n");
      out.write("<script src=\"plugins/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("<!-- AdminLTE App -->\n");
      out.write("<script src=\"dist/js/adminlte.min.js\"></script>\n");
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

  private boolean _jspx_meth_sql_setDataSource_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:setDataSource
    org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag _jspx_th_sql_setDataSource_0 = (org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag) _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.get(org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag.class);
    _jspx_th_sql_setDataSource_0.setPageContext(_jspx_page_context);
    _jspx_th_sql_setDataSource_0.setParent(null);
    _jspx_th_sql_setDataSource_0.setVar("myDatasource");
    _jspx_th_sql_setDataSource_0.setDriver("org.apache.derby.jdbc.ClientDriver");
    _jspx_th_sql_setDataSource_0.setUrl("jdbc:derby://localhost:1527/bloodDonationDB");
    _jspx_th_sql_setDataSource_0.setUser("app");
    _jspx_th_sql_setDataSource_0.setPassword("app");
    int _jspx_eval_sql_setDataSource_0 = _jspx_th_sql_setDataSource_0.doStartTag();
    if (_jspx_th_sql_setDataSource_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.reuse(_jspx_th_sql_setDataSource_0);
      return true;
    }
    _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.reuse(_jspx_th_sql_setDataSource_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("admin");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${result.rows}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                <h3 class=\"text-primary\"><i class=\"fas fa-paint-brush\"></i> Profile</h3>\n");
          out.write("\n");
          out.write("                 <strong><i class=\"fas fa-pencil-alt mr-1\"></i> Admin IC</strong>\n");
          out.write("                <p class=\"text-muted\">\n");
          out.write("                 ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.admIC}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                 <input type=\"hidden\" name=\"admIC\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.admIC}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\"></td> \n");
          out.write("                </p>\n");
          out.write("\n");
          out.write("                <hr>\n");
          out.write("               <strong><i class=\"fas fa-book mr-1\"></i> Admin Name</strong>\n");
          out.write("                <p class=\"text-muted\">\n");
          out.write("                  ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.admName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write(" \n");
          out.write("                  <input type=\"hidden\" name=\"admName\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.admName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                </p>\n");
          out.write("                <hr>\n");
          out.write("              <strong><i class=\"fas fa-book mr-1\"></i> Phone Number</strong>\n");
          out.write("                <p class=\"text-muted\">\n");
          out.write("                  ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.admNumTel}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                  <input type=\"hidden\" name=\"admName\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.admNumTel}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                </p>\n");
          out.write("                <hr>\n");
          out.write("                <strong><i class=\"fas fa-map-marker-alt mr-1\"></i>Address</strong>\n");
          out.write("\n");
          out.write("                <p class=\"text-muted\"> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.admAddress}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</p>\n");
          out.write("                <input type=\"hidden\" name=\"admName\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.admAddress}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                <hr>\n");
          out.write("\n");
          out.write("                <strong><i class=\"fas fa-pencil-alt mr-1\"></i> Email</strong>\n");
          out.write("\n");
          out.write("                <p class=\"text-muted\">\n");
          out.write("                  ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.admEmail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\n");
          out.write("                  <input type=\"hidden\" name=\"admName\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin.admEmail}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">\n");
          out.write("                </p>\n");
          out.write("\n");
          out.write("         <div class=\"col-12\">\n");
          out.write("          <input type=\"submit\" value=\"Update Profile\" class=\"btn btn-success float-right\">\n");
          out.write("        </div>\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }
}
