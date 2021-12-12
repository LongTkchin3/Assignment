<%-- 
    Document   : header
    Created on : Dec 10, 2021, 2:39:35 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link
    rel="stylesheet"
    href="https://use.fontawesome.com/releases/v5.13.0/css/all.css"
    integrity="sha384-Bfad6CLCknfcloXFOyFnlgtENryhrpZCe29RTifKEixXQZ38WheV+i/6YWSzkz3V"
    crossorigin="anonymous"
    />
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
                    <a class="nav-link active" style="color: red;" href="list">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="list.jsp">Table</a>
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
    </div>
</nav>