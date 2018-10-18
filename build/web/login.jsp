<%-- 
    Document   : login.jsp
    Created on : Oct 17, 2018, 7:06:42 PM
    Author     : i1vag_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <p><a href="index.jsp">Trang chủ</a></p>
        <form method="POST" action="doLogin.jsp">
            <pre>Tên đăng nhập :</pre><input type="text" name="username">
            <pre>Mật khẩu      :</pre><input type="password" name="password">
        <p><input type="submit" value="Đăng nhập"></p>
        </form>
        <%if(request.getAttribute("message")!=null) out.print(request.getAttribute("message"));%>
    </body>
</html>
