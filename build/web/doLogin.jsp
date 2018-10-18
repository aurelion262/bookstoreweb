<%-- 
    Document   : doLogin.jsp
    Created on : Oct 17, 2018, 10:06:42 PM
    Author     : i1vag_000
--%>

<%@page import="model.Account"%>
<%@page import="control.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Account acc = new DAO().getAccount((String)request.getParameter("username"),
                                           (String)request.getParameter("password"));
            if(acc!=null)
            {
                session.setAttribute("username", acc.getUsername());
                session.setAttribute("role", acc.getRole());
                session.setAttribute("id",acc.getId());
                RequestDispatcher dpc = request.getRequestDispatcher("index.jsp");
                dpc.forward(request, response);
            }
            else
            {
                request.setAttribute("message","Nhập sai tên tài khoản/mật khẩu. Vui lòng nhập lại !");
                RequestDispatcher dpc = request.getRequestDispatcher("login.jsp");
                dpc.forward(request, response);
            }
        %>
    </body>
</html>
