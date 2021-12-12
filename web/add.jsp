<%-- 
    Document   : add
    Created on : Dec 11, 2021, 9:51:23 PM
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
                            <a class="nav-link disabled" href="">Take</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="">Update</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" style="color: red;" href="add">Add</a>
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
        <div class="container-fluid mt-3">
            <form method="POST" action="add">
                <table class="table">
                    <thead class="thead-dark">
                        <tr style="text-align: center;">
                            <th colspan="3"style="text-align: center;">Add new Student</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr style="text-align: center;">
                            <td colspan=>
                                <div class="form-row">
                                    <div class="form-group  col-sm-4">
                                        <label for="sid">MSSV</label><br>
                                        <input type='text' required="true" id="sid" name='sid'/>
                                    </div>
                                    <div class="form-group  col-sm-4">
                                        <label for="sname">Name</label><br>
                                        <input type='text' required="true" id="sname" name='sname'/>
                                    </div>
                                    <div class="form-group  col-sm-4">
                                        <label for="cid">Class</label>
                                        <select name="cid" id="myClass" class="form-control"> 
                                            <c:forEach items="${sessionScope.clas}" var="c">
                                                        <option value="${c.cid}" >${c.cname}</option>
                                            </c:forEach>   
                                        </select>
                                    </div>
                                </div>
                            </td> 
                        </tr>
                    </tbody>
                </table>
                <br/>
                <input class="btn btn-outline-success" style="float: right;margin-right: 40px;" type="submit" value="Save"/>
            </form><br><br>   
            <h4 style="text-align: center;color: red">${requestScope.msg}</h4>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    </body>
</html>
