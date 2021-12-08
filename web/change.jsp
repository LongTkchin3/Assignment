<%-- 
    Document   : test3
    Created on : Dec 7, 2021, 10:44:00 PM
    Author     : Admin
--%>

<%@page import="model.Table"%>
<%@page import="model.Slot"%>
<%@page import="java.util.ArrayList"%>
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
        <form method="POST" action="change">
            Class:${sessionScope.table.classroom.cname}
            <br/>         
            Date: <input type="date" name="cdate" value="${sessionScope.table.cdate}"/> (yyyy-MM-dd) <br/>
            Slot: 
            <select name="slot"> 
                <c:forEach items="${requestScope.slot}" var="s">
                    <c:choose>
                        <c:when test="${sessionScope.table.slot.slot_id == s.slot_id}">
                            <option value="${s.slot_id}" selected="true" >${s.name}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${s.slot_id}" >${s.name}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>   
            </select>
            <br/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
