/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2022-09-15 12:30:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class admin_002dview_002dvehicles_jsp extends org.apache.jasper.runtime.HttpJspBase
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftag_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005ftag_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ftag_005fforEach_0026_005fvar_005fitems.release();
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

      out.write("\r\n");
      out.write(" \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/addmin-dashboard-side.css\" />\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"d-flex\" id=\"wrapper\">\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "admin-dashboard-side.jsp", out, false);
      out.write("\r\n");
      out.write("<div id=\"page-content-wrapper\">\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "admin-dashboard-header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<h1></h1>\r\n");
      out.write(" <div class=\"container-fluid px-4\">\r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("                <div class=\"row my-5\">\r\n");
      out.write("                    <h3 class=\"fs-4 mb-3\"><b>Vehicles</b><br></h3>\r\n");
      out.write("                      \r\n");
      out.write("                    <div class=\"col\">\r\n");
      out.write("                        \r\n");
      out.write("                        <table class=\" table bg-white shadow-lg p-3 mb-5 bg-white rounded bg-transparent text-dark table-hover\">\r\n");
      out.write("                          <thead>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <th scope=\"col\" width=\"50\">#</th>\r\n");
      out.write("                                    <th scope=\"col\">Register Number</th>\r\n");
      out.write("                                    <th scope=\"col\"> Model</th>\r\n");
      out.write("                                    <th scope=\"col\"> Seats</th>\r\n");
      out.write("                                     <th scope=\"col\">Type</th>\r\n");
      out.write("                                      <th scope=\"col\">Coast Per Hour</th>\r\n");
      out.write("                                       <th scope=\"col\">City</th>\r\n");
      out.write("                                        <th scope=\"col\" colspan=\"2\">Action</th>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                           </thead>\r\n");
      out.write("                            <tbody>  \r\n");
      out.write("                              ");
      if (_jspx_meth_tag_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                \r\n");
      out.write("                            </tbody>\r\n");
      out.write("                        </table>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("</div>\r\n");
      out.write("<h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h4>\r\n");
      out.write(" \r\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<script src=\"javascript/script-dashboard.js\"></script>\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_tag_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  tag:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_tag_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005ftag_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_tag_005fforEach_005f0_reused = false;
    try {
      _jspx_th_tag_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_tag_005fforEach_005f0.setParent(null);
      // /admin-view-vehicles.jsp(45,30) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_tag_005fforEach_005f0.setVar("vehicle");
      // /admin-view-vehicles.jsp(45,30) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_tag_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/admin-view-vehicles.jsp(45,30) '${vehicleData}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${vehicleData}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_tag_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_tag_005fforEach_005f0 = _jspx_th_tag_005fforEach_005f0.doStartTag();
        if (_jspx_eval_tag_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\r\n");
            out.write("                                <tr>\r\n");
            out.write("                                   \r\n");
            out.write("                                    <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vehicle.getVehicleID()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                                    <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vehicle.getVehicle_Registernumber()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                                    <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vehicle.getVehicle_Model()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                                    <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vehicle.getNumberof_Seat()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                                    <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vehicle.getVehicle_Type()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                                    <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vehicle.getCostper_Km()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                                    <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vehicle.getBranch()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                                    <td> \r\n");
            out.write("                                    <form action=\"editVehicle\" method=\"post\">\r\n");
            out.write("                                     <input type=\"hidden\" id=\"productCode\" name=\"vehicleID\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vehicle.getVehicleID()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"/> \r\n");
            out.write("                                    <input type=\"hidden\" name=\"action\" value=\"editVehicle\"/>\r\n");
            out.write("                                    <button class=\"btnedit btn btn-primary\">Edit</button>\r\n");
            out.write("                                    </form>\r\n");
            out.write("                                    <td> \r\n");
            out.write("                                    <form action=\"deleteVehicle\" method=\"post\">\r\n");
            out.write("                                     <input type=\"hidden\" id=\"productCode\" name=\"vehicleID\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vehicle.getVehicleID()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\"/> \r\n");
            out.write("                                    <input type=\"hidden\" name=\"action\" value=\"deleteVehicle\"/>\r\n");
            out.write("                                     <button class=\"btn btn-danger\">Delete</button>\r\n");
            out.write("                                    \r\n");
            out.write("                                    </form>\r\n");
            out.write("                                    </td>\r\n");
            out.write("                                </tr>\r\n");
            out.write("                                ");
            int evalDoAfterBody = _jspx_th_tag_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_tag_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_tag_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_tag_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_tag_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005ftag_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_tag_005fforEach_005f0);
      _jspx_th_tag_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_tag_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_tag_005fforEach_005f0_reused);
    }
    return false;
  }
}
