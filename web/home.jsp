<%-- 
    Document   : home
    Created on : Dec 9, 2021, 8:50:31 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="list" method="post">
            <select name="tid">
                <c:forEach items="${requestScope.teachers}" var="t">
                <option value="${t.tid}">${t.tname}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Get Class"/>
        </form>
    </body>
</html>
