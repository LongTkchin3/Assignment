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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
                            <a class="nav-link" href="list.jsp">Table</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="attend?cid=${sessionScope.table.classroom.cid}&slot_id=${sessionScope.table.slot.slot_id}">Take</a>
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
        <table class="table">
            <thead class="thead-dark">
                <tr style="text-align: center;">
                    <th>Môn Học</th>
                    <th>Ngày</th>
                    <th>Slot</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr style="text-align: center;">
                    <td>${sessionScope.table.classroom.cname}</td>
                    <td>${sessionScope.table.cdate}</td>
                    <td>${sessionScope.table.slot.name}</td>
                    <td><ul class="nav nav-pills nav-fill">
                            <li class="nav-item">
                                <a class="btn btn-outline-success" href="attend?cid=${sessionScope.table.classroom.cid}&slot_id=${sessionScope.table.slot.slot_id}" >Take</a>
                            </li>
                            <li class="nav-item">
                                <a class="btn btn-outline-success" href="change">Change</a>
                            </li>
                        </ul>
                    </td>
                </tr>
            </tbody>
        </table>



        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    </body>
</html>
