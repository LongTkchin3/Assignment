<%-- 
    Document   : home
    Created on : Dec 9, 2021, 8:50:31 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FPT University</title><link rel="shortcut icon" type="image/png" href="https://upload.wikimedia.org/wikipedia/vi/1/1d/Logo_%C4%90%E1%BA%A1i_h%E1%BB%8Dc_FPT.png"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> 
    </head>
    <body>
        <jsp:include page="view/header.jsp" /><br><br><br><br><br><br><br><br>
        <%--------------------------------------------------------------------%>
        <div class="container">
            <form action="list" method="post">
                <select class="form-select" name="tid" style="text-align: center;" >
                    <option hidden selected>Select Teacher to continue</option>
                    <c:forEach items="${requestScope.teachers}" var="t">
                        <option value="${t.tid}">${t.tid}-${t.tname}</option>
                    </c:forEach>
                </select>
                <ul class="nav nav-pills nav-fill" style="margin-top: 50px;">
                    <li class="nav-item">
                        <input class="btn btn-outline-success btn-block" type="submit" value="Get Class"/>
                    </li>
                </ul>
            </form>
        </div>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    </body>
</html>
