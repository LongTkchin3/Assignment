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
        <script>
            var index = 0;
            function addStudent()
            {
                index++;
                var container = document.getElementById("container");
                var div = document.createElement("div");
                div.setAttribute("id", "student" + index);
                container.appendChild(div);
                div.innerHTML += "<input type=\"hidden\" value=\"" + index + "\" name=\"index\"/>";
                div.innerHTML += "MSSV:<input type=\"text\" name=\"sid" + index + "\" /><br>";
                div.innerHTML += "Name:<input type=\"text\" name=\"sname" + index + "\" /><br>";
                div.innerHTML += "Date:<input type=\"date\" name=\"adate" + index + "\" value=\"${sessionScope.table.cdate}\"/><br>";
                div.innerHTML += "Present:<input type=\"checkbox\" name=\"attend" + index + "\"/><br>";
                div.innerHTML += "<input type=\"hidden\" value=\"true\" name=\"available" + index + "\"/>";
                div.innerHTML += "<input type=\"button\" value=\"Remove\" onclick=\"removeStudent(" + index + ");\" />";
            }

            function removeStudent(index) {
                var container = document.getElementById("container");
                var div = document.getElementById("student" + index);
                container.removeChild(div);
            }
        </script>
    </head>
    <body>
        <form action="attend" method="post">
            <div>
                <table border="1px">
                    <tr>
                        <td>MSSV</td>
                        <td>Name</td>
                        <td>Date</td>
                        <td>Present</td>
                    </tr>
                    <c:forEach items="${requestScope.student}" var="r">
                        <tr>
                            <td><input type="text" readonly="true" name="sname" value="${r.sname}"/></td>
                            <td><input type="text" readonly="true" name="sid" value="${r.sid}"/></td>
                            <td><input type="date" name="adate${r.sid}" value="${sessionScope.table.cdate}"/></td>
                            <td><input type="hidden" name="slot_id" value="${sessionScope.table.slot.slot_id}"/>
                                <input type="checkbox" name="attend${r.sid}"/></td>
                        </tr>
                    </c:forEach>    
                </table>
                <input type="button" value="Add Student" onclick="addStudent();" />
            </div>
            <div id="container">
            </div>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
