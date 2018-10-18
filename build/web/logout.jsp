<%-- 
    Document   : logout.jsp
    Created on : Oct 17, 2018, 10:01:47 PM
    Author     : i1vag_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            session.invalidate();
//            request.setAttribute("username", null);
//            request.setAttribute("id", null);
//            request.setAttribute("role",null);
            RequestDispatcher dpc = request.getRequestDispatcher("index.jsp");
            dpc.forward(request, response);
        %>
    </body>
</html>
