<%-- 
    Document   : udetail
    Created on : Dec 8, 2021, 10:33:29 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                            <td><input type="text" readonly="true" name="sname${a.student.sid}" value="${a.student.sname}"/></td>
                            <td><input type="text" readonly="true" name="sid${a.student.sid}" value="${a.student.sid}"/></td>
                            <td><input type="date" name="adate$${a.student.sid}" value="${a.adate}"/></td>
                            <td><input type="hidden" name="slot_id" value="${a.slot.slot_id}"/>
                                <input type="checkbox" name="attend${a.student.sid}"/></td>
                        </tr>
                    </c:forEach>    
                </table>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
