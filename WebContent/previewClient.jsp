<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="org.uniof.manchester.pattern.web.Client"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Preview client</title>


<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/font-awesome.min.css"/>
<link rel="stylesheet" href="css/previewClient.css"/>
<link rel="stylesheet" href="css/googleapis.css"/>

<script src="javascript/jquery-1.12.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>


</head>
<body background="img/background.jpg">

<div class="container">
<form class="form-horizontal" role="form" method="post" action="">

 				<% 
                    Client client_obj = (Client) request.getAttribute("client");
                	
                	
                %>

  <h1>Full details for client <%out.print(client_obj.getName()); %></h1>

        <table class="table table-bordered">

           <summary>ClientID - <%out.print(client_obj.getClientId()); %></summary>
              <tr>
                 <th scope="row">First Name</th>
                 <td><%out.print(client_obj.getName()); %></td>
              </tr>
              <tr>
                 <th scope="row">Last Name</th>
                 <td><%out.print(client_obj.getSurname()); %></td>
              </tr>
              <tr>
                 <th scope="row">Address</th>
                 <td><%out.print(client_obj.getAddress()); %></td>
              </tr>
              <tr>
                 <th scope="row">Phone</th>
                 <td><%out.print(client_obj.getHphone()); %></td>
              </tr>
              <tr>
                 <th scope="row">Mobile Phone</th>
                 <td><%out.print(client_obj.getMphone()); %></td>
              </tr>
              <tr>
                 <th scope="row">Email</th>
                 <td><%out.print(client_obj.getEmail()); %></td>
              </tr>
        </table>
        
        <button type="button" class="btn btn-success" onclick="window.location.href='http://localhost:8080/FurniturePlanner/home.jsp'">Ok</button>
             
</form>
</div>  
</body>
</html>   