<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.Iterator" 
    import="java.util.ArrayList" 
    import="org.uniof.manchester.pattern.web.Client"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Preview of order</title>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/font-awesome.min.css"/>
<link rel="stylesheet" href="css/orderEditing.css"/>
<link rel="stylesheet" href="css/googleapis.css"/>

<script src="javascript/jquery-1.12.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="javascript/orderEditing.js"></script>


</head>
<body>
   
<div class="container">
      <h1>Details and summary of the order</h1> 
      <h2>For client #Client_id</h2>
      
      <% 
        //int num_ord = (Integer) request.getAttribute("totOrders");
        for (int i=0; i<= 2; i++) {
        	String tabName = "table"+i;
        	String tbutton = "tbutton"+i;
      %>
  
      <details>
        <summary>Kitchen - lebes_kitch</summary>
        <div class="table-wrapper">
        <button type="button" class="tbutton" id=<%=i%> ><i class="fa fa-plus"></i> Add new box</button>
                
                <table id=<%=tabName%> class="table table-bordered">
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
                            <td><input type="text" class="form-control" id="box" name="box_name1"></td>
                            <td><input class="form-control" type="text" id="height" name="box_height1"></td>
                            <td><input class="form-control" type="text" id="width" name="box_width1"></td>
                            <td><input class="form-control" type="text" id="depth" name="box_depth1"></td>
                            <td><input class="form-control" type="text" id="depth" name="box_num_shelves1" value="0"></td>
                            <td><input type="text" class="form-control" id="melMat" name="box_colour1"></td>
                            <td><input type="text" class="form-control" id="doorColour" name="door_colour1"></td>
                            <td width="20%">
                                <a class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                            </td>
                        </tr>  
                    </tbody>
                </table>
        </div>
      </details>
      
          <%
           } 
          %>

</div> 
</body>
</html>  