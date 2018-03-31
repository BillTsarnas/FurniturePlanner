<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Order Details</title>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/font-awesome.min.css"/>
<link rel="stylesheet" href="css/order.css"/>
<link rel="stylesheet" href="css/googleapis.css"/>

<script src="javascript/jquery-1.12.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="javascript/order.js"></script>


</head>
<body>
    <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-8"><h2><b>Order Details</b></h2></div>
                    <div class="col-sm-4">
                        <button type="button" class="btn btn-primary add-new"><i class="fa fa-plus"></i> Add new Furniture</button>
                    </div>
                </div>
            </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th id="kind">Kind of Furniture</th>
                        <th id="furnName">Furniture Name</th>
                        <th id="status">Status</th>
                        <th id="productId">ProductID</th>
                       
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>  
                          <select class="form-control" id="selector" data-width="100%">
                            <option >Choose furniture...</option>
                            <option id="kitchen">Kitchen</option>
                            <option id="wardrobe">Wardrobe</option>
                            <option id="door">Door</option>
                            <option id="other">Other furniture</option>
                          </select>
                        </td>
                        <td><input type="text" class="form-control" id="furnitureName"></td>
                        <td>  
                          <select class="form-control" id="status" data-width="100%">
                            <option selected>Choose status</option>
                            <option id="active">Active</option>
                            <option id="postponed">Postponed</option>
                            <option id="inactive">Inactive</option>
                            <option id="cancelled">Cancelled</option>
                          </select>
                        </td>
                        <td><input type="text" class="form-control" id="productid"></td>
                        <td>
                            <a class="edit" title="Edit" data-toggle="tooltip" onclick="window.location.href = 'http://localhost:8080/FurniturePlanner/' + document.getElementById('selector').value;"><i class="material-icons">&#xE254;</i></a>
                            <a class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                        </td>
                    </tr>  
                </tbody>
        </table>

        <button type="button" class="btn btn-danger" onclick="window.location.href='http://localhost:8080/FurniturePlanner/regClient.jsp'">Cancel</button>
        <button type="button" class="btn btn-success" onclick="window.location.href='http://localhost:8080/FurniturePlanner/tofillit.jsp'">Save</button>
        
        </div>
    </div> 


</body>
</html>                            