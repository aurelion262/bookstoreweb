<%-- 
    Document   : doRegister.jsp
    Created on : Oct 16, 2018, 12:19:48 AM
    Author     : i1vag_000
--%>

<%@page import="control.DAO"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String message="";
            if(new DAO().checkUsername(request.getParameter("username")).equals("available")
                    &&!request.getParameter("username").equals("")
                    &&!request.getParameter("password").equals(""))
            {
                Account a = new Account();
                a.setUsername(request.getParameter("username"));
                a.setPassword(request.getParameter("password"));
                a.setRole("CLIENT");
                new DAO().addAccount(a);
                session.setAttribute("username", a.getUsername());
                session.setAttribute("role",a.getRole());
                session.setAttribute("id",a.getId());
                RequestDispatcher dpc = request.getRequestDispatcher("index.jsp");
                dpc.forward(request, response);
            }
            else
            {
                if(new DAO().checkUsername(request.getParameter("username")).equals("used"))
                {
                    message+="Ten da duoc su dung. Vui long chon ten khac.\n";
                }
                if(request.getParameter("username").equals("")
                        ||request.getParameter("password").equals(""))
                {
                    message+="Nhung truong co dau (*) bat buoc phai nhap thong tin";
                }
                request.setAttribute("message", message);
                RequestDispatcher dpc = request.getRequestDispatcher("register.jsp");
                dpc.forward(request, response);
            }
        %>
    </body>
</html>
