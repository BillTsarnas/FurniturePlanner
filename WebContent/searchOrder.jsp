<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Available Orders</title>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/font-awesome.min.css"/>
<link rel="stylesheet" href="css/googleapis.css"/>
<link rel="stylesheet" href="css/searchOrder.css"/>

<script src="jquery-1.12.1.min.js"></script>

<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="javascript/searchOrder.js"></script>


</head>
<body>

<div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2><b>List of the Availble Orders</h2></div>
                    <div class="labelAvail"><h2><b>Client:</b> Nikos Oikonomou</h2></div>
                </div>
            </div>
            <table class="table table-bordered">
                <tbody>
                    <tr>
                        <td width="90%">
                            <label class="radio">OrderId: 2311 - Library
                                <input type="radio" checked="checked" name="is_company">
                                <span class="checkround"></span>
                            </label>
                        </td> 
                        <td width="10%">
                            <a class="edit" title="Edit" data-toggle="tooltip" onclick="window.location.href = 'http://localhost:8080/FurniturePlanner/order.jsp'"><i class="material-icons">&#xE254;</i></a>
                        </td>
                    </tr> 
                    <tr>
                        <td width="90%">
                            <label class="radio">OrderId: 2350 - Wardrobe 
                                <input type="radio" name="is_company">
                                <span class="checkround"></span>
                            </label>
                        </td> 
                        <td width="10%">
                            <a class="edit" title="Edit" data-toggle="tooltip" onclick="window.location.href = 'http://localhost:8080/FurniturePlanner/order.jsp'"><i class="material-icons">&#xE254;</i></a>
                        </td>
                    </tr> 
                    <tr>
                        <td width="90%">
                            <label class="radio">OrderId: 2324- Wooden materials
                                <input type="radio" name="is_company">
                                <span class="checkround"></span>
                            </label>
                        </td> 
                        <td width="10%">
                            <a class="edit" title="Edit" data-toggle="tooltip" onclick="window.location.href = 'http://localhost:8080/FurniturePlanner/order.jsp'"><i class="material-icons">&#xE254;</i></a>
                        </td>
                    </tr> 
                </tbody>
            </table>

            <button type="button" class="btn btn-danger" onclick="window.location.href='http://localhost:8080/FurniturePlanner/home.jsp'">Back</button>
            <button type="button" class="btn btn-success" onclick="window.location.href='http://localhost:8080/FurniturePlanner/home.jsp'">Save</button>

        </div>
    </div> 

</body>
</html>                            