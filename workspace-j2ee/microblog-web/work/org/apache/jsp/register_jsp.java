package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fforceAddSchemeHostAndPort_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fforceAddSchemeHostAndPort_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fforceAddSchemeHostAndPort_005fnobody.release();
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

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> \r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\"> \r\n");
      out.write("<head> \r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /> \r\n");
      out.write("<meta name=\"keywords\" content=\"MicroBlog\" /> \r\n");
      out.write("<meta name=\"description\" content=\"MicroBlog by vivian\" /> \r\n");
      out.write("<title>MicroBlog register page</title> \r\n");
      out.write("<link rel=\"shortcut icon\" href=\"images/favicon.ico\" /> \r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var etuser='{\"siteurl\":\"");
      if (_jspx_meth_s_005furl_005f0(_jspx_page_context))
        return;
      out.write("\",\"pubdir\":\"");
      if (_jspx_meth_s_005furl_005f1(_jspx_page_context))
        return;
      out.write("\",\"setok\":\"-1\",\"my_uid\":\"\",\"user_name\":\"\",\"nickname\":\"\",\"space\":\"\"}';var stalk='';var shorturl='http://goo.gl';\r\n");
      out.write("</script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jquery.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"js/common.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"js/extends.js\"></script> \r\n");
      out.write("<script type=\"text/javascript\" src=\"js/ye_dialog.js\"></script> \r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/highslide/highslide.css\" /> \r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" /> \r\n");
      out.write("<!--[if lte IE 6]>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("#header .left{filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='image',src='images/logo.png');background:none;cursor:pointer}\r\n");
      out.write("#header .topmenubg{filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',sizingMethod='image',src='images/topmenu.png');background:none;}\r\n");
      out.write("#navbg {filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true', sizingMethod='scale',src='images/headbg.png');background:none;}\r\n");
      out.write("#sidebar .homestabs .menu li .arrHover{filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true,sizingMethod=image,src='images/sidemenuArr_over.png');background:none;}\r\n");
      out.write("#sidebar .homestabs .menu li .arrCurt{filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true,sizingMethod=image,src='images/sidemenuArr.png');background:none}\r\n");
      out.write("#sidebar .sect {filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true,sizingMethod=scale, src='images/dot.png');background:none;}\r\n");
      out.write(".newst {filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled=true,sizingMethod=image,src='images/newst.png');background:none;}\r\n");
      out.write("</style>\r\n");
      out.write("<![endif]--> \r\n");
      out.write("</head> \r\n");
      out.write(" \r\n");
      out.write("<body>\r\n");
      out.write("<div id=\"container\" class=\"newlook\"> \r\n");
      out.write("\t<div id=\"header2\"> \r\n");
      out.write("\t\t<a href=\"Main\"><div class=\"left\"></div></a> \r\n");
      out.write("\t</div> \r\n");
      out.write("\t<div class=\"clearline\"></div> \r\n");
      out.write("\t<div id=\"register\"> \r\n");
      out.write("\t\t<div class=\"indexh\" style=\"margin-bottom:20px\"> \r\n");
      out.write("\t\t\t<div class=\"tabon\">Sign Up</div> \r\n");
      out.write("\t\t\t<div class=\"taboff\"><a href=\"Login_Show\">Already signed up? Sign in.</a></div> \r\n");
      out.write("\t\t\t<div class=\"taboff\"><a href=\"Reset\">Forget Password?</a></div> \r\n");
      out.write("\t\t</div> \r\n");
      out.write("\t\t<table border=\"0\" style=\"width:90%;margin-left:40px\"> \r\n");
      out.write("\t\t<tr><td valign=\"top\"> \r\n");
      out.write("\t\t<h3 class=\"tt\">Join the Conversation</h3> \r\n");
      out.write("\t\t\t\t<form method=\"post\" action=\"##\" class=\"lf\"> \r\n");
      out.write("\t\t<table class=\"regtb\"> \r\n");
      out.write("\t\t\t<tr> \r\n");
      out.write("\t\t\t\t<th><label class=\"label_input\" for=\"username\">Username</label></th> \r\n");
      out.write("\t\t\t\t<td height=\"50px\" width=\"210px\"><input tabindex=\"2\" type=\"text\" id=\"username\" name=\"username\" class=\"input_text\" value=\"\" maxlength=\"20\"/></td> \r\n");
      out.write("\t\t\t\t<td>4 ~ 20 characters</td> \r\n");
      out.write("\t\t\t</tr> \r\n");
      out.write("\t\t\t<!--\r\n");
      out.write("\t\t\t<tr height=\"30px\"> \r\n");
      out.write("\t\t\t\t<td></td> \r\n");
      out.write("\t\t\t\t<td colspan=\"2\"><span class=\"grey\">Your URL http://127.0.0.1/<span id=\"wbadd\"></span></span></td> \r\n");
      out.write("\t\t\t</tr> \r\n");
      out.write("\t\t\t-->\r\n");
      out.write("\t\t\t<tr> \r\n");
      out.write("\t\t\t\t<th><label class=\"label_input\" for=\"email\">Email</label></th> \r\n");
      out.write("\t\t\t\t<td height=\"50px\"><input tabindex=\"4\" type=\"text\" id=\"email\" name=\"email\" class=\"input_text\" value=\"\" /></td> \r\n");
      out.write("\t\t\t\t<td>Note: You will find your password by email when you forgot it.</td> \r\n");
      out.write("\t\t\t</tr> \r\n");
      out.write("\t\t\t<tr> \r\n");
      out.write("\t\t\t\t<th><label class=\"label_input\" for=\"password\">Password</label></th> \r\n");
      out.write("\t\t\t\t<td height=\"50px\"><input tabindex=\"5\" type=\"password\" id=\"password\" name=\"password\" class=\"input_text\" value=\"\" maxlength=\"20\" style=\"ime-mode:disabled\" onpaste=\"return false;\"/></td> \r\n");
      out.write("\t\t\t\t<td>4 ~ 20 characters (be tricky!)</td> \r\n");
      out.write("\t\t\t</tr> \r\n");
      out.write("\t\t\t<tr> \r\n");
      out.write("\t\t\t\t<th><label class=\"label_input\" for=\"repassword\">Confirm</label></th> \r\n");
      out.write("\t\t\t\t<td height=\"50px\"><input tabindex=\"6\" type=\"password\" id=\"repassword\" name=\"repassword\" class=\"input_text\" value=\"\" maxlength=\"20\" style=\"ime-mode:disabled\" onpaste=\"return false;\"/></td> \r\n");
      out.write("\t\t\t\t<td>Confirm your password</td> \r\n");
      out.write("\t\t\t</tr> \r\n");
      out.write("\t\t\t<tr> \r\n");
      out.write("\t\t\t\t<td></td> \r\n");
      out.write("\t\t\t\t<td height=\"50px\" colspan=\"2\">\r\n");
      out.write("\t\t\t\t<input tabindex=\"7\" type=\"button\" class=\"button1\" value=\"Create\" onclick=\"check_register();\"/>\r\n");
      out.write("\t\t\t\t</td> \r\n");
      out.write("\t\t\t</tr> \r\n");
      out.write("\t\t</table> \r\n");
      out.write("\t\t<input type=\"hidden\" name=\"__hash__\" value=\"cc4596e00e9073792a6fd48debe75700\" /></form> \r\n");
      out.write("\t\t</td></tr> \r\n");
      out.write("\t\t</table> \r\n");
      out.write("\t</div> \r\n");
      out.write("\t<script type=\"text/javascript\"> \r\n");
      out.write("\t$(\"#username\").keyup(function(){\r\n");
      out.write("\t\t$('#username').val($('#username').val().replace(/\\s/ig,\"\"));\r\n");
      out.write("\t\t$('#wbadd').html($('#username').val());\r\n");
      out.write("\t\t$('#username').val($('#username').val().slice(0,12));\r\n");
      out.write("\t\t$('#wbadd').html($('#username').val().slice(0,12));\r\n");
      out.write("\t});\r\n");
      out.write("\t$(\"#mailadres\").keyup(function() {$('#mailadres').val($('#mailadres').val().replace(/\\s/ig,\"\"));});\r\n");
      out.write("\t$(\"#password1\").keyup(function() {$('#password1').val($('#password1').val().replace(/\\s/ig,\"\"));});\r\n");
      out.write("\t$(\"#password2\").keyup(function() {$('#password2').val($('#password2').val().replace(/\\s/ig,\"\"));});\r\n");
      out.write("\t</script> \r\n");
      out.write("\r\n");
      out.write("\t<div id=\"footer\">Powered by vivian.&copy; 2011</div> \r\n");
      out.write("</div> \r\n");
      out.write("<div class=\"gotop\"><button onclick=\"indextop();\" title=\"Back to top\"><span>Back to top</span></button></div> \r\n");
      out.write("</body> \r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_s_005furl_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f0 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fforceAddSchemeHostAndPort_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f0.setParent(null);
    // /register.jsp(11,24) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f0.setValue("");
    // /register.jsp(11,24) name = forceAddSchemeHostAndPort type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f0.setForceAddSchemeHostAndPort("true");
    int _jspx_eval_s_005furl_005f0 = _jspx_th_s_005furl_005f0.doStartTag();
    if (_jspx_th_s_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fforceAddSchemeHostAndPort_005fnobody.reuse(_jspx_th_s_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fforceAddSchemeHostAndPort_005fnobody.reuse(_jspx_th_s_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005furl_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:url
    org.apache.struts2.views.jsp.URLTag _jspx_th_s_005furl_005f1 = (org.apache.struts2.views.jsp.URLTag) _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fforceAddSchemeHostAndPort_005fnobody.get(org.apache.struts2.views.jsp.URLTag.class);
    _jspx_th_s_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005furl_005f1.setParent(null);
    // /register.jsp(11,86) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f1.setValue("");
    // /register.jsp(11,86) name = forceAddSchemeHostAndPort type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005furl_005f1.setForceAddSchemeHostAndPort("true");
    int _jspx_eval_s_005furl_005f1 = _jspx_th_s_005furl_005f1.doStartTag();
    if (_jspx_th_s_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fforceAddSchemeHostAndPort_005fnobody.reuse(_jspx_th_s_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005furl_0026_005fvalue_005fforceAddSchemeHostAndPort_005fnobody.reuse(_jspx_th_s_005furl_005f1);
    return false;
  }
}
