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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
        <title>FPT University</title><link rel="shortcut icon" type="image/png" href="https://upload.wikimedia.org/wikipedia/vi/1/1d/Logo_%C4%90%E1%BA%A1i_h%E1%BB%8Dc_FPT.png"/>
        <script>
            var index = 0;
            function addStudent()
            {
                index++;
                var container = document.getElementById("container");
                var div = document.createElement("div");
                div.setAttribute("id", "student" + index);
                container.appendChild(div);
                div.innerHTML += "<table class=\"table\"><tr style=\"text-align: center;\"><td><input type=\"hidden\" value=\"" + index + "\" name=\"index\"/><input type=\"text\" required=\"true\" name=\"sid" + index + "\"placeholder=\"MSSV\" /></td><td><input type=\"text\" name=\"sname" + index + "\" placeholder=\"Name\"/></td><td><input type=\"date\" name=\"adate" + index + "\" value=\"${sessionScope.table.cdate}\"/></td><td><input type=\"checkbox\" name=\"attend" + index + "\"/></td><td><input type=\"hidden\" value=\"true\" name=\"available" + index + "\"/><button class=\"btn btn-outline-danger\" onclick=\"removeStudent(" + index + ");\">X</button></td></tr></table>";
            }
            function removeStudent(index) {
                var container = document.getElementById("container");
                var div = document.getElementById("student" + index);
                container.removeChild(div);
            }
        </script>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light fixed-top " style="background-color: white;max-height: 100px">
            <div class="container-fluid">
                <a class="navbar-brand" href="list">
                    <img src="https://upload.wikimedia.org/wikipedia/vi/1/1d/Logo_%C4%90%E1%BA%A1i_h%E1%BB%8Dc_FPT.png" style="max-width: 75px;" alt="">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link"  href="list">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="list.jsp">Table</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" style="color: red;" href="attend?cid=${sessionScope.table.classroom.cid}&slot_id=${sessionScope.table.slot.slot_id}">Take</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="update.jsp">Update</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="add">Add</a>
                        </li>
                    </ul>
                </div>
                <ul class="nav nav-pills justify-content-end">
                    <li class="nav-item">
                        <a class="nav-link disabled">${sessionScope.tid}</a>
                    </li>
                </ul>
            </div>
        </nav><br><br><br>
        <%--------------------------------------------------------------------%>
        <form action="attend" method="post">
            <div>
                <table class="table">
                    <thead class="thead-dark">
                        <tr style="text-align: center;">
                            <th>MSSV</th>
                            <th>Name</th>
                            <th>Date</th>
                            <th><input class="btn btn-outline-primary " type="button" value="Add Student" onclick="addStudent();"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${requestScope.student}" var="r">
                            <tr style="text-align: center;">                                  
                                <td><input type="text"  readonly="true" name="sid" value="${r.sid}"/></td>
                                <td><input type="text" readonly="true" name="sname" value="${r.sname}"/></td>
                                <td><input type="date" name="adate${r.sid}" value="${sessionScope.table.cdate}"/></td>
                                <td><input type="hidden" name="slot_id" value="${sessionScope.table.slot.slot_id}"/>
                                    <input type="checkbox" name="attend${r.sid}"/></td>
                            </tr>
                        </c:forEach>

                    </tbody>  
                </table> 
                <div id="container">
                </div>              
            </div>

            <input class="btn btn-outline-success" style="float: right;margin-right: 40px;"  type="submit" value="Save"/>
        </form>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    </body>
</html>
