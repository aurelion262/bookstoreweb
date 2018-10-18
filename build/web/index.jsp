<%-- 
    Document   : index.jsp
    Created on : Oct 14, 2018, 9:32:19 PM
    Author     : i1vag_000
--%>

<%@page import="control.DAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOMEPAGe</title>
    </head>
    <body>
        
        <!--CODE : kiem tra gia tri cua cac attribute--!>   
        <%
            out.print("<br>username:"+session.getAttribute("username"));
            out.print("<br>password:"+session.getAttribute("password"));
            out.print("<br>id:"+session.getAttribute("id"));
            out.print("<br>role:"+session.getAttribute("role"));
            out.print("<br>message:"+session.getAttribute("message"));
        %>
        
        <%
            String username = (String)session.getAttribute("username");
            if(username!=null)
            {
        %>
        <br>Hello, <%=username%><a href="logout.jsp">(Dang xuat)</a>
        <%}
        else{
        %>
        <br><a href="register.jsp">Đăng ký</a>/<a href="login.jsp">Đăng nhập</a>
        <%}%>
        <p>Danh sách tài khoản :</p>
        <table>
            <tr>
                <th>ID</th>
                <th>USERNAME</th>
                <th>PASSWORD</th>
                <th>ROLE</th>
                <%
                    try {
                            if((session.getAttribute("role")).equals("ADMIN"))
                            { 
                %>
                <th>ACTION</th>
                <%}
                } catch (Exception e) {
                    e.printStackTrace();
                        }%>
                        
            </tr>
        <%
          ArrayList<Account> list = new DAO().getAccount();
          for(Account a : list){
              String urledit="editAccount.jsp?id=" + a.getId();
              String urlremove="removeAccount.jsp?id=" + a.getId();
        %>
            <tr>
                <td><%= a.getId() %></td>
                <td><%= a.getUsername()%></td>
                <td><%= a.getPassword()%></td>
                <td><%= a.getRole()%></td>
                <%
                    try {
                            if((session.getAttribute("role")).equals("ADMIN"))
                            { 
                %>
                <td><a href="<%=urledit%>">Sửa</a>/<a href="<%=urlremove%>">Xóa</a></td>
                <%}
                } catch (Exception e) {
                    e.printStackTrace();
                        }%>
            </tr>
        <%}%>
        </table>
    </body>
</html>
