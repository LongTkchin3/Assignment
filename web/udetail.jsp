<%-- 
    Document   : udetail
    Created on : Dec 8, 2021, 10:33:29 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" 
           uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
        <title>FPT University</title><link rel="shortcut icon" type="image/png" href="https://upload.wikimedia.org/wikipedia/vi/1/1d/Logo_%C4%90%E1%BA%A1i_h%E1%BB%8Dc_FPT.png"/>
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
                            <a class="nav-link "  href="list">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="list.jsp">Table</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="attend?cid=${sessionScope.table.classroom.cid}&slot_id=${sessionScope.table.slot.slot_id}">Take</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" style="color: red;" href="update.jsp">Update</a>
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
        <c:choose>
            <c:when test="${not empty requestScope.att}">
                <form action="update" method="post">
                    <table class="table">
                        <thead class="thead-dark">
                            <tr style="text-align: center;">
                                <th>Name</th>
                                <th>MSSV</th>
                                <th>Date</th>
                                <th>Present</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.att}" var="a">
                                <tr style="text-align: center;">
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
                        </tbody>
                    </table>
                    <input class="btn btn-outline-success" style="float: right;margin-right: 40px;" type="submit" value="Save"/>
                </form>   
            </c:when>
            <c:otherwise>
                <table class="table">
                    <thead class="thead-dark">
                    <th style="text-align: center;">Nothing new to update</th>
                </thead>
            </table>
        </c:otherwise>
    </c:choose>



    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>
