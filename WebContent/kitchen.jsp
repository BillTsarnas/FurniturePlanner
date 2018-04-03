<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Kitchen Details</title>

<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/font-awesome.min.css"/>
<link rel="stylesheet" href="css/kitchen.css"/>
<link rel="stylesheet" href="css/googleapis.css"/>

<script src="javascript/jquery-1.12.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>


</head>
<body>
    <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6"><h2><b>Kitchen Details</b></h2></div>
                </div>
            </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>Box</th>
                        <th>Height</th>
                        <th>Weight</th>
                        <th>Length</th>
                        <th>Depth</th>
                        <th>Melimine colour</th>
                        <th>Door material</th>
                        <th>Door colour</th>  
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="text" class="form-control" id="box"></td>
                        <td><input class="form-control" type="text" id="height"></td>
                        <td><input class="form-control" type="text" id="weight"></td>
                        <td><input class="form-control" type="text" id="lenght"></td>
                        <td><input class="form-control" type="text" id="depth"></td>
                        <td><input type="text" class="form-control" id="melMat"></td>

                        <td>  
                          <select class="form-control" id="doorColour" data-width="100%">
                            <option selected>Choose colour</option>
                            <option id="active">Red</option>
                            <option id="postponed">Postponed</option>
                            <option id="inactive">Inactive</option>
                            <option id="cancelled">Cancelled</option>
                          </select>
                        </td>
                        <td><input type="text" class="form-control" id="melColour"></td>
    
                    </tr>  
                </tbody>
        </table>

        <button type="button" class="btn btn-danger" onclick="window.location.href='http://localhost:8080/FurniturePlanner/order.jsp'">Cancel</button>
        <button type="button" class="btn btn-success" onclick="window.location.href='http://localhost:8080/FurniturePlanner/order.jsp'">Save</button>
        
        </div>
    </div> 


</body>
</html>                            