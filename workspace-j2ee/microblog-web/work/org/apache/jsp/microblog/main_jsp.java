package org.apache.jsp.microblog;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvalue;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvalue = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvalue.release();
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.release();
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
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\r\n");
      out.write("<html version=\"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Micro Blog</title>\r\n");
      out.write("<link href=\"/login.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"jquery126.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"common.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"login.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"body_950\">\r\n");
      out.write("\t<div class=\"top\">\r\n");
      out.write("\t\t<div class=\"logo_img\"></div>\r\n");
      out.write("\t\t<div class=\"top_bg\"></div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"topic_banner\">\r\n");
      out.write("\t\t<div class=\"topic_img\"></div>\r\n");
      out.write("\t\t<div class=\"acticle\" id=\"topicBoxCon\">\r\n");
      out.write("\t\t\t<ul class=\"acticle_list\" id=\"acticle_list\">\r\n");
      out.write("\t\t\t\t<li><a target=\"_blank\" href=\"\" target=\"_blank\">test1</a></li> \r\n");
      out.write("\t\t\t\t<li><a target=\"_blank\" href=\"\" target=\"_blank\">test2</a></li> \r\n");
      out.write("\t\t\t\t<li><a target=\"_blank\" href=\"\" target=\"_blank\">test3</a></li> \r\n");
      out.write("\t\t\t\t<li><a target=\"_blank\" href=\"\" target=\"_blank\">test4</a></li> \r\n");
      out.write("\t\t\t\t<li><a target=\"_blank\" href=\"\" target=\"_blank\">test5</a></li> \r\n");
      out.write("\t\t\t\t<li><a target=\"_blank\" href=\"\" target=\"_blank\">test6</a></li> \r\n");
      out.write("\t\t\t\t<li><a target=\"_blank\" href=\"\" target=\"_blank\">test7</a></li> \r\n");
      out.write("\t\t\t\t<li><a target=\"_blank\" href=\"\" target=\"_blank\">test8</a></li> \r\n");
      out.write("\t\t\t\t<li><a target=\"_blank\" href=\"\" target=\"_blank\">test9</a></li> \r\n");
      out.write("\t\t\t\t<li><a target=\"_blank\" href=\"\" target=\"_blank\">test10</a></li> \r\n");
      out.write("\t\t\t\t<li><a target=\"_blank\" href=\"\" target=\"_blank\">test11</a></li> \r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"login_form\">\r\n");
      out.write("    \t<div class=\"reg\"></div>\r\n");
      out.write("    \t<div class=\"login\">\r\n");
      out.write("\t\t\t<input type=\"text\" id=\"loginname\" title=\"login_name\" tabindex=\"1\"/>\r\n");
      out.write("\t\t\t<input type=\"password\" id=\"password\" title=\"password\" tabindex=\"2\"/>\r\n");
      out.write("\t\t\t<input type=\"text\" id=\"password_text\" style=\"display:none;\"/>\r\n");
      out.write("\t\t\t<span class=\"lf\">\r\n");
      out.write("\t\t\t\t<input type=\"checkbox\" class=\"labelbox\" id=\"remusrname\"  tabindex=\"3\"  checked />\r\n");
      out.write("\t\t\t\t<label  for=\"remusrname\">Remember me</label>\r\n");
      out.write("\t\t\t</span>\r\n");
      out.write("\t\t\t<a class=\"rt\" href=\"\" target=\"_blank\" tabindex=\"4\">Forgot password</a>\r\n");
      out.write("\t\t\t<div class=\"signin\">\r\n");
      out.write("\t\t\t\t<a href=\"javascript:void(0);\" class=\"sp\" id=\"login_submit_btn\"  title=\"login\" tabindex=\"5\"></a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"user_list\">\r\n");
      out.write("\t\t<div class=\"ul_top\"></div>\r\n");
      out.write("\t\t<div class=\"ul_body\" id=\"ul_body\">\r\n");
      out.write("\t    \t<ul class=\"user_list\" id=\"user_list\">\r\n");
      out.write("\t    \t");
      if (_jspx_meth_s_005fiterator_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"ul_msg\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"blog_list\">\r\n");
      out.write("    \t<div class=\"bl_top\"></div>\r\n");
      out.write("\t\t<div class=\"bl_body\" id=\"bl_body\">\r\n");
      out.write("\t    \t<div class=\"blog_coontent\">\r\n");
      out.write("\t    \t\t<div class=\"blog_owner\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_msg\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_time\"></div>\r\n");
      out.write("\t    \t</div>\r\n");
      out.write("\t    \t<div class=\"blog_coontent\">\r\n");
      out.write("\t    \t\t<div class=\"blog_owner\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_msg\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_time\"></div>\r\n");
      out.write("\t    \t</div>\r\n");
      out.write("\t    \t<div class=\"blog_coontent\">\r\n");
      out.write("\t    \t\t<div class=\"blog_owner\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_msg\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_time\"></div>\r\n");
      out.write("\t    \t</div>\r\n");
      out.write("\t    \t<div class=\"blog_coontent\">\r\n");
      out.write("\t    \t\t<div class=\"blog_owner\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_msg\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_time\"></div>\r\n");
      out.write("\t    \t</div>\r\n");
      out.write("\t    \t<div class=\"blog_coontent\">\r\n");
      out.write("\t    \t\t<div class=\"blog_owner\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_msg\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_time\"></div>\r\n");
      out.write("\t    \t</div>\r\n");
      out.write("\t    \t<div class=\"blog_coontent\">\r\n");
      out.write("\t    \t\t<div class=\"blog_owner\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_msg\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_time\"></div>\r\n");
      out.write("\t    \t</div>\r\n");
      out.write("\t    \t<div class=\"blog_coontent\">\r\n");
      out.write("\t    \t\t<div class=\"blog_owner\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_msg\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_time\"></div>\r\n");
      out.write("\t    \t</div>\r\n");
      out.write("\t    \t<div class=\"blog_coontent\">\r\n");
      out.write("\t    \t\t<div class=\"blog_owner\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_msg\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_time\"></div>\r\n");
      out.write("\t    \t</div>\r\n");
      out.write("\t    \t<div class=\"blog_coontent\">\r\n");
      out.write("\t    \t\t<div class=\"blog_owner\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_msg\"></div>\r\n");
      out.write("\t    \t\t<div class=\"blog_time\"></div>\r\n");
      out.write("\t    \t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"ul_msg\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"copyright\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_s_005fiterator_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:iterator
    org.apache.struts2.views.jsp.IteratorTag _jspx_th_s_005fiterator_005f0 = (org.apache.struts2.views.jsp.IteratorTag) _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvalue.get(org.apache.struts2.views.jsp.IteratorTag.class);
    _jspx_th_s_005fiterator_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fiterator_005f0.setParent(null);
    // /microblog/main.jsp(59,6) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fiterator_005f0.setValue("userlist");
    int _jspx_eval_s_005fiterator_005f0 = _jspx_th_s_005fiterator_005f0.doStartTag();
    if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_s_005fiterator_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_s_005fiterator_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<li><a target=\"_blank\" href=\"#\"><img src=");
        if (_jspx_meth_s_005fproperty_005f0(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
          return true;
        out.write(" alt=");
        if (_jspx_meth_s_005fproperty_005f1(_jspx_th_s_005fiterator_005f0, _jspx_page_context))
          return true;
        out.write("/></a></li> \r\n");
        out.write("\t\t\t");
        int evalDoAfterBody = _jspx_th_s_005fiterator_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_s_005fiterator_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_s_005fiterator_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvalue.reuse(_jspx_th_s_005fiterator_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fiterator_0026_005fvalue.reuse(_jspx_th_s_005fiterator_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f0 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /microblog/main.jsp(60,45) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f0.setValue("iconUrl");
    int _jspx_eval_s_005fproperty_005f0 = _jspx_th_s_005fproperty_005f0.doStartTag();
    if (_jspx_th_s_005fproperty_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_s_005fiterator_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f1 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_s_005fiterator_005f0);
    // /microblog/main.jsp(60,79) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f1.setValue("accountName");
    int _jspx_eval_s_005fproperty_005f1 = _jspx_th_s_005fproperty_005f1.doStartTag();
    if (_jspx_th_s_005fproperty_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
    return false;
  }
}
