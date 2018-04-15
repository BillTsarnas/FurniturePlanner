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
            <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/RegisterKitchen">
	            <table class="table table-bordered">
	                <thead>
	                    <tr>
	                        <th>Box</th>
	                        <th>Height</th>
	                        <th>Width</th>
	                        <th>Depth</th>
	                        <th>Number of shelves</th>
	                        <th>Melimine colour</th>
	                        <th>Door colour</th>  
	                    </tr>
	                </thead>
	                <tbody>
	                    <tr>
	                        <td><input type="text" class="form-control" id="box" name="box_name"></td>
	                        <td><input class="form-control" type="text" id="height" name="box_height"></td>
	                        <td><input class="form-control" type="text" id="width" name="box_width"></td>
	                        <td><input class="form-control" type="text" id="depth" name="box_depth"></td>
	                        <td><input class="form-control" type="text" id="depth" name="box_num_shelves" value="0"></td>
	                        <td><input type="text" class="form-control" id="melMat" name="box_colour"></td>
	                        <td><input type="text" class="form-control" id="doorColour" name="door_colour"></td>
	    
	                    </tr>  
	                </tbody>
	        </table>
	
	        <button type="button" class="btn btn-danger" onclick="window.location.href='http://localhost:8080/FurniturePlanner/order.jsp'">Cancel</button>
	        <button type="submit" class="btn btn-success">Save</button>
        </form>
        
        </div>
    </div> 


</body>
</html>                            