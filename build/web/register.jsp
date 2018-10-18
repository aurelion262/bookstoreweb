<%-- 
    Document   : register.jsp
    Created on : Oct 14, 2018, 9:32:45 PM
    Author     : i1vag_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <p><a href="index.jsp">Trang chủ</a></p>
        <%
            String message = (String)request.getAttribute("message");
        %>
        <form method="POST" action="doRegister.jsp">
            <pre>Tên đăng nhập :</pre><input type="text" name="username"> (*)
            <pre>Mật khẩu      :</pre><input type="password" name="password"> (*)
        <p><input type="submit" value="Tạo tài khoản"></p>
        </form>
        <% if(message!=null){ %>
                <p><%=message%></p>
        <%}%>
    </body>
</html>
