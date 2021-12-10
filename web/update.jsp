<%-- 
    Document   : update
    Created on : Dec 8, 2021, 10:04:44 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
                            <a class="nav-link active"  href="list">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="">Take attend</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="">Update</a>
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
            <c:when test="${sessionScope.table!=null}">
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th>Môn Học</th>
                            <th>Ngày</th>
                            <th>Slot</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${sessionScope.table.classroom.cname}</td>
                            <td>${sessionScope.table.cdate}</td>
                            <td>${sessionScope.table.slot.name}</td>
                            <td><ul class="nav nav-pills nav-fill">
                                    <li class="nav-item">
                                        <a class="nav-link" href="update">Update</a>
                                    </li>
                                </ul>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <h4>Nothing new to update</h4>
            </c:otherwise>
        </c:choose>       


        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>
