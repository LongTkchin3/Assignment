<%-- 
    Document   : test1
    Created on : Dec 7, 2021, 3:32:16 PM
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
        <table>
            <tr>
                <th>STT</th>
                <th>Môn Học</th>
                <th>Ngày</th>
                <th>Slot</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <tr>
                <td>1</td>
                <td>${sessionScope.table.classroom.cname}</td>
                <td></td>
                <td></td>
                <td><a href="attend?cid=${sessionScope.table.classroom.cid}&slot_id=${sessionScope.table.slot.slot_id}" >Take</a></td>
                <td><a href="change">Change</a></td>
            </tr>
        </table>
    </body>
</html>
