/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2022-09-16 16:24:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class create_002daccount_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/T:/Tempory%20Data/Web%20App/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/go-cheeta/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153365282000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1660112728163L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write(" \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"ISO-8859-1\">\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"/>\n");
      out.write("     <link rel=\"stylesheet\" href=\"css/addmin-dashboard-side.css\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css\"/>\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"css/account-style.css\" />\n");
      out.write("<style>\n");
      out.write("body{\n");
      out.write("     background-image: url(\"image/account-create.jpeg\");\n");
      out.write("       \n");
      out.write("     \n");
      out.write("   \n");
      out.write("</style>\n");
      out.write("\n");
      out.write("<title>Index</title>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("\n");
      out.write("<body>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "home-page-navbar.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"d-flex justify-content-center cent\">\n");
      out.write("<form action=\"createAccount\" method=\"post\">\n");
      out.write("\n");
      out.write("   <div class=\"form-group\"><input type=\"text\" min=\"2\" class=\" txt form-control addvehicle-input\" name=\"customername1\" id=\"\" placeholder=\"First Name\" required></div><br>\n");
      out.write("   <div class=\"form-group \"><input type=\"text\" min=\"2\" class=\"form-control addvehicle-input\" name=\"customername2\" id=\"\" placeholder=\"Last Name\" required></div><br>\n");
      out.write(" <div class=\"form-group \"><input type=\"email\" min=\"2\" class=\"form-control addvehicle-input\" name=\"email\" id=\"\" placeholder=\"Email Address\" required></div><br>\n");
      out.write(" <div class=\"form-group \"><input type=\"password\" min=\"2\" class=\"form-control addvehicle-input\" name=\"password\" id=\"\" placeholder=\"Password\" required></div><br>\n");
      out.write("     <div class=\"form-group \"><input type=\"text\" min=\"2\" class=\"form-control addvehicle-input\" name=\"addres1\" id=\"\" placeholder=\"Address 1\" required></div><br>\n");
      out.write("   <div class=\"form-group \"><input type=\"text\" min=\"2\" class=\"form-control addvehicle-input\" name=\"addres2\" id=\"\" placeholder=\"Address 2\" required></div><br>   \n");
      out.write("<div class=\"form-group \" >\n");
      out.write("\n");
      out.write("<select class=\"form-select\" aria-label=\"Default select example\" name=\"city\" required>\n");
      out.write("  <option VALUE=\"\"><b>Select City</b></option>\n");
      out.write("  <option value=\"galle\">Galle</option>\n");
      out.write("  <option value=\"kandy\">Kandy</option>\n");
      out.write("  <option value=\"nugegoda\">Nugegoda</option>\n");
      out.write("  <option value=\"gampaha\">Gampaha</option>\n");
      out.write("  <option value=\"kurunegala\">Kurunegala</option>\n");
      out.write("    <option value=\"jaffna\">Jaffna</option>\n");
      out.write("  \n");
      out.write("</select></div><br>\n");
      out.write(" \n");
      out.write(" \n");
      out.write(" <div class=\"d-flex justify-content-center\">\n");
      out.write("    <input type=\"hidden\" name=\"action\" value=\"addCustomer\"/>\n");
      out.write("    \n");
      out.write("    <button type=\"submit\" class=\"btn btn-success addvehiclebtn\">Create Account</button><br><br>\n");
      out.write("  \n");
      out.write("    </div>\n");
      out.write("     <div class=\"d-flex justify-content-center\" style=\"padding-top:20px; font-weight:bold\">\n");
      out.write("      <a href=\"customer-login.jsp\" class=\"link-danger\">Login To Account</a></div>\n");
      out.write("<div class=\"msg\"><h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h4></div>\n");
      out.write("</form>\n");
      out.write("\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
