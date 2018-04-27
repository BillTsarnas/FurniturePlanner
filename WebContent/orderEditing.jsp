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
	  <% String order_name =  (String) request.getAttribute("order_name"); %>
	  <% String client_id =  (String) request.getAttribute("clientId"); %>
      <h1>Order details</h1> 
      <h2>For client #<%out.print(client_id);%>, Order Name: <%out.print(order_name);%> </h2>
      
      <form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/RegisterKitchen">
      
      <% 
        
        int num_ord = (Integer) request.getAttribute("num_furniture");
      
      	ArrayList<String> kind_list = (ArrayList<String>) request.getAttribute("fur_kinds");
        int num_furniture = kind_list.size();
        
        ArrayList<String> name_list = (ArrayList<String>) request.getAttribute("fur_names");
        
        
        for (int i=0; i< num_furniture; i++) {
        	String tabName = "table"+(i+1);
        	String tbutton = "tbutton"+i;
      %>
  
      <details>
        <summary><%out.print(name_list.get(i));%></summary>
        <div class="table-wrapper">
        <button type="button" class="tbutton" id="<%=i+1%>" ><i class="fa fa-plus"></i> Add new box</button>
                
                <table id=<%=tabName%> class="table table-bordered">
                    <thead>
                            <tr>
                                <th>Box</th>
                                <th>Height</th>
                                <th>Width</th>
                                <th>Depth</th>
                                <th>Thickness</th>
                                <th>Melamine colour</th>
                                <th>Door colour</th>  
                                <th>Material</th> 
                            </tr>
                    </thead>
                    <tbody>
                        <tr><td width="20%"><select class="form-control" id="sel_box" name="sel_box<%=i+1%>1" >
	                               <option >Select...</option>
	                               <option id="box_sh">Box with shelves</option>
	                               <option id="box_sh3">Box 3 drawers</option>
	                               <option id="box_sh4">Box 4 drawers</option>
	                           </select>
                            </td>
                            <td width="10%"><input class="form-control" type="text" id="height" name="box_height<%=i+1%>1"></td>
                            <td width="10%"><input class="form-control" type="text" id="width" name="box_width<%=i+1%>1"></td>
                            <td width="10%"><input class="form-control" type="text" id="depth" name="box_depth<%=i+1%>1"></td>
                            <td width="10%"><input class="form-control" type="text" id="thik" name="box_thick<%=i+1%>1" value="1.6"></td>
                            <td width="20%"><input type="text" class="form-control" id="melMat" name="mel<%=i+1%>1"></td><td width="10%"><select class="form-control" id="box_colour<%=i+1%>1" name="box_colour<%=i+1%>1" >
	                               <option id="wood">Wood</option>
	                               <option id="brown">Brown</option>
	                               <option id="red">Red</option>
	                               <option id="white">White</option>
	                           </select>
                            </td><td width="10%"><select class="form-control" id="material" name="material<%=i+1%>1" >
	                               <option id = "melamin">Melamine</option>
	                               <option id="oak">Oak</option>
	                               <option id="maple">Maple</option>
	                               <option id="beech">Beech wood</option>
	                           </select>
                            </td>
                            
                            <td width="10%" >
                                <a class="delete" title="Delete" data-toggle="tooltip" id="<%=i+1%>,delete"><i class="material-icons">&#xE872;</i></a>
                            </td>
                        </tr>  
                    </tbody>
                </table>
        </div>
      </details>
      
      <input type="hidden" id = "num_boxes<%=i+1%>" name = "num_boxes<%=i+1%>" value="1">
      <input type="hidden" id = "fur_kind<%=i+1%>" name = "fur_kind<%=i+1%>" value="<%out.print(kind_list.get(i));%>">
      <input type="hidden" id = "fur_name<%=i+1%>" name = "fur_name<%=i+1%>" value="<%out.print(name_list.get(i));%>">
      
          <%
           } 
          %>
          
        
      <input type="hidden" id = "num_furnitures" name = "num_furniture" value="<%=num_furniture%>">   
          
      <button type="submit" class="btn btn-success" style="float: right;">Save</button>
      <button type="button" class="btn btn-danger" style="float: right;" onclick="window.location.href='http://localhost:8080/FurniturePlanner/home.jsp'">Cancel</button>
	  </form>
</div> 
</body>
</html>  