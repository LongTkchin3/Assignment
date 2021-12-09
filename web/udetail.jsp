<%-- 
    Document   : udetail
    Created on : Dec 8, 2021, 10:33:29 PM
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
        <form action="update" method="post">
            <table border="1px">
                <tr>
                    <td>Name</td>
                    <td>MSSV</td>
                    <td>Date</td>
                    <td>Present</td>
                </tr>
                <c:forEach items="${requestScope.att}" var="a">
                    <tr>
                        <td><input type="text" readonly="true" name="sid" value="${a.student.sid}"/></td>
                        <td><input type="text" readonly="true" name="sname${a.student.sid}" value="${a.student.sname}"/></td>
                        <td><input type="date" name="adate${a.student.sid}" value="${a.adate}"/></td>
                            <c:choose>
                                <c:when test="${a.attend}">
                                <td><input type="hidden" name="slot_id" value="${a.slot.slot_id}"/>
                                    <input type="checkbox" checked="true" name="attend${a.student.sid}"/></td>
                                </c:when>
                                <c:otherwise>
                                <td><input type="hidden" name="slot_id" value="${a.slot.slot_id}"/>
                                    <input type="checkbox"  name="attend${a.student.sid}"/></td>
                                </c:otherwise>
                            </c:choose>
                    </tr>
                </c:forEach>    
            </table>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
