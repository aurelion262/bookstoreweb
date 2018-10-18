package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import control.DAO;
import java.util.ArrayList;
import model.Account;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>HOMEPAGe</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <!--CODE : kiem tra gia tri cua cac attribute--!>\n");
      out.write("        \n");
      out.write("        ");

            out.print("username:"+session.getAttribute("username"));
            out.print("<br>password:"+session.getAttribute("password"));
            out.print("<br>id:"+session.getAttribute("id"));
            out.print("<br>role:"+session.getAttribute("role"));
            out.print("<br>message:"+session.getAttribute("message"));
        
      out.write("\n");
      out.write("        \n");
      out.write("        <!--// KET THUC CODE--!>\n");
      out.write("        \n");
      out.write("        ");

            String username = (String)request.getAttribute("username");
            if(username!=null)
            {
        
      out.write("\n");
      out.write("        Hello, ");
      out.print(username);
      out.write("<a href=\"logout.jsp\">(Dang xuat)</a>\n");
      out.write("        ");
}
        else{
        
      out.write("\n");
      out.write("        <a href=\"register.jsp\">Đăng ký</a>/<a href=\"login.jsp\">Đăng nhập</a>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        <p>Danh sách tài khoản :</p>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>ID</th>\n");
      out.write("                <th>USERNAME</th>\n");
      out.write("                <th>PASSWORD</th>\n");
      out.write("                <th>ROLE</th>\n");
      out.write("                ");

                    try {
                            if((request.getAttribute("role")).equals("ADMIN"))
                            { 
                
      out.write("\n");
      out.write("                <th>ACTION</th>\n");
      out.write("                ");
}
                } catch (Exception e) {
                    e.printStackTrace();
                        }
      out.write("\n");
      out.write("                        \n");
      out.write("            </tr>\n");
      out.write("        ");

          ArrayList<Account> list = new DAO().getAccount();
          for(Account a : list){
              String urledit="editAccount.jsp?id=" + a.getId();
              String urlremove="removeAccount.jsp?id=" + a.getId();
        
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( a.getId() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( a.getUsername());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( a.getPassword());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( a.getRole());
      out.write("</td>\n");
      out.write("                ");

                    try {
                            if((request.getAttribute("role")).equals("ADMIN"))
                            { 
                
      out.write("\n");
      out.write("                <td><a href=\"");
      out.print(urledit);
      out.write("\">Sửa</a>/<a href=\"");
      out.print(urlremove);
      out.write("\">Xóa</a></td>\n");
      out.write("                ");
}
                } catch (Exception e) {
                    e.printStackTrace();
                        }
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
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
