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
                            <a class="nav-link"  href="list">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" style="color: red;"href="list.jsp">Table</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="">Take</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="">Update</a>
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
            <c:when test="${not empty sessionScope.class}">
                <table class="table container">
                    <thead class="thead-dark">
                        <tr style="text-align: center;">
                            <th colspan="2"></th>
                            <th>Monday</th>
                            <th>Tuesday</th>
                            <th>Wednesday</th>
                            <th>Thursday</th>
                            <th>Friday</th>
                            <th>Saturday</th>
                            <th>Sunday</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${sessionScope.slot}" var="s">  
                            <tr style="border-top:1px solid #dee2e6;text-align: center;">
                                <td>${s.name}<td>
                                    <% int count = 0, x = 0, temp = 0;%>
                                    <c:forEach items="${sessionScope.class}" var="c">                                      
                                        <c:choose>
                                            <%-- Monday --%>

                                            <c:when test="${s.slot_id==c.slot.slot_id && c.dow=='Monday'}">
                                            <td>
                                                <a href="get?id=${c.id}&cid=${c.classroom.cid}&slot_id=${c.slot.slot_id}" >${c.classroom.cname}</a> <br>     
                                            </td>
                                            <%count++;%>
                                        </c:when>
                                        <%-- Tuesday --%>
                                        <c:when test="${s.slot_id==c.slot.slot_id && c.dow=='Tuesday'}">
                                            <%if (count == 0) {
                                                    x = 1;
                                                    temp++;
                                                } else {
                                                    x = 1 - x - count;
                                                }
                                            %>
                                            <%if (x > 0) {%><td colspan="<%=x%>"></td><%}%>
                                            <td>
                                                <a href="get?id=${c.id}&cid=${c.classroom.cid}&slot_id=${c.slot.slot_id}" >${c.classroom.cname}</a> <br>     
                                            </td>
                                            <%count++;%>
                                        </c:when>
                                        <%-- Wednesday --%>
                                        <c:when test="${s.slot_id==c.slot.slot_id && c.dow=='Wednesday'}">
                                            <%if (count == 0) {
                                                    x = 2;
                                                    temp++;
                                                } else {
                                                    x = 2 - x - count;
                                                }
                                            %>
                                            <%if (x > 0) {%><td colspan="<%=x%>"></td><%}%>
                                            <td>
                                                <a href="get?id=${c.id}&cid=${c.classroom.cid}&slot_id=${c.slot.slot_id}" >${c.classroom.cname}</a> <br>     
                                            </td>
                                            <%count++;%>
                                        </c:when>
                                        <%-- Thursday --%>
                                        <c:when test="${s.slot_id==c.slot.slot_id && c.dow=='Thursday'}">
                                            <%if (count == 0) {
                                                    x = 3;
                                                    temp++;
                                                } else if (temp >= 1 && count >= 2) {
                                                    x = 3 - x - count - temp;
                                                } else {
                                                    x = 3 - x - count;
                                                }
                                            %>
                                            <%if (x > 0) {%><td colspan="<%=x%>"></td><%}%>
                                            <td>
                                                <a href="get?id=${c.id}&cid=${c.classroom.cid}&slot_id=${c.slot.slot_id}" >${c.classroom.cname}</a> <br>     
                                            </td>
                                            <%count++;%>
                                        </c:when>
                                        <%-- Friday --%>
                                        <c:when test="${s.slot_id==c.slot.slot_id && c.dow=='Friday'}">
                                            <%if (count == 0) {
                                                    x = 4;
                                                } else if (temp >= 1 && count >= 2) {
                                                    x = 4 - x - count - temp;
                                                } else {
                                                    x = 4 - x - count;
                                                }
                                            %>
                                            <%if (x > 0) {%><td colspan="<%=x%>"></td><%}%>
                                            <td>
                                                <a href="get?id=${c.id}&cid=${c.classroom.cid}&slot_id=${c.slot.slot_id}" >${c.classroom.cname}</a> <br>     
                                            </td>
                                            <%count++;%>
                                        </c:when>
                                        <%-- Saturday--%>
                                        <c:when test="${s.slot_id==c.slot.slot_id && c.dow=='Saturday'}">
                                            <%if (count == 0) {
                                                    x = 5;
                                                } else if (temp >= 1 && count >= 2) {
                                                    x = 5 - x - count - temp;
                                                } else {
                                                    x = 5 - x - count;
                                                }
                                            %>
                                            <%if (x > 0) {%><td colspan="<%=x%>"></td><%}%>
                                            <td>
                                                <a href="get?id=${c.id}&cid=${c.classroom.cid}&slot_id=${c.slot.slot_id}" >${c.classroom.cname}</a> <br>     
                                            </td>
                                            <%count++;%>
                                        </c:when>
                                        <%-- Sunday--%>
                                        <c:when test="${s.slot_id==c.slot.slot_id && c.dow=='Sunday'}">
                                            <%if (count == 0) {
                                                    x = 6;
                                                } else if (temp >= 1 && count >= 2) {
                                                    x = 6 - x - count - temp;
                                                } else {
                                                    x = 6 - x - count;
                                                }
                                            %>
                                            <%if (x > 0) {%><td colspan="<%=x%>"></td><%}%>       
                                            <td>
                                                <a href="get?id=${c.id}&cid=${c.classroom.cid}&slot_id=${c.slot.slot_id}" >${c.classroom.cname}</a> <br>     
                                            </td>
                                            <%count++;%>
                                        </c:when>
                                    </c:choose>
                                </c:forEach> 
                            </tr>
                        </c:forEach> 

                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <table class="table">
                    <thead class="thead-dark">
                    <th style="text-align: center;">Choose Teacher to continue</th>
                </thead>
            </table>
        </c:otherwise>
    </c:choose>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>   
</html>
