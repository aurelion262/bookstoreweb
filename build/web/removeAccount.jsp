<%-- 
    Document   : removeAccount.jsp
    Created on : Oct 17, 2018, 11:59:04 PM
    Author     : i1vag_000
--%>

<%@page import="control.DAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>gdfg</title>
    </head>
    <body>
        <%
            try {
                    new DAO().removeAccount(Integer.parseInt(request.getParameter("id")));
                    RequestDispatcher dpc = request.getRequestDispatcher("index.jsp");
                    dpc.forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
            
    </body>
</html>
