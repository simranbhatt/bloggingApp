/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-10-20 18:35:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("<html>\r\n");
      out.write("\r\n");

//if the user isnt logged in, send them to the login page
if(session.getAttribute("username") == null) {
  response.sendRedirect("index.jsp");
  }

      out.write("\r\n");
      out.write("<title>Pense | Home</title>\r\n");
      out.write("<head>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("    body {\r\n");
      out.write("        background-image:linear-gradient(#ECD9BA, #DEC19B);\r\n");
      out.write("        font-family: 'Secular One', sans-serif; color:white;\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        overflow-y: scroll;\r\n");
      out.write("        margin: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    *:focus { /* to prevent black outline appearing on any current form field being filled */\r\n");
      out.write("                outline:none;\r\n");
      out.write("        }\r\n");
      out.write("    /*top navigation bar for computer screens*/\r\n");
      out.write("    .navigation {\r\n");
      out.write("        display: block;\r\n");
      out.write("        background-color: #FFFAF1;\r\n");
      out.write("        overflow: hidden;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .navigation a {\r\n");
      out.write("       float: left;\r\n");
      out.write("       text-align: center;\r\n");
      out.write("       background-color: #FFFAF1;\r\n");
      out.write("       color: black;\r\n");
      out.write("       margin: none;\r\n");
      out.write("       padding: 14px 16px;\r\n");
      out.write("       text-decoration: none;\r\n");
      out.write("       font-size: 17px;\r\n");
      out.write("       border: none;\r\n");
      out.write("       cursor: pointer;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .navigation a:hover {\r\n");
      out.write("       opacity: 0.8;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("     .navigation a.active { /* give the active page title icon a different background color */\r\n");
      out.write("       background-color: #D2B48C;\r\n");
      out.write("       color: white;\r\n");
      out.write("     }\r\n");
      out.write("\r\n");
      out.write("    .loggedInUser { /*styling the username shown on the page */\r\n");
      out.write("     float: left;\r\n");
      out.write("     color: black;\r\n");
      out.write("     text-decoration: none;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navigation .icon {\r\n");
      out.write("      display: none;   /* hide hamburger icon when on a computer screen*/\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    .navigation .search-container  {\r\n");
      out.write("      float: right;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navigation input[type=search] {\r\n");
      out.write("      padding: 5px;\r\n");
      out.write("      margin-top: 10px;\r\n");
      out.write("      margin-bottom: -7px;\r\n");
      out.write("      font-size: 15px;\r\n");
      out.write("      border: none;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navigation .search-container button {\r\n");
      out.write("      float: right;\r\n");
      out.write("      padding: 5px;\r\n");
      out.write("      margin-top: 10px;\r\n");
      out.write("      margin-right: 20px;\r\n");
      out.write("      background: #ddd;\r\n");
      out.write("      font-size: 17px;\r\n");
      out.write("      border: none;\r\n");
      out.write("      cursor: pointer;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navigation .search-container button:hover {\r\n");
      out.write("      background: #ccc;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("     /*styling the post shown on the page */\r\n");
      out.write("        .wrapPost {\r\n");
      out.write("           display: inline-block;\r\n");
      out.write("           float: left;\r\n");
      out.write("           margin-top:2%;\r\n");
      out.write("           margin-left: 1%;\r\n");
      out.write("           margin-bottom:2%;\r\n");
      out.write("           border: solid-white;\r\n");
      out.write("           background-color: white;\r\n");
      out.write("           border-radius: 6px;\r\n");
      out.write("           max-width: 70%;\r\n");
      out.write("           padding-bottom: 10px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .titlesStyle {\r\n");
      out.write("           float: left;\r\n");
      out.write("           text-align: left;\r\n");
      out.write("           width: 100%;\r\n");
      out.write("           display: inline-block;\r\n");
      out.write("           font-family: 'Raleway', sans-serif;\r\n");
      out.write("           font-weight: bold;\r\n");
      out.write("           font-size:30px;\r\n");
      out.write("           color: black;\r\n");
      out.write("           text-decoration: none;\r\n");
      out.write("           margin-top: 1%;\r\n");
      out.write("           margin-left: 1%;\r\n");
      out.write("           max-width: 50%;\r\n");
      out.write("           padding: 5px;\r\n");
      out.write("           padding-bottom:10px;\r\n");
      out.write("           border: none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .nameStyle {\r\n");
      out.write("           float: left;\r\n");
      out.write("           text-align: left;\r\n");
      out.write("           width: 100%;\r\n");
      out.write("           display: inline-block;\r\n");
      out.write("           font-family: 'Raleway', sans-serif;\r\n");
      out.write("           color: black;\r\n");
      out.write("           text-decoration: none;\r\n");
      out.write("           margin-left: 2%;\r\n");
      out.write("           padding: 5px;\r\n");
      out.write("           border: none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .postStyle {\r\n");
      out.write("           float: left;\r\n");
      out.write("           width:90%;\r\n");
      out.write("           text-align: left;\r\n");
      out.write("           display: inline-block;\r\n");
      out.write("           font-family: 'Raleway', sans-serif;\r\n");
      out.write("           color: black;\r\n");
      out.write("           text-decoration: none;\r\n");
      out.write("           margin-top: 1.5%;\r\n");
      out.write("           margin-left: 2%;\r\n");
      out.write("           padding: 20px;\r\n");
      out.write("           padding-left:5px;\r\n");
      out.write("           border: none;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        trashButton {\r\n");
      out.write("         float: right;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    /* mobile display settings*/\r\n");
      out.write("\r\n");
      out.write("    @media screen and (max-width: 600px) {\r\n");
      out.write("      .navigation a:not(.active) { /*on mobile screens, hide all the title icons except the current one */\r\n");
      out.write("      display: none;\r\n");
      out.write("      }\r\n");
      out.write("      .navigation a.icon { /*hamburger icon*/\r\n");
      out.write("        float: right;\r\n");
      out.write("        display: block;\r\n");
      out.write("      }\r\n");
      out.write("    }\r\n");
      out.write("    /*menu display styles for when the hamburger icon is tapped on mobile */\r\n");
      out.write("    @media screen and (max-width: 600px) {\r\n");
      out.write("      .navigation .responsive {\r\n");
      out.write("      position: relative;\r\n");
      out.write("      overflow:hidden;\r\n");
      out.write("      }\r\n");
      out.write("      .navigation.responsive .icon {\r\n");
      out.write("        position: absolute;\r\n");
      out.write("        right: 0;\r\n");
      out.write("        top: 0;\r\n");
      out.write("        display: block;\r\n");
      out.write("      }\r\n");
      out.write("      .navigation.responsive a {\r\n");
      out.write("        float: none;\r\n");
      out.write("        display: block;\r\n");
      out.write("        text-align: left;\r\n");
      out.write("      }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("/*Javascript for toggling the hamburger menu*/\r\n");
      out.write("function myFunction() {\r\n");
      out.write("  var x = document.getElementById(\"navigator\");\r\n");
      out.write("  if (x.className === \"navigation\") {\r\n");
      out.write("    x.className += \" responsive\";\r\n");
      out.write("  } else {\r\n");
      out.write("    x.className = \"navigation\";\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write(" <div class = \"navigation\" id = \"navigator\">\r\n");
      out.write(" <a class = \"active\" href = \"home.jsp\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.username}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</a>\r\n");
      out.write(" <a href = \"create.jsp\">Create</a>\r\n");
      out.write(" <a href = \"logout.jsp\">Logout</a>\r\n");
      out.write(" <div class=\"search-container\">\r\n");
      out.write(" <form action=\"/blogaction\" method = \"post\">\r\n");
      out.write("    <input type=\"search\" name=\"search\" placeholder=\"Search...\">\r\n");
      out.write("    <button name = \"searchButton\" type=\"submit\"><i class=\"fa fa-search\"></i></button>\r\n");
      out.write("  </form>\r\n");
      out.write("  </div>\r\n");
      out.write("<a href=\"javascript:void(0);\" class=\"icon\" onclick=\"myFunction()\">\r\n");
      out.write("    <i class=\"fa fa-bars\"></i>\r\n");
      out.write(" </div>\r\n");
      out.write("\r\n");
      out.write("  <! -- for-each loop using JSTL to display all user's posts. Posts are retrieved from the database via the session attribute \"userPosts\" -->\r\n");
      out.write("  <! -- set in LoginServlet. Note that the taglib on line 2 has to be defined -->\r\n");
      out.write(" ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /home.jsp(223,1) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/home.jsp(223,1) '${sessionScope.userPosts}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${sessionScope.userPosts}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /home.jsp(223,1) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("post");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write(" <div class = \"wrapPost\" id = \"postWrapper\">\r\n");
          out.write(" <div class = \"titlesStyle\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${post.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</div>\r\n");
          out.write(" <div class = \"nameStyle\"><i>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${post.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(" posted at ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${post.timestamp}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(" </i> </div>\r\n");
          out.write(" <div class = \"nameStyle\"><b>Tags:</b> ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${post.tag}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</div>\r\n");
          out.write(" <div class = \"postStyle\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${post.description}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</div>\r\n");
          out.write(" <form action=\"/blogaction\" method = \"post\">\r\n");
          out.write(" <!-- send post id to BlogActionServlet when the \"trash\" button is clicked -->\r\n");
          out.write(" <button name = \"trashButton\" type=\"submit\" value=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${post.postID}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("><i class=\"fa fa-trash\"></i></button>\r\n");
          out.write(" </form>\r\n");
          out.write(" ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
