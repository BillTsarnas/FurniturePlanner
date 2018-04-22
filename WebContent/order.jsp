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
                    <div class="col-sm-8"><h2><b>Order Details for: <% if (request.getParameter("firstName") != null) out.print(request.getParameter("firstName")); %>${firstName} <!-- ${userId} --></b></h2></div>
                    <div class="col-sm-4">
                        <button type="button" class="btn btn-primary add-new"><i class="fa fa-plus"></i> Add new Furniture</button>
                    </div>
                </div>
            </div>
            <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/RegisterOrder">
	           
	           
	           <table class="table table-bordered">
	                <thead>
	                    
	                </thead>
	                <tbody>
	                    <tr>
	                    	<td width="70%"><p>Name of order:</p></td>
	                        <td width="30%"><b><p>Select status:</p></b></td>
	                    </tr> 
	                    <tr>
	                    	<td width="50%" ><input type="text" class="form-control" id="name_order" name="order_name"></td>
	                        <td width="50%">  
	                          <select class="form-control" id="sel_status data-width="100%" name="order_status">
	                            <option >...</option>
	                            <option id="active">Active</option>
	                            <option id="offer">Offer</option>
	                            <option id="progress">On progress</option>
	                            <option id="declined">Declined</option>
	                          </select>
	                        </td>
	                    </tr>  
	                </tbody>
	            </table>
	            
	            
	            <table id="table1" class="table table-bordered">
	                <thead>
	                </thead>
	                <tbody>
	                	<tr>
	                        <td width="40%" id="kind">Kind of Furniture </td>
	                        <td width="40%" id="furnName">Furniture Name </td>
	                        
	                        <td width="20%"> </td>
	                    </tr> 
	                    <tr>
	                        <td width="40%">  
	                          <select class="form-control" id="selector">
	                            <option >Choose furniture...</option>
	                            <option id="kitchen">Kitchen</option>
	                            <option id="wardrobe">Wardrobe</option>
	                            <option id="door">Door</option>
	                            <option id="other">Other furniture</option>
	                          </select>
	                        </td>
	                        <td width="40%"><input type="text" class="form-control" id="furnitureName"></td>
	                        <td width="20%">
	                            <a class="edit" title="Edit" data-toggle="tooltip" onclick="window.location.href = 'http://localhost:8080/FurniturePlanner/kitchen.jsp'"><i class="material-icons">&#xE254;</i></a>
	                            <a class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
	                        </td>
	                    </tr>  
	                </tbody>
	             </table>
				 
				 <input type="hidden" name = "clientId" value="${userId}">
				 
	             <button type="button" class="btn btn-danger" onclick="window.location.href='http://localhost:8080/FurniturePlanner/home.jsp'">Cancel</button>
	             <button type="submit" class="btn btn-success">Save</button>
             </form>
        </div>
    </div> 
</body>
</html>      
