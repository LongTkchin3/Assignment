<%-- 
    Document   : test
    Created on : Dec 6, 2021, 2:36:17 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Table"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${requestScope.class}" var="c">
        <a href="get?id=${c.id}&cid=${c.classroom.cid}&slot_id=${c.slot.slot_id}" >${c.classroom.cname} - ${c.slot.name} - ${c.cdate}</a> <br>     
    </c:forEach>
        </body>   
</html>
