<%-- 
    Document   : test3
    Created on : Dec 7, 2021, 8:30:47 PM
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
        <form action="attend" method="post">
        <table border="1px">
            <tr>
                <td>MSSV</td>
                <td>Name</td>
                <td>Date</td>
                <td>Present</td>
            </tr>
            <c:forEach items="${requestScope.student}" var="r">
                <tr>
                    <td><input type="text" readonly="true" name="sid" value="${r.sid}"/></td>
                    <td>${r.sname}</td>
                    <td><input type="date" name="adate${r.sid}"/></td>
                    <td><input type="hidden" name="slot_id"value="${requestScope.slot_id}"/>
                        <input type="checkbox" name="attend${r.sid}"/></td>
                </tr>
            </c:forEach>    
        </table>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
