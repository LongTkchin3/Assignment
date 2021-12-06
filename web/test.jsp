<%-- 
    Document   : test
    Created on : Dec 6, 2021, 2:36:17 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Table"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%ArrayList<Table> lst = (ArrayList<Table>)request.getAttribute("lst");
        %>
    </head>
    <body>
        <% for (Table x : lst) {%>
               <a href="get?cid=<%=x.getCid().getCid()%>" ><%=x.getCid().getCname()%></a>             
               <%}
        %>
        
    </body>
</html>
